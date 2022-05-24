package app.ui.console;

import app.controller.UserArrivalController;
import app.ui.console.utils.Utils;


public class UserArrivalUI implements Runnable{

    private UserArrivalController controller;

    public UserArrivalUI() {
        this.controller = new UserArrivalController();
    }

    public void run() {
        if (inputData()) {
            getData();

            if (Utils.confirm("Confirms data?(s/n)")) {
                controller.registerUserArrival();
                System.out.println("SNS User registered successfully");
            } else
                run();


        } else {
            System.out.println("not a valid user or already exists");
        }

        getWaitingRoomList();

    }

    private boolean inputData() {


        String name = Utils.readLineFromConsole("Name:");
        String snsUserNumber = Utils.readLineFromConsole("SNS User Number");
        String citizenCardNumber = Utils.readLineFromConsole("Citizen Card Number:");
        String vaccineScheduleDate = Utils.readLineFromConsole("Vaccine Schedule Date:");
//String arrivalTime = Utils.readLineFromConsole("Arrival Time:");


        return controller.newUserArrival(name, snsUserNumber, citizenCardNumber, vaccineScheduleDate);
    }

    private void getData() {
        System.out.println(controller.getUserArrivalString());
    }


    private void getWaitingRoomList() {
        Utils.showList(controller.getWaitingRoomList(),"Waiting Room List");
    }
}
