package app.ui.console.administrator;

import app.controller.administrator.NewVaccineTypeController;
import app.ui.console.utils.Utils;

/**
 * The type New vaccine type ui.
 */
public class NewVaccineTypeUI implements Runnable{

    private NewVaccineTypeController controller;

    /**
     * Instantiates a new New vaccine type ui.
     */
    public NewVaccineTypeUI()
    {
        this.controller = new NewVaccineTypeController();
    }

    public void run(){
        int selection = Utils.showAndSelectIndex(this.controller.getVaccineTechnologyTypes(), "Vaccine Technology Types:");

        if (controller.getWorking() == null) {
            throw new IllegalArgumentException("Can't find any valid Vaccination Center for this user");
        }else {
            if (selection >= 0 && selection < 6) {
                if (inputData(selection)) {
                    getData();

                    if (Utils.confirm("Confirm data?(s/n)")) {
                        controller.registerVaccineType();
                        System.out.println("Success");
                    } else
                        run();
                } else {
                    System.out.println("Not a valid Vaccine Type or already exists");
                }

            } else {
                System.out.println("Invalid Selection");
            }
        }
    }

    private boolean inputData(int techSelection)
    {
        String code = Utils.readLineFromConsole("Code (5 digits):");
        String designation = Utils.readLineFromConsole("Short Description:");

        return controller.newVaccineType(techSelection, code, designation);
    }

    private void getData(){
        System.out.println(controller.getVaccineTypeString());
    }
}
