package app.domain.model;

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
    private VaccineTypeStore oVaccineTypeStore;
    private VaccineStore oVaccineStore;

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
        this.oVaccineTypeStore = new VaccineTypeStore();
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
    }

    /**
     * Get vaccination center store vaccination center store.
     *
     * @return the vaccination center store
     */
    public VaccinationCenterStore getVaccinationCenterStore(){return this.oVaccinationCenterStore;}

    /**
     * Get vaccine type store.
     *
     * @return the vaccine type store
     */
    public VaccineTypeStore getVaccineTypeStore(){return this.oVaccineTypeStore;}

    /**
     * Get vaccine store.
     *
     * @return the vaccine store
     */
    public VaccineStore getVaccineStore(){ return this.oVaccineStore;}
}