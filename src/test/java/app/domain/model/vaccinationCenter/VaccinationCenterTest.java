package app.domain.model.vaccinationCenter;

import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterTest {

    HealthcareCenter hc = new HealthcareCenter("Healthcare", 917876321, 493782,
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            10, 20, 3,20);
    CommunityCenter cc = new CommunityCenter("Community", 917312756, 654253,
            "TesteRua2", "teste2@gmail.com", "community.com",
            8, 22, 5, 40);


    @Test
    public void getName() {
        assertEquals("Healthcare", hc.getName());
        assertEquals("Community", cc.getName());
    }

    @Test
    public void setName() {
        hc.setName("Healthcare");
        cc.setName("Community");
        assertEquals(hc.getName(), "Healthcare");
        assertEquals(cc.getName(), "Community");
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(917876321, hc.getPhoneNumber());
        assertEquals(917312756, cc.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        hc.setPhoneNumber(917876321);
        cc.setPhoneNumber(917312756);
        assertEquals(hc.getPhoneNumber(), 917876321);
        assertEquals(cc.getPhoneNumber(), 917312756);
    }

    @Test
    public void getFaxNumber() {
        assertEquals(493782, hc.getFaxNumber());
        assertEquals(654253, cc.getFaxNumber());
    }

    @Test
    public void setFaxNumber() {
        hc.setFaxNumber(493782);
        cc.setFaxNumber(654253);
        assertEquals(hc.getFaxNumber(), 493782);
        assertEquals(cc.getFaxNumber(), 654253);
    }

    @Test
    public void getHomeAddress() {
        assertEquals("TesteRua1", hc.getHomeAddress());
        assertEquals("TesteRua2", cc.getHomeAddress());
    }

    @Test
    public void setHomeAddress() {
        hc.setHomeAddress("TesteRua1");
        cc.setHomeAddress("TesteRua2");
        assertEquals(hc.getHomeAddress(), "TesteRua1");
        assertEquals(cc.getHomeAddress(), "TesteRua2");
    }

    @Test
    public void getEmailAddress() {
        assertEquals("teste1@gmail.com", hc.getEmailAddress());
        assertEquals("teste2@gmail.com", cc.getEmailAddress());
    }

    @Test
    public void setEmailAddress() {
        hc.setEmailAddress("teste1@gmail.com");
        cc.setEmailAddress("teste2@gmail.com");
        assertEquals(hc.getEmailAddress(), "teste1@gmail.com");
        assertEquals(cc.getEmailAddress(), "teste2@gmail.com");
    }

    @Test
    public void getWebsiteAddress() {
        assertEquals("healthcare.com", hc.getWebsiteAddress());
        assertEquals("community.com", cc.getWebsiteAddress());
    }

    @Test
    public void setWebsiteAddress() {
        hc.setWebsiteAddress("healthcare.com");
        cc.setWebsiteAddress("community.com");
        assertEquals(hc.getWebsiteAddress(), "healthcare.com");
        assertEquals(cc.getWebsiteAddress(), "community.com");
    }

    @Test
    public void getOpeningHours() {
        assertEquals(10, hc.getOpeningHours());
        assertEquals(8, cc.getOpeningHours());
    }

    @Test
    public void setOpeningHours() {
        hc.setOpeningHours(10);
        cc.setOpeningHours(8);
        assertEquals(hc.getOpeningHours(), 10);
        assertEquals(cc.getOpeningHours(), 8);
    }

    @Test
    public void getClosingHours() {
        assertEquals(20, hc.getClosingHours());
        assertEquals(22, cc.getClosingHours());
    }

    @Test
    public void setClosingHours() {
        hc.setClosingHours(20);
        cc.setClosingHours(22);
        assertEquals(hc.getClosingHours(), 20);
        assertEquals(cc.getClosingHours(), 22);
    }

    @Test
    public void getSlotDuration() {
        assertEquals(3, hc.getSlotDuration());
        assertEquals(5, cc.getSlotDuration());
    }

    @Test
    public void setSlotDuration() {
        hc.setSlotDuration(3);
        cc.setSlotDuration(5);
        assertEquals(hc.getSlotDuration(), 3);
        assertEquals(cc.getSlotDuration(), 5);
    }

    @Test
    public void getMaxNumVaccinesPerSlot() {
        assertEquals(20, hc.getMaxNumVaccinesPerSlot());
        assertEquals(40, cc.getMaxNumVaccinesPerSlot());
    }

    @Test
    public void setMaxNumVaccinesPerSlot() {
        hc.setMaxNumVaccinesPerSlot(20);
        cc.setMaxNumVaccinesPerSlot(40);
        assertEquals(hc.getMaxNumVaccinesPerSlot(), 20);
        assertEquals(cc.getMaxNumVaccinesPerSlot(), 40);
    }

    @Test
    public void testToString() {
        assertEquals("\n" +
                "name: Healthcare\n" +
                "phoneNumber: 917876321\n" +
                "faxNumber: 493782\n" +
                "homeAddress: TesteRua1\n" +
                "emailAddress: teste1@gmail.com\n" +
                "websiteAddress: healthcare.com\n" +
                "openingHours: 10\n" +
                "closingHours: 20\n" +
                "slotDuration: 3\n" +
                "maxNumVaccinesPerSlot: 20\n" +
                "\n", hc.toString());
        assertEquals("\n" +
                "name: Community\n" +
                "phoneNumber: 917312756\n" +
                "faxNumber: 654253\n" +
                "homeAddress: TesteRua2\n" +
                "emailAddress: teste2@gmail.com\n" +
                "websiteAddress: community.com\n" +
                "openingHours: 8\n" +
                "closingHours: 22\n" +
                "slotDuration: 5\n" +
                "maxNumVaccinesPerSlot: 40\n" +
                "\n", cc.toString());
    }

    @Test
    void toStringScheduleVaccine() {
    String expected = "\nname: " + "Healthcare" +
            "\nphoneNumber: " + 917876321 +
            "\nhomeAddress: " + "TesteRua1" +
            "\nemailAddress: " + "teste1@gmail.com" +
            "\nwebsiteAddress: " + "healthcare.com" +
            "\n\n";

    assertEquals(expected, hc.toStringScheduleVaccine());
    }

    @Test
    void getVaccineTechnologyTypes() {
        List<String> expected = new ArrayList<>();
        expected.add("Live-Attenuated Vaccine");
        expected.add("Inactivated Vaccine");
        expected.add("Subunit Vaccine");
        expected.add("Toxoid Vaccine");
        expected.add("Viral Vector Vaccine");
        expected.add("Messenger RNA (mRNA) Vaccine");

        assertEquals(expected, hc.getVaccineTechnologyTypes());
    }

    @Test
    void validateVaccineType() {
        VaccineType vt1 = hc.newVaccineType(0, "12345", "COVID-19");
        hc.registerVaccineType(vt1);
        String codeFalse = "12345";
        String codeTrue = "58712";

        assertFalse(hc.validateVaccineType(codeFalse));
        assertTrue(hc.validateVaccineType(codeTrue));
    }

    @Test
    void registerVaccineType() {
        VaccineType vt1 = hc.newVaccineType(0, "12345", "COVID-19");

        assertTrue(hc.registerVaccineType(vt1));
        assertFalse(hc.registerVaccineType(vt1));
    }

    @Test
    void addVaccineType() {
        VaccineType vt1 = hc.newVaccineType(0, "12345", "COVID-19");

        assertTrue(hc.addVaccineType(vt1));
    }

    @Test
    void getListVaccineType() {
    }

    @Test
    void getAvailableSlots() {
    }

    @Test
    void createVaccineSchedule() {
    }

    @Test
    void addVaccineSchedule() {
    }

    @Test
    void findSlot() {
    }

    @Test
    void returnSlot() {
    }

    @Test
    void newVaccinationDay() {
    }

    @Test
    void validateVaccineSchedule() {
    }

    @Test
    void findVaccineType() {
    }

    @Test
    void validateAgeGroup() {
    }

    @Test
    void validateTimeSinceLastDose() {
    }

    @Test
    void vaccineAge() {
    }

    @Test
    void tookVaccine() {
    }

    @Test
    void newUserArrival() {
    }

    @Test
    void registerUserArrival() {
    }

    @Test
    void addUserToUserArrivalList() {
    }

    @Test
    void getListUserToWaitingRoom() {
    }

    @Test
    void getRecoveryRoom() {
    }

    @Test
    void createVaccineAdministration() {
    }

    @Test
    void addVaccineAdministration() {
    }

    @Test
    void moveToWaitingRoom() {
    }

    @Test
    void removeFromWaitingRoom() {
    }

    @Test
    void moveToRecoveryRoom() {
    }

    @Test
    void removeFromRecoveryRoom() {
    }

    @Test
    void validateAdministratedVaccines() {
    }

    @Test
    void getWaitingRoom() {
    }

    @Test
    void scheduleForUser() {
    }

    @Test
    void scheduleForUserWithoutVaccineType() {
    }

    @Test
    void arrivalForUser() {
    }

    @Test
    void administrationsForUser() {
    }

    @Test
    void administrationsForUserVaccine() {
    }

    @Test
    void validateVaccineAdministration() {
    }

    @Test
    void getListAdministratedVaccines() {
    }

    @Test
    void validateOngoingVaccine() {
    }

    @Test
    void validateTimeIntervalForVaccinationCenter() {
    }

    @Test
    void findDivisors() {
    }

    @Test
    void validateAnalyzePerformanceTime() {
    }

    @Test
    void analyzePerformanceTime() {
    }
}