package app.ui.console.nurse;

import app.ui.console.ChoosingVaccinationCenterUI;
import app.ui.console.MenuItem;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Nurse ui.
 */
public class NurseUI implements Runnable{


    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();

        new ChoosingVaccinationCenterUI().run();

        options.add(new MenuItem("List Users in The Waiting Room ", new ListWaitingRoomUI()));
        options.add(new MenuItem("Record Adverse Reactions", new AdverseReactionsUI()));



        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nNurse Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}