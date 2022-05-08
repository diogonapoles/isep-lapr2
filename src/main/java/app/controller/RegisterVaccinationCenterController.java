package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccinationCenter;

import java.util.List;

/**
 * The type Register vaccination center controller.
 */
public class RegisterVaccinationCenterController {

    private App oApp;
    private Company oCompany;
    private VaccinationCenter oVaccinationCenter;

    /**
     * Instantiates a new Register vaccination center controller.
     */
    public RegisterVaccinationCenterController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * New vaccination center boolean.
     *
     * @param typeSelection         the type selection
     * @param name                  the name
     * @param phoneNumber           the phone number
     * @param faxNumber             the fax number
     * @param homeAddress           the home address
     * @param emailAddress          the email address
     * @param websiteAddress        the website address
     * @param openingHours          the opening hours
     * @param closingHours          the closing hours
     * @param slotDuration          the slot duration
     * @param maxNumVaccinesPerSlot the max num vaccines per slot
     * @return the boolean
     */
    public boolean newVaccinationCenter(int typeSelection, String name, String phoneNumber, String faxNumber, String homeAddress, String emailAddress, String websiteAddress, String openingHours, String closingHours, String slotDuration, String maxNumVaccinesPerSlot){

        this.oVaccinationCenter = oCompany.getVaccinationCenterStore().newVaccinationCenter(typeSelection, name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);
        if (this.oVaccinationCenter != null)
            return true;
        else
            return false;

    }

    /**
     * Get vaccination center types list.
     *
     * @return the list
     */
    public List<String> getVaccinationCenterTypes(){return this.oCompany.getVaccinationCenterStore().getVaccinationCenterTypes();}

    /**
     * Get vaccination center string.
     *
     * @return the string
     */
    public String getVaccinationCenterString(){return this.oVaccinationCenter.toString();}

    /**
     * Register vaccination center boolean.
     *
     * @return the boolean
     */
    public boolean registerVaccinationCenter(){return this.oCompany.getVaccinationCenterStore().registerVaccinationCenter(oVaccinationCenter);}
}
