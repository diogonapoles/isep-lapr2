package app.domain.model;

import java.time.LocalDateTime;

public class ScheduleVaccine {

    private String snsUserNumber;
    private VaccinationCenter vaccinationCenter;
    private VaccineType vaccineType;
    private LocalDateTime localDateTime;

    public ScheduleVaccine(String snsUserNumber, VaccinationCenter vaccinationCenter,VaccineType vaccineType, LocalDateTime localDateTime) {

        if((vaccinationCenter == null)  ||
                (snsUserNumber == null) )

            throw new IllegalArgumentException("None of the arguments can be null or empty.");



        setSNSUserNumber(snsUserNumber);
        setVaccineType(vaccineType);
        setVaccinationCenter(vaccinationCenter);
        setLocalDateTime(localDateTime);



    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
        return "The SNS User number " + snsUserNumber + " vaccine appointment is at " + vaccinationCenter + ", at " + localDateTime +  ".";
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }
}
