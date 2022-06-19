package app.controller.nurse;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;

import java.util.Date;
import java.util.List;

/**
 * The type Vaccine administration controller.
 */
public class VaccineAdministrationController {
    private final App oApp;
    private final Company oCompany;
    private VaccinationCenter vaccinationCenter;

    /**
     * Instantiates a new Vaccine administration controller.
     */
    public VaccineAdministrationController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }

    /**
     * Sets working.
     *
     * @param vc the vc
     */
    public void setWorking(VaccinationCenter vc) {
        vaccinationCenter = vc;
    }

    /**
     * Get waiting room list.
     *
     * @return the list
     */
    public List<UserArrival> getWaitingRoom(){
        return vaccinationCenter.getListUserToWaitingRoom();
    }

    /**
     * Get available vaccines for user list.
     *
     * @param user the user
     * @return the list
     */
    public List<Vaccine> getAvailableVaccinesForUser(UserArrival user){
        return user.getSchedule().getVaccineList();
    }

    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Create vaccine administration vaccine administration.
     *
     * @param user    the user
     * @param vaccine the vaccine
     * @param date    the date
     * @return the vaccine administration
     */
    public VaccineAdministration createVaccineAdministration(UserArrival user, Vaccine vaccine, Date date) {
        return vaccinationCenter.createVaccineAdministration(user, vaccine, date);
    }

    /**
     * Add vaccine administration boolean.
     *
     * @param vaccineAdministration the vaccine administration
     * @return the boolean
     */
    public boolean addVaccineAdministration(VaccineAdministration vaccineAdministration){
        return vaccinationCenter.addVaccineAdministration(vaccineAdministration);
    }

    /**
     * Remove from waiting room.
     *
     * @param user the user
     */
    public void removeFromWaitingRoom(UserArrival user){
        vaccinationCenter.removeFromWaitingRoom(user);
    }

    /**
     * Move to recovery room.
     *
     * @param vaccineAdministration the vaccine administration
     * @param vaccine               the vaccine
     */
    public void moveToRecoveryRoom(VaccineAdministration vaccineAdministration, Vaccine vaccine){
        vaccinationCenter.moveToRecoveryRoom(vaccineAdministration);
        //vaccinationCenter.recoveryRoomTimer(vaccineAdministration, vaccine);
    }

    /**
     * Validate vaccine administration vaccine administration.
     *
     * @param user    the user
     * @param vaccine the vaccine
     * @return the vaccine administration
     */
    public VaccineAdministration validateVaccineAdministration(UserArrival user, Vaccine vaccine){
        return vaccinationCenter.validateVaccineAdministration(user.getSnsUser(), vaccine);
    }
}
