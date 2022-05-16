package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.VaccinationCenter;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * type Admin ui.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class AdminUI implements Runnable {
    /**
     * Instantiates a new Admin ui.
     */
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Vaccination Center ", new RegisterVaccinationCenterUI()));
        options.add(new MenuItem("Register Employee ", new RegisterEmployeeUI()));
        options.add(new MenuItem("List Employees ", new ListEmployeesUI()));
        //options.add(new MenuItem("New Vaccine", new NewVaccineUI()));
        options.add(new MenuItem("New Vaccine Type", new NewVaccineTypeUI()));
        options.add(new MenuItem("Load CSV file with SNS Users", new LoadSNSUsersUI()));


        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
