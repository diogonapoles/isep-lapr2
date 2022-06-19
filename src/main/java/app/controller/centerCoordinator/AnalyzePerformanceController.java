package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Benchmark;
import app.domain.model.BruteForce;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AnalyzePerformanceController {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;
    private BruteForce bruteForceAlgorithm;
    private Benchmark benchmarkAlgorithm;

    public AnalyzePerformanceController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
        this.bruteForceAlgorithm = new BruteForce(oCompany);
        this.benchmarkAlgorithm = new Benchmark();
    }

    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    public void setWorking(VaccinationCenter vc) {
        vaccinationCenter = vc;
    }

    public boolean validateTimeIntervalForVaccinationCenter(int timeInterval){
        return vaccinationCenter.validateTimeIntervalForVaccinationCenter(timeInterval);
    }

    public int[] createInputList(int timeInterval, String day){
        String startStr = "08:00";
        Date start = stringToFullDate(day.concat(" ").concat(startStr));

        return bruteForceAlgorithm.createInputList(timeInterval, start);
    }

    public int[] getMaxSubArrayBruteForce(int[] input){
        return bruteForceAlgorithm.maxSubArray(input);
    }

    public String findDay(){
        return bruteForceAlgorithm.findDay(oCompany.getLegacySystemData().getArrivalList());
    }

    public Date stringToFullDate(String strDate) {
        Date date;
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            df.setLenient(false);
            date = df.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public void printArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public int[] getMaxSubArrayBenchmark(int[] inputList) {
        return benchmarkAlgorithm.max(inputList);
    }

    public int getMaxSumBenchmark(int[] maxSubArray) {
        return benchmarkAlgorithm.sum(maxSubArray);
    }

    public int[] findMaxSubarray(int[] inputList, int i, int j) {
        int[] subArray = new int[j-i];
        int pos = i;
        for (int k = 0; k < j; k++) {
            subArray[k] = inputList[pos];
            pos++;
        }
        return subArray;
    }

    public String findTimeInterval(String day, int timeInterval, int i, int length) {
        try {
            String start = "08:00";
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            Date d1 = df.parse(start);
            Calendar s = Calendar.getInstance();
            s.setTime(d1);
            s.add(Calendar.MINUTE, timeInterval*i);
            String startTime = df.format(s.getTime());

            Calendar e = Calendar.getInstance();
            e.setTime(d1);
            e.add(Calendar.MINUTE, timeInterval*length);
            String endTime = df.format(e.getTime());

            return "[" + day + " " + startTime + ", " + day + " " + endTime + "]";

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
