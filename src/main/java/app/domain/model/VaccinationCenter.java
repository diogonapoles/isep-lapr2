package app.domain.model;

import org.apache.commons.lang3.StringUtils;

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

    public VaccinationCenter() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }
    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    public String getOpeningHours() {
        return openingHours;
    }
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getClosingHours() {
        return closingHours;
    }
    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }

    public String getSlotDuration() {
        return slotDuration;
    }
    public void setSlotDuration(String slotDuration) {
        this.slotDuration = slotDuration;
    }

    public String getMaxNumVaccinesPerSlot() {
        return maxNumVaccinesPerSlot;
    }
    public void setMaxNumVaccinesPerSlot(String maxNumVaccinesPerSlot) {
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }

    @Override
    public String toString() {
        return "RegisterVaccinationCenter [" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", websiteAddress='" + websiteAddress + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", closingHours='" + closingHours + '\'' +
                ", slotDuration='" + slotDuration + '\'' +
                ", maxNumVaccinesPerSlot='" + maxNumVaccinesPerSlot + '\'' +
                ']';
    }
}


