package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.LegacySystemDataImporterController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LegacySystemDataImporterUI implements Runnable {

    private final LegacySystemDataImporterController controller;

    private final CenterCoordinatorUI ccUI;

    private List listLegacyData = new ArrayList<>();

    public LegacySystemDataImporterUI() {
        controller = new LegacySystemDataImporterController();
        ccUI = new CenterCoordinatorUI();
    }

    public boolean inputData() throws Exception {
        String fileLocation = Utils.readLineFromConsole("File Location:");
        return controller.newLegacySystemDataReader(fileLocation);
    }


    public void run() {

        try {
            if (inputData()) {
                listLegacyData = controller.getListLegacySystemData();

                addSortStuff();

                String sortChoice = (String) Utils.showAndSelectOne(controller.getSortAlgorithms(), "\n\nChoose the intended sort algorithm\n");
                String sortOrder = (String) Utils.showAndSelectOne(controller.getSortOrder(), "\n\nChoose the intended sorting method\n");
                String sortArrivalLeaving = (String) Utils.showAndSelectOne(controller.getSortArrivalLeaving(), "\n\nChoose the intended parameter for Sorting\n");

                try {
                    controller.sortByParameters(sortChoice, sortOrder, sortArrivalLeaving, listLegacyData);
                }catch (Exception ex){
                    ccUI.run();
                }


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

    private void addSortStuff() {

        this.controller.setSortAlgorithms();
        this.controller.setSortOrder();
        this.controller.setSortArrivalLeaving();


    }

    private void getSortedData() {
        // Utils.showList(controller.getli(), "Sorted Data:");
    }


}


