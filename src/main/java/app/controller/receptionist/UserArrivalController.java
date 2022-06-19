package app.controller.receptionist;

import app.controller.App;
import app.domain.model.*;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
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
     * Get sns user by number sns user.
     *
     * @param snsUserNumber the sns user number
     * @return the sns user
     */
    public SNSUser getSNSUserByNumber(String snsUserNumber){
        for (SNSUser user : oCompany.getSNSUserStore().getSnsUserList()){
            if(user.getSnsUserNumber().equals(snsUserNumber))
                return user;
        }
        return null;
    }

    /**
     * New user arrival boolean.
     *
     * @param user              the user
     * @param vaccinationCenter the vaccination center
     * @return the boolean
     */
    public boolean newUserArrival(SNSUser user, VaccinationCenter vaccinationCenter) {
        this.userArrival = vaccinationCenter.newUserArrival(user);

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
        vaccinationCenter.moveToWaitingRoom(userArrival);
        return this.vaccinationCenter.registerUserArrival(userArrival);
    }

}
