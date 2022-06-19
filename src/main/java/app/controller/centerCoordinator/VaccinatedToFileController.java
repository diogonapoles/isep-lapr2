package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;


import java.util.List;

public class VaccinatedToFileController {
    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;

    public VaccinatedToFileController() {
        oApp = App.getInstance();
        oCompany = oApp.getCompany();
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
    }

    public List<VaccineAdministration> getListAdministratedVaccines() {
        return vaccinationCenter.getListAdministratedVaccines();
    }

    public boolean validateFileName(String fileName) {
        return oCompany.getVaccinatedToFile().validateFileName(fileName);
    }

    public void writeToFile(String fileName, List<VaccineAdministration> listAdministratedVaccines) throws Exception {
        oCompany.getVaccinatedToFile().writeToFile(fileName, listAdministratedVaccines);
    }
}
