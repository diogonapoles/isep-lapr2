package app.domain.store;

import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccineType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScheduleVaccineStore {

    private final List<ScheduleVaccine> listScheduleVaccine = new ArrayList<>();

    public ScheduleVaccineStore() {
    }

    public List<ScheduleVaccine> getListScheduleVaccine() {
        return listScheduleVaccine;
    }

    public ScheduleVaccine getScheduleVaccine(String snsUserNumber, LocalDate date, VaccineType vaccineType) {
        ScheduleVaccine result = null, test;
        boolean flag = true;
        int row = 0;
        while (row < listScheduleVaccine.size() && flag) {
            test = listScheduleVaccine.get(row);
            if (Objects.equals(test.getSNSUserNumber(), snsUserNumber) && test.getLocalDateTime().toLocalDate().compareTo(date) == 0
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
            LocalDateTime localDateTime = oScheduleVaccine.getLocalDateTime();

            if (existsScheduleVaccine(snsUserNumber, vaccinationCenter, localDateTime))
                throw new IllegalArgumentException("A vaccine with those data already exists.");
        } else {
            return false;
        }
        return true;
    }

    private boolean existsScheduleVaccine(String snsUserNumber, VaccinationCenter vaccinationCenter, LocalDateTime localDateTime) {
        for (ScheduleVaccine scheduleVaccine : listScheduleVaccine) {
            if (snsUserNumber.equals(scheduleVaccine.getSNSUserNumber()) &&
                    localDateTime.equals(scheduleVaccine.getLocalDateTime()) &&
                    vaccinationCenter.equals(scheduleVaccine.getVaccinationCenter())) {
                return true;
            }
        }
        return false;
    }

    public ScheduleVaccine newScheduleVaccine(ScheduleVaccine scheduleVaccine){
        String snsUserNumber = scheduleVaccine.getSNSUserNumber();
        VaccinationCenter vaccinationCenter = scheduleVaccine.getVaccinationCenter();
        VaccineType vaccineType = scheduleVaccine.getVaccineType();
        LocalDateTime localDateTime = scheduleVaccine.getLocalDateTime();

        ScheduleVaccine scheduleUserVaccine = new ScheduleVaccine(snsUserNumber,vaccinationCenter,vaccineType,localDateTime);

        if (validateScheduleVaccine(scheduleUserVaccine))
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
    private boolean addScheduleVaccine(ScheduleVaccine schedule) {
        return this.listScheduleVaccine.add(schedule);
    }


}


