package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type App.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;
    private Employee oEmployee;

    private App() {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }


    /**
     * Gets current user session.
     *
     * @return the current user session
     */
    public UserSession getCurrentUserSession() {
        return this.authFacade.getCurrentUserSession();
    }

    /**
     * Do login boolean.
     *
     * @param email the email
     * @param pwd   the pwd
     * @return the boolean
     */
    public boolean doLogin(String email, String pwd) {
        return this.authFacade.doLogin(email, pwd).isLoggedIn();
    }

    /**
     * Do logout.
     */
    public void doLogout() {
        this.authFacade.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }


    private void bootstrap() {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN, Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_SNS_USER, Constants.ROLE_SNS_USER);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST, Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_NURSE, Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_CENTER_COORDINATOR, Constants.ROLE_CENTER_COORDINATOR);

        this.authFacade.addUserWithRole("Nurse", "nurse@lei.sem2.pt", "123456", Constants.ROLE_NURSE);
        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456", Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Receptionist", "receptionist@lei.sem2.pt", "123456", Constants.ROLE_RECEPTIONIST);
        this.getCompany().defaultRegister(this.authFacade);

        createEmployee();
        //createSnsUser();
        //createVaccinnationCenter();
        //createStrap

    }


    private void createEmployee() {

        new Receptionist("maria", "123456789", "travessa 1",
                "tgr@gmail.com", "12341234");

        this.oEmployee =getCompany().getEmployeeStore().newEmployee("maria", "123456789", "travessa 1",
                "tgr@gmail.com", "12341234", 0);

        getCompany().getEmployeeStore().newEmployee("maria", "123456789", "travessa 1",
                "tgr@gmail.com", "12341234", 0);
        this.getCompany().getEmployeeStore().newEmployee("tiago", "912234572", "rua 2",
                "tiago11@gmail.com", "12347623", 1);
        this.getCompany().getEmployeeStore().newEmployee("fernando", "913434572", "avenida 3",
                "nando23@gmail.com", "12349876", 2);

    }


    private static App singleton = null;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }
}
