package app.ui.console;

import app.controller.RegisterVaccinationCenterController;

public class RegisterVaccinationCenterUI implements Runnable{
    private RegisterVaccinationCenterController controller;

    public RegisterVaccinationCenterUI(){
        controller = new RegisterVaccinationCenterController();
    }

    public void run(){
        System.out.println("");
    }
}
