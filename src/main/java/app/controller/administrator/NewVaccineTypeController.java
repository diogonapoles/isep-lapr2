package app.controller.administrator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.VaccineType;

import java.util.List;


/**
 * The type New vaccine type controller.
 */
public class NewVaccineTypeController {
    private App oApp;
    private Company oCompany;
    private VaccineType oVaccineType;
    private VaccinationCenter oVaccinationCenter;

    /**
     * Instantiates a new New vaccine type controller.
     */
    public NewVaccineTypeController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * Sets working.
     *
     * @param vaccinationCenter the vaccination center
     */
    public void setWorking(VaccinationCenter vaccinationCenter) {
        oVaccinationCenter = vaccinationCenter;
    }


    /**
     * New vaccine type boolean.
     *
     * @param techSelection the tech selection
     * @param code          the code
     * @param designation   the designation
     * @return the boolean
     */
    public boolean newVaccineType(int techSelection, String code, String designation){
        this.oVaccineType = oVaccinationCenter.newVaccineType(techSelection, code, designation);
        if (this.oVaccineType != null)
            return true;
        else
            return false;
    }

    /**
     * Get vaccine technology types list.
     *
     * @return the list
     */
    public List<String> getVaccineTechnologyTypes(){return this.oVaccinationCenter.getVaccineTechnologyTypes();}

    /**
     * Get vaccine type string string.
     *
     * @return the string
     */
    public String getVaccineTypeString(){return this.oVaccineType.toString();}

    /**
     * Register vaccine type boolean.
     *
     * @return the boolean
     */
    public boolean registerVaccineType(){return this.oVaccinationCenter.registerVaccineType(oVaccineType);}

    /**
     * Get vaccination centers list.
     *
     * @return the list
     */
    public List<VaccinationCenter> getVaccinationCenters(){return this.oCompany.getVaccinationCenterStore().getVaccinationCenters();}

}
