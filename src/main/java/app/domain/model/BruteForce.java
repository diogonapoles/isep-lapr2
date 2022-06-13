package app.domain.model;

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
    public int[] createInputList(int timeInterval, Date start, Date end, String startString, String endString, List<UserArrival> listUserArrival, List<UserLeaving> listUserLeaving) {
        int listLength = getListLength(timeInterval, startString, endString);
        Calendar startCalendar = Calendar.getInstance();
        List<UserArrival> arrivalList = new ArrayList<>();
        List<UserLeaving> leavingList = new ArrayList<>();

        for (UserArrival arrival : listUserArrival){
            if (arrival.getArrivalTime().equals(start) || arrival.getArrivalTime().after(start)) {
                arrivalList.add(arrival);
            }
        }
        for (UserLeaving leaving : listUserLeaving){
            if (leaving.getLeavingDate().equals(end) || leaving.getLeavingDate().before(end)) {
                leavingList.add(leaving);
            }
        }

        int[] diffList = new int[listLength];
        int[] arrivalCount = new int[listLength];
        int[] leavingCount = new int[listLength];

        startCalendar.setTime(start);
        for (int i = 0; i < listLength; i++) {
            int counter=0;
            Calendar endCalendar = startCalendar;
            endCalendar.add(Calendar.MINUTE, timeInterval);
            for (UserArrival arrival : arrivalList){
                Calendar arrivalTime = Calendar.getInstance();
                arrivalTime.setTime(arrival.getArrivalTime());
                if (arrivalTime.equals(startCalendar) || arrivalTime.after(startCalendar)){
                    if (arrivalTime.equals(endCalendar) || arrivalTime.before(endCalendar)){
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
            for (UserLeaving leaving : leavingList){
                Calendar leavingTime = Calendar.getInstance();
                leavingTime.setTime(leaving.getLeavingDate());
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
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("hh:mm");
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
