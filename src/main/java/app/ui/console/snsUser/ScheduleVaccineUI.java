package app.ui.console.snsUser;


import app.controller.snsUser.ScheduleVaccineController;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineSchedule;
import app.domain.model.vaccine.VaccineType;
import app.ui.console.utils.Utils;

import java.util.Date;
import java.util.List;

public class ScheduleVaccineUI implements Runnable {

    private ScheduleVaccineController controller;

    public ScheduleVaccineUI() {
        this.controller = new ScheduleVaccineController();
    }

    public void run() {
        try {
            if (!controller.validateUserSession()) {
                System.out.println("User is not valid");
                return;
            }

            VaccinationCenter vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(controller.getVaccinationCenterList(), "Select a Vaccination Center:");

            VaccineType vaccineType = (VaccineType) Utils.showAndSelectOne(controller.getAvailableVaccineTypes(vaccinationCenter), "Select a Vaccine Type:");

            Date date = controller.readDate("Insert vaccination date (dd/MM/yyyy)");

            Date timeSelector = (Date) Utils.showAndSelectOne(controller.getAvailableTimes(vaccinationCenter, date), "Select a Schedule:");

        if (!controller.validateVaccineSchedule(vaccineType, vaccinationCenter, timeSelector)){
            System.out.println("This SNS user already scheduled a vaccine");
            return;
        }

            Vaccine vaccine = controller.vaccineAgeAndTimeSinceLastDose(vaccineType, vaccinationCenter, timeSelector);

        List<Vaccine> vaccine = controller.vaccineAgeAndTimeSinceLastDose(vaccineType, vaccinationCenter, timeSelector);

        if (vaccine == null){
            System.out.println("There is any vaccines available for this user");
            return;
        }


        VaccineSchedule schedule = controller.createVaccineSchedule(vaccinationCenter, vaccineType, timeSelector);

        if(schedule == null) {
            System.out.println("Error while creating vaccination schedule");
            return;
        }

        System.out.println(schedule);
        boolean confirm = Utils.confirm("Do you want to schedule this vaccine? (s/n)");
        if(confirm){
            if(controller.addVaccineSchedule(vaccinationCenter, schedule)){
                System.out.println("Success");
            }else{
                System.out.println("Error saving this vaccine schedule");
                return;
            }

            System.out.println(schedule);
            boolean confirm = Utils.confirm("Do you want to schedule this vaccine? (s/n)");
            if (confirm) {
                if (controller.addVaccineSchedule(vaccinationCenter, schedule)) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error saving this vaccine schedule");
                    return;
                }
            }
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("could not load Centers");
        }
    }
}
