package app.domain.model;

import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    private final List<Employee> listEmployee = new ArrayList<>();
    private final AuthFacade authFacade;

    public EmployeeStore(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    public Employee newEmployee(String name, String phoneNumber, String address, String emailAddress, String citizenCardNumber, int roleSelection) {
        if (validateEmployee(phoneNumber, emailAddress, citizenCardNumber)) {
            if (roleSelection == 0)
                return new Receptionist(name, phoneNumber, address, emailAddress, citizenCardNumber);
            else if (roleSelection == 1)
                return new CenterCoordinator(name, phoneNumber, address, emailAddress, citizenCardNumber);
            else if (roleSelection == 2)
                return new Nurse(name, phoneNumber, address, emailAddress, citizenCardNumber);
        }
        return null;
    }

    private boolean validateEmployee(String phoneNumber, String emailAddress, String citizenCardNumber) {

        if (authFacade.existsUser(emailAddress))
            return false;
        else {
            for (Employee employee : listEmployee) {
                if (employee.getCitizenCardNumber() == citizenCardNumber
                        || employee.getPhoneNumber() == phoneNumber
                        || employee.getEmailAddress().compareTo(emailAddress) == 0)
                    return false;
            }
            return true;
        }

    }


    public boolean registerEmployee(Employee employee) {
        return addEmployee(employee);
    }

    private boolean addEmployee(Employee employee) {
        return this.listEmployee.add(employee);
    }

    public List<String> getEmployeeRoles(){

        List<UserRoleDTO> lRolesDTO;
        lRolesDTO = authFacade.getUserRoles();


        List<String> roles = new ArrayList<>();
        for (int x = 0; x < lRolesDTO.size() ; x++) {
            if(lRolesDTO.get(x).getDescription().compareToIgnoreCase("NURSE") == 0
                    || lRolesDTO.get(x).getDescription().compareToIgnoreCase( "CENTER_COORDINATOR") == 0
                    || lRolesDTO.get(x).getDescription().compareToIgnoreCase( "RECEPTIONIST") == 0)
                roles.add(lRolesDTO.get(x).getDescription());
        }

        return roles;
    }



}
