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


    public UserArrival(SNSUser snsUser, Date arrivalTime, VaccineSchedule schedule) {
        this.snsUser = snsUser;
        this.arrivalTime = arrivalTime;
        this.schedule = schedule;
    }
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

    public void setSnsUser(SNSUser snsUser) {
        this.snsUser = snsUser;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public VaccineSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(VaccineSchedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "User [" + "E-mail = " + snsUser.getEmailAddress() + " | Arrival Time = " + arrivalTime + " | Scheduled Time = " + schedule.getTime() + "]";
    }

    public List getArrivalList(){
        return oCompany.getLegacySystemData().getArrivalList();
    }

}
