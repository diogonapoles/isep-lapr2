package app.controller;

import app.domain.model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;


class ScheduleVaccineReceptionistControllerTest {
    HealthcareCenter hc = new HealthcareCenter("Healthcare", "917876321", "493782",
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            "10", "20", "3", "20");

    mRNAVaccine vt1 = new mRNAVaccine("12345", "COVID-19");

    Vaccine v1 = new Vaccine(vt1, "Test", "Pfizer", "18","2", 15, 1);

    @Test
    void newScheduleVaccine() {
        ScheduleVaccineReceptionistControllerTest controller = new ScheduleVaccineReceptionistControllerTest();
        Date dateTime = new Date(2022,10,12,14,7);
        ScheduleVaccineDTO dto = new ScheduleVaccineDTO("123444333", hc, vt1, dateTime);

        controller.newScheduleVaccine(dto, v1);
    }

    @Test
    void getScheduleVaccineString() {
    }

    @Test
    void getVaccinationCenter() {
    }

    @Test
    void getVaccineTypes() {
    }

    @Test
    void getVaccines() {
    }

    @Test
    void registerScheduleVaccine() {
    }

    @Test
    void getScheduleVaccine() {
    }

    @Test
    void getWorking() {
    }

    @Test
    void validateDate() {
    }
}