package app.domain.model.vaccinationProcess;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.SNSUser;

import javax.swing.plaf.basic.ComboPopup;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type User arrival.
 */
public class UserArrival implements Serializable {


    private SNSUser snsUser;
    private Date arrivalTime;
    private VaccineSchedule schedule;
    private App oApp;
    private Company oCompany;


    /**
     * Instantiates a new User arrival.
     *
     * @param snsUser     the sns user
     * @param arrivalTime the arrival time
     * @param schedule    the schedule
     */
    public UserArrival(SNSUser snsUser, Date arrivalTime, VaccineSchedule schedule) {
        this.snsUser = snsUser;
        this.arrivalTime = arrivalTime;
        this.schedule = schedule;
    }

    /**
     * Instantiates a new User arrival.
     */
    public UserArrival(){
        oApp= App.getInstance();
        oCompany=oApp.getCompany();
    }

    /**
     * Gets sns user.
     *
     * @return the sns user
     */
    public SNSUser getSnsUser() {
        return snsUser;
    }

    /**
     * Sets sns user.
     *
     * @param snsUser the sns user
     */
    public void setSnsUser(SNSUser snsUser) {
        this.snsUser = snsUser;
    }

    /**
     * Gets arrival time.
     *
     * @return the arrival time
     */
    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets arrival time.
     *
     * @param arrivalTime the arrival time
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets schedule.
     *
     * @return the schedule
     */
    public VaccineSchedule getSchedule() {
        return schedule;
    }

    /**
     * Sets schedule.
     *
     * @param schedule the schedule
     */
    public void setSchedule(VaccineSchedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "User [" + "E-mail = " + snsUser.getEmailAddress() + " | Arrival Time = " + arrivalTime + " | Scheduled Time = " + schedule.getTime() + "]";
    }

    /**
     * Get arrival list list.
     *
     * @return the list
     */
    public List getArrivalList(){
        return oCompany.getLegacySystemData().getArrivalList();
    }

}
