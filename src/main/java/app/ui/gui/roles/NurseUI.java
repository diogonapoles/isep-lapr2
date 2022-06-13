package app.ui.gui.roles;

import app.controller.ChoosingVaccinationCenterController;
import app.domain.model.vaccinationCenter.VaccinationCenter;
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

public class NurseUI implements Initializable {
    private Stage stage;
    private ChoosingVaccinationCenterController controller;
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



    public void initialize(URL arg0, ResourceBundle arg1){
        controller = new ChoosingVaccinationCenterController();
        List<VaccinationCenter> centers = controller.getVaccinationCenters();
        comboVac.getItems().addAll(centers);
        btnLeft.setDisable(true);
        btnRight.setDisable(true);


    }

    @FXML
    void btnConfirm(ActionEvent event) {
        btnLeft.setDisable(false);
        btnRight.setDisable(false);

    }






    @FXML
    void btnUS7(ActionEvent event) {

    }






    @FXML
    void btnUS8(ActionEvent event) {

    }







    @FXML
    void btnBack(ActionEvent event) {
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
