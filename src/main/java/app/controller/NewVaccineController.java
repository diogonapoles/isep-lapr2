package app.controller;

import app.domain.model.Company;
import app.domain.model.Vaccine;

import java.util.List;

public class NewVaccineController {

    private App oApp;
    private Company oCompany;
    private Vaccine oNewVaccine;


    public NewVaccineController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public boolean newVaccine(String name, String brand, String ageGroup, String doseNumber, double dosage, int timeSinceLastDose ){
        this.oNewVaccine = oCompany.getVaccineStore().newVaccine(name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
        if (this.oNewVaccine != null)
            return true;
        else
            return false;
    }


    public String getNewVaccinetoString(){return this.oNewVaccine.toString();}

    public boolean registerVaccine(){return this.oCompany.getVaccineStore().registerVaccine(oNewVaccine);}
}
