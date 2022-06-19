package app.domain.model.vaccinationProcess;

import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Vaccine schedule.
 */
public class VaccineSchedule implements Comparable<VaccineSchedule>, Serializable {

    private SNSUser user;
    private VaccineType vaccineType;
    private List<Vaccine> vaccineList;
    private Date time;

    /**
     * Instantiates a new Vaccine schedule.
     *
     * @param user        the user
     * @param vaccineType the vaccine type
     * @param vaccineList the vaccine list
     * @param time        the time
     */
    public VaccineSchedule(SNSUser user, VaccineType vaccineType, List<Vaccine> vaccineList, Date time) {
        this.user = user;
        this.vaccineType = vaccineType;
        this.vaccineList = vaccineList;
        this.time = time;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public SNSUser getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(SNSUser user) {
        this.user = user;
    }

    /**
     * Gets vaccine type.
     *
     * @return the vaccine type
     */
    public VaccineType getVaccineType() {
        return vaccineType;}


    /**
     * Sets vaccine type.
     *
     * @param vaccineType the vaccine type
     */
    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Gets vaccine list.
     *
     * @return the vaccine list
     */
    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    /**
     * Sets vaccine list.
     *
     * @param vaccineList the vaccine list
     */
    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VaccineSchedule [" + "SNS User = " + user.getEmailAddress() + " | Vaccine Type = " + vaccineType.getCode() + " | Vaccination Day = " + time + "]";
    }

    @Override
    public int compareTo(VaccineSchedule o) {
        return getTime().compareTo(o.getTime());
    }
}
