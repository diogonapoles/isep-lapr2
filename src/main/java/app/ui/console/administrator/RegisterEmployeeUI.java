package app.ui.console.administrator;

import app.controller.administrator.RegisterEmployeeController;
import app.ui.console.utils.Utils;


/**
 * The type Register employee ui.
 */
public class RegisterEmployeeUI implements Runnable {

    private RegisterEmployeeController controller;

    /**
     * Instantiates a new Register employee ui.
     */
    public RegisterEmployeeUI() {
        this.controller = new RegisterEmployeeController();
    }

    public void run() {

        int selection = Utils.showAndSelectIndex(this.controller.getEmployeeRoles(), "Roles:");

        if (selection >= 0 && selection < 3) {
            if (inputData(selection)) {
                getData();

                if (Utils.confirm("Confirms data?(s/n)")) {
                    controller.registerEmployee();
                    System.out.println("Employee registered successfully");
                } else
                    run();


            } else {

                System.out.println("That's not a Valid User");

            }

        } else {
            System.out.println("invalid selection");
        }

    }


    private boolean inputData(int roleSelection) {


        String name = Utils.readLineFromConsole("Name:");
        String phoneNumber = Utils.readLineFromConsole("Phone Number:");
        String address = Utils.readLineFromConsole("Address:");
        String emailAddress = Utils.readLineFromConsole("Email Address:");
        String citizenCardNumber = Utils.readLineFromConsole("citizenCardNumber:");


        return controller.newEmployee(name, phoneNumber, address, emailAddress, citizenCardNumber, roleSelection);
    }

    private void getData() {
        System.out.println(controller.getEmployeeString());
    }


}