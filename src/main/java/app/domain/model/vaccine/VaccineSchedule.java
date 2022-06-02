package app.domain.model.vaccine;

import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.Day;

import java.util.Date;

public class VaccineSchedule {

    private SNSUser user;
    private VaccineType vaccineType;
    private Date time;

    public VaccineSchedule(SNSUser user, VaccineType vaccineType, Date time) {
        this.user = user;
        this.vaccineType = vaccineType;
        this.time = time;
    }

    public SNSUser getUser() {
        return user;
    }

    public void setUser(SNSUser user) {
        this.user = user;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VaccineSchedule [" + "SNS User = " + user.getEmailAddress() + " | Vaccine Type = " + vaccineType.getCode() + " | Vaccination Day = " + time + "]";
    }
}
