package app.controller;

import app.domain.model.*;
import app.domain.model.systemUser.Employee;
import app.domain.model.vaccinationCenter.Day;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.ScheduleVaccine;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineSchedule;
import app.domain.model.vaccine.VaccineType;
import app.domain.shared.Constants;
import app.domain.model.systemUser.SNSUser;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        try {
            bootstrap();
        } catch (ParseException e) {
            e.printStackTrace();
        }
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


    private void bootstrap() throws ParseException {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN, Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_SNS_USER, Constants.ROLE_SNS_USER);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST, Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_NURSE, Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_CENTER_COORDINATOR, Constants.ROLE_CENTER_COORDINATOR);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456", Constants.ROLE_ADMIN);

        this.getCompany().defaultRegister(this.authFacade);

        createEmployee();
        SNSUser snsU2 = this.company.getSNSUserStore().newSNSUser("tomas", "masculine", "07/10/1999", "avenue 45", "915654723", "tomas23@gmail.com", "123444333", "76342123");
        createSnsUser();

        VaccinationCenter vc1 = this.company.getVaccinationCenterStore().newVaccinationCenter(1, "Healthcare", 917876321, 493782,
                "TestRua1", "teste1@gmail.com", "healthcare.com",
                10, 20, 3, 20);
        this.company.getVaccinationCenterStore().registerVaccinationCenter(vc1);
        VaccinationCenter vc2 = this.company.getVaccinationCenterStore().newVaccinationCenter(0, "Community", 917312756, 654253,
                "TestRua2", "teste2@gmail.com", "community.com",
                8, 22, 5, 40);
        this.company.getVaccinationCenterStore().registerVaccinationCenter(vc2);

//        createSchedules();



        VaccineType vt1 = vc1.newVaccineType(0, "12345", "COVID-19");
        VaccineType vt2 = vc1.newVaccineType(0, "54321", "FLU");
        createVaccineType(vc1);


        Vaccine v1 = vt1.newVaccine("COVID-19 Vaccine", "Pfizer", "18-22", "2", 5, 90);
        Vaccine v2 = vt2.newVaccine("FLU Vaccine", "Pfizer", "10-45", "1", 5, 180);
        createVaccine(vc1.findVaccineType("12345"), vc1.findVaccineType("54321"));
    }

    private void createVaccineType(VaccinationCenter vc1) {
        VaccineType vt1 = vc1.newVaccineType(0, "12345", "COVID-19");
        VaccineType vt2 = vc1.newVaccineType(0, "54321", "FLU");
        vc1.registerVaccineType(vt1);
        vc1.registerVaccineType(vt2);
    }

    private void createVaccine(VaccineType vt1, VaccineType vt2) {
        Vaccine v1 = vt1.newVaccine("COVID-19 Vaccine", "Pfizer", "18-22", "2", 2, 2);
        Vaccine v2 = vt2.newVaccine("FLU Vaccine", "Pfizer", "10-45", "1", 5, 180);
        vt1.registerVaccine(v1);
        vt2.registerVaccine(v2);
    }


    private void createSnsUser() throws ParseException {
        SNSUser snsU1 = this.company.getSNSUserStore().newSNSUser("maria", "feminine", "09/03/1998", "street 21", "912245654", "maria12@gmail.com", "123459876", "34566543");
        this.company.getSNSUserStore().registerSNSUser(snsU1);
        SNSUser snsU2 = this.company.getSNSUserStore().newSNSUser("tomas", "masculine", "07/10/1999", "avenue 45", "915654723", "tomas23@gmail.com", "123444333", "76342123");
        this.company.getSNSUserStore().registerSNSUser(snsU2);
        SNSUser snsU3 = this.company.getSNSUserStore().newSNSUser("snsUser", "masculine", "09/10/2016", "avenue 45", "917774723", "snsuser@lei.sem2.pt", "977642231", "11177744");
        this.company.getSNSUserStore().registerSNSUser(snsU3);


    }

    private void createSchedules() throws ParseException {
        VaccinationCenter vc = this.getCompany().getVaccinationCenterStore().getVaccinationCenters().get(0);
        VaccineType vt1 = vc.newVaccineType(0, "12345", "COVID-19");
        Vaccine v1 = vt1.newVaccine("COVID-19 Vaccine", "Pfizer", "18-22", "2", 5, 90);
        SNSUser snsUser01 = this.company.getSNSUserStore().getSNSUserByNumber("123444333");

        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH,1);
        vc.createVaccineSchedule(vc,snsUser01,vt1,v1,date.getTime());


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

        Employee employee4 = getCompany().getEmployeeStore().newEmployee("Receptionist" , "912333121", "street 21",
                "receptionist@lei.sem2.pt", "12344321", 0);
        getCompany().getEmployeeStore().registerEmployee(employee4);

        Employee employee5 = getCompany().getEmployeeStore().newEmployee("Nurse", "918564321", "avenue 21",
                "nurse@lei.sem2.pt", "10293847", 2);
        getCompany().getEmployeeStore().registerEmployee(employee5);

        Employee employee6 = getCompany().getEmployeeStore().newEmployee("Coordinator", "912218217", "avenue 26",
                "coordinator@lei.sem2.pt", "19231741", 1);
        getCompany().getEmployeeStore().registerEmployee(employee6);

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
