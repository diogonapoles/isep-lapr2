package app.domain.model.vaccinationProcess;

import app.domain.model.vaccine.Vaccine;

import java.util.Date;

public class VaccineAdministration {

    private UserArrival userArrival;
    private Date vaccinationTime;
    private Vaccine vaccine;
    private Integer doses;
    private Integer recoveryRoomTime;


    public VaccineAdministration(UserArrival userArrival, Vaccine vaccine, Date vaccinationTime, int recoveryRoomTime) {
        this.userArrival = userArrival;
        this.vaccinationTime = vaccinationTime;
        this.vaccine = vaccine;
        this.doses = 0;
        this.recoveryRoomTime = recoveryRoomTime;
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

    public Integer getRecoveryRoomTime() {
        return recoveryRoomTime;
    }

    public void setRecoveryRoomTime(Integer recoveryRoomTime) {
        this.recoveryRoomTime = recoveryRoomTime;
    }

    @Override
    public String toString() {
        return "VaccineAdministration [" + " SNS User = " + userArrival.getSnsUser().getEmailAddress() + " | Vaccine = " + vaccine.getName() + "]";
    }
}
