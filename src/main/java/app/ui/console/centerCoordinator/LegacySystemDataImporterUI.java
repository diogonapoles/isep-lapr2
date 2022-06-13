package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.LegacySystemDataImporterController;
import app.ui.console.utils.Utils;

public class LegacySystemDataImporterUI implements Runnable {

    private final LegacySystemDataImporterController controller;


    public LegacySystemDataImporterUI() {
        controller = new LegacySystemDataImporterController();
    }

    public boolean inputData() throws Exception {
        String fileLocation = Utils.readLineFromConsole("File Location:");
        return controller.newLegacySystemDataReader(fileLocation);
    }


    public void run() {

        try {
            if (inputData()) {
                this.controller.setSortAlgorithms();
                String sortChoice = (String) Utils.showAndSelectOne(controller.getSortAlgorithms(),"\n\nChoose the intended sort algorithm\n");
                this.controller.setSortOrder();
                String sortOrder = (String) Utils.showAndSelectOne(controller.getSortOrder(),"\n\nChoose the intended sorting method\n");
                this.controller.setSortArrivalLeaving();
                String sortArrivalLeaving = (String) Utils.showAndSelectOne(controller.getSortArrivalLeaving(),"\n\nChoose the intended parameter for Sorting\n");



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


