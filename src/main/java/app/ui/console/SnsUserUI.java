package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sns user ui.
 */
public class SnsUserUI implements Runnable{
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();


        options.add(new MenuItem("Schedule Vaccine: ", new ScheduleVaccineUI()));



        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nSNS User Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
