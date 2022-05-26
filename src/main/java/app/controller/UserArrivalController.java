package app.controller;

import app.domain.model.Company;
import app.domain.systemUsers.SNSUser;
import app.domain.model.VaccinationCenter;

/**
 * The type User arrival controller.
 */
public class UserArrivalController {

    private final App oApp;
    private final Company oCompany;
    private SNSUser oSNSUser;

    /**
     * Instantiates a new User arrival controller.
     */
    public UserArrivalController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * Get working vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getWorking(){
        return oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
    }


    /**
     * New user arrival boolean.
     *
     * @param snsUserNumber the sns user number
     * @return the boolean
     */
    public boolean newUserArrival(String snsUserNumber) {
        this.oSNSUser = oCompany.getUserArrivalStore().newUserArrival(snsUserNumber);

        if (this.oSNSUser != null)
            return true;
        else
            return false;
    }

    /**
     * Register user arrival boolean.
     *
     * @return the boolean
     */
    public boolean registerUserArrival() {
        return this.oCompany.getUserArrivalStore().registerUserArrival(this.oSNSUser);
    }


    /**
     * Gets user arrival string.
     *
     * @return the user arrival string
     */
    public String getUserArrivalString() {
        return this.oSNSUser.toStringArrival();
    }
}
