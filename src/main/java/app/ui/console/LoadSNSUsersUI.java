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
        if(inputData()){
            getData();
            if(Utils.confirm("Confirm data?(s/n)"))
            {
                controller.importSNSUserCSV();
                controller.clearTempArray();
                System.out.println("Operation finished");
            } else
                run();
        }else
            System.out.println("There is a problem with the file");
    }

    private boolean inputData()
    {
        String fileLocation = Utils.readLineFromConsole("File Location:");

        return controller.newCSVReader(fileLocation);
    }

    private void getData(){
        System.out.println(controller.getCSVFileString());
    }
}
