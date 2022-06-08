package app.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LegacySystemData {

    private List listSortAlgorithms = new ArrayList<>();
    private int snsUserNumber;
    private String vaccineName;
    private String dose;
    private String lotNumber;
    private Date scheduledDateTime;
    private Date arrivalDateTime;
    private Date leavingDateTime;


    public LegacySystemData(int snsUserNumber, String vaccineName, String dose, String lotNumber,
                                  Date scheduledDateTime, Date arrivalDateTime, Date leavingDateTime) {
        this.snsUserNumber = snsUserNumber;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lotNumber = lotNumber;
        this.scheduledDateTime = scheduledDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.leavingDateTime = leavingDateTime;

    }

    public int getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(int snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Date getLeavingDateTime() {
        return leavingDateTime;
    }

    public void setLeavingDateTime(Date leavingDateTime) {
        this.leavingDateTime = leavingDateTime;
    }


    public List getSortAlgorithms() {
        listSortAlgorithms.add("Bubble Sort");
        listSortAlgorithms.add("Insertion Sort");
        return listSortAlgorithms;
    }

}
