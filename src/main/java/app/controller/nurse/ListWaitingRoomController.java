package app.controller.nurse;

import app.controller.App;
import app.controller.receptionist.UserArrivalController;
import app.domain.model.systemUser.SNSUser;

import java.util.List;

/**
 * The type List waiting room controller.
 */
public class ListWaitingRoomController extends UserArrivalController {


    private final App oApp;

    /**
     * Instantiates a new List waiting room controller.
     */
    public ListWaitingRoomController() {
        this.oApp = App.getInstance();
    }

    /**
     * Gets list users in waiting room.
     *
     * @return the list users in waiting room
     */
    public List<SNSUser>  getListUsersInWaitingRoom() {
        return this.oApp.getCompany().getUserArrivalStore().getListUserToWaitingRoom(getWorking());
    }




}
