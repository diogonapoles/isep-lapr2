package app.ui.gui.US.ui;

import app.controller.nurse.VaccineAdministrationController;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.ui.console.utils.Utils;
import app.ui.gui.US.ctrl.US8ctrl;

import java.util.Date;

public class US8ui implements Runnable{
    private US8ctrl controller;

    public US8ui() {
        this.controller = new US8ctrl();
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

            Vaccine vaccine = (Vaccine) Utils.showAndSelectOne(controller.getAvailableVaccinesForUser(user), "Available Vaccines for this user:");
            if (vaccine == null){
                return;
            }

            VaccineAdministration vaccineAdministration = controller.validateVaccineAdministration(user, vaccine);
            if (vaccineAdministration == null)
                vaccineAdministration = controller.createVaccineAdministration(user, vaccine, new Date());

            System.out.println(vaccineAdministration);
            boolean confirm = Utils.confirm("Do you want to record this vaccine? (s/n)");
            if(confirm){
                if(controller.addVaccineAdministration(vaccineAdministration)){
                    controller.removeFromWaitingRoom(user);
                    controller.moveToRecoveryRoom(vaccineAdministration, vaccine);
                    System.out.println("Success");
                }else{
                    System.out.println("Error saving this vaccine administration process");
                    return;
                }
            }
        }
    }
}
