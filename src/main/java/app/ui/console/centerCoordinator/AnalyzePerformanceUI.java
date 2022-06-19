package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.AnalyzePerformanceController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class AnalyzePerformanceUI implements Runnable{
    private final AnalyzePerformanceController controller;

    public AnalyzePerformanceUI() {
        controller = new AnalyzePerformanceController();
    }

    private static final String BRUTEFORCE_ALGORITHM = "BruteForce";
    private static final String BENCHMARK_ALGORITHM = "Benchmark";

    public void run() {
        if (controller.getWorking() == null) {
            System.out.println("Doesn't exist");
            return;
        }

        Properties props = getProperties();

        String day;
        try{
            day = controller.findDay();
        }catch (Exception e){
            System.out.println("You have to load a legacy file first");
            return;
        }


        int timeInterval = Utils.readIntegerFromConsole("Type the desired time interval (in minutes):");
        if (!controller.validateTimeIntervalForVaccinationCenter(timeInterval)) {
            System.out.println("Interval not found");
            return;
        }

        String algorithm = props.getProperty(Constants.PARAMS_ALGORITHM);


        int[] inputList = controller.createInputList(timeInterval, day);
        if (algorithm.equals(BRUTEFORCE_ALGORITHM)) {
            int[] maxInfo = controller.getMaxSubArrayBruteForce(inputList);
            int[] maxSubArray = controller.findMaxSubarray(inputList, maxInfo[0], maxInfo[1]);
            System.out.println("Input List:");
            controller.printArray(inputList);

            System.out.println("Maximum Subarray:");
            controller.printArray(maxSubArray);

            System.out.println("Max Sum:" + maxInfo[2]);

            System.out.println("Time Interval:");
            System.out.println(controller.findTimeInterval(day, timeInterval, maxInfo[0], maxSubArray.length));
        }
        if (algorithm.equals(BENCHMARK_ALGORITHM)) {
            System.out.println("Input List:");
            controller.printArray(inputList);

            System.out.println("Maximum Subarray:");
            int[] result = controller.getMaxSubArrayBenchmark(inputList);
            System.out.println(Arrays.toString(result));

            int maxSum = controller.getMaxSumBenchmark(result);

            System.out.println("Max Sum:" + maxSum);
        }

    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_ALGORITHM, "BruteForce");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_ALGORITHM);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }
}
