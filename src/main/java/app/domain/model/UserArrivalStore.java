package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class UserArrivalStore {

    private final List<SNSUser> listSnsUser = new ArrayList<>();

    private final List<SNSUser> listUserToWaitingRoom = new ArrayList<>();

    public SNSUser newUserArrival(String name, String snsUserNumber, String citizenCardNumber , String vaccineScheduleDate) {

        if (validateUserSchedule(name, snsUserNumber, citizenCardNumber, vaccineScheduleDate))
            return new SNSUser(name, snsUserNumber, citizenCardNumber, vaccineScheduleDate);

        return null;
    }

    private boolean validateUserSchedule(String name, String snsUserNumber, String citizenCardNumber , String vaccineScheduleDate) {
        for (SNSUser snsUser : listSnsUser) {
            if (snsUser.getName().equalsIgnoreCase(name)
                    // || snsUser.getArrivalTime().equals(arrivalTime)
                    || snsUser.getSnsUserNumber().equals(snsUserNumber)
                    || snsUser.getCitizenCardNumber().equals(citizenCardNumber)
                    || snsUser.getVaccineScheduleDate().equals(vaccineScheduleDate))
                return false;
            else
                return true;
        }
        return false;
    }

    private boolean addSnsUser(SNSUser snsUser) {
        return this.listSnsUser.add(snsUser);
    }

    private boolean addUserToWaitingRoom(SNSUser snsUser) {
        return this.listUserToWaitingRoom.add(snsUser);
    }


    public List<SNSUser> getListUserToWaitingRoom() {
        return listUserToWaitingRoom;
    }

}
