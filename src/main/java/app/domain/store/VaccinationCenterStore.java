package app.domain.store;

import app.domain.model.vaccinationCenter.CommunityCenter;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccination center store.
 */
public class VaccinationCenterStore {

    private final List<VaccinationCenter> listVaccinationCenter = new ArrayList<>();

    /**
     * Instantiates a new Vaccination center store.
     */
    public VaccinationCenterStore() {
    }

    /**
     * New vaccination center vaccination center.
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
     * @return the vaccination center
     */
    public VaccinationCenter newVaccinationCenter(int typeSelection, String name, int phoneNumber, int faxNumber, String homeAddress, String emailAddress, String websiteAddress, int openingHours, int closingHours, int slotDuration, int maxNumVaccinesPerSlot){
        if(validateVaccinationCenter(emailAddress))
        {
            if (typeSelection == 0)
                return new HealthcareCenter(name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);
            else if (typeSelection == 1)
                return new CommunityCenter( name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);
        }
        return null;
    }

    /**
     * Validate vaccination center boolean.
     *
     * @param emailAddress the email address
     * @return the boolean
     */
    public boolean validateVaccinationCenter(String emailAddress)
    {
        for(VaccinationCenter vacs: listVaccinationCenter)
        {
            if(vacs.getEmailAddress().contains(emailAddress))
                return false;
        }

        return true;
    }


    /**
     * Register vaccination center boolean.
     *
     * @param oVaccinationCenter the o vaccination center
     * @return the boolean
     */
    public boolean registerVaccinationCenter(VaccinationCenter oVaccinationCenter)
    {
        if(validateVaccinationCenter(oVaccinationCenter.getEmailAddress()))
            return addVaccinationCenter(oVaccinationCenter);
        else
            return false;
    }

    private boolean addVaccinationCenter(VaccinationCenter vac){return this.listVaccinationCenter.add(vac);}


    /**
     * Gets vaccination center types.
     *
     * @return the vaccination center types
     */
    public List<String> getVaccinationCenterTypes()
    {
        List<String> listOfVaccinationCenter = new ArrayList<>();
        listOfVaccinationCenter.add("HealthCareCenter");
        listOfVaccinationCenter.add("Community Mass Vaccination Center");


        return listOfVaccinationCenter;
    }

    /**
     * Get vaccination centers list.
     *
     * @return the list
     */

    public List<VaccinationCenter> getVaccinationCenters(){
        return this.listVaccinationCenter;
    }
}
