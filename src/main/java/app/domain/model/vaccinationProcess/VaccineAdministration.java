package app.domain.model.vaccinationProcess;

import app.domain.model.vaccine.Vaccine;

import java.util.Date;

public class VaccineAdministration {

    private UserArrival userArrival;
    private Date vaccinationTime;
    private Vaccine vaccine;
    private Integer doses;


    public VaccineAdministration(UserArrival userArrival, Vaccine vaccine, Date vaccinationTime, int doses) {
        this.userArrival = userArrival;
        this.vaccinationTime = vaccinationTime;
        this.vaccine = vaccine;
        this.doses = 0;
    }

    public UserArrival getUserArrival() {
        return userArrival;
    }

    public void setUserArrival(UserArrival userArrival) {
        this.userArrival = userArrival;
    }

    public Date getVaccinationTime() {
        return vaccinationTime;
    }

    public void setVaccinationTime(Date vaccinationTime) {
        this.vaccinationTime = vaccinationTime;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public void addDose(){
        this.doses++;
    }

    public Integer getDoses() {
        return doses;
    }

    public void setDoses(Integer doses) {
        this.doses = doses;
    }

    @Override
    public String toString() {
        return "VaccineAdministration [" + " SNS User = " + userArrival.getSnsUser().getEmailAddress() + " | Vaccine = " + vaccine.getName() + "]";
    }
}
