package app.controller;

import app.domain.Slot;
import app.domain.model.Company;
import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccineType;
import app.domain.store.SNSUserStore;
import app.domain.store.ScheduleVaccineStore;
import app.domain.store.VaccinationCenterStore;
import app.domain.store.VaccineTypeStore;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ScheduleVaccineController {

    private App oApp;
    private Company oCompany;
    private ScheduleVaccine oScheduleVaccine;
    private final AuthFacade authFacade;
    private final ScheduleVaccineStore scheduleVaccineStore;
    private final VaccinationCenterStore vaccinationCenterStore;
    private final VaccineTypeStore vaccineTypeStore;
    private final SNSUserStore snsUserStore;

    public ScheduleVaccineController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
        this.authFacade = this.oCompany.getAuthFacade();
        this.scheduleVaccineStore = oCompany.getScheduleVaccineStore();
        this.vaccinationCenterStore = oCompany.getVaccinationCenterStore();
        this.vaccineTypeStore = oCompany.getVaccineTypeStore();
        this.snsUserStore = oCompany.getSNSUserStore();
    }

    public boolean newScheduleVaccine(ScheduleVaccineDTO scheduleVaccineDTO) {
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


    public String getScheduleVaccineString() {
        return this.oScheduleVaccine.toString();
    }


    //    public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}

    //public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}


    public List<VaccinationCenter> getVaccinationCenter() {
        return this.vaccinationCenterStore.getVaccinationCenters();
    }

    public List<VaccineType> getVaccineTypes() {
        return this.vaccineTypeStore.getListVaccineType();
    }

    public boolean registerScheduleVaccine() {
        return this.oCompany.getScheduleVaccineStore().registerScheduleVaccine(this.oScheduleVaccine);
    }

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


