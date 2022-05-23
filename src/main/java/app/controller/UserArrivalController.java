package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.SNSUser;

import java.util.List;

public class UserArrivalController {

    private final App oApp;
    private final Company oCompany;
    private SNSUser oSNSUser;

    public UserArrivalController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
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

    public List<SNSUser> getWaitingRoomList() {
        return this.oApp.getCompany().getUserArrivalStore().getWaitingRoomList();
    }


    public String getUserArrivalString() {
        return this.oSNSUser.toStringArrival();
    }
}
