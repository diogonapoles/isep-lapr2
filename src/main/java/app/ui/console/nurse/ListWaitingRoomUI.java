package app.ui.console.nurse;

import app.controller.nurse.ListWaitingRoomController;
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
        if (controller.getWorking() == null) {
            System.out.println("Doesn't exist");
        } else {
            Utils.showList(controller.getListUsersInWaitingRoom(), "List of SNS Users in the Waiting Room");
        }
    }
}
