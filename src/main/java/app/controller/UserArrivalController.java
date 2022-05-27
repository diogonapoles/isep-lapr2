package app.controller;

import app.domain.model.Company;
import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccineType;
import app.domain.store.ScheduleVaccineStore;
import app.domain.store.VaccineTypeStore;
import app.domain.systemUsers.SNSUser;
import app.domain.model.VaccinationCenter;

import java.time.LocalDate;
import java.util.List;

/**
 * The type User arrival controller.
 */
public class UserArrivalController {

    private final App oApp;
    private final Company oCompany;
    private SNSUser oSNSUser;
    private VaccineTypeStore vaccineTypeStore;
    private ScheduleVaccineStore vaccineScheduleStore;

    /**
     * Instantiates a new User arrival controller.
     */
    public UserArrivalController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
        this.vaccineTypeStore = oCompany.getVaccineTypeStore();
        this.vaccineScheduleStore =oCompany.getScheduleVaccineStore();
    }

    /**
     * Get working vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getWorking() {
        return oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
    }

    public List<VaccineType> getVaccineTypeList() {
        return vaccineTypeStore.getListVaccineType();
    }

    /**
     * New user arrival boolean.
     *
     * @param snsUserNumber the sns user number
     * @return the boolean
     */
    public boolean newUserArrival(String snsUserNumber) {
        this.oSNSUser = oCompany.getUserArrivalStore().newUserArrival(snsUserNumber);

        if (this.oSNSUser != null)
            return true;
        else
            return false;
    }

    public ScheduleVaccine getScheduleVaccine(String snsUserNumber, VaccineType vaccineType) {
        return vaccineScheduleStore.getScheduleVaccine(snsUserNumber, LocalDate.now(), vaccineType);
    }

    /**
     * Register user arrival boolean.
     *
     * @return the boolean
     */
    public boolean registerUserArrival() {
        return this.oCompany.getUserArrivalStore().registerUserArrival(this.oSNSUser);
    }


    /**
     * Gets user arrival string.
     *
     * @return the user arrival string
     */
    public String getUserArrivalString() {
        return this.oSNSUser.toStringWaitingRoom();
    }
}
