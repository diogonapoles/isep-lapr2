package app.ui.console;

import app.controller.ListEmployeesController;

public class ListEmployeesUI implements Runnable{
    private ListEmployeesController controller;

    public ListEmployeesUI(){
        controller = new ListEmployeesController();
    }

    public void run(){
        System.out.println("");
    }
}
