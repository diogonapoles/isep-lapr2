package app.controller;

import app.domain.model.CommunityCenter;
import app.domain.model.VaccinationCenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoosingVaccinationCenterControllerTest {

    @Test
    void getVaccinationCenters() {
        ChoosingVaccinationCenterController cvcc = new ChoosingVaccinationCenterController();
        VaccinationCenter vc = new CommunityCenter("Community", "917312756", "654253",
                "TesteRua2", "teste2@gmail.com", "community.com",
                "8", "22", "5", "40");

        assertFalse(cvcc.getVaccinationCenters().contains(vc));
    }


}