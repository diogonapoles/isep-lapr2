package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class SNSUser {

    String name;
    String gender;
    String birthDate;
    String homeAddress;
    String phoneNumber;
    String emailAddress;
    String snsUserNumber;
    String citizenCardNumber;

    public SNSUser(String name, String gender, String birthDate, String homeAddress, String phoneNumber, String emailAddress, String snsUserNumber, String citizenCardNumber) {
        try {
            if ((name == null) || (name.isEmpty())
                    || (gender == null) || (gender.isEmpty())
                    || (birthDate == null) || (birthDate.isEmpty())
                    || (homeAddress == null) || (homeAddress.isEmpty())
                    || (phoneNumber == null) || (phoneNumber.isEmpty())
                    || (emailAddress == null) || (emailAddress.isEmpty())
                    || (snsUserNumber == null) || (snsUserNumber.isEmpty())
                    || (citizenCardNumber == null) || (citizenCardNumber.isEmpty())
                    || (phoneNumber.length() != 9) || !StringUtils.isNumeric(phoneNumber)
                    || (citizenCardNumber.length() != 8) || !StringUtils.isNumeric(citizenCardNumber)) {
                throw new IllegalArgumentException("All attributes are mandatory!" +
                        " Phone Number and Citizen Card Number must have 9 and 8 numbers respectively!");
            } else {
                this.name = name;
                this.gender = gender;
                this.birthDate = birthDate;
                this.homeAddress = homeAddress;
                this.phoneNumber = phoneNumber;
                this.emailAddress = emailAddress;
                this.snsUserNumber = snsUserNumber;
                this.citizenCardNumber = citizenCardNumber;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String address) {
        this.homeAddress = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    @Override
    public String toString() {
        return "SNSUser{" +
                "name='" + name + '\'' +
                ", address='" + homeAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", snsUserNumber='" + snsUserNumber + '\'' +
                ", citizenCardNumber='" + citizenCardNumber + '\'' +
                '}';
    }
}
