package app.ui.console;

import app.controller.ChoosingVaccinationCenterController;
import app.ui.console.utils.Utils;

public class ChoosingVaccinationCenterUI implements Runnable {

    private final ChoosingVaccinationCenterController controller;

    public ChoosingVaccinationCenterUI() {
        controller = new ChoosingVaccinationCenterController();
    }

    public void run() {

        if (this.controller.getVaccinationCenters() == null) {
            System.out.println("null list");
        }else if (this.controller.getVaccinationCenters().isEmpty()) {
            System.out.println("empty list");
            return;
        }

        Object vc = Utils.showAndSelectOne(controller.getVaccinationCenters(),"Choose Center:\n\n");
        controller.setWorking(vc);


    }

}
