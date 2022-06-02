package app.domain.model;

import app.domain.store.*;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * The type Company.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private EmployeeStore oEmployeeStore;
    private VaccinationCenterStore oVaccinationCenterStore;
    private SNSUserStore oSNSUserStore;
    private CSVReader oCSVReader;
    private UserArrivalStore oUserArrivalStore;
    private ScheduleVaccineStore oScheduleVaccineStore;

    /**
     * Instantiates a new Company.
     *
     * @param designation the designation
     */
    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.oVaccinationCenterStore = new VaccinationCenterStore();
        this.oCSVReader = new CSVReader();
        this.oScheduleVaccineStore = new ScheduleVaccineStore();
        this.oUserArrivalStore = new UserArrivalStore(getScheduleVaccineStore());
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets auth facade.
     *
     * @return the auth facade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Get csv reader csv reader.
     *
     * @return the csv reader
     */
    public CSVReader getCSVReader(){return this.oCSVReader;}

    /**
     * Get employee store.
     *
     * @return the employee store
     */
    public EmployeeStore getEmployeeStore(){return this.oEmployeeStore;}

    /**
     * Default register.
     *
     * @param authFacade the auth facade
     */
    public void defaultRegister(AuthFacade authFacade){
        this.oEmployeeStore = new EmployeeStore(this.authFacade);
        this.oSNSUserStore = new SNSUserStore(this.authFacade);
    }

    /**
     * Get vaccination center store vaccination center store.
     *
     * @return the vaccination center store
     */
    public VaccinationCenterStore getVaccinationCenterStore(){return this.oVaccinationCenterStore;}

    /**
     * Get sns user store sns user store.
     *
     * @return the sns user store
     */
    public SNSUserStore getSNSUserStore(){return this.oSNSUserStore;}

    /**
     * Get user arrival store user arrival store.
     *
     * @return the user arrival store
     */
    public UserArrivalStore getUserArrivalStore(){return this.oUserArrivalStore;}

    /**
     * Gets schedule vaccine store.
     *
     * @return the schedule vaccine store
     */
    public ScheduleVaccineStore getScheduleVaccineStore() {
        return this.oScheduleVaccineStore;
    }
}