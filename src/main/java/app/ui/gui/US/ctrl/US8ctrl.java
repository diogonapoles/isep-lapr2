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

public class US8ctrl {
    private final App oApp;
    private final Company oCompany;
    private VaccinationCenter vaccinationCenter;

    public US8ctrl() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public VaccinationCenter getWorking() {
        vaccinationCenter = NurseUI.vaccinationCenter;
        return vaccinationCenter;
    }

    public List<UserArrival> getWaitingRoom(){
        return vaccinationCenter.getListUserToWaitingRoom();
    }

    public List<Vaccine> getAvailableVaccinesForUser(UserArrival user){
        return user.getSchedule().getVaccineList();
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public VaccineAdministration createVaccineAdministration(UserArrival user, Vaccine vaccine, Date date) {
        return vaccinationCenter.createVaccineAdministration(user, vaccine, date);
    }

    public boolean addVaccineAdministration(VaccineAdministration vaccineAdministration){
        return vaccinationCenter.addVaccineAdministration(vaccineAdministration);
    }

    public void removeFromWaitingRoom(UserArrival user){
        vaccinationCenter.removeFromWaitingRoom(user);
    }

    public void moveToRecoveryRoom(VaccineAdministration vaccineAdministration, Vaccine vaccine){
        vaccinationCenter.moveToRecoveryRoom(vaccineAdministration);
        vaccinationCenter.recoveryRoomTimer(vaccineAdministration, vaccine);
    }

    public VaccineAdministration validateVaccineAdministration(UserArrival user, Vaccine vaccine){
        return vaccinationCenter.validateVaccineAdministration(user.getSnsUser(), vaccine);
    }
}
