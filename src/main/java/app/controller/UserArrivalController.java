package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

import java.util.List;

public class UserArrivalController {

    private final App oApp;
    private final Company oCompany;
    private SNSUser oSNSUser;

    public UserArrivalController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public VaccinationCenter getWorking(){
        return oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
    }


    public boolean newUserArrival(String name, String snsUserNumber, String citizenCardNumber , String vaccineScheduleDate) {
        this.oSNSUser = oCompany.getUserArrivalStore().newUserArrival(name, snsUserNumber, citizenCardNumber, vaccineScheduleDate);

        if (this.oSNSUser != null)
            return true;
        else
            return false;
    }

    public boolean registerUserArrival() {
        return this.oCompany.getUserArrivalStore().registerUserArrival(this.oSNSUser);
    }

 

    public String getUserArrivalString() {
        return this.oSNSUser.toStringArrival();
    }
}
