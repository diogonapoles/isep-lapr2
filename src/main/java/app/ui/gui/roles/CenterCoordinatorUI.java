package app.ui.gui.roles;

import app.controller.ChoosingVaccinationCenterController;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.ui.gui.Appfx;
import app.ui.gui.LoginScene1UI;
import app.ui.gui.US.ui.US16ui;
import app.ui.gui.US.ui.US17ui;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CenterCoordinatorUI implements Initializable {
    private Stage stage;
    private ChoosingVaccinationCenterController controller;
    public static VaccinationCenter vaccinationCenter;
    private Appfx mainAppfx;

    @FXML
    private Button btnBack;

    @FXML
    private ChoiceBox<VaccinationCenter> comboVac;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnLeft;

    @FXML
    private Button btnRight;
     @FXML
     private Button btnCenter;


    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }




    public void initialize(URL arg0, ResourceBundle arg1){
        controller = new ChoosingVaccinationCenterController();
        List<VaccinationCenter> centers = controller.getVaccinationCenters();
        comboVac.getItems().addAll(centers);
        btnLeft.setDisable(true);
        btnRight.setDisable(true);
        btnCenter.setDisable(true);

    }

    @FXML
    void btnConfirm(ActionEvent event) {
        btnLeft.setDisable(false);
        btnRight.setDisable(false);
        btnCenter.setDisable(false);
        vaccinationCenter = comboVac.getValue();

    }






    @FXML
    void btnUS15(ActionEvent event) {
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
    void btnUS16(ActionEvent event) throws IOException {
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
    void btnUS17(ActionEvent event) throws IOException {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/US/17s1.fxml"));
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
    void btnBack(ActionEvent event) throws Exception {


        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/Login1.fxml"));
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
