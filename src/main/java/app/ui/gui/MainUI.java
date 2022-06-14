package app.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainUI {
    private Appfx mainAppfx;
    private Stage stage ;
    @FXML
    private Button btnDEv;

    @FXML
    private Button btnlogin;

    @FXML
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }
    @FXML
    void btnDev(ActionEvent event) throws Exception {

/*
            DevTeamUI devTeamUI = (DevTeamUI) mainAppfx.replaceSceneContent("/fxml/DevTeam.fxml");
            devTeamUI.setMainApp(mainAppfx);
*/


        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/DevTeam.fxml"));
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
    void btnLogin(ActionEvent event) {


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

