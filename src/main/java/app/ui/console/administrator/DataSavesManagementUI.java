package app.ui.console.administrator;

import app.controller.administrator.DataSavesManagementController;
import app.controller.administrator.ListEmployeesController;
import app.ui.console.utils.Utils;

/**
 * The type Data saves management ui.
 */
public class DataSavesManagementUI implements Runnable{

    private DataSavesManagementController controller;

    /**
     * Instantiates a new List employees ui.
     */
    public DataSavesManagementUI(){
        controller = new DataSavesManagementController();
    }



    public void run(){

        int selection = Utils.showAndSelectIndex(controller.availableOptions(),"DATA SAVES MANAGEMENT MENU:");
        switch (selection){
            case -1:
                return;
            case 0:
                if(!controller.saveSNSUsers()){
                    System.out.println("Saving not completed");
                    return;
                }
                break;
            case 1:
                if(!controller.saveEmployees()){
                    System.out.println("Saving not completed");
                    return;
                }
                break;
            case 2:
                if(!controller.saveVaccinationCenters()){
                    System.out.println("Saving not completed");
                    return;
                }
                break;
            case 3:
                controller.readSNSUsers();
                break;
            case 4:
                controller.readEmployees();
                break;
            case 5:
                controller.readVaccinationCenters();
                break;
            default:
                System.out.println("Invalid option");
                return;
        }
        System.out.println("Success");
    }
}
