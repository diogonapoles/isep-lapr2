package app.domain.store;

import app.controller.UserArrivalController;
import app.domain.model.ScheduleVaccine;
import app.domain.systemUsers.SNSUser;


import java.util.ArrayList;
import java.util.List;

public class UserArrivalStore {

    private final List<SNSUser> listUserToWaitingRoom = new ArrayList<>();

    private final ScheduleVaccineStore scheduleVaccineStore;

    public UserArrivalStore(ScheduleVaccineStore scheduleVaccineStore) {
        this.scheduleVaccineStore = scheduleVaccineStore;

    }

    public SNSUser newUserArrival(String snsUserNumber) {

        if (validateUserSchedule(snsUserNumber))
            return new SNSUser(SNSUser.getName(), SNSUser.getHomeAddress(), SNSUser.getPhoneNumber(), SNSUser.getBirthDate(), SNSUser.getEmailAddress(), snsUserNumber, SNSUser.getCitizenCardNumber());


        return null;
    }


    private boolean validateUserSchedule(String snsUserNumber) {
        for (ScheduleVaccine sv : scheduleVaccineStore.getListScheduleVaccine()) {
            if (sv.getSNSUserNumber().equals(snsUserNumber))
                if (listUserToWaitingRoom.isEmpty())
                    return true;
                else
                    for (SNSUser snsU : listUserToWaitingRoom)
                        if (!snsU.getSnsUserNumber().equals(snsUserNumber))
                            return true;
        }
        return false;
    }


    public boolean registerUserArrival(SNSUser snsUser) {
        return addUserToWaitingRoom(snsUser);
    }

    private boolean addUserToWaitingRoom(SNSUser snsUser) {
        return this.listUserToWaitingRoom.add(snsUser);
    }


    public List<SNSUser> getListUserToWaitingRoom() {
        return listUserToWaitingRoom;
    }


}
