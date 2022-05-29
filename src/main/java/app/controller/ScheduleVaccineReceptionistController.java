package app.controller;

import app.domain.model.*;
import app.domain.store.*;
import app.domain.systemUsers.SNSUser;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type Schedule vaccine receptionist controller.
 */
public class ScheduleVaccineReceptionistController {

    private App oApp;
    private Company oCompany;
    private ScheduleVaccine oScheduleVaccine;
    private final AuthFacade authFacade;
    private final ScheduleVaccineStore scheduleVaccineStore;
    private final VaccinationCenterStore vaccinationCenterStore;
    private final VaccineTypeStore vaccineTypeStore;
    private final VaccineStore vaccineStore;
    private final SNSUserStore snsUserStore;

    /**
     * Instantiates a new Schedule vaccine receptionist controller.
     */
    public ScheduleVaccineReceptionistController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
        this.authFacade = this.oCompany.getAuthFacade();
        this.scheduleVaccineStore = oCompany.getScheduleVaccineStore();
        this.vaccinationCenterStore = oCompany.getVaccinationCenterStore();
        this.vaccineTypeStore = oCompany.getVaccineTypeStore();
        this.vaccineStore = oCompany.getVaccineStore();
        this.snsUserStore = oCompany.getSNSUserStore();
    }

    /**
     * New schedule vaccine boolean.
     *
     * @param scheduleVaccineDTO the schedule vaccine dto
     * @param vaccine            the vaccine
     * @return the boolean
     */
    public boolean newScheduleVaccine(ScheduleVaccineDTO scheduleVaccineDTO, Vaccine vaccine) {
        String snsUserNumber = scheduleVaccineDTO.getSnsUserNumber();
        SNSUser user = oCompany.getSNSUserStore().getSNSUserByNumber(snsUserNumber);

        this.oScheduleVaccine = oCompany.getScheduleVaccineStore().newScheduleVaccineReceptionist(scheduleVaccineDTO, user, vaccine);
        if (this.oScheduleVaccine != null) {
            return true;
        } else {
            return false;
        }
    }

    //  public List<String> getScheduleVaccine() {
    //    return this.oCompany.getScheduleVaccineStore().listScheduleVaccine();
    //}


    /**
     * Gets schedule vaccine string.
     *
     * @return the schedule vaccine string
     */
    public String getScheduleVaccineString() {
        return this.oScheduleVaccine.toString();
    }


    //    public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}

    //public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}


    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public List<VaccinationCenter> getVaccinationCenter() {
        return this.vaccinationCenterStore.getVaccinationCenters();
    }

    /**
     * Gets vaccine types.
     *
     * @return the vaccine types
     */
    public List<VaccineType> getVaccineTypes() {
        return this.vaccineTypeStore.getListVaccineType();
    }

    /**
     * Gets vaccines.
     *
     * @return the vaccines
     */
    public List<Vaccine> getVaccines() {
        return this.vaccineStore.getListVaccines();
    }

    /**
     * Register schedule vaccine boolean.
     *
     * @param scheduleVaccineDTO the schedule vaccine dto
     * @param vaccine            the vaccine
     * @return the boolean
     */
    public boolean registerScheduleVaccine(ScheduleVaccineDTO scheduleVaccineDTO, Vaccine vaccine) {
        String snsUserNumber = scheduleVaccineDTO.getSnsUserNumber();
        SNSUser user = oCompany.getSNSUserStore().getSNSUserByNumber(snsUserNumber);

        return this.oCompany.getScheduleVaccineStore().registerScheduleVaccineReceptionist(this.oScheduleVaccine, user, vaccine);
    }

    /**
     * Gets schedule vaccine.
     *
     * @return the schedule vaccine
     */
    public ScheduleVaccine getScheduleVaccine() {
        return oScheduleVaccine;
    }

    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        VaccinationCenter vc = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vc;
    }

    /**
     * Validate date boolean.
     *
     * @param d the d
     * @return the boolean
     */
    public boolean validateDate(Date d) {
        LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now(ZoneId.systemDefault());

        if (date.isBefore(today)) {
            return false;
        }
        return true;
    }
}
