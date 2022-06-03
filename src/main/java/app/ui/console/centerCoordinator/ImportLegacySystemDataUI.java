package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.ImportLegacySystemDataController;

public class ImportLegacySystemDataUI implements Runnable{

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
