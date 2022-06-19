package app.controller.centerCoordinator;

import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccinatedToFileControllerTest {

    VaccinatedToFileController controller = new VaccinatedToFileController();


    @Test
    void getListAdministratedVaccines() {
        assertNull(VaccinationCenter.getListAdministratedVaccines());
    }

    @Test
    void validateFileName() {
        assertTrue(controller.validateFileName("tei.csv"));
        assertFalse(controller.validateFileName("tei.csv"));


    }

    @Test
    void writeToFile() throws Exception {
    }
}