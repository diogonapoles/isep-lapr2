package app.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VaccineTest {

    Vaccine v1 = new Vaccine("vaccine1", "brand1", "1-10", "M54A", 10.2, 50);

    @Test
    void getName() {
        assertEquals("vaccine1", v1.getName());
    }

    @Test
    void getBrand() {
        assertEquals("brand1", v1.getBrand());
    }

    @Test
    void getAgeGroup() {
        assertEquals("1-10", v1.getAgeGroup());
    }

    @Test
    void getDoseNumber() {
        assertEquals("M54A", v1.getDoseNumber());
    }

    @Test
    void getDosage() {
        assertEquals(10.2, v1.getDosage(), 0);
    }

    @Test
    void getTimeSinceLastDose() {
        assertEquals(50, v1.getTimeSinceLastDose());
    }

    @Test
    void testToString() {
        assertEquals("Vaccine [name = vaccine1, Brand = brand1, Age Group = 1-10, Dose Number = M54A, Dosage = 10.2, Time Since Last Dose = 50]", v1.toString());
    }
}