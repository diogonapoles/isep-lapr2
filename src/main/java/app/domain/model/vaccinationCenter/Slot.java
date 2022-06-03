package app.domain.model.vaccinationCenter;

import app.domain.model.systemUser.SNSUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Slot {

    private Day vaccineDay;
    private List<Date> allSlots;
    private List<SNSUser> userSlotList;
    private List <Boolean> slotOcupation;

    public Slot(Day vaccineDay){
        this.vaccineDay = vaccineDay;
        this.allSlots = new ArrayList<>();
        this.userSlotList = new ArrayList<>();
        this.slotOcupation = new ArrayList<>();
    }

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

    public void startUserSlotList(){
        for (int i = 0; i < allSlots.size(); i++) {
            userSlotList.add(null);
        }
    }

    public void addSNSUserSlot(SNSUser user, Date date){
        int index = findDate(date);
        if(index == -1)
            throw new IllegalArgumentException("No slots available");
        userSlotList.set(index, user);
    }

    public void slotOcupationGenerator(){
        for (int i = 0; i < allSlots.size(); i++) {
            slotOcupation.add(i, false);
        }
    }


    public void modifySlotOcupation(){
        for (int i = 0; i < allSlots.size(); i++) {
            if (validateSlot(i))
                slotOcupation.set(i, true);
        }
    }

    //true = ocupado
    //false = livre
    public boolean validateSlot(int position){
        if(userSlotList.get(position) != null)
            return true;
        return false;
    }

    public List<Date> getAvailableSlots() {
        List <Date> availableSlots = new ArrayList<>();
        modifySlotOcupation();

        for (int i = 0; i < allSlots.size(); i++) {
            if (!slotOcupation.get(i))
                availableSlots.add(allSlots.get(i));
        }
        return availableSlots;
    }

    public int findDate(Date date){
        for (int index = 0; index < allSlots.size(); index++) {
            if (allSlots.get(index).equals(date) && !slotOcupation.get(index))
                return index;
        }
        return -1;
    }

    public Day getVaccineDay() {
        return vaccineDay;
    }

    public void setVaccineDay(Day vaccineDay) {
        this.vaccineDay = vaccineDay;
    }

    public List<Date> getAllSlots() {
        return allSlots;
    }

    public void setAllSlots(List<Date> allSlots) {
        this.allSlots = allSlots;
    }


    public List<SNSUser> getUserSlotList() {
        return userSlotList;
    }

    public void setUserSlotList(List<SNSUser> userSlotList) {
        this.userSlotList = userSlotList;
    }
}

