package app.controller;

import app.domain.model.ToxoidVaccine;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewVaccineTypeControllerTest {

    @org.junit.Test
    public void newVaccineType() {
        NewVaccineTypeController nvtc = new NewVaccineTypeController();

        boolean result1 = nvtc.newVaccineType(2, "55563", "test");
        boolean result2 = nvtc.newVaccineType(10, "55563", "test");

        assertEquals(true, result1);
        assertEquals(false, result2);
    }


    @org.junit.Test
    public void getVaccineTypeString() {
        NewVaccineTypeController nvtc = new NewVaccineTypeController();
        ToxoidVaccine vt = new ToxoidVaccine("78984", "unit test");

        nvtc.newVaccineType(3,"78984", "unit test");
        nvtc.registerVaccineType();

        String expected = vt.toString();
        String result = nvtc.getVaccineTypeString();

        assertEquals(expected, result);
    }

    @org.junit.Test
    public void registerVaccineType() {
        NewVaccineTypeController nvtc = new NewVaccineTypeController();

        boolean result = nvtc.newVaccineType(2, "55563", "test");
        assertEquals(true, result);
    }
}