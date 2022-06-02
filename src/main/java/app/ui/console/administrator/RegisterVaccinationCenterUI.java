package app.ui.console.administrator;

import app.controller.administrator.RegisterVaccinationCenterController;
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
        int phoneNumber = Utils.readIntegerFromConsole("Phone Number (Portuguese format, 9 digits):");
        int faxNumber = Utils.readIntegerFromConsole("Fax Number:");
        String homeAddress = Utils.readLineFromConsole("Home Address:");
        String emailAddress = Utils.readLineFromConsole("Email Address:");
        String websiteAddress = Utils.readLineFromConsole("Website Address:");
        int openingHours = Utils.readIntegerFromConsole("Opening Hours:");
        int closingHours = Utils.readIntegerFromConsole("Closing Hours:");
        int slotDuration = Utils.readIntegerFromConsole("Slot Duration:");
        int maxNumVaccinesPerSlot = Utils.readIntegerFromConsole("Maximum number of vaccines per slot:");

        return controller.newVaccinationCenter(typeSelection, name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);

    }
    private void getData(){
        System.out.println(controller.getVaccinationCenterString());
    }

}
