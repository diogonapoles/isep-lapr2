package app.ui.gui;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class MainUI extends App {
    private App mainApp;

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnDev;


    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;

    }
        @FXML
    public void btnLogin(ActionEvent e){
         //   LoginUI LoginUI = new LoginUI(this.mainApp);
          //  LoginUI.toLoginSceneUI1();
    }
    @FXML
    public void btnDev(ActionEvent e){
            System.out.println("teste");
    }

}
