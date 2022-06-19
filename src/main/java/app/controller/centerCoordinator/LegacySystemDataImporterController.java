package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;

import java.util.ArrayList;
import java.util.List;

public class LegacySystemDataImporterController {
    private final App oApp;
    private final Company oCompany;

    public LegacySystemDataImporterController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }


    private List listLegacySystemData = new ArrayList<>();
    private List listSorted = new ArrayList();



    public boolean newLegacySystemDataReader(String filePath) throws Exception {
        this.listLegacySystemData = oCompany.getLegacySystemDataReader().csvReaderLegacyData(filePath);
        if (this.listLegacySystemData != null)
            return true;
        else
            return false;
    }

    public List getListLegacySystemData() {
        return listLegacySystemData;
    }



    public List<Object> getSortAlgorithms() {
        return oCompany.getLegacySystemData().getSortAlgorithms();
    }

    public void setSortAlgorithms() {
        oCompany.getLegacySystemData().setSortAlgorithms();

    }

    public List<Object> getSortOrder() {
        return oCompany.getLegacySystemData().getSortOrder();
    }

    public void setSortOrder() {
        oCompany.getLegacySystemData().setSortOrder();

    }

    public List<Object> getSortArrivalLeaving() {
        return oCompany.getLegacySystemData().getSortArrivalLeaving();
    }

    public void setSortArrivalLeaving() {
        oCompany.getLegacySystemData().setSortArrivalLeaving();

    }



    public List sortByParameters(String sortChoice, String sortOrder, String sortArrivalLeaving, List listLegacyData) {
        listSorted =oCompany.getLegacySystemData().sortByParameters(sortChoice, sortOrder, sortArrivalLeaving, listLegacyData);
    return listSorted;
    }


    public List getLeavingList(){
        return oCompany.getLegacySystemData().getLeavingList();
    }




}
