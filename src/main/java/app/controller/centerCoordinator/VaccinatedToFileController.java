package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;


import java.util.List;

/**
 * The type Vaccinated to file controller.
 */
public class VaccinatedToFileController {
    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter;

    /**
     * Instantiates a new Vaccinated to file controller.
     */
    public VaccinatedToFileController() {
        oApp = App.getInstance();
        oCompany = oApp.getCompany();
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
    }

    /**
     * Gets list administrated vaccines.
     *
     * @return the list administrated vaccines
     */
    public List<VaccineAdministration> getListAdministratedVaccines() {
        return vaccinationCenter.getListAdministratedVaccines();
    }

    /**
     * Validate file name boolean.
     *
     * @param fileName the file name
     * @return the boolean
     */
    public boolean validateFileName(String fileName) {
        return oCompany.getVaccinatedToFile().validateFileName(fileName);
    }

    /**
     * Write to file.
     *
     * @param fileName                  the file name
     * @param listAdministratedVaccines the list administrated vaccines
     * @throws Exception the exception
     */
    public void writeToFile(String fileName, List<VaccineAdministration> listAdministratedVaccines) throws Exception {
        oCompany.getVaccinatedToFile().writeToFile(fileName, listAdministratedVaccines);
    }
}
