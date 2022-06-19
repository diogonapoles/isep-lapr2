package app.domain.model.vaccine;

import app.controller.App;
import app.domain.model.Company;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine type.
 */
public class VaccineType implements Serializable {
    private String code;
    private String designation;
    private List<Vaccine> listVaccine;

    private App oApp;
    private Company oCompany;

    /**
     * Instantiates a new Vaccine type.
     *
     * @param code        the code
     * @param designation the designation
     */
    public VaccineType(String code, String designation) {
        if ((code == null) || (code.isEmpty()) ||
                (designation == null) || (designation.isEmpty()) ||
                (code.length() != 5) || !StringUtils.isNumeric(code))
            throw new IllegalArgumentException("None of the arguments can be null or empty. Code must be 5 digits");

        this.code = code;
        this.designation = designation;
        this.listVaccine = new ArrayList<>();

    }

    /**
     * Instantiates a new Vaccine type.
     */
    public VaccineType() {
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets designation.
     *
     * @param designation the designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "VaccineType [" +
                "code: " + code +
                ", description: " + designation +
                "]";
    }


    /**
     * Validate vaccine boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean validateVaccine(String name) {
        for (Vaccine lv : listVaccine) {
            if (lv.getName().contains(name))
                return false;
        }
        return true;
    }

    /**
     * Register vaccine boolean.
     *
     * @param oVaccine the o vaccine
     * @return the boolean
     */
    public boolean registerVaccine(Vaccine oVaccine) {
        if (validateVaccine(oVaccine.getName()))
            return addVaccine(oVaccine);
        else
            return false;
    }


    /**
     * Add vaccine boolean.
     *
     * @param v the v
     * @return the boolean
     */
    public boolean addVaccine(Vaccine v) {
        return this.listVaccine.add(v);
    }

    /**
     * New vaccine vaccine.
     *
     * @param name              the name
     * @param brand             the brand
     * @param ageGroup          the age group
     * @param doseNumber        the dose number
     * @param dosage            the dosage
     * @param timeSinceLastDose the time since last dose
     * @return the vaccine
     */
    public Vaccine newVaccine(String name, String brand, String ageGroup, int doseNumber, double dosage, int timeSinceLastDose) {
        if (validateVaccine(name)) {
            return new Vaccine(name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
        }
        return null;
    }

    /**
     * Get list vaccines list.
     *
     * @return the list
     */
    public List<Vaccine> getListVaccines() {
        return listVaccine;
    }

}
