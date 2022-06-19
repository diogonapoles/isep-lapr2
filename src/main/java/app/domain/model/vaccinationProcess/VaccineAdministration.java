package app.domain.model.vaccinationProcess;

import app.domain.model.vaccine.Vaccine;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Vaccine administration.
 */
public class VaccineAdministration implements Serializable {

    private UserArrival userArrival;
    private Date vaccinationTime;
    private Vaccine vaccine;
    private Integer doses;
    private Integer recoveryRoomTime;


    /**
     * Instantiates a new Vaccine administration.
     *
     * @param userArrival      the user arrival
     * @param vaccine          the vaccine
     * @param vaccinationTime  the vaccination time
     * @param recoveryRoomTime the recovery room time
     */
    public VaccineAdministration(UserArrival userArrival, Vaccine vaccine, Date vaccinationTime, int recoveryRoomTime) {
        this.userArrival = userArrival;
        this.vaccinationTime = vaccinationTime;
        this.vaccine = vaccine;
        this.doses = 0;
        this.recoveryRoomTime = recoveryRoomTime;
    }

    /**
     * Gets user arrival.
     *
     * @return the user arrival
     */
    public UserArrival getUserArrival() {
        return userArrival;
    }

    /**
     * Sets user arrival.
     *
     * @param userArrival the user arrival
     */
    public void setUserArrival(UserArrival userArrival) {
        this.userArrival = userArrival;
    }

    /**
     * Gets vaccination time.
     *
     * @return the vaccination time
     */
    public Date getVaccinationTime() {
        return vaccinationTime;
    }

    /**
     * Sets vaccination time.
     *
     * @param vaccinationTime the vaccination time
     */
    public void setVaccinationTime(Date vaccinationTime) {
        this.vaccinationTime = vaccinationTime;
    }

    /**
     * Gets vaccine.
     *
     * @return the vaccine
     */
    public Vaccine getVaccine() {
        return vaccine;
    }

    /**
     * Sets vaccine.
     *
     * @param vaccine the vaccine
     */
    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    /**
     * Add dose.
     */
    public void addDose(){
        this.doses++;
    }

    /**
     * Gets doses.
     *
     * @return the doses
     */
    public Integer getDoses() {
        return doses;
    }

    /**
     * Sets doses.
     *
     * @param doses the doses
     */
    public void setDoses(Integer doses) {
        this.doses = doses;
    }

    /**
     * Gets recovery room time.
     *
     * @return the recovery room time
     */
    public Integer getRecoveryRoomTime() {
        return recoveryRoomTime;
    }

    /**
     * Sets recovery room time.
     *
     * @param recoveryRoomTime the recovery room time
     */
    public void setRecoveryRoomTime(Integer recoveryRoomTime) {
        this.recoveryRoomTime = recoveryRoomTime;
    }



    @Override
    public String toString() {
        return "VaccineAdministration ["+"SNS User Number "+userArrival.getSnsUser().getSnsUserNumber()
                + " | SNS User = " + userArrival.getSnsUser().getEmailAddress() + " | Vaccine = " + vaccine.getName() + "]";
    }
}
