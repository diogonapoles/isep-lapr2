package app.controller.nurse;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;

import java.util.List;

/**
 * The type Remove from recovery room controller.
 */
public class RemoveFromRecoveryRoomController {
    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;

    /**
     * Instantiates a new Remove from recovery room controller.
     */
    public RemoveFromRecoveryRoomController() {
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
     * Gets recovery room.
     *
     * @return the recovery room
     */
    public List<VaccineAdministration> getRecoveryRoom() {
        return vaccinationCenter.getRecoveryRoom();
    }

    /**
     * Remove from recovery room.
     *
     * @param administration the administration
     */
    public void removeFromRecoveryRoom(VaccineAdministration administration){
        vaccinationCenter.removeFromRecoveryRoom(administration);
    }

    /**
     * Issue notification.
     *
     * @param administration the administration
     */
    public void issueNotification(VaccineAdministration administration){
        vaccinationCenter.issueNotification(administration);
    }
}
