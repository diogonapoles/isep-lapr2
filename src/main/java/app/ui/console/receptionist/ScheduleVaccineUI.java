package app.ui.console.receptionist;


import app.controller.receptionist.ScheduleVaccineController;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineSchedule;
import app.domain.model.vaccine.VaccineType;
import app.ui.console.utils.Utils;

import java.util.Date;

public class ScheduleVaccineUI implements Runnable {

    private ScheduleVaccineController controller;

    public ScheduleVaccineUI() {
        this.controller = new ScheduleVaccineController();
    }

    public void run() {
        if (!controller.validateUserSession()) {
            System.out.println("User is not valid");
            return;
        }

        SNSUser user = controller.getSNSUserByNumber(Utils.readLineFromConsole("Insert SNS user number:"));
        if (user == null){
            System.out.println("Could't find SNS user in the System");
            return;
        }

        VaccinationCenter vaccinationCenter = controller.getWorking();
        
        VaccineType vaccineType = (VaccineType) Utils.showAndSelectOne(controller.getAvailableVaccineTypes(vaccinationCenter), "Select a Vaccine Type:");

        Date date = controller.readDate("Insert vaccination date (dd/MM/yyyy)");

        Date timeSelector = (Date) Utils.showAndSelectOne(controller.getAvailableTimes(vaccinationCenter, date), "Select a Schedule:");

        if (!controller.validateVaccineSchedule(user, vaccineType, vaccinationCenter)){
            System.out.println("This SNS user already scheduled a vaccine");
            return;
        }

        Vaccine vaccine = controller.vaccineAgeAndTimeSinceLastDose(user, vaccineType, vaccinationCenter, timeSelector);

        VaccineSchedule schedule = controller.createVaccineSchedule(user, vaccinationCenter, vaccineType, vaccine, timeSelector);

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
        }
    }
}
