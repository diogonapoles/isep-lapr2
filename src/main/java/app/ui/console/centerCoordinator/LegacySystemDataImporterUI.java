package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.LegacySystemDataImporterController;
import app.ui.console.utils.Utils;

import java.io.IOException;

public class LegacySystemDataImporterUI implements Runnable {

    private final LegacySystemDataImporterController controller;


    public LegacySystemDataImporterUI() {
        controller = new LegacySystemDataImporterController();
    }


    public void run() {

        try {
            if (inputData()) {
                String sa = (String) Utils.showAndSelectOne(controller.getSortAlgorithms(),"Choose the intended sort algorithm");
                this.controller.setSortAlgorithm(sa);
/*
                if (Utils.confirm("Confirm data?(s/n)")) {
                    controller.importLegacySystemDataCSV();
                    controller.clearTempArray();
                    System.out.println("Operation finished");
                } else
                    run();

 */
            } else
                System.out.println("There is a problem with the file");


        } catch (Exception e) {
            System.out.println("ola");
            throw new RuntimeException(e);

        }


    }

    private boolean inputData() throws Exception {
        String fileLocation = Utils.readLineFromConsole("File Location:");
        return controller.newLegacySystemDataReader(fileLocation);
    }



    private void getSortedData() {
       // Utils.showList(controller.getli(), "Sorted Data:");
    }




}
      /*  if (this.controller.getVaccinationCenters() == null) {
            System.out.println("null list");
        }else if (this.controller.getVaccinationCenters().isEmpty()) {
            System.out.println("empty list");
            return;
        }

        Object vc = Utils.showAndSelectOne(controller.getVaccinationCenters(),"Choose Center:\n\n");
        controller.setWorking(vc);

       */

