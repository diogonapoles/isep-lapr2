package app.ui.console;

import app.controller.NewVaccineController;
import app.ui.console.utils.Utils;

/**
 * The type New vaccine ui.
 */
public class NewVaccineUI implements Runnable {

    private NewVaccineController controller;

    /**
     * Instantiates a new New vaccine ui.
     */
    public NewVaccineUI() {
        this.controller = new NewVaccineController();
    }

    public void run() {
        if (this.controller.getVaccineTypes() == null)
            throw new IllegalArgumentException("No Vaccine Types were found");
        int selection = Utils.showAndSelectIndex(this.controller.getVaccineTypes(), "Vaccine Types:");
        if(selection >= 0 && selection < this.controller.getVaccineTypes().size()) {
            if (inputData()) {
                getData();

                if (Utils.confirm("Confirm data?(s/n)")) {
                    controller.registerVaccine();
                    System.out.println("Vaccine registered successfully.");
                } else
                    run();
            } else {
                System.out.println("Not a valid Vaccine or already exists");
            }
        }
    }

        private boolean inputData () {
            String name = Utils.readLineFromConsole("Name:");
            String brand = Utils.readLineFromConsole("Brand:");
            String ageGroup = Utils.readLineFromConsole("Age Group:");
            String doseNumber = Utils.readLineFromConsole("Dose Number:");
            double dosage = Double.parseDouble(Utils.readLineFromConsole("Dosage:"));
            int timeSinceLastDose = Integer.parseInt(Utils.readLineFromConsole("Time Since Last Dose:"));

            return controller.newVaccine(name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
        }


        private void getData() {
            System.out.println(controller.getNewVaccinetoString());
        }
    }

