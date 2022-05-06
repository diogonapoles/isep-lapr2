package app.domain.model;

public class CommunityCenter extends VaccinationCenter{

    public CommunityCenter(String name, String phoneNumber, String faxNumber, String homeAddress, String emailAddress, String websiteAddress, String openingHours, String closingHours, String slotDuration, String maxNumVaccinesPerSlot)
    {
        super(name, phoneNumber, faxNumber, homeAddress, emailAddress, websiteAddress, openingHours, closingHours, slotDuration, maxNumVaccinesPerSlot);

    }
}
