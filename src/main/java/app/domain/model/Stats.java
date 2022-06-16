package app.domain.model;

import app.controller.App;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.shared.Constants;
import org.apache.commons.lang3.time.DateUtils;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Stats {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd_MM_yyyy");
    private static final String DATE = DATE_FORMAT.format(new Date());

    private static final String CSV_FILE_PATH = "./results_" + DATE + ".csv";
    private static final String SEPARATOR = ";";


    private Company company;

    public Stats() {
        this.company = company;
    }

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    volatile boolean isStopIssued;

    public void start() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String time = props.getProperty(Constants.PARAMS_DAILYSTATISTICS_TIME);
        String[] hoursMinutes = time.split(":");
        int targetHour = Integer.parseInt(hoursMinutes[0]);
        int targetMin = Integer.parseInt(hoursMinutes[1]);
        startExecutionAt(targetHour, targetMin, 0);
    }

    public void startExecutionAt(int targetHour, int targetMin, int targetSec) {
        Runnable taskWrapper = new Runnable(){

            @Override
            public void run()
            {
                addDataToCSV(CSV_FILE_PATH);
                startExecutionAt(targetHour, targetMin, targetSec);
            }

        };
        long delay = computeNextDelay(targetHour, targetMin, targetSec);
        executorService.schedule(taskWrapper, delay, TimeUnit.SECONDS);
    }

    private long computeNextDelay(int targetHour, int targetMin, int targetSec) {
        LocalDateTime localNow = LocalDateTime.now();
        ZoneId currentZone = ZoneId.systemDefault();
        ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
        ZonedDateTime zonedNextTarget = zonedNow.withHour(targetHour).withMinute(targetMin).withSecond(targetSec);
        if(zonedNow.compareTo(zonedNextTarget) > 0)
            zonedNextTarget = zonedNextTarget.plusDays(1);

        Duration duration = Duration.between(zonedNow, zonedNextTarget);
        return duration.getSeconds();
    }

    public void stop() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addDataToCSV(String output) {
        File file = new File(output);
        try {
            FileWriter writer = new FileWriter(file);
            List<String> header = new ArrayList<>();
            header.add("Vaccination Center");
            header.add("Vaccination Time");
            header.add("SNS User");

            String collect = header.stream().collect(Collectors.joining(";"));
            writer.write(collect);

            for (VaccinationCenter vaccinationCenter : company.getVaccinationCenterStore().getVaccinationCenters()){
                for(VaccineAdministration administration : vaccinationCenter.getListAdministratedVaccines()){
                    if (DateUtils.isSameDay(administration.getVaccinationTime(), new Date())){
                        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

                        List<String> data = new ArrayList<>();
                        data.add(vaccinationCenter.getName());
                        data.add(dateFormat.format(administration.getVaccinationTime()));
                        data.add(administration.getUserArrival().getSnsUser().getEmailAddress());

                        String rowdata = data.stream().collect(Collectors.joining(SEPARATOR));
                        writer.write(rowdata);
                        writer.write("\n");
                    }
                }
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

