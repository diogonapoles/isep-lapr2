package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;

import java.util.List;

public class RegisterEmployeeController {

    private App oApp;
    private Company oCompany;
    private Employee oEmployee;

    public RegisterEmployeeController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }


    public boolean newEmployee(String name, String phoneNumber, String address,
                               String emailAddress, String citizenCardNumber, int roleSelection) {

        this.oEmployee = oCompany.getEmployeeStore().newEmployee(name, phoneNumber, address, emailAddress, citizenCardNumber, roleSelection);


        this.oEmployee = oCompany.getEmployeeStore().newEmployee(name, phoneNumber, address, emailAddress, citizenCardNumber, roleSelection);

        if (this.oEmployee != null)
            return true;
        else
            return false;


    }

    public boolean registerEmployee() {
        return this.oCompany.getEmployeeStore().registerEmployee(this.oEmployee);
    }

    public List<String> getEmployeeRoles() {
        return this.oCompany.getEmployeeStore().getEmployeeRoles();
    }

    public String getEmployeeString() {
        return this.oEmployee.toString();
    }

}
