package app.controller.nurse;


import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;

import java.util.List;

public class AdverseReactionsController {


    private final App oApp;
    private final Company oCompany;
    private VaccinationCenter vaccinationCenter;


    public AdverseReactionsController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();

    }

    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    public List<UserArrival> getWaitingRoomList(){
        return this.getWorking().getListUserToWaitingRoom();
    }



    public Boolean isUserInRecoveryList(String snsUserNumber) {

        for (UserArrival user : getWaitingRoomList()){
            if (user.getSnsUser().getSnsUserNumber().equals(snsUserNumber)){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

}
