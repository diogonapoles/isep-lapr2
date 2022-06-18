package app.ui.gui.US.ui;


import app.controller.centerCoordinator.AnalyzePerformanceController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import app.ui.gui.Appfx;
import app.ui.gui.MainUI;
import app.ui.gui.US.ctrl.US16ctrl;
import com.sun.jdi.event.ExceptionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class US16ui {
    private final US16ctrl controller;
    private Stage stage;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnConfirm;

    @FXML
    private TextField intervalTF;

    @FXML
    private Button btnOK1;

    @FXML
    private Button btnOK2;



    public US16ui() {
        controller = new US16ctrl();
    }
    @FXML
    public void btnOK2(ActionEvent event) throws Exception {


        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/US/16s1.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }catch (Exception ex){
            ex.printStackTrace();
        }



    }
    @FXML
    public void btnOK1(ActionEvent event) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/CenterCoordinator.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void btnBack(ActionEvent event) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/CenterCoordinator.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void btnConfirm(ActionEvent event) {
        boolean success=true;
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

        String day;
        try{
            day = controller.findDay();
        }catch (Exception e){
            System.out.println("You have to load a legacy file first");
            return;
        }


        int timeInterval = Utils.readIntegerFromConsole("Type the desired time interval (in minutes):");
        if (!controller.validateTimeIntervalForVaccinationCenter(timeInterval)) {
            try {
                var loader = new FXMLLoader(getClass().getResource("/fxml/US/16s3.fxml"));
                Parent root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
                String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);

            }catch (Exception ex){
                ex.printStackTrace();
            }
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
        if(success){
            try {
                var loader = new FXMLLoader(getClass().getResource("/fxml/US/16s2.fxml"));
                Parent root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
                String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.setScene(scene);

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

    }


    private static final String BRUTEFORCE_ALGORITHM = "BruteForce";
    private static final String BENCHMARK_ALGORITHM = "Benchmark";


}
