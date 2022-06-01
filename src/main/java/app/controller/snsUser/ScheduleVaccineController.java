package app.controller.snsUser;

import app.controller.App;
import app.controller.ScheduleVaccineDTO;
import app.domain.model.*;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.ScheduleVaccine;
import app.domain.model.vaccine.VaccineType;
import app.domain.store.SNSUserStore;
import app.domain.store.ScheduleVaccineStore;
import app.domain.store.VaccinationCenterStore;
import app.domain.store.VaccineTypeStore;
import app.domain.model.systemUser.SNSUser;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.List;

/**
 * The type Schedule vaccine controller.
 */
public class ScheduleVaccineController {

    private App oApp;
    private Company oCompany;
    private ScheduleVaccine oScheduleVaccine;
    private final AuthFacade authFacade;
    private final ScheduleVaccineStore scheduleVaccineStore;
    private final VaccinationCenterStore vaccinationCenterStore;
    private final VaccineTypeStore vaccineTypeStore;
    private final SNSUserStore snsUserStore;

    /**
     * Instantiates a new Schedule vaccine controller.
     */
    public ScheduleVaccineController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
        this.authFacade = this.oCompany.getAuthFacade();
        this.scheduleVaccineStore = oCompany.getScheduleVaccineStore();
        this.vaccinationCenterStore = oCompany.getVaccinationCenterStore();
        this.vaccineTypeStore = oCompany.getVaccineTypeStore();
        this.snsUserStore = oCompany.getSNSUserStore();
    }

    /**
     * New schedule vaccine boolean.
     *
     * @param scheduleVaccineDTO the schedule vaccine dto
     * @return the boolean
     */
    public boolean newScheduleVaccine(ScheduleVaccineDTO scheduleVaccineDTO) {
        String snsUserNumber = scheduleVaccineDTO.getSnsUserNumber();
        SNSUser user = oCompany.getSNSUserStore().getSNSUserByNumber(snsUserNumber);

        this.oScheduleVaccine = oCompany.getScheduleVaccineStore().newScheduleVaccine(scheduleVaccineDTO);
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
     * Register schedule vaccine boolean.
     *
     * @return the boolean
     */
    public boolean registerScheduleVaccine() {
        return this.oCompany.getScheduleVaccineStore().registerScheduleVaccine(this.oScheduleVaccine);
    }

    /**
     * Gets schedule vaccine.
     *
     * @return the schedule vaccine
     */
    public ScheduleVaccine getScheduleVaccine() {
        return oScheduleVaccine;
    }

   /* public boolean validateWithinWorkingHours(VaccinationCenter vaccinationCenter, Date date) throws ParseException {
        String oh = vaccinationCenter.getOpeningHours();
        Date o = new SimpleDateFormat("HH:mm").parse(oh);
        String ch = vaccinationCenter.getClosingHours();
        Date c = new SimpleDateFormat("HH:mm").parse(ch);
        if (o.toInstant().isBefore(date)) {
            if (c.isBefore(date)) {
                return true;
            }
        }
        return false;
    }

    */

}


