package app.ui.gui.roles;

import app.ui.gui.Appfx;
import app.ui.gui.DevTeamUI;
import app.ui.gui.LoginScene1UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The type Admin ui.
 */
public class AdminUI {
    private Stage stage;
    private Appfx mainAppfx;
    @FXML
    private Button btnBack;

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
            // scene.getStylesheets().add(getClass( ).getResource("/styles/Styles.css").toExternalForm());
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * Sets main app.
     *
     * @param mainAppfx the main appfx
     */
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }

}
