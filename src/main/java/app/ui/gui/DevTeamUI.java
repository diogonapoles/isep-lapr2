package app.ui.gui;


import app.ui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DevTeamUI implements Initializable {
    private Appfx mainAppfx;
    private Stage stage;
    @FXML
    private Button btnBack;
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }
    @FXML
    void btnBack(ActionEvent event) throws Exception {
      /*
        try {
            MainUI UI = (MainUI) mainAppfx.replaceSceneContent("/fxml/Main.fxml");
            UI.setMainApp(mainAppfx);
        } catch (Exception ex) {
            Logger.getLogger(Appfx.class.getName()).log(Level.SEVERE, null, ex);
        }

       */




        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
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

    }
}
