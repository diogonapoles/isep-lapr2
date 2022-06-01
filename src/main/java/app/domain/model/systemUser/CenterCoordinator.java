package app.domain.model.systemUser;

/**
 * The type Center coordinator.
 */
public class CenterCoordinator extends Employee {

    /**
     * Instantiates a new Center coordinator.
     *
     * @param name              the name
     * @param phoneNumber       the phone number
     * @param address           the address
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     */
    public CenterCoordinator(String name, String phoneNumber, String address, String emailAddress, String citizenCardNumber) {
        super(name, phoneNumber, address, emailAddress, citizenCardNumber);
    }
}
