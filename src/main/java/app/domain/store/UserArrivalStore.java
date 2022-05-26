package app.domain.store;

import app.domain.systemUsers.SNSUser;

import java.util.ArrayList;
import java.util.List;

public class UserArrivalStore {

    private final List<SNSUser> listSnsUser = new ArrayList<>();

    private final List<SNSUser> listUserToWaitingRoom = new ArrayList<>();


    public SNSUser newUserArrival(String snsUserNumber) {

        if (validateUserSchedule(snsUserNumber))
            return new SNSUser(snsUserNumber);

        return null;
    }

    private boolean validateUserSchedule(String snsUserNumber) {
        for (SNSUser snsUser : listSnsUser) {
            if (snsUser.getSnsUserNumber().equals(snsUserNumber))
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
