package app.controller.nurse;


import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;

import java.util.List;

/**
 * The type Adverse reactions controller.
 */
public class AdverseReactionsController {


    private final App oApp;
    private final Company oCompany;
    private VaccinationCenter vaccinationCenter;


    /**
     * Instantiates a new Adverse reactions controller.
     */
    public AdverseReactionsController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();

    }

    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    /**
     * Get recovery room list.
     *
     * @return the list
     */
    public List<VaccineAdministration> getRecoveryRoom(){
        return this.getWorking().getRecoveryRoom();
    }


    /**
     * Is user in recovery list boolean.
     *
     * @param snsUserNumber the sns user number
     * @return the boolean
     */
    public Boolean isUserInRecoveryList(String snsUserNumber) {
        for (VaccineAdministration user : getRecoveryRoom()){
            if (user.getUserArrival().getSnsUser().getSnsUserNumber().equals(snsUserNumber)){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

}
