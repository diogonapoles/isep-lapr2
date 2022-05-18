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
     * Get CSV file types list.
     *
     * @return the list
     */
    public List<String> getCSVFileTypes(){return this.oCompany.getCSVReader().getCSVFileTypes();}

    /**
     * Import SNS User CSV boolean.
     *
     * @return the boolean
     */
    public boolean importSNSUserCSV() {
        return this.oCompany.getSNSUserStore().importSNSUserCSV(oSNSUserList);
    }

    /**
     * New CSV reader boolean.
     *
     * @param typeSelection the type selection
     * @param fileLocation  the file location
     * @return the boolean
     */
    public boolean newCSVReader(int typeSelection, String fileLocation) {
        this.oSNSUserList = oCompany.getCSVReader().readCSVFile(typeSelection, fileLocation);
        if (this.oSNSUserList != null)
            return true;
        else
            return false;
    }

    /**
     * Clear temp array.
     */
    public void clearTempArray(){
        oSNSUserList.clear();
    }
}
