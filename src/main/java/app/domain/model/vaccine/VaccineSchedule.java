package app.domain.model.vaccine;

import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.Day;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.ui.console.utils.Data;

import java.util.Date;
import java.util.List;

public class VaccineSchedule implements Comparable<VaccineSchedule> {

    private SNSUser user;
    private VaccineType vaccineType;
    private List<Vaccine> vaccineList;
    private Date time;

    public VaccineSchedule(SNSUser user, VaccineType vaccineType, List<Vaccine> vaccineList, Date time) {
        this.user = user;
        this.vaccineType = vaccineType;
        this.vaccineList = vaccineList;
        this.time = time;
    }

    public SNSUser getUser() {
        return user;
    }

    public void setUser(SNSUser user) {
        this.user = user;
    }

    public VaccineType getVaccineType() {
        return vaccineType;}



    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Date getTime() {
        return time;
    }

    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

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
