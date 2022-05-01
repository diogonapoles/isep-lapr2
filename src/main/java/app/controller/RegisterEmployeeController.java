package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;

public class RegisterEmployeeController {

    private App oApp;
    private Company oCompany;
    private Employee oEmployee;

    public RegisterEmployeeController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public boolean newEmployee(String name, String phoneNumber, String address,
                               String emailaddress, int citizenCardNumber ){
        return false;
    }



}
