package app.domain.model.systemUser;

import app.domain.model.vaccinationCenter.VaccinationCenter;
import org.apache.commons.lang3.StringUtils;

/**
 * The type Employee.
 */
public abstract class Employee {


    private String name;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private String citizenCardNumber;

    private VaccinationCenter vaccinationCenter;


    /**
     * Instantiates a new Employee.
     *
     * @param name              the name
     * @param phoneNumber       the phone number
     * @param address           the address
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     */
    public Employee(String name, String phoneNumber, String address, String emailAddress, String citizenCardNumber) {
        try {
            if ((name == null) || (name.isEmpty())
                    || (phoneNumber == null) || (phoneNumber.isEmpty())
                    || (address == null) || (address.isEmpty())
                    || (emailAddress == null) || (emailAddress.isEmpty())
                    || (citizenCardNumber == null) || (citizenCardNumber.isEmpty())
                    || (phoneNumber.length() != 9) || !StringUtils.isNumeric(phoneNumber)
                    || (citizenCardNumber.length() != 8) || !StringUtils.isNumeric(citizenCardNumber)) {
                throw new IllegalArgumentException();
            } else {
                this.name = name;
                this.phoneNumber = phoneNumber;
                this.address = address;
                this.emailAddress = emailAddress;
                this.citizenCardNumber = citizenCardNumber;
            }
        }catch (IllegalArgumentException ex) {
            System.out.println("All attributes are mandatory!" +
                    " Phone Number and Citizen Card Number must have 9 and 8 numbers respectively!");

        }
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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * Gets citizen card number.
     *
     * @return the citizen card number
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Sets citizen card number.
     *
     * @param citizenCardNumber the citizen card number
     */
    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Sets working.
     *
     * @param vaccinationCenter the vaccination center
     */
    public void setWorking(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        return vaccinationCenter;
    }


    public String toString() {
        return String.format("Employee [name = " + name + ", Phone Number = " + phoneNumber +
                ", Address = " + address + ", Email Address = " + emailAddress +
                ", Citizen Card Number = " + citizenCardNumber + "]");
    }


}
