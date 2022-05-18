package app.controller;

import app.domain.model.Company;
import app.domain.model.SNSUser;

public class UserArrivalController {

    private final App oApp;
    private final Company oCompany;
    private SNSUser oSNSUser;

    public UserArrivalController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }


    public boolean newUserArrival(String name, String vaccineScheduleDate, String citizenCardNumber, String snsUserNumber) {
        this.oSNSUser = oCompany.getUserArrivalStore().newUserArrival(name, vaccineScheduleDate, citizenCardNumber, snsUserNumber);

        if (this.oSNSUser != null)
            return true;
        else
            return false;
    }
}
