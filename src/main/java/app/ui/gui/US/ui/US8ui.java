package app.ui.gui.US.ui;


import app.controller.nurse.VaccineAdministrationController;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.ui.console.utils.Utils;
import app.ui.gui.US.ctrl.US8ctrl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class US8ui implements Initializable {
    private US8ctrl controller;
 private VaccineAdministration vaccineAdministration;
 private UserArrival user;
    private Stage stage;
 private Vaccine vaccine;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnConfirm0;

    @FXML
    private Button btnConfirm1;

    @FXML
    private Button btnNo;

    @FXML
    private Button btnYes;
    @FXML
    private Button btnOK1;
    @FXML
    private Button btnOK2;

    @FXML
    private ChoiceBox<UserArrival> userCombo;

    @FXML
    private ChoiceBox<Vaccine> vacCombo;


    @FXML
    void btnConfirm0(ActionEvent event) {
        if (userCombo.getValue() != null) {
            if (controller.getWorking() == null) {
                System.out.println("Doesn't exist");
                return;
            } else {
                user = userCombo.getValue();
                btnConfirm1.setDisable(false);
                vacCombo.setDisable(false);
                List<Vaccine> vacs = new ArrayList<>();
                vacs = controller.getAvailableVaccinesForUser(user);
                vacCombo.getItems().addAll(vacs);


                if (user == null) {
                    return;
                }

            }

        }else{

        }
    }
    @FXML
    public void btnConfirm1(ActionEvent event) {
        if (vacCombo.getValue() != null) {
            vaccine = vacCombo.getValue();

            if (vaccine == null) {
                try {
                    var loader = new FXMLLoader(getClass().getResource("/fxml/US/8s3.fxml"));
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
             vaccineAdministration = controller.validateVaccineAdministration(user, vaccine);
            if (vaccineAdministration == null)
                vaccineAdministration = controller.createVaccineAdministration(user, vaccine, new Date());
            btnYes.setDisable(false);
            btnNo.setDisable(false);
        }else{

        }

    }
    @FXML
    void btnYes(ActionEvent event) {

        if (controller.addVaccineAdministration(vaccineAdministration)) {
            controller.removeFromWaitingRoom(user);
            controller.moveToRecoveryRoom(vaccineAdministration, vaccine);

                try {
                    var loader = new FXMLLoader(getClass().getResource("/fxml/US/8s2.fxml"));
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

        } else {
            try {
                var loader = new FXMLLoader(getClass().getResource("/fxml/US/8s3.fxml"));
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
    void btnNo(ActionEvent event){
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/US/8s3.fxml"));
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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controller = new US8ctrl();
        List<UserArrival> users = new ArrayList<>();
        users = controller.getWaitingRoom();
        userCombo.getItems().addAll(users);
        btnConfirm1.setDisable(true);
        vacCombo.setDisable(true);
        btnYes.setDisable(true);
        btnNo.setDisable(true);



    }
    @FXML
    public void btnBack(ActionEvent event) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/Nurse.fxml"));
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





    public US8ui() {

    }
    @FXML
    public void btnOK1(ActionEvent event) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/Nurse.fxml"));
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
    public void btnOK2(ActionEvent event) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/US/8s1.fxml"));
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
/*
    public void run() {
        if (controller.getWorking() == null) {
            System.out.println("Doesn't exist");
            return;
        } else {
            UserArrival user = (UserArrival) Utils.showAndSelectOne(controller.getWaitingRoom(), "Select SNS user from the waiting room:");
            if (user == null){
                return;
            }

            Vaccine vaccine = (Vaccine) Utils.showAndSelectOne(controller.getAvailableVaccinesForUser(user), "Available Vaccines for this user:");
            if (vaccine == null){
                return;
            }

            VaccineAdministration vaccineAdministration = controller.validateVaccineAdministration(user, vaccine);
            if (vaccineAdministration == null)
                vaccineAdministration = controller.createVaccineAdministration(user, vaccine, new Date());

            System.out.println(vaccineAdministration);
            boolean confirm = Utils.confirm("Do you want to record this vaccine? (s/n)");
            if(confirm){
                if(controller.addVaccineAdministration(vaccineAdministration)){
                    controller.removeFromWaitingRoom(user);
                    controller.moveToRecoveryRoom(vaccineAdministration, vaccine);
                    System.out.println("Success");
                }else{
                    System.out.println("Error saving this vaccine administration process");
                    return;
                }
            }
        }
    }

 */


}
