package app.controller;

import app.domain.model.CommunityCenter;
import app.domain.model.HealthcareCenter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class RegisterVaccinationCenterControllerTest {
    HealthcareCenter hc = new HealthcareCenter("Healthcare", "917876321", "493782",
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            "10", "20", "3", "20");
    CommunityCenter cc = new CommunityCenter("Community", "917312756", "654253",
            "TesteRua2", "teste2@gmail.com", "community.com",
            "8", "22", "5", "40");

    @Test
    public void newVaccinationCenter() {
        RegisterVaccinationCenterController rvcc = new RegisterVaccinationCenterController();

        boolean result1 = rvcc.newVaccinationCenter(0, "Healthcare", "917876321", "493782",
                "TesteRua1", "teste1@gmail.com", "healthcare.com",
                "10", "20", "3", "20");
        boolean result2 = rvcc.newVaccinationCenter(1, "Community", "917312756", "654253",
                "TesteRua2", "teste2@gmail.com", "community.com",
                "8", "22", "5", "40");

        assertEquals(true, result1);
        assertEquals(true, result2);
    }

    @Test
    public void getVaccinationCenterTypes() {
        RegisterVaccinationCenterController rvcc = new RegisterVaccinationCenterController();

        List<String> VaccinationCenterTypes = new ArrayList<>();
        VaccinationCenterTypes.add("HealthCareCenter");
        VaccinationCenterTypes.add("Community Mass Vaccination Center");

        assertLinesMatch(rvcc.getVaccinationCenterTypes(), VaccinationCenterTypes);
    }

    @Test
    public void getVaccinationCenterString() {
        Assert.assertEquals("RegisterVaccinationCenter [" +
                "name: " + "Healthcare" +
                ", phoneNumber: " + "917876321" +
                ", faxNumber: " + "493782" +
                ", homeAddress: " + "TesteRua1" +
                ", emailAddress: " + "teste1@gmail.com" +
                ", websiteAddress: " + "healthcare.com" +
                ", openingHours: " + "10" +
                ", closingHours: " + "20" +
                ", slotDuration: " + "3" +
                ", maxNumVaccinesPerSlot: " + "20" +
                "]", hc.toString());
        Assert.assertEquals("RegisterVaccinationCenter [" +
                "name: " + "Community" +
                ", phoneNumber: " + "917312756" +
                ", faxNumber: " + "654253" +
                ", homeAddress: " + "TesteRua2" +
                ", emailAddress: " + "teste2@gmail.com" +
                ", websiteAddress: " + "community.com" +
                ", openingHours: " + "8" +
                ", closingHours: " + "22" +
                ", slotDuration: " + "5" +
                ", maxNumVaccinesPerSlot: " + "40" +
                "]", cc.toString());
    }

    @Test
    public void registerVaccinationCenter() {
        RegisterVaccinationCenterController rvcc = new RegisterVaccinationCenterController();

        boolean result1 = rvcc.newVaccinationCenter(0, "Healthcare", "917876321", "493782",
                "TesteRua1", "teste1@gmail.com", "healthcare.com",
                "10", "20", "3", "20");
        boolean result2 = rvcc.newVaccinationCenter(1, "Community", "917312756", "654253",
                "TesteRua2", "teste2@gmail.com", "community.com",
                "8", "22", "5", "40");

        assertEquals(true, result1);
        assertEquals(true, result2);
    }
}