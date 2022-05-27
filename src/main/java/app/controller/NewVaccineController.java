package app.controller;

import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

import java.util.List;


/**
 * The type New vaccine controller.
 */
public class NewVaccineController {

    private App oApp;
    private Company oCompany;
    private Vaccine oNewVaccine;


    /**
     * Instantiates a new New vaccine controller.
     */
    public NewVaccineController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * New vaccine boolean.
     *
     * @param name              the name
     * @param brand             the brand
     * @param ageGroup          the age group
     * @param doseNumber        the dose number
     * @param dosage            the dosage
     * @param timeSinceLastDose the time since last dose
     * @return the boolean
     */
    public boolean newVaccine(String name, String brand, String ageGroup, String doseNumber, double dosage, int timeSinceLastDose ){
        this.oNewVaccine = oCompany.getVaccineStore().newVaccine(name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
        if (this.oNewVaccine != null)
            return true;
        else
            return false;
    }


    /**
     * Get new vaccineto string string.
     *
     * @return the string
     */
    public String getNewVaccinetoString(){return this.oNewVaccine.toString();}

    /**
     * Register vaccine boolean.
     *
     * @return the boolean
     */
    public boolean registerVaccine(){return this.oCompany.getVaccineStore().registerVaccine(oNewVaccine);}

    public List<VaccineType> getVaccineTypes(){return this.oCompany.getVaccineTypeStore().getListVaccineType();}
}
