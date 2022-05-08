package app.domain.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The type Vaccine.
 */
public class Vaccine {

    private String name;
    private String brand;
    private String ageGroup;
    private String doseNumber;
    private double dosage;
    private  int timeSinceLastDose;


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets age group.
     *
     * @return the age group
     */
    public String getAgeGroup() {
        return ageGroup;
    }

    /**
     * Sets age group.
     *
     * @param ageGroup the age group
     */
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    /**
     * Gets dose number.
     *
     * @return the dose number
     */
    public String getDoseNumber() {
        return doseNumber;
    }

    /**
     * Sets dose number.
     *
     * @param doseNumber the dose number
     */
    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    /**
     * Gets dosage.
     *
     * @return the dosage
     */
    public double getDosage() {
        return dosage;
    }

    /**
     * Sets dosage.
     *
     * @param dosage the dosage
     */
    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    /**
     * Gets time since last dose.
     *
     * @return the time since last dose
     */
    public int getTimeSinceLastDose() {
        return timeSinceLastDose;
    }

    /**
     * Sets time since last dose.
     *
     * @param timeSinceLastDose the time since last dose
     */
    public void setTimeSinceLastDose(int timeSinceLastDose) {
        this.timeSinceLastDose = timeSinceLastDose;
    }

    /**
     * Instantiates a new Vaccine.
     *
     * @param name              the name
     * @param brand             the brand
     * @param ageGroup          the age group
     * @param doseNumber        the dose number
     * @param dosage            the dosage
     * @param timeSinceLastDose the time since last dose
     */
    public Vaccine(String name, String brand, String ageGroup, String doseNumber, double dosage, int timeSinceLastDose){
        if ((name == null) || (name.isEmpty())
                || (brand == null) || (brand.isEmpty())
                || (ageGroup == null) || (ageGroup.isEmpty())
                || (doseNumber == null) || (doseNumber.isEmpty())
                || (dosage == 0)
                || (timeSinceLastDose == 0)){
            throw new IllegalArgumentException("All attributes are mandatory!" +
                    " Write number of days since last dose on the last field.");
        } else {
            this.name = name;
            this.brand = brand;
            this.ageGroup = ageGroup;
            this.doseNumber = doseNumber;
            this.dosage = dosage;
            this.timeSinceLastDose = timeSinceLastDose;
        }
    }

    public String toString(){
        return String.format("Vaccine [name = "+ name+", Brand = "+brand+
                ", Age Group = "+ageGroup+", Dose Number = "+doseNumber+
                ", Dosage = "+dosage+"" +
                ", Time Since Last Dose = "+timeSinceLastDose+"]");
    }
}
