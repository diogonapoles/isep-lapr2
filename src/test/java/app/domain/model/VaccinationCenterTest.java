package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class VaccinationCenterTest {

    HealthcareCenter hc = new HealthcareCenter("Healthcare", "917876321", "493782",
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            "10", "20", "3", "20");
    CommunityCenter cc = new CommunityCenter("Community", "917312756", "654253",
            "TesteRua2", "teste2@gmail.com", "community.com",
            "8", "22", "5", "40");

    @Test
    public void getName() {
        assertEquals("Healthcare", hc.getName());
        assertEquals("Community", cc.getName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("917876321", hc.getPhoneNumber());
        assertEquals("917312756", cc.getPhoneNumber());
    }

    @Test
    public void getFaxNumber() {
        assertEquals("493782", hc.getFaxNumber());
        assertEquals("654253", cc.getFaxNumber());
    }

    @Test
    public void getHomeAddress() {
        assertEquals("TesteRua1", hc.getHomeAddress());
        assertEquals("TesteRua2", cc.getHomeAddress());
    }

    @Test
    public void getEmailAddress() {
        assertEquals("teste1@gmail.com", hc.getEmailAddress());
        assertEquals("teste2@gmail.com", cc.getEmailAddress());
    }

    @Test
    public void getWebsiteAddress() {
        assertEquals("healthcare.com", hc.getWebsiteAddress());
        assertEquals("community.com", cc.getWebsiteAddress());
    }

    @Test
    public void getOpeningHours() {
        assertEquals("10", hc.getOpeningHours());
        assertEquals("8", cc.getOpeningHours());
    }

    @Test
    public void getClosingHours() {
        assertEquals("20", hc.getClosingHours());
        assertEquals("22", cc.getClosingHours());
    }

    @Test
    public void getSlotDuration() {
        assertEquals("3", hc.getSlotDuration());
        assertEquals("5", cc.getSlotDuration());
    }

    @Test
    public void getMaxNumVaccinesPerSlot() {
        assertEquals("20", hc.getMaxNumVaccinesPerSlot());
        assertEquals("40", cc.getMaxNumVaccinesPerSlot());
    }

    @Test
    public void testToString() {
        assertEquals("RegisterVaccinationCenter [" +
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
        assertEquals("RegisterVaccinationCenter [" +
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
}