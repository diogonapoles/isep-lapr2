package app.ui.console.centerCoordinator;

import app.ui.console.ChoosingVaccinationCenterUI;
import app.ui.console.MenuItem;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Center coordinator ui.
 */
public class CenterCoordinatorUI implements Runnable {

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();

        new ChoosingVaccinationCenterUI().run();

        options.add(new MenuItem("Import data from legacy system ", new LegacySystemDataImporterUI()));

        options.add(new MenuItem("Analyze Performance", new AnalyzePerformanceUI()));

        options.add(new MenuItem("Export Vaccination Statistics", new VaccinatedToFileUI()));


        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nCenter Coordinator Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);

    }


}
