package app.domain.model.vaccine;


import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * The type Vaccine.
 */
public class Vaccine implements Serializable {

    /**
     * The Vaccine type list.
     */
    private String name;
    private String brand;
    private String ageGroup;
    private int doseNumber;
    private double dosage;
    private int timeSinceLastDose;

    private VaccineType oVaccineType;

    public Vaccine() {

    }

    //  public Vaccine(VaccineType oVaccineType) {

    //    this.oVaccineType = oVaccineType;
    //}

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
    public int getDoseNumber() {
        return doseNumber;
    }

    /**
     * Sets dose number.
     *
     * @param doseNumber the dose number
     */
    public void setDoseNumber(int doseNumber) {
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

    public String getVaccineDescription(){
        return oVaccineType.getDesignation();
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
    public Vaccine(String name, String brand, String ageGroup, int doseNumber, double dosage, int timeSinceLastDose){
        if ((name == null) || (name.isEmpty())
                || (brand == null) || (brand.isEmpty())
                || (ageGroup == null) || (ageGroup.isEmpty()) || !validateAgeGroup(ageGroup)
                || (doseNumber == 0)
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
        return String.format("Vaccine [name = "+ name+" | Brand = "+brand+
                " | Age Group = "+ageGroup+" | Dose Number = "+doseNumber+ " doses" +
                " | Dosage = "+dosage+" mg/l" +
                " | Time Since Last Dose = "+timeSinceLastDose+ " days]");
    }

    private static final Pattern p = Pattern.compile("\\d{2}-\\d{2}");

    public boolean validateAgeGroup(String ageGroup){
        if(p.matcher(ageGroup).matches())
            return true;
        throw new IllegalArgumentException("Age group is not valid. It should be (minAge-maxAge)");
    }

    public int getAgeGroup(int limit){
        String[] group = ageGroup.split("-");
        return Integer.parseInt(group[limit]);
    }
}
