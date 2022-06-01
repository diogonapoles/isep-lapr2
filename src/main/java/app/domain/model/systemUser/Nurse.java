package app.domain.model.systemUser;

/**
 * The type Nurse.
 */
public class Nurse extends Employee {
    /**
     * Instantiates a new Nurse.
     *
     * @param name              the name
     * @param phoneNumber       the phone number
     * @param address           the address
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     */
    public Nurse(String name, String phoneNumber, String address, String emailAddress, String citizenCardNumber) {
        super(name, phoneNumber, address, emailAddress, citizenCardNumber);
    }
}
