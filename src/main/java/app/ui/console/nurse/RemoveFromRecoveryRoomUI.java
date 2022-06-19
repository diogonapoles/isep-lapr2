package app.ui.console.nurse;

import app.controller.nurse.ListWaitingRoomController;
import app.controller.nurse.RemoveFromRecoveryRoomController;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.ui.console.utils.Utils;

/**
 * The type Remove from recovery room ui.
 */
public class RemoveFromRecoveryRoomUI implements Runnable {
    private RemoveFromRecoveryRoomController controller ;

    /**
     * Instantiates a new Remove from recovery room ui.
     */
    RemoveFromRecoveryRoomUI(){
        this.controller = new RemoveFromRecoveryRoomController();
    }

    public void run() {
        if (controller.getWorking() == null) {
            System.out.println("Doesn't exist");
            return;
        } else {

            VaccineAdministration administration = (VaccineAdministration) Utils.showAndSelectOne(controller.getRecoveryRoom(), "Users in the Recovery Room:");
            if (administration == null) {
                return;
            }

            controller.removeFromRecoveryRoom(administration);
            controller.issueNotification(administration);
            System.out.println("Success");
        }
    }
}
