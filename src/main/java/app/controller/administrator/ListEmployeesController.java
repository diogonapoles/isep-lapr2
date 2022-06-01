package app.controller.administrator;

import app.controller.App;
import app.domain.model.systemUser.Employee;

import java.util.List;

/**
 * The type List employees controller.
 */
public class ListEmployeesController {

    private App oApp;

    /**
     * Instantiates a new List employees controller.
     */
    public ListEmployeesController() {
        this.oApp = App.getInstance();
    }

    /**
     * Gets employee roles.
     *
     * @return the employee roles
     */
    public List<String> getEmployeeRoles() {
        return this.oApp.getCompany().getEmployeeStore().getEmployeeRoles();
    }

    /**
     * Gets employees by role.
     *
     * @param selectionRole the selection role
     * @return the employees by role
     */
    public List<Employee> getEmployeesByRole(int selectionRole) {
        return this.oApp.getCompany().getEmployeeStore().getEmployeesByRole(selectionRole);
    }
}