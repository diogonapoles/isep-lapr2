package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.VaccinatedToFileController;
import app.ui.console.utils.Utils;

public class VaccinatedToFileUI implements Runnable {
    private final VaccinatedToFileController controller;

    public VaccinatedToFileUI() {
        controller = new VaccinatedToFileController();
    }

    @Override
    public void run() {
        String file = Utils.readLineFromConsole("Insert the File Name to Export Data");
       // controller.getListAdministratedVaccines();
        System.out.println(controller.getListAdministratedVaccines());
    }
}
