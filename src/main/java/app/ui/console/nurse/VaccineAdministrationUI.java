package app.ui.console.nurse;

import app.controller.nurse.VaccineAdministrationController;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineSchedule;
import app.ui.console.utils.Utils;

import java.util.Date;
import java.util.List;

public class VaccineAdministrationUI implements Runnable{
    private VaccineAdministrationController controller;

    public VaccineAdministrationUI() {
        this.controller = new VaccineAdministrationController();
    }

    public void run() {
        if (controller.getWorking() == null) {
            System.out.println("Doesn't exist");
            return;
        } else {
            UserArrival user = (UserArrival) Utils.showAndSelectOne(controller.getWaitingRoom(), "Select SNS user from the waiting room:");
            if (user == null){
                return;
            }

            Vaccine vaccine = (Vaccine) Utils.showAndSelectOne(controller.getAvailableVaccinesForUser(user.getSchedule().getVaccineType(), user.getSnsUser(), user.getSchedule().getTime()), "Available Vaccines for this user:");
            if (vaccine == null){
                return;
            }

            VaccineAdministration vaccineAdministration = controller.createVaccineAdministration(user, vaccine, new Date());
            System.out.println(vaccineAdministration);
            boolean confirm = Utils.confirm("Do you want to schedule this vaccine? (s/n)");
            if(confirm){
                if(controller.addVaccineAdministration(vaccineAdministration)){
                    controller.removeFromWaitingRoom(user);
                    controller.moveToRecoveryRoom(vaccineAdministration);
                    System.out.println("Success");
                }else{
                    System.out.println("Error saving this vaccine administration process");
                    return;
                }
            }
        }
    }
}
