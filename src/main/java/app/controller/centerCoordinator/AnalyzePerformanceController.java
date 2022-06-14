package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnalyzePerformanceController {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;

    public AnalyzePerformanceController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    public boolean validateTimeIntervalForVaccinationCenter(int timeInterval, String start, String end){
        return vaccinationCenter.validateTimeIntervalForVaccinationCenter(timeInterval, start, end);
    }

    public Date setTime(String time, boolean flag){
        return vaccinationCenter.analyzePerformanceTime(time, flag);
    }

    public int[] createInputList(int timeInterval, String startString, String endString){
        Date start = stringToDate(startString);
        Date end = stringToDate(endString);

        if (start == null || end == null){
            throw new IllegalArgumentException("Invalid Dates");
        }

        return oCompany.getBruteForceAlgorithm().createInputList(timeInterval, start, end, startString, endString, vaccinationCenter.getListUserArrival(), vaccinationCenter.getListUserLeaving());
    }

    public int[] getMaxSubArrayBruteForce(int[] input){
        return oCompany.getBruteForceAlgorithm().maxSubArray(input);
    }

    public int getMaxSumBruteForce(int[] input){
        return oCompany.getBruteForceAlgorithm().maxSum(input);
    }

    public Date stringToDate(String strDate) {
        Date date;
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            date = df.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public void printArray(int[] array){
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    public int[] getMaxSubArrayBenchmark(int[] inputList) {
        return oCompany.getBenchmarkAlgorithm().max(inputList);
    }

    public int getMaxSumBruteBenchmark(int[] maxSubArray) {
        return oCompany.getBenchmarkAlgorithm().sum(maxSubArray);
    }
}
