package app.domain.model.vaccinationProcess;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type User leaving.
 */
public class UserLeaving implements Serializable {

    private VaccineAdministration schedule;
    private Date leavingDate;
    private Company oCompany;
    private App oApp ;


    /**
     * Instantiates a new User leaving.
     *
     * @param administration the administration
     * @param leavingDate    the leaving date
     */
    public UserLeaving(VaccineAdministration administration, Date leavingDate) {
        this.leavingDate = leavingDate;
        this.schedule = administration;
    }

    /**
     * Instantiates a new User leaving.
     */
    public UserLeaving(){
        oApp=App.getInstance();
        oCompany=oApp.getCompany();
    }

    /**
     * Gets schedule.
     *
     * @return the schedule
     */
    public VaccineAdministration getSchedule() {
        return schedule;
    }

    /**
     * Sets leaving date.
     *
     * @param leavingDate the leaving date
     */
    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    /**
     * Gets leaving date.
     *
     * @return the leaving date
     */
    public Date getLeavingDate() {
        return leavingDate;
    }

    /**
     * Get leaving list list.
     *
     * @return the list
     */
    public List getLeavingList(){
        return oCompany.getLegacySystemData().getLeavingList();
    }
}
