package app.ui.console.administrator;

import app.controller.administrator.ListEmployeesController;
import app.ui.console.utils.Utils;

/**
 * type List employees ui.
 */
public class ListEmployeesUI implements Runnable{
    private ListEmployeesController controller;

    /**
     * Instantiates a new List employees ui.
     */
    public ListEmployeesUI(){
        controller = new ListEmployeesController();
    }



    public void run(){

        int selectionRole = Utils.showAndSelectIndex(controller.getEmployeeRoles(),"Roles");
        getListEmployees(selectionRole);

    }

    private void getListEmployees(int selectionRole)
    {
        Utils.showList(controller.getEmployeesByRole(selectionRole),"List of Employees");
    }
}