package app.domain.store;


import app.domain.model.vaccinationProcess.ScheduleVaccine;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.systemUser.SNSUser;


import java.util.ArrayList;
import java.util.List;

/**
 * The type User arrival store.
 */
public class UserArrivalStore {

    private final List<UserArrival> listUserToWaitingRoom = new ArrayList<>();

    private final ScheduleVaccineStore scheduleVaccineStore;

    /**
     * Instantiates a new User arrival store.
     *
     * @param scheduleVaccineStore the schedule vaccine store
     */
    public UserArrivalStore(ScheduleVaccineStore scheduleVaccineStore) {
        this.scheduleVaccineStore = scheduleVaccineStore;

    }

    /**
     * New user arrival user arrival.
     *
     * @param snsUser       the sns user
     * @param snsUserNumber the sns user number
     * @param vc            the vc
     * @return the user arrival
     */
    public UserArrival newUserArrival(SNSUser snsUser, String snsUserNumber, VaccinationCenter vc) {

        if (validateUserSchedule(snsUser))
            return new UserArrival(snsUser, vc);

        return null;
    }


    private boolean validateUserSchedule(SNSUser snsUser) {
        try {
            for (ScheduleVaccine sv : scheduleVaccineStore.getListScheduleVaccine()) {
                if (sv.getSNSUserNumber().equals(snsUser.getSnsUserNumber()))
                    if (listUserToWaitingRoom.isEmpty())
                        return true;
                    else
                        for (UserArrival userArrival : listUserToWaitingRoom)
                            if (!userArrival.getSnsUser().equals(snsUser))
                                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }


    /**
     * Register user arrival boolean.
     *
     * @param userArrival the user arrival
     * @return the boolean
     */
    public boolean registerUserArrival(UserArrival userArrival) {
        return addUserToWaitingRoom(userArrival);
    }

    private boolean addUserToWaitingRoom(UserArrival userArrival) {
        return this.listUserToWaitingRoom.add(userArrival);
    }


    /**
     * Gets list user to waiting room.
     *
     * @param vaccinationCenter the vaccination center
     * @return the list user to waiting room
     */
    public List<SNSUser> getListUserToWaitingRoom(VaccinationCenter vaccinationCenter) {
        List<SNSUser> list = new ArrayList<>();
        for(UserArrival userArrival : listUserToWaitingRoom){
            if (userArrival.getVaccinationCenter().equals(vaccinationCenter))
                list.add(userArrival.getSnsUser());
        }
        return list;
    }


}
