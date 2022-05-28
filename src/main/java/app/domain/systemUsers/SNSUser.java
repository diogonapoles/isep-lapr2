package app.domain.systemUsers;

import app.domain.store.SNSUserStore;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class SNSUser {

    private String name;
    private String gender;
    private Date birthDate;
    private String homeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String snsUserNumber;
    private String citizenCardNumber;
    private String vaccineScheduleDate;


    public SNSUser(String name, String gender, Date birthDate, String homeAddress, String phoneNumber, String emailAddress, String snsUserNumber, String citizenCardNumber) {
        try {
            if ((name == null) || (name.isEmpty())
                    || (gender == null) || (gender.isEmpty())
                    || (birthDate == null)
                    || (homeAddress == null) || (homeAddress.isEmpty())
                    || (phoneNumber == null) || (phoneNumber.isEmpty())
                    || (emailAddress == null) || (emailAddress.isEmpty())
                    || (snsUserNumber == null) || (snsUserNumber.isEmpty())
                    || (citizenCardNumber == null) || (citizenCardNumber.isEmpty()))
                throw new IllegalArgumentException("None of the arguments can be null or empty.");

            if ((phoneNumber.length() != 9) || !StringUtils.isNumeric(phoneNumber))
                throw new IllegalArgumentException("Phone number must be in PT format.");

            if ((citizenCardNumber.length() != 8) || !StringUtils.isNumeric(citizenCardNumber))
                throw new IllegalArgumentException("Citizen card must have 8 digits.");

            if ((snsUserNumber.length() != 9) || !StringUtils.isNumeric(snsUserNumber))
                throw new IllegalArgumentException("SNS User number must have 9 digits.");

            if (!emailAddress.contains("@"))
                throw new IllegalArgumentException("Not a valid e-mail address.");

            this.name = name;
            this.gender = gender;
            this.birthDate = birthDate;
            this.homeAddress = homeAddress;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.snsUserNumber = snsUserNumber;
            this.citizenCardNumber = citizenCardNumber;
        }catch (IllegalArgumentException e){
            System.out.println();
        }
    }

    public SNSUser(String name, String homeAddress, String phoneNumber, Date birthDate, String emailAddress, String snsUserNumber, String citizenCardNumber) {

            if ((snsUserNumber == null) || snsUserNumber.length() != 9 || !StringUtils.isNumeric(snsUserNumber)) {
                throw new IllegalArgumentException("Not a valid SNS Number");
            } else {
                this.name = name;
                this.phoneNumber = phoneNumber;
                this.birthDate = birthDate;
                this.emailAddress = emailAddress;
                this.snsUserNumber = snsUserNumber;

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


    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String address) {
        homeAddress = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
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

    public String getVaccineScheduleDate() {
        return vaccineScheduleDate;
    }

    public void setVaccineScheduleDate(String vaccineScheduleDate) {
        this.vaccineScheduleDate = vaccineScheduleDate;
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

    public String toStringWaitingRoom() {
        return "SNSUser{" +
                "name='" + name + '\'' +
                ", snsUserNumber='" + snsUserNumber + '\'' +
                ", citizenCardNumber='" + citizenCardNumber + '\'' +
                ", vaccineScheduleDate='" + vaccineScheduleDate + '\'' +
                '}';
    }

}
