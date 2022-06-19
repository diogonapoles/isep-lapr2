package app.controller.centerCoordinator;

import app.controller.App;
import app.domain.model.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Legacy system data importer controller.
 */
public class LegacySystemDataImporterController {
    private final App oApp;
    private final Company oCompany;

    /**
     * Instantiates a new Legacy system data importer controller.
     */
    public LegacySystemDataImporterController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }


    private List listLegacySystemData = new ArrayList<>();
    private List listSorted = new ArrayList();


    /**
     * New legacy system data reader boolean.
     *
     * @param filePath the file path
     * @return the boolean
     * @throws Exception the exception
     */
    public boolean newLegacySystemDataReader(String filePath) throws Exception {
        this.listLegacySystemData = oCompany.getLegacySystemDataReader().csvReaderLegacyData(filePath);
        if (this.listLegacySystemData != null)
            return true;
        else
            return false;
    }

    /**
     * Gets list legacy system data.
     *
     * @return the list legacy system data
     */
    public List getListLegacySystemData() {
        return listLegacySystemData;
    }


    /**
     * Gets sort algorithms.
     *
     * @return the sort algorithms
     */
    public List<Object> getSortAlgorithms() {
        return oCompany.getLegacySystemData().getSortAlgorithms();
    }

    /**
     * Sets sort algorithms.
     */
    public void setSortAlgorithms() {
        oCompany.getLegacySystemData().setSortAlgorithms();

    }

    /**
     * Gets sort order.
     *
     * @return the sort order
     */
    public List<Object> getSortOrder() {
        return oCompany.getLegacySystemData().getSortOrder();
    }

    /**
     * Sets sort order.
     */
    public void setSortOrder() {
        oCompany.getLegacySystemData().setSortOrder();

    }

    /**
     * Gets sort arrival leaving.
     *
     * @return the sort arrival leaving
     */
    public List<Object> getSortArrivalLeaving() {
        return oCompany.getLegacySystemData().getSortArrivalLeaving();
    }

    /**
     * Sets sort arrival leaving.
     */
    public void setSortArrivalLeaving() {
        oCompany.getLegacySystemData().setSortArrivalLeaving();

    }


    /**
     * Sort by parameters list.
     *
     * @param sortChoice         the sort choice
     * @param sortOrder          the sort order
     * @param sortArrivalLeaving the sort arrival leaving
     * @param listLegacyData     the list legacy data
     * @return the list
     */
    public List sortByParameters(String sortChoice, String sortOrder, String sortArrivalLeaving, List listLegacyData) {
        listSorted =oCompany.getLegacySystemData().sortByParameters(sortChoice, sortOrder, sortArrivalLeaving, listLegacyData);
    return listSorted;
    }


    /**
     * Get leaving list list.
     *
     * @return the list
     */
    public List getLeavingList(){
        return oCompany.getLegacySystemData().getLeavingList();
    }




}
