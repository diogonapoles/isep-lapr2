package app.domain.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The type Brute force.
 */
public class BruteForce {
    private Company oCompany;

    /**
     * Instantiates a new Brute force.
     *
     * @param oCompany the o company
     */
    public BruteForce(Company oCompany) {
        this.oCompany = oCompany;
    }

    /**
     * Create input list int [ ].
     *
     * @param timeInterval the time interval
     * @param opening      the opening
     * @return the int [ ]
     */
    public int[] createInputList(int timeInterval, Date opening) {
        int listLength = getListLength(timeInterval);
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = startCalendar.getInstance();
        List<Date> arrivalList = oCompany.getLegacySystemData().getArrivalList();
        List<Date> leavingList = oCompany.getLegacySystemData().getLeavingList();

        int[] diffList = new int[listLength];
        int[] arrivalCount = new int[listLength];
        int[] leavingCount = new int[listLength];

        startCalendar.setTime(opening);
        for (int i = 0; i < listLength; i++) {
            int counterArrival=0;
            int counterLeaving=0;
            endCalendar.setTime(startCalendar.getTime());
            endCalendar.add(Calendar.MINUTE, timeInterval);
            for (Date arrival : arrivalList){
                if (arrival.compareTo(startCalendar.getTime())==0 || arrival.compareTo(startCalendar.getTime()) > 0){
                    if (arrival.compareTo(endCalendar.getTime()) < 0){
                        counterArrival++;
                    }
                }
            }
            for (Date leaving : leavingList){
                if (leaving.compareTo(startCalendar.getTime())==0 || leaving.compareTo(startCalendar.getTime()) > 0){
                    if (leaving.compareTo(endCalendar.getTime()) < 0){
                        counterLeaving++;
                    }
                }
            }
            startCalendar.add(Calendar.MINUTE, timeInterval);
            arrivalCount[i] = counterArrival;
            leavingCount[i] = counterLeaving;
        }

        for (int i = 0; i < listLength; i++) {
            diffList[i] = arrivalCount[i]-leavingCount[i];
        }

        return diffList;
    }

    /**
     * Find day string.
     *
     * @param arrivals the arrivals
     * @return the string
     */
    public String findDay(List<Date> arrivals){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(arrivals.get(1));
    }

    private static int TIME = 720;

    /**
     * Get list length int.
     *
     * @param timeInterval the time interval
     * @return the int
     */
    public int getListLength(int timeInterval){
        int length = TIME/timeInterval;
        if (length == 0 || length == 1){
            throw new IllegalArgumentException("Problem dividing the time given");
        }else{
            return length;
        }
    }

    /**
     * Max sub array int [ ].
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public int[] maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = currSum;
        int maxPosition = 0;


        for (int i = 0; i < nums.length; i++) {
            currSum = nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                currSum = currSum + nums[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxPosition = i;
                }
            }
        }
        int[] max = new int[3];
        max[0]=maxPosition;
        max[1]=findLimit(nums,maxPosition,maxSum);
        max[2]=maxSum;

        return max;
    }

    /**
     * Find limit int.
     *
     * @param nums   the nums
     * @param maxPos the max pos
     * @param maxSum the max sum
     * @return the int
     */
    public int findLimit(int[] nums, int maxPos, int maxSum){
        int sum=0;
        int i = maxPos;
        while (sum != maxSum) {
            sum += nums[i];
            i++;
        }
        return i;
    }
}
