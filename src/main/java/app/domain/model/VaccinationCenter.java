package app.domain.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The type Vaccination center.
 */
public abstract class VaccinationCenter {


    private String name;
    private String phoneNumber;
    private String faxNumber;
    private String homeAddress;
    private String emailAddress;
    private String websiteAddress;
    private String openingHours;
    private String closingHours;
    private String slotDuration;
    private String maxNumVaccinesPerSlot;

    /**
     * Instantiates a new Vaccination center.
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
    public VaccinationCenter(String name, String phoneNumber, String faxNumber, String homeAddress, String emailAddress, String websiteAddress, String openingHours, String closingHours, String slotDuration, String maxNumVaccinesPerSlot){
        if((name == null) || (name.isEmpty()) ||
                (phoneNumber == null) || (phoneNumber.isEmpty()) || (faxNumber == null) ||
                (faxNumber.isEmpty()) || (homeAddress == null) ||
                (homeAddress.isEmpty()) || (emailAddress == null) ||
                (emailAddress.isEmpty()) || (websiteAddress == null) || (websiteAddress.isEmpty()) ||
                (openingHours == null) || (openingHours.isEmpty()) || (closingHours == null) || (closingHours.isEmpty()) ||
                (slotDuration == null) || (slotDuration.isEmpty()) ||
                (maxNumVaccinesPerSlot == null) || (maxNumVaccinesPerSlot.isEmpty()) ||
                (phoneNumber.length() != 9) || !StringUtils.isNumeric(phoneNumber))
            throw new IllegalArgumentException("None of the arguments can be null or empty. Phone number must be in PT format");

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
        this.websiteAddress = websiteAddress;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.slotDuration = slotDuration;
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }

    /**
     * Instantiates a new Vaccination center.
     */
    public VaccinationCenter() {

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets fax number.
     *
     * @return the fax number
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets fax number.
     *
     * @param faxNumber the fax number
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * Gets home address.
     *
     * @return the home address
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Sets home address.
     *
     * @param homeAddress the home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets website address.
     *
     * @return the website address
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Sets website address.
     *
     * @param websiteAddress the website address
     */
    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    /**
     * Gets opening hours.
     *
     * @return the opening hours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets opening hours.
     *
     * @param openingHours the opening hours
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * Gets closing hours.
     *
     * @return the closing hours
     */
    public String getClosingHours() {
        return closingHours;
    }

    /**
     * Sets closing hours.
     *
     * @param closingHours the closing hours
     */
    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }

    /**
     * Gets slot duration.
     *
     * @return the slot duration
     */
    public String getSlotDuration() {
        return slotDuration;
    }

    /**
     * Sets slot duration.
     *
     * @param slotDuration the slot duration
     */
    public void setSlotDuration(String slotDuration) {
        this.slotDuration = slotDuration;
    }

    /**
     * Gets max num vaccines per slot.
     *
     * @return the max num vaccines per slot
     */
    public String getMaxNumVaccinesPerSlot() {
        return maxNumVaccinesPerSlot;
    }

    /**
     * Sets max num vaccines per slot.
     *
     * @param maxNumVaccinesPerSlot the max num vaccines per slot
     */
    public void setMaxNumVaccinesPerSlot(String maxNumVaccinesPerSlot) {
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }

    @Override
    public String toString() {
        return "name: " + name +
                "\nphoneNumber: " + phoneNumber +
                "\nfaxNumber: " + faxNumber +
                "\nhomeAddress: " + homeAddress +
                "\nemailAddress: " + emailAddress +
                "\nwebsiteAddress: " + websiteAddress +
                "\nopeningHours: " + openingHours +
                "\nclosingHours: " + closingHours +
                "\nslotDuration: " + slotDuration +
                "\nmaxNumVaccinesPerSlot: " + maxNumVaccinesPerSlot +
                "\n\n" ;
    }
}


