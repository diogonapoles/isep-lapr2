package app.controller.nurse;

import app.controller.App;
import app.controller.receptionist.UserArrivalController;
import app.domain.model.Company;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;

import java.util.List;

/**
 * The type List waiting room controller.
 */
public class ListWaitingRoomController extends UserArrivalController {


    private final App oApp;
    private final Company oCompany;
    private VaccinationCenter vaccinationCenter;

    /**
     * Instantiates a new List waiting room controller.
     */
    public ListWaitingRoomController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    /**
     * Gets list users in waiting room.
     *
     * @return the list users in waiting room
     */
    public List<UserArrival>  getListUsersInWaitingRoom() {
        return this.vaccinationCenter.getListUserToWaitingRoom();
    }
}
