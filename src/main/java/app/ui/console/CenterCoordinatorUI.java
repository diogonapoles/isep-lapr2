package app.ui.console;

import app.domain.model.ImportLegacySystemData;
import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CenterCoordinatorUI implements Runnable{

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();

        new ImportLegacySystemDataUI().run();

        options.add(new MenuItem("Import data from legacy system ", new CenterCoordinatorUI()));



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
