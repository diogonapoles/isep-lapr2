package app.domain.model.systemUser;

/**
 * The type Receptionist.
 */
public class Receptionist extends Employee {

    /**
     * Instantiates a new Receptionist.
     *
     * @param name              the name
     * @param phoneNumber       the phone number
     * @param address           the address
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     */
    public Receptionist(String name, String phoneNumber, String address, String emailAddress, String citizenCardNumber) {
        super(name, phoneNumber, address, emailAddress, citizenCardNumber);
    }
}
