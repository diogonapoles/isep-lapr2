package app.ui.console.receptionist;

import app.ui.console.ChoosingVaccinationCenterUI;
import app.ui.console.MenuItem;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Receptionist ui.
 */
public class ReceptionistUI implements Runnable{


    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();

        new ChoosingVaccinationCenterUI().run();

        options.add(new MenuItem("Register User Arrival ", new UserArrivalUI()));
        options.add(new MenuItem("Schedule Vaccine ", new ScheduleVaccineUI()));



        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
