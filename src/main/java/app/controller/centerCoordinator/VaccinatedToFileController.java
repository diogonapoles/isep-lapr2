package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;

import java.util.List;

public class VaccinatedToFileController {
    private App oApp;
    private Company oCompany;

    public VaccinatedToFileController() {
        oApp = App.getInstance();
        oCompany = oApp.getCompany();
    }

    public List getListAdministratedVaccines() {
        return oCompany.getVaccinationCenterStore().getListAdministratedVaccines();
    }
}
