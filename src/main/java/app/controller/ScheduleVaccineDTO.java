package app.controller;

import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

import java.util.Date;

public class ScheduleVaccineDTO {
    private final String snsUserNumber;
    private final VaccinationCenter vaccinationCenter;
    private final VaccineType vaccineType;
    private final Date dateTime;

    public ScheduleVaccineDTO(String snsUserNumber, VaccinationCenter vaccinationCenter, VaccineType vaccineType, Date dateTime){
        this.snsUserNumber = snsUserNumber;
        this.vaccinationCenter = vaccinationCenter;
        this.vaccineType= vaccineType;
        this.dateTime=dateTime;
    }

    
    public String getSnsUserNumber(){
        return snsUserNumber;
    }
    public VaccinationCenter getVaccinationCenter(){
        return vaccinationCenter;
    }
    public VaccineType getVaccineType(){
        return vaccineType;
    }
    public Date getDateTime(){
        return dateTime;
    }
    
}
