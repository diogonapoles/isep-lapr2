package app.ui.gui;

import app.ui.controller.LoginController;

public class LoginUI {
    private final App mainApp;
    private final LoginController controller;

    public LoginUI(App mainApp) {
        this.mainApp = mainApp;
        this.controller = new LoginController();
    }

        /* public void toLoginSceneUI1(){
            try {
            LoginScene1UI LoginScene1UI = (app.ui.gui.LoginScene1UI) this.mainApp.replaceSceneContent("/fxml/Login1.fxml");



            }

        } */

}
