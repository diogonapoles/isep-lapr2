package app.controller.administrator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.systemUser.Employee;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.util.ArrayList;
import java.util.List;

public class DataSavesManagementController {

    private App oApp;
    private Company oCompany;

    public DataSavesManagementController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public boolean saveSNSUsers(){
        return this.oCompany.getFileUtils().saveSNSUsers(oCompany.getSNSUserStore().getSnsUserList());
    }

    public boolean saveEmployees(){
        return this.oCompany.getFileUtils().saveEmployees(oCompany.getEmployeeStore().getListEmployee());
    }

    public boolean saveVaccinationCenters(){
        return this.oCompany.getFileUtils().saveVaccinationCenters(oCompany.getVaccinationCenterStore().getVaccinationCenters());
    }

    public void readSNSUsers(){
        for (SNSUser user : oCompany.getFileUtils().readSNSUsers()){
            if (oCompany.getSNSUserStore().validateSNSUser(user.getPhoneNumber(), user.getHomeAddress(), user.getEmailAddress())){
                oCompany.getSNSUserStore().registerSNSUser(user);
            }
        }
    }

    public void readEmployees(){
        for (Employee emp : oCompany.getFileUtils().readEmployes()){
            if (oCompany.getEmployeeStore().validateEmployee(emp.getPhoneNumber(), emp.getEmailAddress(), emp.getCitizenCardNumber())){
                oCompany.getEmployeeStore().registerEmployeeFromFile(emp);
            }
        }
    }

    public void readVaccinationCenters(){
        for (VaccinationCenter center : oCompany.getFileUtils().readVaccinationCenters()){
            if (oCompany.getVaccinationCenterStore().validateVaccinationCenter(center.getEmailAddress())){
                oCompany.getVaccinationCenterStore().registerVaccinationCenter(center);
            }
        }
    }

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
