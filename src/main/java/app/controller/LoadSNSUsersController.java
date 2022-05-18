package app.controller;

import app.domain.model.CSVReader;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.VaccineType;

import java.util.List;

public class LoadSNSUsersController {
    private App oApp;
    private Company oCompany;
    private SNSUser oSNSUser;
    public List <SNSUser> oSNSUserList;

    public LoadSNSUsersController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public List<String> getCSVFileTypes(){return this.oCompany.getCSVReader().getCSVFileTypes();}

    public boolean importSNSUserCSV() {
        return this.oCompany.getSNSUserStore().importSNSUserCSV(oSNSUserList);
    }

    public boolean newCSVReader(int typeSelection, String fileLocation) {
        this.oSNSUserList = oCompany.getCSVReader().readCSVFile(typeSelection, fileLocation);
        if (this.oSNSUserList != null)
            return true;
        else
            return false;
    }

    public void clearTempArray(){
        oSNSUserList.clear();
    }
}
