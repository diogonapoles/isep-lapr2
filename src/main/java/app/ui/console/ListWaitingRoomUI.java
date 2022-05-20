package app.ui.console;

import app.controller.ListWaitingRoomController;
import app.ui.console.utils.Utils;

public class ListWaitingRoomUI implements Runnable{
    private ListWaitingRoomController controller ;


    public ListWaitingRoomUI() {controller = new ListWaitingRoomController();}



    public void run() {
        listUsersInWaitingRoom();
    }

    private void listUsersInWaitingRoom(){

        Utils.showList(controller.getListUsersInWaitingRoom(),"List of SNS Users in the Waiting Room");
    }
}
