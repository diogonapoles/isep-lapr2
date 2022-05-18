package app.ui.console;

import app.controller.UserArrivalController;
import app.ui.console.utils.Utils;
import jdk.jshell.execution.Util;

public class UserArrivalUI {

    private UserArrivalController controller;

    public UserArrivalUI(){ this.controller= new UserArrivalController();}

    public void run(){

    }

    private boolean inputData() {


        String name = Utils.readLineFromConsole("Name:");
        //String arrivalTime = Utils.readLineFromConsole("Arrival Time:");
        String snsUserNumber = Utils.readLineFromConsole("SNS User Number");
        String citizenCardNumber = Utils.readLineFromConsole("Citizen Card Number:");
        String vaccineScheduleDate = Utils.readLineFromConsole("Vaccine Schedule Date:");



        return controller.newUserArrival(name, snsUserNumber, citizenCardNumber, vaccineScheduleDate);
    }




}
