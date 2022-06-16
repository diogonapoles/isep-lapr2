package app.controller.nurse;


import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;

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

    public List<VaccineAdministration> getRecoveryRoom(){
        return this.getWorking().getRecoveryRoom();
    }



    public Boolean isUserInRecoveryList(String snsUserNumber) {
        System.out.println(getRecoveryRoom());
        System.out.println("ola");
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
