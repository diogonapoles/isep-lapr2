package app.domain.model.vaccinationProcess;

import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.VaccineType;

import java.util.Date;

/**
 * The type Schedule vaccine.
 */
public class ScheduleVaccine {

    private String snsUserNumber;
    private VaccinationCenter vaccinationCenter;
    private VaccineType vaccineType;
    private Date dateTime;

    /**
     * Instantiates a new Schedule vaccine.
     *
     * @param snsUserNumber     the sns user number
     * @param vaccinationCenter the vaccination center
     * @param vaccineType       the vaccine type
     * @param dateTime          the date time
     */
    public ScheduleVaccine(String snsUserNumber, VaccinationCenter vaccinationCenter, VaccineType vaccineType, Date dateTime) {
        if((vaccinationCenter == null)  ||
                (snsUserNumber == null) )

            throw new IllegalArgumentException("None of the arguments can be null or empty.");



        setSNSUserNumber(snsUserNumber);
        setVaccineType(vaccineType);
        setVaccinationCenter(vaccinationCenter);
        setDateTime(dateTime);
    }

    /**
     * Sets vaccine type.
     *
     * @param vaccineType the vaccine type
     */
    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }


    /**
     * Gets date time.
     *
     * @return the date time
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Sets date time.
     *
     * @param dateTime the date time
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }


    /**
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public String getSNSUserNumber() {
        return snsUserNumber;
    }

    /**
     * Sets sns user number.
     *
     * @param SNSUserNumber the sns user number
     */
    public void setSNSUserNumber(String SNSUserNumber) {
        this.snsUserNumber = SNSUserNumber;
    }

    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Sets vaccination center.
     *
     * @param vaccinationCenter the vaccination center
     */
    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }


    public String toString() {
        return "The SNS User number " + snsUserNumber + " has his vaccine appointment schedule at " +dateTime+" at: "+vaccinationCenter.toStringScheduleVaccine();
    }

    /**
     * Gets vaccine type.
     *
     * @return the vaccine type
     */
    public VaccineType getVaccineType() {
        return vaccineType;
    }


}