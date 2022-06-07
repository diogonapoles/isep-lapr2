package app.ui.console.receptionist;


import app.controller.receptionist.UserArrivalController;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
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
            return;
        } else {
            String snsUserNumber = Utils.readLineFromConsole("SNS User Number");
            try {
                SNSUser user = controller.getSNSUserByNumber(snsUserNumber);
                VaccinationCenter vaccinationCenter = controller.getWorking();
                if (user == null) {
                    System.out.println("SNS user not found in the System");
                    return;
                }
                if (inputData(user, vaccinationCenter)) {

                    controller.registerUserArrival();
                    System.out.println("SNS User arrival registered successfully");

                } else {
                    System.out.println("not a valid user or already exists");
                }
            }catch (Exception e){
                System.out.println(e);
                return;
            }
        }

    }

    private boolean inputData(SNSUser user, VaccinationCenter vaccinationCenter) {

        return controller.newUserArrival(user, vaccinationCenter);
    }



}
