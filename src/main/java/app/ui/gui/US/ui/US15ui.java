package app.ui.gui.US.ui;

import app.controller.centerCoordinator.VaccinatedToFileController;
import app.ui.console.utils.Utils;
import app.ui.gui.US.ctrl.US15ctrl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class US15ui implements Initializable {
    private US15ctrl controller;
    private Stage stage;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnConfirm;

    @FXML
    private TextField fileTF;

    @FXML
    private Button btnOK1;

    @FXML
    private Button btnOK2;



    private List lista= new ArrayList();

    public US15ui() {
        controller = new US15ctrl();
    }


    @FXML
    void btnConfirm(ActionEvent event) {
        String fileName = inputData();
        controller.getListAdministratedVaccines();

        if (controller.validateFileName(fileName)) {
            try {
                controller.writeToFile(fileName);
                try {
                    var loader = new FXMLLoader(getClass().getResource("/fxml/US/15s2.fxml"));
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

            } catch (Exception e) {
                try {
                    var loader = new FXMLLoader(getClass().getResource("/fxml/US/15s3.fxml"));
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
                throw new RuntimeException("couldn't write the data on the file");
            }
        }
        else {
            System.out.println("Invalid File Name");
            try {
                var loader = new FXMLLoader(getClass().getResource("/fxml/US/15s3.fxml"));
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





    private String inputData() {
        String fileName = fileTF.getText();
        return fileName;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new US15ctrl();
    }

    @FXML
    public void btnOK2(ActionEvent event) throws Exception {


        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/US/15s1.fxml"));
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

}