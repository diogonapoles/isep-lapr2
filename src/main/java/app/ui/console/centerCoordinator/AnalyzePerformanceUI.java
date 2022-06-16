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

        String dateString = Utils.readLineFromConsole("Insert date to analyze (dd/MM/yyyy):");
        Date date = controller.stringToDate(dateString);
        if (date == null){
            System.out.println("Date should be (dd/MM/yyyy)");
            return;
        }

        String start = Utils.readLineFromConsole("Start time (HH:mm):");
        if (!start.matches("\\d{2}:\\d{2}")){
            System.out.println("Time must be (HH:mm)");
        }

        String end = Utils.readLineFromConsole("End time (HH:mm):");
        if (!end.matches("\\d{2}:\\d{2}")){
            System.out.println("Time must be (HH:mm)");
        }

        int timeInterval = Utils.readIntegerFromConsole("Type the desired time interval (in minutes):");
        if (!controller.validateTimeIntervalForVaccinationCenter(timeInterval, start, end)) {
            System.out.println("Interval not found");
            return;
        }

        String algorithm = props.getProperty(Constants.PARAMS_ALGORITHM);


        int[] inputList = controller.createInputList(timeInterval,dateString, start, end);
        if (algorithm.equals(BRUTEFORCE_ALGORITHM)) {
            int[] maxSubArray = controller.getMaxSubArrayBruteForce(inputList);
            int maxSum = controller.getMaxSumBruteForce(maxSubArray);
            System.out.println("Input List:");
            controller.printArray(inputList);

            System.out.println("Maximum Subarray:");
            controller.printArray(maxSubArray);

            System.out.println("Max Sum:" + maxSum);
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
