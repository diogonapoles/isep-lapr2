package app.ui.console;

import app.controller.ListWaitingRoomController;
import app.domain.model.Employee;
import app.ui.console.utils.Utils;

/**
 * The type List waiting room ui.
 */
public class ListWaitingRoomUI implements Runnable{
    private ListWaitingRoomController controller ;


    /**
     * Instantiates a new List waiting room ui.
     */
    public ListWaitingRoomUI() {controller = new ListWaitingRoomController();}



    public void run() {
        listUsersInWaitingRoom();
    }

    private void listUsersInWaitingRoom(){

        Utils.showList(controller.getListUsersInWaitingRoom(),"List of SNS Users in the Waiting Room");
    }
}
