package app.ui.console;

import app.controller.ChoosingVaccinationCenterController;
import app.domain.model.ImportLegacySystemDataController;
import app.ui.console.utils.Utils;

public class ImportLegacySystemDataUI {

    private final ImportLegacySystemDataController controller;


    public ImportLegacySystemDataUI() {
        controller = new ImportLegacySystemDataController();
    }




    public void run() {
      /*  if (this.controller.getVaccinationCenters() == null) {
            System.out.println("null list");
        }else if (this.controller.getVaccinationCenters().isEmpty()) {
            System.out.println("empty list");
            return;
        }

        Object vc = Utils.showAndSelectOne(controller.getVaccinationCenters(),"Choose Center:\n\n");
        controller.setWorking(vc);

       */
    }
}
