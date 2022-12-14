package app.domain.store;

import app.domain.model.systemUser.Employee;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.shared.Constants;
import app.domain.model.systemUser.CenterCoordinator;
import app.domain.model.systemUser.Nurse;
import app.domain.model.systemUser.Receptionist;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Employee store.
 */
public class EmployeeStore implements Serializable {

    private final List<Employee> listEmployee = new ArrayList<>();
    private final AuthFacade authFacade;

    /**
     * Instantiates a new Employee store.
     *
     * @param authFacade the auth facade
     */
    public EmployeeStore(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    /**
     * New employee employee.
     *
     * @param name              the name
     * @param phoneNumber       the phone number
     * @param address           the address
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     * @param roleSelection     the role selection
     * @return the employee
     */
    public Employee newEmployee(String name, String phoneNumber, String address,
                                String emailAddress, String citizenCardNumber, int roleSelection) {

        if (validateEmployee(phoneNumber, emailAddress, citizenCardNumber)) {
            if (roleSelection == 0) {
                this.authFacade.addUserWithRole(name, emailAddress, "123456", Constants.ROLE_RECEPTIONIST);
                return new Nurse (name, phoneNumber, address, emailAddress, citizenCardNumber);
            } else if (roleSelection == 1) {
                this.authFacade.addUserWithRole(name, emailAddress, "123456", Constants.ROLE_CENTER_COORDINATOR);
                return new CenterCoordinator (name, phoneNumber, address, emailAddress, citizenCardNumber);
            } else if (roleSelection == 2) {
                this.authFacade.addUserWithRole(name, emailAddress, "123456", Constants.ROLE_NURSE);
                return new Receptionist (name, phoneNumber, address, emailAddress, citizenCardNumber);
            }
        }
        return null;
    }

    /**
     * Validate employee boolean.
     *
     * @param phoneNumber       the phone number
     * @param emailAddress      the email address
     * @param citizenCardNumber the citizen card number
     * @return the boolean
     */
    public boolean validateEmployee(String phoneNumber, String emailAddress, String citizenCardNumber) {

        for (Employee employee : listEmployee) {
            if (employee.getCitizenCardNumber().equals(citizenCardNumber)
                    || employee.getPhoneNumber().equals(phoneNumber)
                    || employee.getEmailAddress().compareTo(emailAddress) == 0)
                return false;
        }
        if (authFacade.existsUser(emailAddress)) {
            return false;
        } else
            return true;

    }


    /**
     * Register employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean registerEmployee(Employee employee) {
        return addEmployee(employee);
    }

    /**
     * Register employee from file boolean.
     *
     * @param emp the emp
     * @return the boolean
     */
    public boolean registerEmployeeFromFile(Employee emp){
        String role = null;
        if (emp instanceof Receptionist)
            role = Constants.ROLE_RECEPTIONIST;
        else if (emp instanceof CenterCoordinator)
            role = Constants.ROLE_CENTER_COORDINATOR;
        else if (emp instanceof Nurse)
            role = Constants.ROLE_NURSE;
        if (role == null)
            return false;
        this.authFacade.addUserWithRole(emp.getName(), emp.getEmailAddress(), "123456", role);
        return addEmployee(emp);
    }

    private boolean addEmployee(Employee employee) {
        return this.listEmployee.add(employee);
    }

    /**
     * Gets employee roles.
     *
     * @return the employee roles
     */
    public List<String> getEmployeeRoles() {

        List<UserRoleDTO> lRolesDTO;
        lRolesDTO = authFacade.getUserRoles();


        List<String> roles = new ArrayList<>();
        for (int x = 0; x < lRolesDTO.size(); x++) {
            if (lRolesDTO.get(x).getDescription().compareToIgnoreCase("NURSE") == 0
                    || lRolesDTO.get(x).getDescription().compareToIgnoreCase("CENTER_COORDINATOR") == 0
                    || lRolesDTO.get(x).getDescription().compareToIgnoreCase("RECEPTIONIST") == 0)
                roles.add(lRolesDTO.get(x).getDescription());
        }

        return roles;
    }

    /**
     * Gets employees by role.
     *
     * @param selectionRole the selection role
     * @return the employees by role
     */
    public List<Employee> getEmployeesByRole(int selectionRole) {
        List<Employee> listTemp = new ArrayList<>();

        for (Employee employee : listEmployee) {
            if (employee instanceof Receptionist && selectionRole == 0)
                listTemp.add(employee);
            else if (employee instanceof CenterCoordinator && selectionRole == 1)
                listTemp.add(employee);
            else if (employee instanceof Nurse && selectionRole == 2)
                listTemp.add(employee);
        }

        return listTemp;

    }

    /**
     * Gets employee using email.
     *
     * @param email the email
     * @return the employee using email
     */
    public Employee getEmployeeUsingEmail(String email) {
        for (Employee employee : listEmployee)
            if (employee.getEmailAddress().equals(email))
                return employee;

        return null;
    }

    /**
     * Gets working.
     *
     * @param email the email
     * @return the working
     */
    public VaccinationCenter getWorking(String email) {
        for (Employee employee : listEmployee)
            if (employee.getEmailAddress().equals(email))
                return employee.getWorking();

        return null;
    }

    private static final String EMPLOYEE_FILE_NAME = "employee.ser";

    /**
     * Gets list employee.
     *
     * @return the list employee
     */
    public List<Employee> getListEmployee() {
        return listEmployee;
    }

}
