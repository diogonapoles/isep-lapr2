package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.LegacySystemDataImporterController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LegacySystemDataImporterUI implements Runnable {

    private final LegacySystemDataImporterController controller;

    private final CenterCoordinatorUI ccUI;

    private List listLegacyData = new ArrayList<>();
    private List listSorted = new ArrayList();

    public LegacySystemDataImporterUI() {
        controller = new LegacySystemDataImporterController();
        ccUI = new CenterCoordinatorUI();
    }

    public boolean inputData() throws Exception {
        try {
            String fileLocation = Utils.readLineFromConsole("File Location:");
            return controller.newLegacySystemDataReader(fileLocation);
        } catch (Exception ex) {
            throw new Exception("Couldn´t read the file");
        }
    }


    public void run() {

        try {
            if (inputData()) {
                listLegacyData = controller.getListLegacySystemData();

                addSortStuff();

                String sortChoice = (String) Utils.showAndSelectOne(controller.getSortAlgorithms(), "\n\nChoose the intended sort algorithm\n");
                String sortOrder = (String) Utils.showAndSelectOne(controller.getSortOrder(), "\n\nChoose the intended sorting method\n");
                String sortArrivalLeaving = (String) Utils.showAndSelectOne(controller.getSortArrivalLeaving(), "\n\nChoose the intended parameter for Sorting\n");

/*                String name = controller.getNameByNumber();
                String vaccineDescription = controller.getVaccineDescription();
                controller.getName(name);
                controller.getDescription(vaccineDescription);

 */

                try {
                    listSorted = controller.sortByParameters(sortChoice, sortOrder, sortArrivalLeaving, listLegacyData);
                } catch (Exception ex) {
                    ccUI.run();
                }

                System.out.println("\nSnsNumber  VaccineName   Dose     LotNumber       ScheduledDateTime               ArrivalDateTime          NurseAdministrationDateTime          LeavingDateTime\n");
                for (int i = 0; i < listSorted.size(); i++) {
                    System.out.println(listSorted.get(i).toString());
                }


            } else
                System.out.println("There is a problem with the file");


        } catch (Exception e) {
            //throw new RuntimeException("couldn't open the file");
            System.out.printf("\n\ncouldn't open the file\n");
            run();

        }
    }

    private void addSortStuff() {

        this.controller.setSortAlgorithms();
        this.controller.setSortOrder();
        this.controller.setSortArrivalLeaving();


    }


}


