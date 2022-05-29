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

public class ScheduleVaccineStore {

    private final List<ScheduleVaccine> listScheduleVaccine = new ArrayList<>();

    public ScheduleVaccineStore() {
    }

    public List<ScheduleVaccine> getListScheduleVaccine() {
        return listScheduleVaccine;
    }

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

    public boolean registerScheduleVaccine(ScheduleVaccine oScheduleVaccine) {
        if (validateScheduleVaccine(oScheduleVaccine)) {
            addScheduleVaccine(oScheduleVaccine);
            return true;
        } else
            return false;
    }

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


    public boolean verifyAgeAndTimeSinceLastDose(ScheduleVaccine sv, SNSUser user, Vaccine vaccine) {
        int userAge = user.getAge();

        if (Integer.parseInt(vaccine.getAgeGroup()) == userAge){
            return true;
        }
        return false;
    }
}


