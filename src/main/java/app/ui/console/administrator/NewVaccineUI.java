package app.ui.console.administrator;

import app.controller.administrator.NewVaccineController;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.VaccineType;
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
        if (this.controller.getVaccinationCenters() == null) {
            System.out.println("No Vaccination Centers were found");
            return;
        }
        VaccinationCenter vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(this.controller.getVaccinationCenters(), "Vaccination Centers:");
        if (vaccinationCenter == null)
            return;
        controller.setWorking(vaccinationCenter);
        if (this.controller.getVaccineTypes() == null) {
            System.out.println("No Vaccine Types were found");
            return;
        }
        VaccineType vaccineType = (VaccineType) Utils.showAndSelectOne(this.controller.getVaccineTypes(), "Vaccine Types:");
        if (vaccineType == null)
            return;
        controller.setVaccineType(vaccineType);

        if (inputData(vaccineType)){
            getData();

            if (Utils.confirm("Confirm data?(s/n)")) {
                controller.registerVaccine();
                System.out.println("Vaccine registered successfully.");
            } else
                return;
        } else {
            System.out.println("Not a valid Vaccine or already exists");
            return;
        }
    }

        private boolean inputData (VaccineType type) {
            String name = Utils.readLineFromConsole("Name:");
            String brand = Utils.readLineFromConsole("Brand:");
            String ageGroup = Utils.readLineFromConsole("Age Group:");
            int doseNumber = Integer.parseInt(Utils.readLineFromConsole("Dose Number:"));
            double dosage = Double.parseDouble(Utils.readLineFromConsole("Dosage:"));
            int timeSinceLastDose = Integer.parseInt(Utils.readLineFromConsole("Time Since Last Dose:"));

            return controller.newVaccine(type, name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
        }

        private void getData() {
            System.out.println(controller.getNewVaccinetoString());
        }
    }

