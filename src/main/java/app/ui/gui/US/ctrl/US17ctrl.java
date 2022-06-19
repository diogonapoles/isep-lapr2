package app.ui.gui.US.ctrl;


import app.controller.App;
import app.domain.model.Company;
import app.ui.gui.Appfx;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Us 17 ctrl.
 */
public class US17ctrl {
    private final App oApp;
    private final Company oCompany;


    /**
     * Instantiates a new Us 17 ctrl.
     */
    public US17ctrl(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }


    private List listLegacySystemData = new ArrayList<>();
    private List listSorted = new ArrayList();
    private List listTest= new ArrayList();


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
     * Sort legacy system data.
     *
     * @param listLegacySystemData the list legacy system data
     */
    public void sortLegacySystemData(List listLegacySystemData) {
        boolean ascending = false;
        int position = 0;
        this.listLegacySystemData = oCompany.getLegacySystemData().bubbleSortArrayList(listLegacySystemData, ascending, position);
        System.out.println(listLegacySystemData);

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
     * Gets name by number.
     *
     * @return the name by number
     */
    public String getNameByNumber() {
        return oCompany.getSNSUserStore().getSNSUserNameByNumber(oCompany.getLegacySystemData().getSnsUserNumber());
    }

    /**
     * Gets vaccine description.
     *
     * @return the vaccine description
     */
    public String getVaccineDescription() {
        return oCompany.getVaccine().getVaccineDescription();
    }


  /*  public int getSnsUserNumber() {
        return oCompany.getLegacySystemData().getSnsUserNumber();
    }

   */


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
