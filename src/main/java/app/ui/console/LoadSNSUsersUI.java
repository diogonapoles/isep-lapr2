package app.ui.console;

import app.controller.LoadSNSUsersController;
import app.domain.model.SNSUser;
import app.ui.console.utils.Utils;

import java.util.List;

public class LoadSNSUsersUI implements Runnable {

    private LoadSNSUsersController controller;

    public LoadSNSUsersUI() {
        this.controller = new LoadSNSUsersController();
    }

    public void run(){
        int selection = Utils.showAndSelectIndex(this.controller.getCSVFileTypes(), "CSV File Types:");

        if(selection >= 0 && selection < 2)
        {

            if(inputData(selection))
            {
                if(Utils.confirm("Confirm data?(s/n)"))
                {
                    controller.importSNSUserCSV();
                    System.out.println("Success");
                }
                else
                    run();
            }
            else
            {
                System.out.println("Not a valid SNS User or already exists");
            }

        }
        else
        {
            System.out.println("Invalid Selection");
        }

    }

    private boolean inputData(int typeSelection)
    {
        String fileLocation = Utils.readLineFromConsole("File Location:");

        return controller.newCSVReader(typeSelection, fileLocation);
    }

}
