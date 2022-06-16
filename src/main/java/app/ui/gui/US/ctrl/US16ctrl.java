package app.ui.gui.US.ctrl;


import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.ui.gui.roles.CenterCoordinatorUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class US16ctrl {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;

    public US16ctrl() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public VaccinationCenter getWorking() {
        vaccinationCenter= CenterCoordinatorUI.vaccinationCenter;
        //vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    public boolean validateTimeIntervalForVaccinationCenter(int timeInterval, String start, String end){
        return vaccinationCenter.validateTimeIntervalForVaccinationCenter(timeInterval);
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

        return oCompany.getBruteForceAlgorithm().createInputList(timeInterval, start);
    }

    public Date stringToDate(String strDate) {
        Date date;
        try {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
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
