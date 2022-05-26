package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import app.domain.systemUsers.SNSUser;
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
        createSnsUser();
        createVaccinnationCenter();
        //createStrap

    }

    private void createSnsUser() {
        SNSUser snsU1 = this.company.getSNSUserStore().newSNSUser("maria", "feminine", "09/03/1998", "Rua 21", "912245654", "maria12@gmail.com", "123476432", "34566543");
        this.company.getSNSUserStore().registerSNSUser(snsU1);
    }


    private void createVaccinnationCenter() {
        VaccinationCenter vc1 = this.company.getVaccinationCenterStore().newVaccinationCenter(1, "Healthcare", "917876321", "493782",
                "TestRua1", "teste1@gmail.com", "healthcare.com",
                "10", "20", "3", "20");
        this.company.getVaccinationCenterStore().registerVaccinationCenter(vc1);
        VaccinationCenter vc2 = this.company.getVaccinationCenterStore().newVaccinationCenter(0, "Community", "917312756", "654253",
                "TestRua2", "teste2@gmail.com", "community.com",
                "8", "22", "5", "40");
        this.company.getVaccinationCenterStore().registerVaccinationCenter(vc2);
    }


    private void createEmployee() {

        Employee employee1 = getCompany().getEmployeeStore().newEmployee("maria", "123456789", "avenue 1",
                "tgr@gmail.com", "12341234", 0);
        getCompany().getEmployeeStore().registerEmployee(employee1);

        Employee employee2 = getCompany().getEmployeeStore().newEmployee("tiago", "912234572", "Street 2",
                "tiago11@gmail.com", "12347623", 1);
        getCompany().getEmployeeStore().registerEmployee(employee2);

        Employee employee3 = getCompany().getEmployeeStore().newEmployee("fernando", "913434572", "avenue 3",
                "nando23@gmail.com", "12349876", 2);
        getCompany().getEmployeeStore().registerEmployee(employee3);

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
