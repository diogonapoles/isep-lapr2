package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * type Main menu ui.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    /**
     * Instantiates a new Main menu ui.
     */
    public MainMenuUI()
    {
    }

    /**
     * Run.
     *
     * @throws IOException the io exception
     */
    public void run() throws IOException
    {
        try {
            List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Do Login", new AuthUI()));
            options.add(new MenuItem("Know the Development Team", new DevTeamUI()));
            int option = 0;
            do {
                option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

                if ((option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            }
            while (option != -1);
        }catch (IllegalArgumentException ex){
            System.out.println(ex);
            run();
        }
    }


}
