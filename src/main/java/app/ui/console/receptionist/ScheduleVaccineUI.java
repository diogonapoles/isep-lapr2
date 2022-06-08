package app.ui.console.receptionist;


import app.controller.receptionist.ScheduleVaccineController;
import app.domain.model.systemUser.SNSUser;
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
        if (vaccineType == null){
            return;
        }

        if (!controller.validateAdministratedVaccines(vaccineType, user)){
            System.out.println("This user has overdue vaccinations, please go to the vaccination center and only after taking the vaccine of this type will you be able to schedule a new one.");
            return;
        }

        Date date = controller.readDate("Insert vaccination date (dd/MM/yyyy)");
        if (date == null)
            return;

        Date timeSelector = (Date) Utils.showAndSelectOne(controller.getAvailableTimes(vaccinationCenter, date), "Select a Schedule:");

        if (!controller.validateVaccineSchedule(user, vaccineType, vaccinationCenter, timeSelector)){
            System.out.println("This SNS user already scheduled a vaccine for this day");
            return;
        }

        List<Vaccine> vaccines = controller.vaccineAgeAndTimeSinceLastDose(user, vaccineType, vaccinationCenter, timeSelector);

        if (vaccines.isEmpty()){
            System.out.println("There aren't any vaccines available for this user");
            return;
        }

        VaccineSchedule schedule = controller.createVaccineSchedule(user, vaccinationCenter, vaccineType, timeSelector);

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
