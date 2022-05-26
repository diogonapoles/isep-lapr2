package app.ui.console;

import app.controller.UserArrivalController;
import app.ui.console.utils.Utils;


/**
 * The type User arrival ui.
 */
public class UserArrivalUI implements Runnable {

    private UserArrivalController controller;

    /**
     * Instantiates a new User arrival ui.
     */
    public UserArrivalUI() {
        this.controller = new UserArrivalController();
    }

    public void run() {

        if (controller.getWorking() == null) {
            System.out.println("Doesn't exist");
        } else {

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
        }

    }

    private boolean inputData() {

        String snsUserNumber = Utils.readLineFromConsole("SNS User Number");
        String arrivalTime = Utils.readLineFromConsole("Arrival Time:");


        return controller.newUserArrival(snsUserNumber);
    }

    private void getData() {
        System.out.println(controller.getUserArrivalString());
    }


}
