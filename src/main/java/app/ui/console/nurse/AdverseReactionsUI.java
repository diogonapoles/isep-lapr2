package app.ui.console.nurse;

import app.controller.nurse.AdverseReactionsController;
import app.ui.console.utils.Utils;


/**
 * The type Adverse reactions ui.
 */
public class AdverseReactionsUI implements Runnable {

    private AdverseReactionsController controller;
    private String snsUserNumber;
    private String adverseReactions;


    /**
     * Instantiates a new Adverse reactions ui.
     */
    public AdverseReactionsUI() {
        controller = new AdverseReactionsController();
    }

    public void run() {
        snsUserNumber = Utils.readLineFromConsole("Insert the SNS User Number");
        if (isUserInRecoveryList(snsUserNumber)) {
            adverseReactions = Utils.readLineFromConsole("Describe the Adverse Reactions Presented");
            System.out.println("Reactions Registered Successfully");
        }else {
            System.out.println("User is not in the Recovery Room");
            return;
        }



    }

    private Boolean isUserInRecoveryList(String snsUserNumber) {
        return this.controller.isUserInRecoveryList(snsUserNumber);
    }
}
