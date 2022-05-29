package app.controller;

import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

import java.util.Date;

/**
 * The type Schedule vaccine dto.
 */
public class ScheduleVaccineDTO {
    private final String snsUserNumber;
    private final VaccinationCenter vaccinationCenter;
    private final VaccineType vaccineType;
    private final Date dateTime;

    /**
     * Instantiates a new Schedule vaccine dto.
     *
     * @param snsUserNumber     the sns user number
     * @param vaccinationCenter the vaccination center
     * @param vaccineType       the vaccine type
     * @param dateTime          the date time
     */
    public ScheduleVaccineDTO(String snsUserNumber, VaccinationCenter vaccinationCenter, VaccineType vaccineType, Date dateTime){
        this.snsUserNumber = snsUserNumber;
        this.vaccinationCenter = vaccinationCenter;
        this.vaccineType= vaccineType;
        this.dateTime=dateTime;
    }


    /**
     * Get sns user number string.
     *
     * @return the string
     */
    public String getSnsUserNumber(){
        return snsUserNumber;
    }

    /**
     * Get vaccination center vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter(){
        return vaccinationCenter;
    }

    /**
     * Get vaccine type vaccine type.
     *
     * @return the vaccine type
     */
    public VaccineType getVaccineType(){
        return vaccineType;
    }

    /**
     * Get date time date.
     *
     * @return the date
     */
    public Date getDateTime(){
        return dateTime;
    }
    
}
