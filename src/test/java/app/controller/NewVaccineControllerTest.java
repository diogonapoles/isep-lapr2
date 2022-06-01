/*package app.controller;

import app.domain.model.vaccine.ToxoidVaccine;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import app.domain.store.VaccineTypeStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewVaccineControllerTest {

    @Test
    void newVaccine() {
        NewVaccineController nvc = new NewVaccineController();

        boolean result1 = nvc.newVaccine("vaccine1", "brand1", "1-10", "M54A", 10.2, 50);
        boolean result2 = nvc.newVaccine("vaccine2", "brand2", "2-20", "LALA", 25, 100);

        assertEquals(true, result1);
        assertEquals(false, result2);
    }

    @Test
    void getNewVaccinetoString() {
        NewVaccineController nvc = new NewVaccineController();
        Vaccine lv = new Vaccine("vaccine1", "brand1", "1-10", "M54A", 10.2, 50);

        nvc.newVaccine("vaccine1", "brand1", "1-10", "M54A", 10.2, 50);
        nvc.registerVaccine();

        String expected = lv.toString();
        String result = nvc.getNewVaccinetoString();

        assertEquals(expected, result);
    }

    @Test
    void registerVaccine() {
        NewVaccineController nvc = new NewVaccineController();

        boolean result = nvc.newVaccine("vaccine1", "brand1", "1-10", "M54A", 10.2, 50);
        assertEquals(true, result);
    }
}*/