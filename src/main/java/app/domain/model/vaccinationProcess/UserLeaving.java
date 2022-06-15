package app.domain.model.vaccinationProcess;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserLeaving implements Serializable {

    private VaccineAdministration schedule;
    private Date leavingDate;
    private Company oCompany;
    private App oApp ;


    public UserLeaving(VaccineAdministration administration, Date leavingDate) {
        this.leavingDate = leavingDate;
        this.schedule = administration;
    }
    public UserLeaving(){
        oApp=App.getInstance();
        oCompany=oApp.getCompany();
    }

    public VaccineAdministration getSchedule() {
        return schedule;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public List getLeavingList(){
        return oCompany.getLegacySystemData().getLeavingList();
    }
}
