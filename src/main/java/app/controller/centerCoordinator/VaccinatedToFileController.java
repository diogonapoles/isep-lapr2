package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class VaccinatedToFileController {
    private App oApp;
    private Company oCompany;

    public VaccinatedToFileController() {
        oApp = App.getInstance();
        oCompany = oApp.getCompany();
    }

    public List getListAdministratedVaccines() {
        return VaccinationCenter.getListAdministratedVaccines();
    }

    public boolean validateFileName(String fileName) {
        return oCompany.getVaccinatedToFile().validateFileName(fileName);
    }

    public void writeToFile(String fileName) throws Exception {
        oCompany.getVaccinatedToFile().writeToFile(fileName);
    }
}
