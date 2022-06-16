package app.domain.model;

import app.controller.App;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.UserLeaving;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class BruteForce {
    private Company oCompany;

    public BruteForce(Company oCompany) {
        this.oCompany = oCompany;
    }

    public int[] createInputList(int timeInterval, Date start, Date end, String startString, String endString, List<UserArrival> listUserArrival, List<UserLeaving> listUserLeaving) {
        int listLength = getListLength(timeInterval, startString, endString);
        Calendar startCalendar = Calendar.getInstance();
        List<Date> arrivalList = new ArrayList<>();
        List<Date> leavingList = new ArrayList<>();

        for (Date arrival : oCompany.getLegacySystemData().getArrivalList()){
            if (arrival.equals(start) || arrival.after(start)) {
                arrivalList.add(arrival);
            }
        }
        for (Date leaving : oCompany.getLegacySystemData().getLeavingList()){
            if (leaving.equals(end)) {
                leavingList.add(leaving);
                break;
            }
            if (leaving.before(end) && leaving.after(start))
                leavingList.add(leaving);
        }

        int[] diffList = new int[listLength];
        int[] arrivalCount = new int[listLength];
        int[] leavingCount = new int[listLength];

        startCalendar.setTime(start);
        for (int i = 0; i < listLength; i++) {
            int counter=0;
            Calendar endCalendar = startCalendar;
            endCalendar.add(Calendar.MINUTE, timeInterval);
            for (Date arrival : arrivalList){
                Calendar arrivalTime = Calendar.getInstance();
                arrivalTime.setTime(arrival);
                if (arrivalTime.compareTo(startCalendar)==0 || arrivalTime.compareTo(startCalendar)==1){
                    if (arrivalTime.compareTo(endCalendar)==0 || arrivalTime.compareTo(endCalendar)==-1){
                        counter++;
                    }
                }
            }
            startCalendar.add(Calendar.MINUTE, timeInterval);
            arrivalCount[i] = counter;
        }

        for (int i = 0; i < listLength; i++) {
            int counter=0;
            Calendar endCalendar = startCalendar;
            endCalendar.add(Calendar.MINUTE, timeInterval);
            for (Date leaving : leavingList){
                Calendar leavingTime = Calendar.getInstance();
                leavingTime.setTime(leaving);
                if (leavingTime.equals(startCalendar) || leavingTime.after(startCalendar)){
                    if (leavingTime.equals(endCalendar) || leavingTime.before(endCalendar)){
                        counter++;
                    }
                }
            }
            startCalendar.add(Calendar.MINUTE, timeInterval);
            leavingCount[i] = counter;
        }

        for (int i = 0; i < listLength; i++) {
            diffList[i] = arrivalCount[i]-leavingCount[i];
        }

        return diffList;
    }

    public int getListLength(int timeInterval, String startString, String endString){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime t1 = LocalTime.parse(startString, fmt);
        LocalTime t2 = LocalTime.parse(endString, fmt);
        long minutes = ChronoUnit.MINUTES.between(t1, t2);

        int length = (int) (minutes/timeInterval);
        if (length == 0 || length == 1){
            throw new IllegalArgumentException("Problem dividing the time given");
        }else{
            return length;
        }
    }

    public int[] maxSubArray(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < n; left++) {

            int runningWindowSum = 0;

            for (int right = left; right < n; right++) {
                runningWindowSum += nums[right];

                if (runningWindowSum > maximumSubArraySum) {
                    maximumSubArraySum = runningWindowSum;
                    start = left;
                    end = right;
                }
            }
        }
        int [] maxSubArray = new int[end-start+1];
        int counter=0;
        for (int i = start; i < end+1; i++) {
            maxSubArray[counter] = nums[i];
        }
        return maxSubArray;
    }

    public int maxSum(int[] maxSubArray){
        int sum=0;
        for (int i = 0; i < maxSubArray.length; i++) {
            sum += maxSubArray[i];
        }
        return sum;
    }
}
