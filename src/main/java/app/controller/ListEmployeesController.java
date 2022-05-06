package app.controller;

import app.domain.model.Employee;

import java.util.List;

public class ListEmployeesController {

    private App oApp;

    public ListEmployeesController() {
        this.oApp = App.getInstance();
    }

    public List<String> getEmployeeRoles() {
        return this.oApp.getCompany().getEmployeeStore().getEmployeeRoles();
    }

    public List<Employee> getEmployeesByRole(int selectionRole) {
        return this.oApp.getCompany().getEmployeeStore().getEmployeesByRole(selectionRole);
    }
}