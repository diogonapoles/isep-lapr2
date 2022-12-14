package app.ui.gui.US.ui;

import app.ui.gui.Appfx;
import app.ui.gui.US.ctrl.US7ctrl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * The type Us 7 ui.
 */
public class US7ui {

    private US7ctrl controller;
    private String snsUserNumber;
    private String adverseReactions;
    private Stage stage;
    private Appfx mainAppfx;


    @FXML
    private Button btnBack ;
    @FXML
    private TextField reactionTextField;

    @FXML
    private TextField userTextField;
    @FXML
    private Button btnOK1;
    @FXML
    private Button btnOK2;

    /**
     * Sets main app.
     *
     * @param mainAppfx the main appfx
     */
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }


    /**
     * Btn ok 1.
     *
     * @param event the event
     */
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

    /**
     * Btn ok 2.
     *
     * @param event the event
     */
    @FXML
    public void btnOK2(ActionEvent event) {
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
     * Instantiates a new Us 7 ui.
     */
    public US7ui() {
        controller = new US7ctrl();
    }


    /**
     * Btn confirm.
     *
     * @param event the event
     */
    @FXML
    public void btnConfirm(ActionEvent event) {
        snsUserNumber = userTextField.getText();

        if (isUserInRecoveryList(snsUserNumber)) {
            adverseReactions = reactionTextField.getText();
            try {
                var loader = new FXMLLoader(getClass().getResource("/fxml/US/7s2.fxml"));
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
        } else
            try {
                var loader = new FXMLLoader(getClass().getResource("/fxml/US/7s3.fxml"));
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









    private Boolean isUserInRecoveryList(String snsUserNumber) {
        return this.controller.isUserInRecoveryList(snsUserNumber);
    }

    /**
     * Btn back.
     *
     * @param event the event
     */
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


}