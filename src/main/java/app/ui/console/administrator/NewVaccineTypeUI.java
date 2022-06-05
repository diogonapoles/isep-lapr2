package app.ui.console.administrator;

import app.controller.administrator.NewVaccineTypeController;
import app.domain.model.vaccinationCenter.VaccinationCenter;
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
        if (this.controller.getVaccinationCenters() == null) {
            System.out.println("No Vaccination Centers were found");
            return;
        }
        VaccinationCenter vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(this.controller.getVaccinationCenters(), "Vaccination Centers:");
        if (vaccinationCenter == null)
            return;
        controller.setWorking(vaccinationCenter);

        int selection = Utils.showAndSelectIndex(this.controller.getVaccineTechnologyTypes(), "Vaccine Technology Types:");

            if (selection >= 0 && selection < controller.getVaccineTechnologyTypes().size()) {
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
