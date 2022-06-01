package app.controller;

import app.controller.administrator.NewVaccineTypeController;
import app.domain.model.vaccine.ToxoidVaccine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class NewVaccineTypeControllerTest {

    @org.junit.Test
    public void newVaccineType() {
        NewVaccineTypeController nvtc = new NewVaccineTypeController();

        boolean result1 = nvtc.newVaccineType(2, "55563", "test");
        boolean result2 = nvtc.newVaccineType(10, "55563", "test");

        assertEquals(true, result1);
        assertEquals(false, result2);
    }

    @Test
    public void getVaccineTechnologyTypes(){
        NewVaccineTypeController nvtc = new NewVaccineTypeController();

        List<String> Technology = new ArrayList<>();
        Technology.add("Live-Attenuated Vaccine");
        Technology.add("Inactivated Vaccine");
        Technology.add("Subunit Vaccine");
        Technology.add("Toxoid Vaccine");
        Technology.add("Viral Vector Vaccine");
        Technology.add("Messenger RNA (mRNA) Vaccine");

        assertLinesMatch(nvtc.getVaccineTechnologyTypes(), Technology);
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