package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterStore {

    private final List<VaccinationCenter> listVaccinationCenter = new ArrayList<>();

    public VaccinationCenterStore() {
    }

    public VaccinationCenter newVaccinationCenter(int typeSelection, String name, String phoneNumber, String faxNumber, String homeAddress, String emailAddress, String websiteAddress, String openingHours, String closingHours, String slotDuration, String maxNumVaccinesPerSlot){
        if(validateVaccinationCenter(name,faxNumber,homeAddress,emailAddress))
        {
            if (typeSelection == 0)
                return new HealthcareCenter(name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);
            else if (typeSelection == 1)
                return new CommunityCenter( name,phoneNumber,faxNumber,homeAddress,emailAddress, websiteAddress,openingHours,closingHours,slotDuration,maxNumVaccinesPerSlot);
        }
        return null;
    }

    public boolean validateVaccinationCenter(String phoneNumber, String faxNumber, String homeAddress, String emailAddress)
    {
        for(VaccinationCenter vacs: listVaccinationCenter)
        {
            if(vacs.getPhoneNumber().contains(phoneNumber)
                    ||vacs.getFaxNumber().contains(faxNumber)
                    || vacs.getEmailAddress().contains(emailAddress)
                    || vacs.getHomeAddress().contains(homeAddress))
                return false;
        }

        return true;
    }


    public boolean registerVaccinationCenter(VaccinationCenter oVaccinationCenter)
    {
        if(validateVaccinationCenter(oVaccinationCenter.getPhoneNumber(),oVaccinationCenter.getFaxNumber(),oVaccinationCenter.getHomeAddress(),oVaccinationCenter.getEmailAddress()))
            return addVaccinationCenter(oVaccinationCenter);
        else
            return false;
    }

    private boolean addVaccinationCenter(VaccinationCenter vac){return this.listVaccinationCenter.add(vac);}


    public List<String> getVaccinationCenterTypes()
    {
        List<String> listOfVaccinationCenter = new ArrayList<>();
        listOfVaccinationCenter.add("HealthCareCenter");
        listOfVaccinationCenter.add("Community Mass Vaccination Center");


        return listOfVaccinationCenter;
    }
}
