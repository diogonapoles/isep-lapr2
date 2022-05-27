package app.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

public class ScheduleVaccine {

    private String snsUserNumber;
    private VaccinationCenter vaccinationCenter;
    private VaccineType vaccineType;
    private Date dateTime;

    public ScheduleVaccine(String snsUserNumber, VaccinationCenter vaccinationCenter,VaccineType vaccineType, Date dateTime) {

        if((vaccinationCenter == null)  ||
                (snsUserNumber == null) )

            throw new IllegalArgumentException("None of the arguments can be null or empty.");



        setSNSUserNumber(snsUserNumber);
        setVaccineType(vaccineType);
        setVaccinationCenter(vaccinationCenter);
        setDateTime(dateTime);



    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }



    public String getSNSUserNumber() {
        return snsUserNumber;
    }

    public void setSNSUserNumber(String SNSUserNumber) {
        this.snsUserNumber = SNSUserNumber;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }


    public String toString() {
        return "The SNS User number " + snsUserNumber + "has his vaccine appointment schedule at " +dateTime+" at "+vaccinationCenter+".";
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }


}
