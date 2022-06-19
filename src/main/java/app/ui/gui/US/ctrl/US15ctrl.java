package app.ui.gui.US.ctrl;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.ui.gui.roles.CenterCoordinatorUI;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The type Us 15 ctrl.
 */
public class US15ctrl {
    private App oApp;
    private Company oCompany;
    private VaccinationCenter vaccinationCenter = CenterCoordinatorUI.vaccinationCenter;

    /**
     * Instantiates a new Us 15 ctrl.
     */
    public US15ctrl() {
        oApp = App.getInstance();
        oCompany = oApp.getCompany();
    }

    /*public void getWorking(){
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
    }

     */

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