package app.controller.receptionist;

import app.controller.App;
import app.domain.model.*;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.store.ScheduleVaccineStore;
import app.domain.model.systemUser.SNSUser;

/**
 * The type User arrival controller.
 */
public class UserArrivalController {

    private final App oApp;
    private final Company oCompany;
    private SNSUser oSNSUser;
    private UserArrival userArrival;
    private VaccinationCenter vaccinationCenter;


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
    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }


    /**
     * New user arrival boolean.
     *
     * @param snsUserNumber the sns user number
     * @return the boolean
     */
    public boolean newUserArrival(String snsUserNumber) {
        this.userArrival = oCompany.getUserArrivalStore().newUserArrival(oCompany.getSNSUserStore().getSNSUserByNumber(snsUserNumber), snsUserNumber, vaccinationCenter);

        if (this.userArrival != null)
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
        return this.oCompany.getUserArrivalStore().registerUserArrival(this.userArrival);
    }


    /**
     * Gets user arrival string.
     *
     * @return the user arrival string
     */
    public String getUserArrivalString() {
        return this.oSNSUser.toStringWaitingRoom();
    }
}
