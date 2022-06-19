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

/**
 * The type Day.
 */
public class Day implements Serializable {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;
    private Date day;
    private Integer openingHours;
    private Integer closingHours;
    private Integer slotDuration;
    private Integer maxNumVaccinesPerSlot;

    /**
     * Instantiates a new Day.
     *
     * @param vaccinationCenter     the vaccination center
     * @param day                   the day
     * @param openingHours          the opening hours
     * @param closingHours          the closing hours
     * @param slotDuration          the slot duration
     * @param maxNumVaccinesPerSlot the max num vaccines per slot
     */
    public Day(VaccinationCenter vaccinationCenter, Date day, int openingHours, int closingHours, int slotDuration, int maxNumVaccinesPerSlot){
        this.vaccinationCenter = vaccinationCenter;
        this.day = day;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.slotDuration = slotDuration;
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }


    /**
     * Get day schedule list.
     *
     * @return the list
     */
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

    /**
     * Gets day.
     *
     * @return the day
     */
    public Date getDay() {
        return day;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(Date day) {
        this.day = day;
    }

    /**
     * Gets opening hours.
     *
     * @return the opening hours
     */
    public Integer getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets opening hours.
     *
     * @param openingHours the opening hours
     */
    public void setOpeningHours(Integer openingHours) {
        this.openingHours = openingHours;
    }


    /**
     * Gets closing hours.
     *
     * @return the closing hours
     */
    public Integer getClosingHours() {
        return closingHours;
    }

    /**
     * Sets closing hours.
     *
     * @param closingHours the closing hours
     */
    public void setClosingHours(Integer closingHours) {
        this.closingHours = closingHours;
    }

    /**
     * Gets slot duration.
     *
     * @return the slot duration
     */
    public Integer getSlotDuration() {
        return slotDuration;
    }

    /**
     * Sets slot duration.
     *
     * @param slotDuration the slot duration
     */
    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
    }

    /**
     * Gets max num vaccines per slot.
     *
     * @return the max num vaccines per slot
     */
    public Integer getMaxNumVaccinesPerSlot() {
        return maxNumVaccinesPerSlot;
    }

    /**
     * Sets max num vaccines per slot.
     *
     * @param maxNumVaccinesPerSlot the max num vaccines per slot
     */
    public void setMaxNumVaccinesPerSlot(Integer maxNumVaccinesPerSlot) {
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }
}
