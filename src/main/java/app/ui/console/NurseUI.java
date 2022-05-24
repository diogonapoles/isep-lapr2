package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NurseUI implements Runnable{


    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List Users in The Waiting Room ", new UserArrivalUI()));



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