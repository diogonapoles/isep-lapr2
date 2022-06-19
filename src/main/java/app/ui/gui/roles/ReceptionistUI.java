package app.ui.gui.roles;

import app.ui.gui.Appfx;
import app.ui.gui.MainUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * The type Receptionist ui.
 */
public class ReceptionistUI implements Initializable {
    private Stage stage;
    @FXML
    private Button btnBack;
    private Appfx mainAppfx;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}