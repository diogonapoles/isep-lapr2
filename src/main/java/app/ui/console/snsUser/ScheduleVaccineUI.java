
package app.ui.console.snsUser;

import app.controller.App;
import app.controller.snsUser.ScheduleVaccineController;
import app.controller.ScheduleVaccineDTO;
import app.domain.model.*;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.VaccineType;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.Date;
import java.util.List;

/**
 * The type Schedule vaccine ui.
 */
public class ScheduleVaccineUI implements Runnable {

    private final ScheduleVaccineController controller;
    private final AuthFacade authFacade;
    private final Company company;


    /**
     * Instantiates a new Schedule vaccine ui.
     */
    public ScheduleVaccineUI() {
        this.company = App.getInstance().getCompany();
        this.controller = new ScheduleVaccineController();
        this.authFacade = this.company.getAuthFacade();


    }


    @Override
    public void run() {

        //try {
        if (getVaccinationCenter().size() < 0) {
            throw new IllegalArgumentException("there are none vaccination centers registered to schedule vaccines");
        } else {
            String snsUserNumber = null;
            VaccinationCenter vaccinationCenter = null;
            VaccineType vaccineType = null;
            Date date = null;

            if (this.authFacade.getCurrentUserSession().getUserRoles().get(0).getId().equals(Constants.ROLE_SNS_USER)) {
                snsUserNumber = Utils.readLineFromConsole("SNS Number:");
            } else {
                //not a receptionist
            }

            vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(this.controller.getVaccinationCenter(), "Vaccination Centers:");

            if (!(vaccinationCenter instanceof HealthcareCenter)) {
                vaccineType = (VaccineType) Utils.showAndSelectOne(this.controller.getVaccineTypes(), "vaccine Types:");
            }
               vaccineType = company.getVaccineTypeStore().getCurrentOutbreak();


            date = Utils.readDateFromConsole("Date:(day-month-year hour:minute)");




     /*   if (getVaccinationCenter().size() < 0) {
            throw new IllegalArgumentException("there are none vaccination centers registered to schedule vaccines");
        } else {
            String snsUserNumber = Utils.readLineFromConsole("SNS Number:");
            VaccinationCenter vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(this.controller.getVaccinationCenter(), "Vaccination Centers:");
            try {
                VaccineType vaccineType = (VaccineType) Utils.showAndSelectOne(this.controller.getVaccineTypes(), "Vaccine Type:");
            } catch (Exception ex) {
                System.out.printf("outbreak\n\n");
                //vaccineType = company.getCurrentOutBreak();
            }
            Date date = Utils.readDateFromConsole("Date:(day-month-year)");
            getData();
            if (Utils.confirm("Confirms data?(s/n)")) {
                if (controller.getAvailableSlot(getVaccinationCenter(), date) == null) {
                    System.out.printf("No slots available for that date");
                    return;
                }


                controller.registerScheduleVaccine();


                System.out.println("Schedule registered successfully");
            } else
                run();
        } else{

            System.out.println("Cannot Schedule the Vaccine");
        }


      */

            ScheduleVaccineDTO scheduleVaccineDTO = new ScheduleVaccineDTO(snsUserNumber, vaccinationCenter, vaccineType, date);

            try {
                this.controller.newScheduleVaccine(scheduleVaccineDTO);
                getData();
                if (Utils.confirm("Confirms data?(s/n)")) {

                  /*  if (controller.validateWithinWorkingHours(vaccinationCenter, date)) {
                        System.out.println("Outside center working hours");
                        return;
                    }

                   */

                    controller.registerScheduleVaccine();

                    System.out.println("Schedule registered successfully");
                } else
                    run();


            } catch (Exception e) {
                System.out.println(e);
            }


        }

    }


    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public List<VaccinationCenter> getVaccinationCenter() {
        return this.controller.getVaccinationCenter();
    }

    private boolean inputData() {
        VaccineType vaccineType = null;

        String snsUserNumber = Utils.readLineFromConsole("SNS Number:");
        VaccinationCenter vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(this.controller.getVaccinationCenter(), "Vaccination Centers:");
        try {
            vaccineType = (VaccineType) Utils.showAndSelectOne(this.controller.getVaccineTypes(), "Vaccine Type:");
        } catch (Exception ex) {
            System.out.printf("outbreak\n\n\n\n");
            //vaccineType = company.getCurrentOutBreak();
        }
        Date date = Utils.readDateFromConsole("Date:");
        ScheduleVaccineDTO scheduleVaccineDTO = new ScheduleVaccineDTO(snsUserNumber, vaccinationCenter, vaccineType, date);
        return this.controller.newScheduleVaccine(scheduleVaccineDTO);


    }

    private void getData() {
        System.out.println(controller.getScheduleVaccineString());
    }

}


