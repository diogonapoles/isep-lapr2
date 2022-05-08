package app.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VaccineTest {

    Vaccine v1 = new Vaccine("vaccine1", "brand1", "1-10", "M54A", 10, 50);

    @Test
    void getName() {
        assertEquals("vaccine1", v1.getName());
    }

    @Test
    void setName() {
        v1.setName("vaccine1");
        assertEquals(v1.getName(), "vaccine1");
    }

    @Test
    void getBrand() {
        assertEquals("brand1", v1.getBrand());
    }

    @Test
    void setBrand() {
        v1.setBrand("brand1");
        assertEquals(v1.getBrand(), "brand1");
    }

    @Test
    void getAgeGroup() {
        assertEquals("1-10", v1.getAgeGroup());
    }

    @Test
    void setAgeGroup() {
        v1.setAgeGroup("1-10");
        assertEquals(v1.getAgeGroup(), "1-10");
    }

    @Test
    void getDoseNumber() {
        assertEquals("M54A", v1.getDoseNumber());
    }

    @Test
    void setDoseNumber() {
        v1.setDoseNumber("M54A");
        assertEquals(v1.getDoseNumber(), "M54A");
    }

    @Test
    void getDosage() {
        assertEquals(10.2, v1.getDosage(), 0);
    }

    @Test
    void setDosage() {
        v1.setDosage(10);
        assertEquals(v1.getDosage(), 10);
    }

    @Test
    void getTimeSinceLastDose() {
        assertEquals(50, v1.getTimeSinceLastDose());
    }

    @Test
    void setTimeSinceLastDose() {
        v1.setTimeSinceLastDose(50);
        assertEquals(v1.getTimeSinceLastDose(), 50);
    }

    @Test
    void testToString() {
        assertEquals("Vaccine [name = vaccine1, Brand = brand1, Age Group = 1-10, Dose Number = M54A, Dosage = 10.2, Time Since Last Dose = 50]", v1.toString());
    }
}