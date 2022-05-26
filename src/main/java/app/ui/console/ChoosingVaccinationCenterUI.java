package app.ui.console;

import app.controller.ChoosingVaccinationCenterController;
import app.ui.console.utils.Utils;

/**
 * The type Choosing vaccination center ui.
 */
public class ChoosingVaccinationCenterUI implements Runnable {

    private final ChoosingVaccinationCenterController controller;

    /**
     * Instantiates a new Choosing vaccination center ui.
     */
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
