package app.ui.console;

import app.controller.NewVaccineController;
import app.ui.console.utils.Utils;

public class NewVaccineUI implements Runnable {

    private NewVaccineController controller;

    public NewVaccineUI() {
        this.controller = new NewVaccineController();
    }

    public void run() {
            if(inputData())
            {
                getData();

                if(Utils.confirm("Confirm data?(s/n)"))
                {
                    controller.registerVaccine();
                    System.out.println("Vaccine registered successfully.");
                }
                else
                    run();
            }
            else
            {
                System.out.println("Not a valid Vaccine or already exists");
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

