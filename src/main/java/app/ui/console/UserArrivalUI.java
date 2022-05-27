package app.ui.console;

import app.controller.App;
import app.controller.UserArrivalController;
import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccineType;
import app.domain.store.VaccineTypeStore;
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
                    System.out.println("SNS User registered successfully");
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

    private void getData() {
        System.out.println(controller.getUserArrivalString());
    }


}
