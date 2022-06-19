package app.ui.console.receptionist;


import app.controller.receptionist.ScheduleVaccineController;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccinationProcess.VaccineSchedule;
import app.domain.model.vaccine.VaccineType;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Schedule vaccine ui.
 */
public class ScheduleVaccineUI implements Runnable {

    private ScheduleVaccineController controller;

    /**
     * Instantiates a new Schedule vaccine ui.
     */
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

        if (!controller.validateVaccineSchedule(user, vaccineType, vaccinationCenter, date)){
            System.out.println("This SNS user already scheduled a vaccine for this day");
            return;
        }

        VaccineAdministration administration =  controller.ongoingVaccine(vaccineType, user, date);
        List<Vaccine> vaccineList = new ArrayList<>();
        if (administration == null){
            vaccineList = controller.vaccineAge(user, vaccineType, vaccinationCenter);
        }else{
            if(controller.timeSinceLastDose(administration, date)) {
                vaccineList.add(administration.getVaccine());
            }else {
                System.out.println("You have to wait " + controller.calculateDaysLeftTimeSinceLastDose(administration.getVaccinationTime(), date) + " days until you can take a new dose for this vaccine type");
                return;
            }
        }

        if (vaccineList.isEmpty()){
            System.out.println("There aren't any vaccines available for this user");
            return;
        }

        Date timeSelector = (Date) Utils.showAndSelectOne(controller.getAvailableTimes(vaccinationCenter, date), "Select a Schedule:");

        VaccineSchedule schedule = controller.createVaccineSchedule(user, vaccinationCenter, vaccineType, vaccineList, timeSelector);

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
