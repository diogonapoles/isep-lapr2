package app.domain.model.vaccinationCenter;

/**
 * The type Healthcare center.
 */
public class HealthcareCenter extends VaccinationCenter {

    /**
     * Instantiates a new Healthcare center.
     *
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
     */
    public HealthcareCenter(String name, int phoneNumber, int faxNumber, String homeAddress, String emailAddress, String websiteAddress, int openingHours, int closingHours, int slotDuration, int maxNumVaccinesPerSlot)
    {
        super(name, phoneNumber, faxNumber, homeAddress, emailAddress, websiteAddress, openingHours, closingHours, slotDuration, maxNumVaccinesPerSlot);

    }
}
