
package app.ui.console;

import app.controller.App;
import app.controller.ScheduleVaccineController;
import app.controller.ScheduleVaccineDTO;
import app.domain.model.Company;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccineType;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.Date;
import java.util.List;

public class ScheduleVaccineUI implements Runnable {

    private final ScheduleVaccineController controller;
    private final AuthFacade authFacade;
    private final Company company;


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
        } else if (inputData()) {
            getData();
            if (Utils.confirm("Confirms data?(s/n)")) {
                controller.registerScheduleVaccine();
                System.out.println("Schedule registered successfully");
            } else
                run();
        } else {

            System.out.println("Cannot Schedule the Vaccine");
        }


    }


    public List<VaccinationCenter> getVaccinationCenter() {
        return this.controller.getVaccinationCenter();
    }

    private boolean inputData() {
        VaccineType vaccineType = null;
        String snsUserNumber = Utils.readLineFromConsole("SNS Number:");
        VaccinationCenter vaccinationCenter = (VaccinationCenter) Utils.showAndSelectOne(this.controller.getVaccinationCenter(), "Vaccination Centers:");
        Date dateTime = Utils.readDateFromConsole("Date and Time:");
        try {
            vaccineType = (VaccineType) Utils.showAndSelectOne(this.controller.getVaccineTypes(), "Vaccine Type:");
        } catch (Exception ex) {
            System.out.printf("outbreak\n\n\n\n");
            //vaccineType = company.getCurrentOutBreak();
        }
        ScheduleVaccineDTO scheduleVaccineDTO = new ScheduleVaccineDTO(snsUserNumber, vaccinationCenter, vaccineType, dateTime);
        return this.controller.newScheduleVaccine(scheduleVaccineDTO);


    }

    private void getData() {
        System.out.println(controller.getScheduleVaccineString());
    }

}


