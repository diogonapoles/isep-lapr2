
package app.ui.console.receptionist;

import app.controller.App;
import app.controller.ScheduleVaccineDTO;
import app.controller.receptionist.ScheduleVaccineController;
import app.domain.model.*;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.Date;
import java.util.List;

/**
 * The type Schedule vaccine receptionist ui.
 */
public class ScheduleVaccineUI implements Runnable {

    private final ScheduleVaccineController controller;
    private final AuthFacade authFacade;
    private final Company company;


    /**
     * Instantiates a new Schedule vaccine receptionist ui.
     */
    public ScheduleVaccineUI() {
        this.company = App.getInstance().getCompany();
        this.controller = new ScheduleVaccineController();
        this.authFacade = this.company.getAuthFacade();


    }


    @Override
    public void run() {

        //try {
        if (getVaccinationCenter().size() == 0) {
            throw new IllegalArgumentException("there are none vaccination centers registered to schedule vaccines");
        } else {
            String snsUserNumber = null;
            VaccinationCenter vaccinationCenter = null;
            VaccineType vaccineType = null;
            Vaccine vaccine = null;
            Date date = null;

            if (this.authFacade.getCurrentUserSession().getUserRoles().get(0).getId().equals(Constants.ROLE_RECEPTIONIST)) {
                snsUserNumber = Utils.readLineFromConsole("SNS Number:");
            } else {
                throw new IllegalArgumentException("Not a receptionist");
            }

            vaccinationCenter = controller.getWorking();

            if (!(vaccinationCenter instanceof HealthcareCenter)) {
                vaccine = (Vaccine) Utils.showAndSelectOne(this.controller.getVaccines(), "Vaccine:");
            }else {
                vaccine = this.controller.getVaccines().get(0);
            }
            date = Utils.readDateFromConsole("Date:(day-month-year hour:minute)");
            if (!controller.validateDate(date))
                throw new IllegalArgumentException("Date is not valid");


            ScheduleVaccineDTO scheduleVaccineDTO = new ScheduleVaccineDTO(snsUserNumber, vaccinationCenter, vaccine.getType(), date);


            try {
                this.controller.newScheduleVaccine(scheduleVaccineDTO, vaccine);
                getData();
                if (Utils.confirm("Confirms data?(s/n)")) {

                  /*  if (controller.validateWithinWorkingHours(vaccinationCenter, date)) {
                        System.out.println("Outside center working hours");
                        return;
                    }

                   */

                    controller.registerScheduleVaccine(scheduleVaccineDTO, vaccine);

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


    private void getData() {
        System.out.println(controller.getScheduleVaccineString());
    }

}
