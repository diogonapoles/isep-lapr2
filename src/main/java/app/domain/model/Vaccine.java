package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Vaccine {

    private String name;
    private String brand;
    private String ageGroup;
    private String doseNumber;
    private double dosage;
    private  int timeSinceLastDose;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public int getTimeSinceLastDose() {
        return timeSinceLastDose;
    }

    public void setTimeSinceLastDose(int timeSinceLastDose) {
        this.timeSinceLastDose = timeSinceLastDose;
    }

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
