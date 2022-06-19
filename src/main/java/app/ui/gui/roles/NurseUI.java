package app.ui.gui.roles;

import app.controller.ChoosingVaccinationCenterController;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.ui.gui.Appfx;
import app.ui.gui.MainUI;
import app.ui.gui.US.ctrl.US8ctrl;
import app.ui.gui.US.ui.US17ui;
import app.ui.gui.US.ui.US7ui;
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
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Nurse ui.
 */
public class NurseUI implements Initializable {
    private Stage stage;
    private ChoosingVaccinationCenterController controller;
    private boolean pressed = false;
    /**
     * The constant vaccinationCenter.
     */
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

    /**
     * Sets main app.
     *
     * @param mainAppfx the main appfx
     */
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }



    public void initialize(URL arg0, ResourceBundle arg1){
        controller = new ChoosingVaccinationCenterController();
        List<VaccinationCenter> centers = controller.getVaccinationCenters();
        comboVac.getItems().addAll(centers);
        btnLeft.setDisable(true);
        btnRight.setDisable(true);


    }

    /**
     * Btn confirm.
     *
     * @param event the event
     */
    @FXML
    void btnConfirm(ActionEvent event) {
            btnLeft.setDisable(false);
            btnRight.setDisable(false);
            vaccinationCenter = comboVac.getValue();




    }


    /**
     * Get vaccination center vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter(){
        return this.vaccinationCenter;
    }

    /**
     * Btn press.
     *
     * @param event the event
     */
    @FXML
    void btnPress(ActionEvent event) {
        pressed = true;
    }


    /**
     * Btn us 7.
     *
     * @param event the event
     * @throws Exception the exception
     */
    @FXML
    void btnUS7(ActionEvent event) throws Exception {

        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/US/7s1.fxml"));
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


    /**
     * Btn us 8.
     *
     * @param event the event
     * @throws Exception the exception
     */
    @FXML
    void btnUS8(ActionEvent event) throws Exception {

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


    /**
     * Btn back.
     *
     * @param event the event
     * @throws Exception the exception
     */
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
