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


    private EmployeeStore oRegisterEmployee;





    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public EmployeeStore getEmployeeStore(){return this.oRegisterEmployee;}

    public void defaultRegister(AuthFacade authFacade){
   //     this.oRegisterEmployee = new EmployeeStore(authFacade);
    }
}
