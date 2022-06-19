package app.controller.administrator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;

import java.util.List;


/**
 * The type New vaccine controller.
 */
public class NewVaccineController {

    private App oApp;
    private Company oCompany;
    private Vaccine oNewVaccine;
    private VaccineType oVaccineType;
    private VaccinationCenter oVaccinationCenter;


    /**
     * Instantiates a new New vaccine controller.
     */
    public NewVaccineController() {
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
     * Sets vaccine type.
     *
     * @param vaccineType the vaccine type
     */
    public void setVaccineType(VaccineType vaccineType) {
        oVaccineType = vaccineType;
    }

    /**
     * New vaccine boolean.
     *
     * @param type              the type
     * @param name              the name
     * @param brand             the brand
     * @param ageGroup          the age group
     * @param doseNumber        the dose number
     * @param dosage            the dosage
     * @param timeSinceLastDose the time since last dose
     * @return the boolean
     */
    public boolean newVaccine(VaccineType type, String name, String brand, String ageGroup, int doseNumber, double dosage, int timeSinceLastDose ){
        this.oNewVaccine = oVaccineType.newVaccine(name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
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
    public boolean registerVaccine(){return this.oVaccineType.registerVaccine(oNewVaccine);}

    /**
     * Get vaccine types list.
     *
     * @return the list
     */
    public List<VaccineType> getVaccineTypes(){return this.oVaccinationCenter.getListVaccineType();}

    /**
     * Get vaccination centers list.
     *
     * @return the list
     */
    public List<VaccinationCenter> getVaccinationCenters(){return this.oCompany.getVaccinationCenterStore().getVaccinationCenters();}

}
