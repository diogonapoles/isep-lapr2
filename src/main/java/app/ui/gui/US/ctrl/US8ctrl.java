package app.ui.gui.US.ctrl;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import app.ui.gui.roles.NurseUI;

import java.util.Date;
import java.util.List;

/**
 * The type Us 8 ctrl.
 */
public class US8ctrl {
    private final App oApp;
    private final Company oCompany;
    private VaccinationCenter vaccinationCenter = NurseUI.vaccinationCenter;

    /**
     * Instantiates a new Us 8 ctrl.
     */
    public US8ctrl() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        return vaccinationCenter;
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
