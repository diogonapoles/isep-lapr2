package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccineType;

import java.util.List;


/**
 * The type New vaccine type controller.
 */
public class NewVaccineTypeController {
    private App oApp;
    private Company oCompany;
    private VaccineType oVaccineType;

    /**
     * Instantiates a new New vaccine type controller.
     */
    public NewVaccineTypeController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
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
        this.oVaccineType = oCompany.getVaccineTypeStore().newVaccineType(techSelection, code, designation);
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
    public List<String> getVaccineTechnologyTypes(){return this.oCompany.getVaccineTypeStore().getVaccineTechnologyTypes();}

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
    public boolean registerVaccineType(){return this.oCompany.getVaccineTypeStore().registerVaccineType(oVaccineType);}
}
