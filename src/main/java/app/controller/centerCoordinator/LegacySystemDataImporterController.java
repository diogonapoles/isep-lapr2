package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;
import app.domain.model.LegacySystemData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LegacySystemDataImporterController {
    private App oApp;
    private Company oCompany;

    public LegacySystemDataImporterController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }



    public List<LegacySystemData> listLegacySystemData= new ArrayList<>();


    public boolean newLegacySystemDataReader(String filePath) throws Exception {
        //this.listLegacySystemData = oCompany.getLegacySystemDataReader().csvReaderLegacyData(filePath);
        oCompany.getLegacySystemDataReader().csvReaderLegacyData(filePath);
        if (this.listLegacySystemData != null)
            return true;
        else
            return false;
    }


    public boolean importSNSUserCSV() {
    /*    this.listLegacySystemData = oCompany.getSNSUserStore().validateTempList(listLegacySystemData);
        if (listLegacySystemData.size() > 0) {
            return this.oCompany.getSNSUserStore().importSNSUserCSV(listLegacySystemData);
        }else{
            return false;
        }

     */
        return false;
    }


    public void clearTempArray(){
        listLegacySystemData.clear();
    }


   // public List<SNSUser> getCSVUserList(){
    //    return this.listLegacySystemData;
    //}





    public void importLegacySystemDataCSV() {
    }


    public List getSortAlgorithms() {
        return oCompany.getLegacySystemData().getSortAlgorithms();
    }

    public void setSortAlgorithm(String sa) {
        String sortAlgorithm = sa;
    }
}
