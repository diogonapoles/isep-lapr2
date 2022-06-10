package app.domain.model;

import app.controller.App;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.shared.Constants;
import com.opencsv.CSVWriter;
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

public class Stats {
    private App oApp;
    private static Company oCompany;

    public Stats() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    volatile boolean isStopIssued;

    public void start() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("/Users/diogonapoles/lei-22-s2-1dc-g13/config.properties"));
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


    private static final String CSV_FILE_PATH = "./result.csv";
    private static final String SEPARATOR = ";";



    public void addDataToCSV(String output) {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(output);
        Scanner sc = new Scanner(System.in);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with ';' as separator
            CSVWriter writer = new CSVWriter(outputfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains Data
            List<String[]> data = new ArrayList<String[]>();

            for (VaccinationCenter vaccinationCenter : oCompany.getVaccinationCenterStore().getVaccinationCenters()){
                for(VaccineAdministration administration : vaccinationCenter.getListAdministratedVaccines()){
                    if (DateUtils.isSameDay(administration.getVaccinationTime(), new Date())){
                        String center = vaccinationCenter.getName();

                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                        String date = dateFormat.format(administration.getVaccinationTime());

                        String user = administration.getUserArrival().getSnsUser().getEmailAddress();

                        String row = center.concat(SEPARATOR).concat(date).concat(SEPARATOR).concat(user);
                        String[] rowdata = row.split(SEPARATOR);
                        data.add(rowdata);
                    }
                }
            }

            writer.writeAll(data);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
