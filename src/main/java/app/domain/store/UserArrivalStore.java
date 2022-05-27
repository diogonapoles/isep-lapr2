package app.domain.store;

import app.domain.model.ScheduleVaccine;
import app.domain.systemUsers.SNSUser;


import java.util.ArrayList;
import java.util.List;

public class UserArrivalStore {

    private final List<SNSUser> listUserToWaitingRoom = new ArrayList<>();

    private final ScheduleVaccineStore scheduleVaccineStore;

    public UserArrivalStore(ScheduleVaccineStore scheduleVaccineStore){
        this.scheduleVaccineStore = scheduleVaccineStore;

    }

    public SNSUser newUserArrival(String snsUserNumber) {

        if (validateUserSchedule(snsUserNumber))
            return new SNSUser(snsUserNumber);

        return null;
    }


    private boolean validateUserSchedule(String snsUserNumber) {
        for (ScheduleVaccine sv: scheduleVaccineStore.getListScheduleVaccine()) {
            if (sv.getSNSUserNumber().compareTo(snsUserNumber)==0)
                return true;
        }
        return false;
    }

    public boolean registerUserArrival(SNSUser snsUser) {return addUserToWaitingRoom(snsUser);}

    private boolean addUserToWaitingRoom(SNSUser snsUser) {
        return this.listUserToWaitingRoom.add(snsUser);
    }


    public List<SNSUser> getListUserToWaitingRoom() {
        return listUserToWaitingRoom;
    }


}
