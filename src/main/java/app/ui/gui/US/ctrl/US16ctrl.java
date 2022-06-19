package app.ui.gui.US.ctrl;


import app.controller.App;
import app.domain.model.Benchmark;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.BruteForce;
import app.ui.gui.roles.CenterCoordinatorUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Us 16 ctrl.
 */
public class US16ctrl {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter = CenterCoordinatorUI.vaccinationCenter;
    private BruteForce bruteForceAlgorithm;
    private Benchmark benchmarkAlgorithm;

    /**
     * Instantiates a new Us 16 ctrl.
     */
    public US16ctrl() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
        this.bruteForceAlgorithm = new BruteForce(oCompany);
        this.benchmarkAlgorithm = new Benchmark();
    }


    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        return vaccinationCenter;
    }

    /**
     * Sets working.
     *
     * @param vc the vc
     */
    public void setWorking(VaccinationCenter vc) {
        vaccinationCenter = vc;
    }

    /**
     * Validate time interval for vaccination center boolean.
     *
     * @param timeInterval the time interval
     * @return the boolean
     */
    public boolean validateTimeIntervalForVaccinationCenter(int timeInterval){
        return vaccinationCenter.validateTimeIntervalForVaccinationCenter(timeInterval);
    }

    /**
     * Create input list int [ ].
     *
     * @param timeInterval the time interval
     * @param day          the day
     * @return the int [ ]
     */
    public int[] createInputList(int timeInterval, String day){
        String startStr = "08:00";
        Date start = stringToFullDate(day.concat(" ").concat(startStr));

        return bruteForceAlgorithm.createInputList(timeInterval, start);
    }

    /**
     * Get max sub array brute force int [ ].
     *
     * @param input the input
     * @return the int [ ]
     */
    public int[] getMaxSubArrayBruteForce(int[] input){
        return bruteForceAlgorithm.maxSubArray(input);
    }

    /**
     * Find day string.
     *
     * @return the string
     */
    public String findDay(){
        return bruteForceAlgorithm.findDay(oCompany.getLegacySystemData().getArrivalList());
    }

    /**
     * String to full date date.
     *
     * @param strDate the str date
     * @return the date
     */
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

    /**
     * Print array.
     *
     * @param array the array
     */
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

    /**
     * Get max sub array benchmark int [ ].
     *
     * @param inputList the input list
     * @return the int [ ]
     */
    public int[] getMaxSubArrayBenchmark(int[] inputList) {
        return benchmarkAlgorithm.max(inputList);
    }

    /**
     * Gets max sum benchmark.
     *
     * @param maxSubArray the max sub array
     * @return the max sum benchmark
     */
    public int getMaxSumBenchmark(int[] maxSubArray) {
        return benchmarkAlgorithm.sum(maxSubArray);
    }

    /**
     * Find max subarray int [ ].
     *
     * @param inputList the input list
     * @param i         the
     * @param j         the j
     * @return the int [ ]
     */
    public int[] findMaxSubarray(int[] inputList, int i, int j) {
        int[] subArray = new int[j-i];
        int pos = i;
        for (int k = 0; k < j; k++) {
            subArray[k] = inputList[pos];
            pos++;
        }
        return subArray;
    }

    /**
     * Find time interval string.
     *
     * @param day          the day
     * @param timeInterval the time interval
     * @param i            the
     * @param length       the length
     * @return the string
     */
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
