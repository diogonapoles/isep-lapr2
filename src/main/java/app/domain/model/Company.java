package app.domain.model;

import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
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

    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.oVaccinationCenterStore = new VaccinationCenterStore();
        this.oVaccineTypeStore = new VaccineTypeStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public EmployeeStore getEmployeeStore(){return this.oEmployeeStore;}

    public void defaultRegister(AuthFacade authFacade){
        this.oEmployeeStore = new EmployeeStore(this.authFacade);
    }

    public VaccinationCenterStore getVaccinationCenterStore(){return this.oVaccinationCenterStore;}

    public VaccineTypeStore getVaccineTypeStore(){return this.oVaccineTypeStore;}

    public VaccineStore getVaccineStore(){ return this.oVaccineStore;}
}