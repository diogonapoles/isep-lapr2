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
import java.util.Date;
import java.util.Properties;

public class US16ui {
    private final US16ctrl controller;
    private Stage stage;
    private Appfx mainAppfx;
    @FXML
    private TextField dateTF;

    @FXML
    private TextField endTF;

    @FXML
    private TextField intervalTF;

    @FXML
    private TextField startTF;

    @FXML
    private Button btnOK1;
    @FXML
    private Button btnOK2;

    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }




        @FXML
        private Button btnBack;

        @FXML
        private Button btnConfirm;


        @FXML
         void btnConfirm(ActionEvent event) {
            boolean success =true;
            if (controller.getWorking() == null) {
                System.out.println("Doesn't exist");
                return;
            }
            Properties props = new Properties();
            try {
                props.load(new FileInputStream("./config.properties"));
            } catch (IOException e) {
                System.out.println("Could not read config file");
                return;
            }
            String dateString = dateTF.getText();
             Date date = controller.stringToDate(dateString);
            if (date == null){
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
                success = false;
            }

            String start = startTF.getText();
            if (!start.matches("\\d{2}:\\d{2}")){
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
                success = false;
            }
            String end = endTF.getText();
            if (!end.matches("\\d{2}:\\d{2}")){
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
                success = false;
            }

                int timeInterval = Integer.parseInt(intervalTF.getText());
                if (!controller.validateTimeIntervalForVaccinationCenter(timeInterval, start, end)) {
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
                    success = false;
                }


            String algorithm = props.getProperty(Constants.PARAMS_ALGORITHM);
            int[] inputList = controller.createInputList(timeInterval, start, end);
            if (algorithm.equals(BRUTEFORCE_ALGORITHM)) {
                /*//int[] maxSubArray = controller.getMaxSubArrayBruteForce(inputList);
                int maxSum = controller.getMaxSumBruteForce(maxSubArray);
                System.out.println("Input List:");
                controller.printArray(inputList);

                System.out.println("Maximum Subarray:");
                controller.printArray(maxSubArray);

                System.out.println("Max Sum:" + maxSum);*/
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




    public US16ui() {
        controller = new US16ctrl();
    }

    private static final String BRUTEFORCE_ALGORITHM = "BruteForce";
    private static final String BENCHMARK_ALGORITHM = "Benchmark";

    public void run() {
















    }
}
