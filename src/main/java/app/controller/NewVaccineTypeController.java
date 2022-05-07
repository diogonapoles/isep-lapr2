package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccineType;

import java.util.List;


public class NewVaccineTypeController {
    private App oApp;
    private Company oCompany;
    private VaccineType oVaccineType;

    public NewVaccineTypeController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public boolean newVaccineType(int techSelection, String code, String designation){
        this.oVaccineType = oCompany.getVaccineTypeStore().newVaccineType(techSelection, code, designation);
        if (this.oVaccineType != null)
            return true;
        else
            return false;

    }

    public List<String> getVaccineTechnologyTypes(){return this.oCompany.getVaccineTypeStore().getVaccineTechnologyTypes();}

    public String getVaccineTypeString(){return this.oVaccineType.toString();}

    public boolean registerVaccineType(){return this.oCompany.getVaccineTypeStore().registerVaccineType(oVaccineType);}
}
