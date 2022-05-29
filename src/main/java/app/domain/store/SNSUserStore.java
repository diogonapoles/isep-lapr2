package app.domain.store;

import app.domain.shared.Constants;
import app.domain.systemUsers.SNSUser;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Sns user store.
 */
public class SNSUserStore {
    private final List<SNSUser> listSNSUser = new ArrayList<>();
    private final AuthFacade authFacade;

    /**
     * Instantiates a new Sns user store.
     *
     * @param authFacade the auth facade
     */
    public SNSUserStore(AuthFacade authFacade) {
        this.authFacade = authFacade;

    }

    /**
     * Import sns user csv boolean.
     *
     * @param list the list
     * @return the boolean
     */
    public boolean importSNSUserCSV(List<SNSUser> list) {
        for (int counter = 0; counter < list.size(); counter++) {
            SNSUser oSNSUser = list.get(counter);
            if (validateSNSUser(oSNSUser.getPhoneNumber(), oSNSUser.getHomeAddress(), oSNSUser.getEmailAddress()))
                addSNSUser(oSNSUser);
            else
                return false;
        }
        return true;
    }

    /**
     * Validate temp list list.
     *
     * @param list the list
     * @return the list
     */
    public List<SNSUser> validateTempList(List<SNSUser> list) {
        int size = list.size();
        List<SNSUser> listCopy = new ArrayList<>();
        for (int counter = 0; counter < size; counter++) {
            SNSUser oSNSUser = list.get(counter);
            if (validateSNSUser(oSNSUser.getPhoneNumber(), oSNSUser.getHomeAddress(), oSNSUser.getEmailAddress())) {
                listCopy.add(oSNSUser);
            } else {
                System.out.println("SNS USER WITH THE E-MAIL: " + oSNSUser.getEmailAddress() + " IS ALREADY REGISTERED IN THE SYSTEM!");
            }
        }
        return listCopy;
    }

    /**
     * Validate sns user boolean.
     *
     * @param phoneNumber  the phone number
     * @param homeAddress  the home address
     * @param emailAddress the email address
     * @return the boolean
     */
    public boolean validateSNSUser(String phoneNumber, String homeAddress, String emailAddress) {
        for (SNSUser user : listSNSUser) {
            if (user.getPhoneNumber().contains(phoneNumber)
                    || user.getEmailAddress().contains(emailAddress)
                    || user.getHomeAddress().contains(homeAddress))
                return false;
        }
        if (authFacade.existsUser(emailAddress)) {
            return false;
        } else
            return true;
    }

    /**
     * Register sns user boolean.
     *
     * @param User the user
     * @return the boolean
     */
    public boolean registerSNSUser(SNSUser User) {
        return addSNSUser(User);
    }

    private boolean addSNSUser(SNSUser user) {
        return this.listSNSUser.add(user);
    }


    /**
     * New sns user sns user.
     *
     * @param name              the name
     * @param gender            the gender
     * @param birthDate         the birth date
     * @param homeAddress       the home address
     * @param phoneNumber       the phone number
     * @param emailAddress      the email address
     * @param snsUserNumber     the sns user number
     * @param citizenCardNumber the citizen card number
     * @return the sns user
     * @throws ParseException the parse exception
     */
    public SNSUser newSNSUser(String name, String gender, String birthDate, String homeAddress, String phoneNumber, String emailAddress, String snsUserNumber, String citizenCardNumber) throws ParseException {
        this.authFacade.addUserWithRole(name, emailAddress, "123456", Constants.ROLE_SNS_USER);
        Date birth = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        return new SNSUser(name, gender, birth, homeAddress, phoneNumber, emailAddress, snsUserNumber, citizenCardNumber);
    }

    /**
     * Get sns user list list.
     *
     * @return the list
     */
    public List<SNSUser> getSnsUserList(){
        return this.listSNSUser;
    }

    /**
     * Get sns user by number sns user.
     *
     * @param snsUserNumber the sns user number
     * @return the sns user
     */
    public SNSUser getSNSUserByNumber(String snsUserNumber){
        for (SNSUser user : listSNSUser) {
            if (user.getSnsUserNumber().contains(snsUserNumber))
                return user;
        }
        return null;
    }
}
