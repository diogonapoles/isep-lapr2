package app.ui.console.receptionist;


import app.controller.receptionist.UserArrivalController;
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
            String snsUserNumber = Utils.readLineFromConsole("SNS User Number");
            if (inputData(snsUserNumber)) {

            //    Object o = Utils.showAndSelectOne(controller.getVaccineTypeList(), "\nVaccineTypes: ");
              //  ScheduleVaccine scheduleVaccine = controller.getScheduleVaccine(snsUserNumber, (VaccineType) o);
              //  getData();

                //if (Utils.confirm("Confirms data?(s/n)")) {
                    controller.registerUserArrival();
                    System.out.println("SNS User arrival registered successfully");
                //} else
                    //run();


            } else {
                System.out.println("not a valid user or already exists");
            }
        }

    }

    private boolean inputData(String snsUserNumber) {

        return controller.newUserArrival(snsUserNumber);
    }



}
