package app.domain.store;

import app.controller.ScheduleVaccineDTO;
import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;
import app.domain.systemUsers.SNSUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The type Schedule vaccine store.
 */
public class ScheduleVaccineStore {

    private final List<ScheduleVaccine> listScheduleVaccine = new ArrayList<>();

    /**
     * Instantiates a new Schedule vaccine store.
     */
    public ScheduleVaccineStore() {
    }

    /**
     * Gets list schedule vaccine.
     *
     * @return the list schedule vaccine
     */
    public List<ScheduleVaccine> getListScheduleVaccine() {
        return listScheduleVaccine;
    }

    /**
     * Gets schedule vaccine.
     *
     * @param snsUserNumber the sns user number
     * @param dateTime      the date time
     * @param vaccineType   the vaccine type
     * @return the schedule vaccine
     */
    public ScheduleVaccine getScheduleVaccine(String snsUserNumber, Date dateTime, VaccineType vaccineType) {
        ScheduleVaccine result = null, test;
        boolean flag = true;
        int row = 0;
        while (row < listScheduleVaccine.size() && flag) {
            test = listScheduleVaccine.get(row);
            if (Objects.equals(test.getSNSUserNumber(), snsUserNumber) && (test.getDateTime().equals(dateTime))
                    && test.getVaccineType().equals(vaccineType)) {
                result = test;
                flag = false;
            }
            row++;
        }
        return result;
    }


    /**
     * Validate schedule vaccine boolean.
     *
     * @param oScheduleVaccine the o schedule vaccine
     * @return the boolean
     */
    public boolean validateScheduleVaccine(ScheduleVaccine oScheduleVaccine) {
        if (oScheduleVaccine != null) {
            String snsUserNumber = oScheduleVaccine.getSNSUserNumber();
            VaccinationCenter vaccinationCenter = oScheduleVaccine.getVaccinationCenter();
            Date dateTime = oScheduleVaccine.getDateTime();

            if (existsScheduleVaccine(snsUserNumber, vaccinationCenter, dateTime))
                throw new IllegalArgumentException("A vaccine with those data already exists.");

        } else {
            return false;
        }
        return true;
    }

    /**
     * Validate schedule vaccine receptionist boolean.
     *
     * @param oScheduleVaccine the o schedule vaccine
     * @param user             the user
     * @param vaccine          the vaccine
     * @return the boolean
     */
    public boolean validateScheduleVaccineReceptionist(ScheduleVaccine oScheduleVaccine, SNSUser user, Vaccine vaccine) {
        if (oScheduleVaccine != null) {
            String snsUserNumber = user.getSnsUserNumber();
            VaccinationCenter vaccinationCenter = oScheduleVaccine.getVaccinationCenter();
            Date dateTime = oScheduleVaccine.getDateTime();

            if (existsScheduleVaccine(snsUserNumber, vaccinationCenter, dateTime))
                throw new IllegalArgumentException("A vaccine with those data already exists.");

            if (!verifyAgeAndTimeSinceLastDose(oScheduleVaccine, user, vaccine))
                throw new IllegalArgumentException("User does not belong to this vaccine age group.");

        } else {
            return false;
        }
        return true;
    }

    private boolean existsScheduleVaccine(String snsUserNumber, VaccinationCenter vaccinationCenter, Date dateTime) {
        for (ScheduleVaccine scheduleVaccine : listScheduleVaccine) {
            if (snsUserNumber.equals(scheduleVaccine.getSNSUserNumber()) &&
                    dateTime.equals(scheduleVaccine.getDateTime()) &&
                    vaccinationCenter.equals(scheduleVaccine.getVaccinationCenter())) {
                return true;
            }
        }
        return false;
    }

    /**
     * New schedule vaccine schedule vaccine.
     *
     * @param scheduleVaccineDTO the schedule vaccine dto
     * @return the schedule vaccine
     */
    public ScheduleVaccine newScheduleVaccine(ScheduleVaccineDTO scheduleVaccineDTO) {
        String snsUserNumber = scheduleVaccineDTO.getSnsUserNumber();
        VaccinationCenter vaccinationCenter = scheduleVaccineDTO.getVaccinationCenter();
        VaccineType vaccineType = scheduleVaccineDTO.getVaccineType();
        Date dateTime = scheduleVaccineDTO.getDateTime();

        ScheduleVaccine scheduleUserVaccine = new ScheduleVaccine(snsUserNumber, vaccinationCenter, vaccineType, dateTime);

        if (validateScheduleVaccine(scheduleUserVaccine))
            return scheduleUserVaccine;
        else
            return null;
    }

    /**
     * New schedule vaccine receptionist schedule vaccine.
     *
     * @param scheduleVaccineDTO the schedule vaccine dto
     * @param user               the user
     * @param vaccine            the vaccine
     * @return the schedule vaccine
     */
    public ScheduleVaccine newScheduleVaccineReceptionist(ScheduleVaccineDTO scheduleVaccineDTO, SNSUser user, Vaccine vaccine) {
        String snsUserNumber = scheduleVaccineDTO.getSnsUserNumber();
        VaccinationCenter vaccinationCenter = scheduleVaccineDTO.getVaccinationCenter();
        VaccineType vaccineType = scheduleVaccineDTO.getVaccineType();
        Date dateTime = scheduleVaccineDTO.getDateTime();

        ScheduleVaccine scheduleUserVaccine = new ScheduleVaccine(snsUserNumber, vaccinationCenter, vaccineType, dateTime);

        if (validateScheduleVaccineReceptionist(scheduleUserVaccine, user, vaccine))
            return scheduleUserVaccine;
        else
            return null;
    }

    /**
     * Register schedule vaccine boolean.
     *
     * @param oScheduleVaccine the o schedule vaccine
     * @return the boolean
     */
    public boolean registerScheduleVaccine(ScheduleVaccine oScheduleVaccine) {
        if (validateScheduleVaccine(oScheduleVaccine)) {
            addScheduleVaccine(oScheduleVaccine);
            return true;
        } else
            return false;
    }

    /**
     * Register schedule vaccine receptionist boolean.
     *
     * @param oScheduleVaccine the o schedule vaccine
     * @param user             the user
     * @param vaccine          the vaccine
     * @return the boolean
     */
    public boolean registerScheduleVaccineReceptionist(ScheduleVaccine oScheduleVaccine, SNSUser user, Vaccine vaccine) {
        if (validateScheduleVaccineReceptionist(oScheduleVaccine,  user,  vaccine)) {
            addScheduleVaccine(oScheduleVaccine);
            return true;
        } else
            return false;
    }

    private boolean addScheduleVaccine(ScheduleVaccine schedule) {
        return this.listScheduleVaccine.add(schedule);
    }


    /**
     * Verify age and time since last dose boolean.
     *
     * @param sv      the sv
     * @param user    the user
     * @param vaccine the vaccine
     * @return the boolean
     */
    public boolean verifyAgeAndTimeSinceLastDose(ScheduleVaccine sv, SNSUser user, Vaccine vaccine) {
        int userAge = user.getAge();

        if (Integer.parseInt(vaccine.getAgeGroup()) == userAge){
            return true;
        }
        return false;
    }
}


