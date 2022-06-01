package app.controller.administrator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.Employee;

import java.util.List;

/**
 * The type Register employee controller.
 */
public class RegisterEmployeeController {

    private App oApp;
    private Company oCompany;
    private Employee oEmployee;

    /**
     * Instantiates a new Register employee controller.
     */
    public RegisterEmployeeController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }


    /**
     * New employee boolean.
     *
     * @param name              the name
     * @param phoneNumber       the phone number
     * @param address           the address
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     * @param roleSelection     the role selection
     * @return the boolean
     */
    public boolean newEmployee(String name, String phoneNumber, String address,
                               String emailAddress, String citizenCardNumber, int roleSelection) {

        this.oEmployee = oCompany.getEmployeeStore().newEmployee(name, phoneNumber, address, emailAddress, citizenCardNumber, roleSelection);
        if (name != null) {
            if (this.oEmployee != null)
                return true;
            else
                return false;
        }
        return false;

    }

    /**
     * Register employee boolean.
     *
     * @return the boolean
     */
    public boolean registerEmployee() {
        return this.oCompany.getEmployeeStore().registerEmployee(this.oEmployee);
    }

    /**
     * Gets employee roles.
     *
     * @return the employee roles
     */
    public List<String> getEmployeeRoles() {
        return this.oCompany.getEmployeeStore().getEmployeeRoles();
    }

    /**
     * Gets employee string.
     *
     * @return the employee string
     */
    public String getEmployeeString() {
        return this.oEmployee.toString();
    }

}
