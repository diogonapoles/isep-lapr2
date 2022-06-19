package app.domain.model.vaccinationCenter;

import app.domain.model.systemUser.SNSUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Slot.
 */
public class Slot implements Serializable {

    private Day vaccineDay;
    private List<Date> allSlots;
    private List<SNSUser> userSlotList;
    private List <Boolean> slotOcupation;

    /**
     * Instantiates a new Slot.
     *
     * @param vaccineDay the vaccine day
     */
    public Slot(Day vaccineDay){
        this.vaccineDay = vaccineDay;
        this.allSlots = new ArrayList<>();
        this.userSlotList = new ArrayList<>();
        this.slotOcupation = new ArrayList<>();
    }

    /**
     * All slots.
     *
     * @param daySchedule the day schedule
     * @param maxNumVacs  the max num vacs
     */
    public void allSlots(List<Date> daySchedule, int maxNumVacs){
        List<Date> tempScheduleList = new ArrayList<>();

        for (int day = 0; day < daySchedule.size(); day++) {
            int counter = 0;
            while (counter != maxNumVacs){
                tempScheduleList.add(daySchedule.get(day));
                counter++;
            }
        }
        allSlots = tempScheduleList;
        slotOcupationGenerator();
    }

    /**
     * Start user slot list.
     */
    public void startUserSlotList(){
        for (int i = 0; i < allSlots.size(); i++) {
            userSlotList.add(null);
        }
    }

    /**
     * Add sns user slot.
     *
     * @param user the user
     * @param date the date
     */
    public void addSNSUserSlot(SNSUser user, Date date){
        int index = findDate(date);
        if(index == -1)
            throw new IllegalArgumentException("No slots available");
        userSlotList.set(index, user);
    }

    /**
     * Slot ocupation generator.
     */
    public void slotOcupationGenerator(){
        for (int i = 0; i < allSlots.size(); i++) {
            slotOcupation.add(i, false);
        }
    }


    /**
     * Modify slot ocupation.
     */
    public void modifySlotOcupation(){
        for (int i = 0; i < allSlots.size(); i++) {
            if (validateSlot(i))
                slotOcupation.set(i, true);
        }
    }

    /**
     * Validate slot boolean.
     *
     * @param position the position
     * @return the boolean
     */
//true = ocupado
    //false = livre
    public boolean validateSlot(int position){
        if(userSlotList.get(position) != null)
            return true;
        return false;
    }

    /**
     * Gets available slots.
     *
     * @return the available slots
     */
    public List<Date> getAvailableSlots() {
        List <Date> availableSlots = new ArrayList<>();
        modifySlotOcupation();

        for (int i = 0; i < allSlots.size(); i++) {
            if (!slotOcupation.get(i))
                availableSlots.add(allSlots.get(i));
        }
        return availableSlots;
    }

    /**
     * Find date int.
     *
     * @param date the date
     * @return the int
     */
    public int findDate(Date date){
        for (int index = 0; index < allSlots.size(); index++) {
            if (allSlots.get(index).equals(date) && !slotOcupation.get(index))
                return index;
        }
        return -1;
    }

    /**
     * Gets vaccine day.
     *
     * @return the vaccine day
     */
    public Day getVaccineDay() {
        return vaccineDay;
    }

    /**
     * Sets vaccine day.
     *
     * @param vaccineDay the vaccine day
     */
    public void setVaccineDay(Day vaccineDay) {
        this.vaccineDay = vaccineDay;
    }

    /**
     * Gets all slots.
     *
     * @return the all slots
     */
    public List<Date> getAllSlots() {
        return allSlots;
    }

    /**
     * Sets all slots.
     *
     * @param allSlots the all slots
     */
    public void setAllSlots(List<Date> allSlots) {
        this.allSlots = allSlots;
    }


    /**
     * Gets user slot list.
     *
     * @return the user slot list
     */
    public List<SNSUser> getUserSlotList() {
        return userSlotList;
    }

    /**
     * Sets user slot list.
     *
     * @param userSlotList the user slot list
     */
    public void setUserSlotList(List<SNSUser> userSlotList) {
        this.userSlotList = userSlotList;
    }
}

