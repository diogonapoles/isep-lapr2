package app.domain.store;


import app.domain.model.ScheduleVaccine;
import app.domain.model.UserArrival;
import app.domain.model.VaccinationCenter;
import app.domain.systemUsers.SNSUser;


import java.util.ArrayList;
import java.util.List;

public class UserArrivalStore {

    private final List<UserArrival> listUserToWaitingRoom = new ArrayList<>();

    private final ScheduleVaccineStore scheduleVaccineStore;

    public UserArrivalStore(ScheduleVaccineStore scheduleVaccineStore) {
        this.scheduleVaccineStore = scheduleVaccineStore;

    }

    public UserArrival newUserArrival(SNSUser snsUser, String snsUserNumber, VaccinationCenter vc) {

        if (validateUserSchedule(snsUser))
            return new UserArrival(snsUser, vc);

        return null;
    }


    private boolean validateUserSchedule(SNSUser snsUser) {
        for (ScheduleVaccine sv : scheduleVaccineStore.getListScheduleVaccine()) {
            if (sv.getSNSUserNumber().equals(snsUser.getSnsUserNumber()))
                if (listUserToWaitingRoom.isEmpty())
                    return true;
                else
                    for (UserArrival userArrival : listUserToWaitingRoom)
                        if (!userArrival.getSnsUser().equals(snsUser))
                            return true;
        }
        return false;
    }


    public boolean registerUserArrival(UserArrival userArrival) {
        return addUserToWaitingRoom(userArrival);
    }

    private boolean addUserToWaitingRoom(UserArrival userArrival) {
        return this.listUserToWaitingRoom.add(userArrival);
    }


    public List<SNSUser> getListUserToWaitingRoom(VaccinationCenter vaccinationCenter) {
        List<SNSUser> list = new ArrayList<>();
        for(UserArrival userArrival : listUserToWaitingRoom){
            if (userArrival.getVaccinationCenter().equals(vaccinationCenter))
                list.add(userArrival.getSnsUser());
        }
        return list;
    }


}
