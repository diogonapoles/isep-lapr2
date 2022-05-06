package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccinationCenter;

import java.util.List;

public class RegisterVaccinationCenterController {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter oVaccinationCenter;

    public RegisterVaccinationCenterController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public boolean newVaccinationCenter(int typeSelection, String name, String phoneNumber, String faxNumber, String homeAddress, String emailAddress, String websiteAddress, String openingHours, String closingHours, String slotDuration, String maxNumVaccinesPerSlot){

        this.oVaccinationCenter = oCompany.getVaccinationCenterStore().newVaccinationCenter(typeSelection, name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);
        if (this.oVaccinationCenter != null)
            return true;
        else
            return false;

    }

    public List<String> getVaccinationCenterTypes(){return this.oCompany.getVaccinationCenterStore().getVaccinationCenterTypes();}

    public String getVaccinationCenterString(){return this.oVaccinationCenter.toString();}

    public boolean registerVaccinationCenter(){return this.oCompany.getVaccinationCenterStore().registerVaccinationCenter(oVaccinationCenter);}
}
