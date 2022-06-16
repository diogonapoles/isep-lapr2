package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.AnalyzePerformanceController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
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

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Could not read config file");
            return;
        }


        String day = controller.findDay();

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
            int[] maxSubArray = controller.getMaxSubArrayBenchmark(inputList);
            int maxSum = controller.getMaxSumBruteBenchmark(maxSubArray);
            System.out.println("Input List:");
            controller.printArray(inputList);

            System.out.println("Maximum Subarray:");
            controller.printArray(maxSubArray);

            System.out.println("Max Sum:" + maxSum);
        }

    }
}
