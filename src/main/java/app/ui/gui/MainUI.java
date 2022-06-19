package app.ui.gui;

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

/**
 * The type Main ui.
 */
public class MainUI implements Initializable {
    private Appfx mainAppfx;
    private Stage stage ;
    @FXML
    private Button btnDEv;

    @FXML
    private Button btnlogin;

    /**
     * Sets main app.
     *
     * @param mainAppfx the main appfx
     */
    @FXML
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }

    /**
     * Btn dev.
     *
     * @param event the event
     * @throws Exception the exception
     */
    @FXML
    void btnDev(ActionEvent event) throws Exception {
/*
        try {
            DevTeamUI UI = (DevTeamUI) mainAppfx.replaceSceneContent("/fxml/DevTeam.fxml");
            UI.setMainApp(mainAppfx);
        } catch (Exception ex) {
            Logger.getLogger(Appfx.class.getName()).log(Level.SEVERE, null, ex);
        }




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

    /**
     * Btn login.
     *
     * @param event the event
     */
    @FXML
    void btnLogin(ActionEvent event) {
    /*
        try {
            LoginScene1UI UI = (LoginScene1UI) mainAppfx.replaceSceneContent("/fxml/Login1.fxml");
            UI.setMainApp(mainAppfx);
        } catch (Exception ex) {
            Logger.getLogger(Appfx.class.getName()).log(Level.SEVERE, null, ex);
        }

     */


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

