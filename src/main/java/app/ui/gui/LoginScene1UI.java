package app.ui.gui;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.console.MenuItem;
import app.ui.console.administrator.AdminUI;
import app.ui.console.centerCoordinator.CenterCoordinatorUI;
import app.ui.console.nurse.NurseUI;
import app.ui.console.receptionist.ReceptionistUI;
import app.ui.console.snsUser.SnsUserUI;
import app.ui.console.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class LoginScene1UI implements Initializable {
    private Stage stage ;
    private AuthController ctrl;
    private Appfx mainAppfx;
    @FXML
    private TextField idTextline ;
    @FXML
    private TextField pwdTextline;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnConfirm;



    @FXML
    void btnBack(ActionEvent event) throws IOException {


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
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }


    public boolean doLogin() {


        ctrl = new AuthController();

        int maxAttempts = 3;
        boolean success = false;
        do {
            maxAttempts--;
            String id = idTextline.getText();
            String pwd = pwdTextline.getText();
            success = ctrl.doLogin(id, pwd);
            if (!success) {
                System.out.println("Invalid UserId and/or Password. \n You have  " + maxAttempts + " more attempt(s).");
                idTextline.clear();
                pwdTextline.clear();

            }

        } while (!success && maxAttempts > 0);

        return success;

    }
    @FXML
    public void btnConfirm(ActionEvent event) {
        boolean success = doLogin();

        if (success) {
            List<UserRoleDTO> roles = this.ctrl.getUserRoles();
            if ((roles == null) || (roles.isEmpty())) {
                System.out.println("User has not any role assigned.");
            } else {
                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role)) {
                    HashMap<String , String> rolesUI = getMenuItemForRoles();
                    this.redirectToRoleUI(rolesUI, role , event);
                } else {
                    System.out.println("User did not select a role.");
                }
            }
        }
        this.logout();
    }
    private void logout() {
        ctrl.doLogout();
    }
    private HashMap<String, String> getMenuItemForRoles()
    {

        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.ROLE_NURSE, "/fxml/Nurse.fxml");
        map.put(Constants.ROLE_RECEPTIONIST, "/fxml/Receptionist.fxml");
        map.put(Constants.ROLE_CENTER_COORDINATOR, "/fxml/CenterCoordinator.fxml");
        map.put(Constants.ROLE_ADMIN, "/fxml/Admin.fxml");
        map.put(Constants.ROLE_SNS_USER, "/fxml/SNSUser.fxml");


        return map;
    }
    private UserRoleDTO selectsRole(List<UserRoleDTO> roles) {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }
    private void redirectToRoleUI(HashMap<String , String> rolesUI, UserRoleDTO role , ActionEvent event) {
       boolean found = false;

        String fxml = rolesUI.get(role.getDescription());

        if (fxml == null)
            System.out.println("There is no UI for users with role '" + role.getDescription() + "'");
        else {

            try {
                var loader = new FXMLLoader(getClass().getResource(fxml));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
