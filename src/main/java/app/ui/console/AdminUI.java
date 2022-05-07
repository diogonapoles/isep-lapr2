package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.VaccinationCenter;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable {
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Vaccination Center ", new RegisterVaccinationCenterUI()));
        options.add(new MenuItem("Register Employee ", new RegisterEmployeeUI()));
        options.add(new MenuItem("List Employees ", new ListEmployeesUI()));
        //options.add(new MenuItem("New Vaccine", new NewVaccineUI()));
        options.add(new MenuItem("New Vaccine Type", new NewVaccineTypeUI()));


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
