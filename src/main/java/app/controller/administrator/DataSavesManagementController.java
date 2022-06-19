package app.controller.administrator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.Employee;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Data saves management controller.
 */
public class DataSavesManagementController {

    private App oApp;
    private Company oCompany;

    /**
     * Instantiates a new Data saves management controller.
     */
    public DataSavesManagementController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * Save sns users boolean.
     *
     * @return the boolean
     */
    public boolean saveSNSUsers(){
        return this.oCompany.getFileUtils().saveSNSUsers(oCompany.getSNSUserStore().getSnsUserList());
    }

    /**
     * Save employees boolean.
     *
     * @return the boolean
     */
    public boolean saveEmployees(){
        return this.oCompany.getFileUtils().saveEmployees(oCompany.getEmployeeStore().getListEmployee());
    }

    /**
     * Save vaccination centers boolean.
     *
     * @return the boolean
     */
    public boolean saveVaccinationCenters(){
        return this.oCompany.getFileUtils().saveVaccinationCenters(oCompany.getVaccinationCenterStore().getVaccinationCenters());
    }

    /**
     * Read sns users.
     */
    public void readSNSUsers(){
        for (SNSUser user : oCompany.getFileUtils().readSNSUsers()){
            if (oCompany.getSNSUserStore().validateSNSUser(user.getPhoneNumber(), user.getHomeAddress(), user.getEmailAddress())){
                oCompany.getSNSUserStore().registerSNSUser(user);
            }
        }
    }

    /**
     * Read employees.
     */
    public void readEmployees(){
        for (Employee emp : oCompany.getFileUtils().readEmployes()){
            if (oCompany.getEmployeeStore().validateEmployee(emp.getPhoneNumber(), emp.getEmailAddress(), emp.getCitizenCardNumber())){
                oCompany.getEmployeeStore().registerEmployeeFromFile(emp);
            }
        }
    }

    /**
     * Read vaccination centers.
     */
    public void readVaccinationCenters(){
        for (VaccinationCenter center : oCompany.getFileUtils().readVaccinationCenters()){
            if (oCompany.getVaccinationCenterStore().validateVaccinationCenter(center.getEmailAddress())){
                oCompany.getVaccinationCenterStore().registerVaccinationCenter(center);
            }
        }
    }

    /**
     * Available options list.
     *
     * @return the list
     */
    public List<String> availableOptions(){
        List<String> availableOptions = new ArrayList<>();
        availableOptions.add("Save SNS Users data to a file");
        availableOptions.add("Save Employees data to a file");
        availableOptions.add("Save Vaccination Centers data to a file");
        availableOptions.add("Import SNS Users data");
        availableOptions.add("Import Employees data");
        availableOptions.add("Import Vaccination Centers data");

        return availableOptions;
    }
}
