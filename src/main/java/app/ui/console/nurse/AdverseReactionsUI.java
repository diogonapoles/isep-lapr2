package app.ui.console.nurse;

import app.controller.nurse.AdverseReactionsController;
import app.ui.console.utils.Utils;


public class AdverseReactionsUI implements Runnable {

    private AdverseReactionsController controller;
    private String snsUserNumber;
    private String adverseReactions;


    public AdverseReactionsUI() {
        controller = new AdverseReactionsController();
    }


    public void run() {
        snsUserNumber = Utils.readLineFromConsole("Insert the User SNS Number");
        if (isUserInRecoveryList(snsUserNumber))
            adverseReactions = Utils.readLineFromConsole("Describe the Adverse Reactions Presented");
        else
            throw new IllegalArgumentException("User is not in the Recovery Room");


    }

    private Boolean isUserInRecoveryList(String snsUserNumber) {
        return this.controller.isUserInRecoveryList(snsUserNumber);
    }




}
