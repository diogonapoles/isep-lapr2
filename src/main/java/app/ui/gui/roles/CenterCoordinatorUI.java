package app.ui.gui.roles;

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
import java.util.List;
import java.util.ResourceBundle;

public class CenterCoordinatorUI implements Initializable {
    private Stage stage;
    @FXML
    private Button btnBack;

    @FXML
    private ChoiceBox<String> comboVac;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnLeft;

    @FXML
    private Button btnRight;



    public void initialize(URL arg0, ResourceBundle arg1){

        List<String> centers = new ArrayList<>();
        centers.add("center1");
        centers.add("center2");
        centers.add("center3");
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
    void btnUS15(ActionEvent event) {

    }






    @FXML
    void btnUS16(ActionEvent event) {

    }


    @FXML
    void btnUS17(ActionEvent event) {

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
