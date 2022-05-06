package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public abstract class Employee {


    private String name;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private String citizenCardNumber;


    public Employee(String name, String phoneNumber, String address, String emailAddress, String citizenCardNumber) {
        if ((name == null) || (name.isEmpty())
                || (phoneNumber == null) || (phoneNumber.isEmpty())
                || (address == null) || (address.isEmpty())
                || (emailAddress == null) || (emailAddress.isEmpty())
                || (citizenCardNumber == null) || (citizenCardNumber.isEmpty())
                || (phoneNumber.length() != 9) || !StringUtils.isNumeric(phoneNumber)
                || (citizenCardNumber.length() != 8) || !StringUtils.isNumeric(citizenCardNumber)) {
            throw new IllegalArgumentException("All attributes are mandatory!" +
                    " Phone Number and Citizen Card Number must have 9 and 8 numbers respectively!");
        } else {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.emailAddress = emailAddress;
            this.citizenCardNumber = citizenCardNumber;
        }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }


    public String toString(){
        return String.format("Employee [name = "+ name+", Phone Number = "+phoneNumber+
                ", Address = "+address+", Email Address = "+emailAddress+
                ", Citizen Card Number = "+citizenCardNumber+"]");
    }




}
