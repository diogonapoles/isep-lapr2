package app.domain.model.systemUser;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Sns user.
 */
public class SNSUser implements Serializable {

    private String name;
    private String gender;
    private Date birthDate;
    private String homeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String snsUserNumber;
    private String citizenCardNumber;
    private String vaccineScheduleDate;


    /**
     * Instantiates a new Sns user.
     *
     * @param name              the name
     * @param gender            the gender
     * @param birthDate         the birth date
     * @param homeAddress       the home address
     * @param phoneNumber       the phone number
     * @param emailAddress      the email address
     * @param snsUserNumber     the sns user number
     * @param citizenCardNumber the citizen card number
     */
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

    /**
     * Instantiates a new Sns user.
     *
     * @param name              the name
     * @param birthDate         the birth date
     * @param homeAddress       the home address
     * @param phoneNumber       the phone number
     * @param emailAddress      the email address
     * @param snsUserNumber     the sns user number
     * @param citizenCardNumber the citizen card number
     */
    public SNSUser(String name, Date birthDate, String homeAddress, String phoneNumber, String emailAddress, String snsUserNumber, String citizenCardNumber) {
        try {
            if ((name == null) || (name.isEmpty())
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

    /**
     * Instantiates a new Sns user.
     *
     * @param name              the name
     * @param homeAddress       the home address
     * @param phoneNumber       the phone number
     * @param birthDate         the birth date
     * @param emailAddress      the email address
     * @param snsUserNumber     the sns user number
     * @param citizenCardNumber the citizen card number
     */
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


    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @param address the address
     */
    public void setHomeAddress(String address) {
        homeAddress = address;
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
     * Gets birth date.
     *
     * @return the birth date
     */
    public Date getBirthDate() {
        return birthDate;
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
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Sets sns user number.
     *
     * @param snsUserNumber the sns user number
     */
    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    /**
     * Gets citizen card number.
     *
     * @return the citizen card number
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
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

    /**
     * To string waiting room string.
     *
     * @return the string
     */
    public String toStringWaitingRoom() {
        return "SNSUser{" +
                "name='" + name + '\'' +
                ", snsUserNumber='" + snsUserNumber + '\'' +
                ", citizenCardNumber='" + citizenCardNumber + '\'' +
                ", vaccineScheduleDate='" + vaccineScheduleDate + '\'' +
                '}';
    }

    /**
     * Get age int.
     *
     * @return the int
     */
    public int getAge(){
        Calendar c = Calendar.getInstance();
        c.setTime(birthDate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate today = LocalDate.now();
        Period period = Period.between(l1, today);

        return period.getYears();
    }
}
