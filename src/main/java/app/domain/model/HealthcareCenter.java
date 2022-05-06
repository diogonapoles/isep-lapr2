package app.domain.model;

public class HealthcareCenter extends VaccinationCenter{

    public HealthcareCenter(String name, String phoneNumber, String faxNumber, String homeAddress, String emailAddress, String websiteAddress, String openingHours, String closingHours, String slotDuration, String maxNumVaccinesPerSlot)
    {
        super(name, phoneNumber, faxNumber, homeAddress, emailAddress, websiteAddress, openingHours, closingHours, slotDuration, maxNumVaccinesPerSlot);

    }
}
