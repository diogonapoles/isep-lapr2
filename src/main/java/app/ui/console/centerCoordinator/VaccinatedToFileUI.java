package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.VaccinatedToFileController;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccinated to file ui.
 */
public class VaccinatedToFileUI implements Runnable {
    private final VaccinatedToFileController controller;

    private List lista= new ArrayList();

    /**
     * Instantiates a new Vaccinated to file ui.
     */
    public VaccinatedToFileUI() {
        controller = new VaccinatedToFileController();
    }

    @Override
    public void run() {
        String fileName = inputData();
        List<VaccineAdministration> listAdministratedVaccines = controller.getListAdministratedVaccines();


        if (controller.validateFileName(fileName)) {
            try {
                controller.writeToFile(fileName, listAdministratedVaccines);
            } catch (Exception e) {
                throw new RuntimeException("couldn't write the data on the file");
            }
        }
        else {
            System.out.println("Invalid File Name");
            run();
        }

    }

    private String inputData() {
        String fileName = Utils.readLineFromConsole("Insert the File Name to Export Data");
        return fileName;
    }
}
