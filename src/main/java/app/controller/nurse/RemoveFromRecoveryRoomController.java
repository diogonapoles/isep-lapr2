package app.controller.nurse;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;

import java.util.List;

public class RemoveFromRecoveryRoomController {
    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;

    public RemoveFromRecoveryRoomController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }
    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    public SNSUser getSNSUserByNumber(String snsUserNumber){
        for (SNSUser user : oCompany.getSNSUserStore().getSnsUserList()){
            if(user.getSnsUserNumber().equals(snsUserNumber))
                return user;
        }
        return null;
    }

    public List<VaccineAdministration> getRecoveryRoom() {
        return vaccinationCenter.getRecoveryRoom();
    }

    public void removeFromRecoveryRoom(VaccineAdministration administration){
        vaccinationCenter.removeFromRecoveryRoom(administration);
    }

    public void issueNotification(VaccineAdministration administration){
        vaccinationCenter.issueNotification(administration);
    }
}
