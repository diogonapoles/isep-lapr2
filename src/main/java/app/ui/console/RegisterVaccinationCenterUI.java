package app.ui.console;

import app.controller.RegisterVaccinationCenterController;
import app.ui.console.utils.Utils;

/**
 * The type Register vaccination center ui.
 */
public class RegisterVaccinationCenterUI implements Runnable{

    private RegisterVaccinationCenterController controller;

    /**
     * Instantiates a new Register vaccination center ui.
     */
    public RegisterVaccinationCenterUI()
    {
        this.controller = new RegisterVaccinationCenterController();
    }

    public void run(){
        int selection = Utils.showAndSelectIndex(this.controller.getVaccinationCenterTypes(), "Vaccination Center Types:");

        if(selection >= 0 && selection < 2)
        {
            if(inputData(selection))
            {
                getData();

                if(Utils.confirm("Confirm data?(s/n)"))
                {
                    controller.registerVaccinationCenter();
                    System.out.println("Success");
                }
                else
                    run();


            }
            else
            {
                System.out.println("Not a valid vaccination center or already exists");
            }

        }
        else
        {
            System.out.println("Invalid selection");
        }
    }

    private boolean inputData(int typeSelection)
    {
        String name = Utils.readLineFromConsole("Name:");
        String phoneNumber = Utils.readLineFromConsole("Phone Number (Portuguese format, 9 digits):");
        String faxNumber = Utils.readLineFromConsole("Fax Number:");
        String homeAddress = Utils.readLineFromConsole("Home Address:");
        String emailAddress = Utils.readLineFromConsole("Email Address:");
        String websiteAddress = Utils.readLineFromConsole("Website Address:");
        String openingHours = Utils.readLineFromConsole("Opening Hours:");
        String closingHours = Utils.readLineFromConsole("Closing Hours:");
        String slotDuration = Utils.readLineFromConsole("Slot Duration:");
        String maxNumVaccinesPerSlot = Utils.readLineFromConsole("Maximum number of vaccines per slot:");

        return controller.newVaccinationCenter(typeSelection, name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);

    }
    private void getData(){
        System.out.println(controller.getVaccinationCenterString());
    }

}
