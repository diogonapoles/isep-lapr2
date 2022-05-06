package app.ui.console;

import app.controller.ListEmployeesController;
import app.ui.console.utils.Utils;

public class ListEmployeesUI implements Runnable{
    private ListEmployeesController controller;

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