package app.domain.model.vaccinationCenter;

import app.controller.App;
import app.domain.model.Company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Day implements Serializable {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;
    private Date day;
    private Integer openingHours;
    private Integer closingHours;
    private Integer slotDuration;
    private Integer maxNumVaccinesPerSlot;

    public Day(VaccinationCenter vaccinationCenter, Date day, int openingHours, int closingHours, int slotDuration, int maxNumVaccinesPerSlot){
        this.vaccinationCenter = vaccinationCenter;
        this.day = day;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.slotDuration = slotDuration;
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }


    public List<Date> getDaySchedule(){
        List<Date> daySchedule = new ArrayList<>();

        Calendar opening = Calendar.getInstance();
        opening.setTime(day);
        opening.set(Calendar.HOUR, openingHours);
        opening.set(Calendar.MINUTE, 0);

        Calendar closing = Calendar.getInstance();
        closing.setTime(day);
        closing.set(Calendar.HOUR, closingHours);
        closing.set(Calendar.MINUTE, 0);

        for (Calendar i = opening; i.before(closing); i.add(Calendar.MINUTE, slotDuration)) {
            Date newDate = calendarToDate(i);
            daySchedule.add(newDate);
        }
        return daySchedule;
    }

    private Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Integer openingHours) {
        this.openingHours = openingHours;
    }


    public Integer getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(Integer closingHours) {
        this.closingHours = closingHours;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
    }

    public Integer getMaxNumVaccinesPerSlot() {
        return maxNumVaccinesPerSlot;
    }

    public void setMaxNumVaccinesPerSlot(Integer maxNumVaccinesPerSlot) {
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }
}
