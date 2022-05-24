package app.controller;

import app.domain.model.CSVReader;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.VaccineType;

import java.util.List;

/**
 * The type Load sns users controller.
 */
public class LoadSNSUsersController {
    private App oApp;
    private Company oCompany;
    private SNSUser oSNSUser;
    public List <SNSUser> oSNSUserList;

    /**
     * Instantiates a new Load sns users controller.
     */
    public LoadSNSUsersController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * New CSV reader boolean.
     *
     * @param fileLocation  the file location
     * @return the boolean
     */
    public boolean newCSVReader(String fileLocation) {
        this.oSNSUserList = oCompany.getCSVReader().readCSVFile(fileLocation);
        if (this.oSNSUserList != null)
            return true;
        else
            return false;
    }

    /**
     * Clear temp array.
     */


    public boolean importSNSUserCSV() {
        this.oSNSUserList = oCompany.getSNSUserStore().validateTempList(oSNSUserList);
        if (oSNSUserList.size() > 0) {
            return this.oCompany.getSNSUserStore().importSNSUserCSV(oSNSUserList);
        }else{
            return false;
        }
    }

    public void clearTempArray(){
        oSNSUserList.clear();
    }

    public String getCSVFileString(){
        return this.oSNSUserList.toString();
    }
}
