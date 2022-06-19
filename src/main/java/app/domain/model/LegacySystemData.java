package app.domain.model;


import java.util.*;

/**
 * The type Legacy system data.
 */
public class LegacySystemData implements Comparable<LegacySystemData> {


    private List<LegacySystemData> listLegacy = new ArrayList<>();
    private final List listLeaving = new ArrayList<>();
    private final List listArrival = new ArrayList();
    private final List<Object> listSortAlgorithms = new ArrayList<>();
    private final List<Object> listSortOrder = new ArrayList<>();
    private final List<Object> listSortArrivalLeaving = new ArrayList<>();

    private int snsUserNumber;
    private String vaccineName;
    private String dose;
    private String lotNumber;
    private Date scheduledDateTime;
    private Date arrivalDateTime;
    private Date nurseAdministrationTime;
    private Date leavingDateTime;

    private String oName;
    private String oDescription;


    /**
     * The Arrival position.
     */
    final int ARRIVAL_POSITION = 7;
    /**
     * The Leaving position.
     */
    final int LEAVING_POSITION = 9;

    /**
     * Instantiates a new Legacy system data.
     *
     * @param snsUserNumber           the sns user number
     * @param vaccineName             the vaccine name
     * @param dose                    the dose
     * @param lotNumber               the lot number
     * @param scheduledDateTime       the scheduled date time
     * @param arrivalDateTime         the arrival date time
     * @param nurseAdministrationTime the nurse administration time
     * @param leavingDateTime         the leaving date time
     */
    public LegacySystemData(int snsUserNumber, String vaccineName, String dose, String lotNumber,
                            Date scheduledDateTime, Date arrivalDateTime, Date nurseAdministrationTime, Date leavingDateTime) {
        this.snsUserNumber = snsUserNumber;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lotNumber = lotNumber;
        this.scheduledDateTime = scheduledDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.nurseAdministrationTime = nurseAdministrationTime;
        this.leavingDateTime = leavingDateTime;


    }

    /**
     * Instantiates a new Legacy system data.
     */
    public LegacySystemData() {
    }

    /**
     * Gets nurse administration time.
     *
     * @return the nurse administration time
     */
    public Date getNurseAdministrationTime() {
        return nurseAdministrationTime;
    }

    /**
     * Sets nurse administration time.
     *
     * @param nurseAdministrationTime the nurse administration time
     */
    public void setNurseAdministrationTime(Date nurseAdministrationTime) {
        this.nurseAdministrationTime = nurseAdministrationTime;
    }


    /**
     * Gets sns user number.
     *
     * @return the sns user number
     */
    public int getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Sets sns user number.
     *
     * @param snsUserNumber the sns user number
     */
    public void setSnsUserNumber(int snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    /**
     * Gets vaccine name.
     *
     * @return the vaccine name
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * Sets vaccine name.
     *
     * @param vaccineName the vaccine name
     */
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    /**
     * Gets dose.
     *
     * @return the dose
     */
    public String getDose() {
        return dose;
    }

    /**
     * Sets dose.
     *
     * @param dose the dose
     */
    public void setDose(String dose) {
        this.dose = dose;
    }

    /**
     * Gets lot number.
     *
     * @return the lot number
     */
    public String getLotNumber() {
        return lotNumber;
    }

    /**
     * Sets lot number.
     *
     * @param lotNumber the lot number
     */
    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    /**
     * Gets scheduled date time.
     *
     * @return the scheduled date time
     */
    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    /**
     * Sets scheduled date time.
     *
     * @param scheduledDateTime the scheduled date time
     */
    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    /**
     * Gets arrival date time.
     *
     * @return the arrival date time
     */
    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * Sets arrival date time.
     *
     * @param arrivalDateTime the arrival date time
     */
    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * Gets leaving date time.
     *
     * @return the leaving date time
     */
    public Date getLeavingDateTime() {
        return leavingDateTime;
    }

    /**
     * Sets leaving date time.
     *
     * @param leavingDateTime the leaving date time
     */
    public void setLeavingDateTime(Date leavingDateTime) {
        this.leavingDateTime = leavingDateTime;
    }

    /**
     * Sets sort algorithms.
     */
    public void setSortAlgorithms() {
        listSortAlgorithms.clear();
        listSortAlgorithms.add("Bubble Sort");
        listSortAlgorithms.add("Collection Sort");
    }

    /**
     * Gets sort algorithms.
     *
     * @return the sort algorithms
     */
    public List<Object> getSortAlgorithms() {
        return listSortAlgorithms;
    }

    /**
     * Sets sort order.
     */
    public void setSortOrder() {
        listSortOrder.clear();
        listSortOrder.add("Ascending");
        listSortOrder.add("Descending");
    }

    /**
     * Gets sort order.
     *
     * @return the sort order
     */
    public List<Object> getSortOrder() {
        return listSortOrder;
    }

    /**
     * Sets sort arrival leaving.
     */
    public void setSortArrivalLeaving() {
        listSortArrivalLeaving.clear();
        listSortArrivalLeaving.add("Sort By Arrival Time");
        listSortArrivalLeaving.add("Sort by leaving Time");
    }

    /**
     * Gets sort arrival leaving.
     *
     * @return the sort arrival leaving
     */
    public List<Object> getSortArrivalLeaving() {
        return listSortArrivalLeaving;
    }


    /**
     * Insertion sort.
     *
     * @param arr the arr
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
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

        boolean ascending = true;
        int position;


        if (sortChoice.equals("Bubble Sort")) {
            if (sortOrder.equals("Ascending")) {
                if (sortArrivalLeaving.equals("Sort By Arrival Time")) {
                    position = ARRIVAL_POSITION;
                } else {
                    position = LEAVING_POSITION;
                }
                listLegacy = bubbleSortArrayList(listLegacyData, ascending, position);
            } else {
                if (sortArrivalLeaving.equals("Sort By Arrival Time")) {
                    position = ARRIVAL_POSITION;
                } else {
                    position = LEAVING_POSITION;
                }
                listLegacy = bubbleSortArrayList(listLegacyData, !ascending, position);
            }


        } else if (sortOrder.equals("Ascending")) {
            if (sortArrivalLeaving.equals("Sort By Arrival Time")) {
                Collections.sort(listLegacy, compareByArrivalTime);
            } else {
                Collections.sort(listLegacy, compareByLeavingTime);
            }

        } else {
            if (sortArrivalLeaving.equals("Sort By Arrival Time")) {
                Collections.sort(listLegacy, compareByArrivalTime.reversed());
            } else {
                Collections.sort(listLegacy, compareByLeavingTime.reversed());
            }
        }


        return listLegacy;


    }

    /**
     * Gets leaving list.
     *
     * @return the leaving list
     */
    public List<Date> getLeavingList() {
        List listLeaving = new ArrayList<>();
        for (int i = 0; i < listLegacy.size(); i++) {
            listLeaving.add(listLegacy.get(i).getLeavingDateTime());
        }
        return getListSorted(listLeaving);
    }

    /**
     * Gets arrival list.
     *
     * @return the arrival list
     */
    public List<Date> getArrivalList() {
        List listArrival=new ArrayList();
        for (int i = 0; i < listLegacy.size(); i++) {
            listArrival.add(listLegacy.get(i).getArrivalDateTime());
        }
        return getListSorted(listArrival);
    }

    /**
     * Gets list sorted.
     *
     * @param list the list
     * @return the list sorted
     */
    public List getListSorted(List list) {
        Collections.sort(list);
        return list;
    }



    public String toString() {
        return String.format(/*oName + ";  " + oDescription + ";  " +*/ getSnsUserNumber() + ";  " + getVaccineName() + ";  " + getDose() + ";  " + getLotNumber() + ";  " +
                getScheduledDateTime() + ";  " + getArrivalDateTime() + ";  " + getNurseAdministrationTime() + ";  " +
                getLeavingDateTime());
    }


    /**
     * Bubble sort array list list.
     *
     * @param list      the list
     * @param ascending the ascending
     * @param position  the position
     * @return the list
     */
    public List bubbleSortArrayList(List<LegacySystemData> list, Boolean ascending, int position) {
        LegacySystemData temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int j = position; j <= position; j++) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (ascending) {
                        if (position == ARRIVAL_POSITION) {
                            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                                temp = list.get(i);
                                list.set(i, list.get(i + 1));
                                list.set(i + 1, temp);
                                sorted = false;
                            }
                        } else {
                            if (list.get(i).compareToLeaving(list.get(i + 1)) > 0) {
                                temp = list.get(i);
                                list.set(i, list.get(i + 1));
                                list.set(i + 1, temp);
                                sorted = false;
                            }
                        }
                    } else {
                        if (position == ARRIVAL_POSITION) {
                            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                                temp = list.get(i);
                                list.set(i, list.get(i + 1));
                                list.set(i + 1, temp);
                                sorted = false;
                            }
                        } else {
                            if (list.get(i).compareToLeaving(list.get(i + 1)) < 0) {
                                temp = list.get(i);
                                list.set(i, list.get(i + 1));
                                list.set(i + 1, temp);
                                sorted = false;
                            }
                        }

                    }
                }
            }
        }
        return list;
    }


    public int compareTo(LegacySystemData n) {
        int res = 0;
        if (this.arrivalDateTime.before(n.getArrivalDateTime())) {
            res = -1;
        }
        if (this.arrivalDateTime.after(n.getArrivalDateTime())) {
            res = 1;
        }


        return res;
    }

    /**
     * Compare to leaving int.
     *
     * @param n the n
     * @return the int
     */
    public int compareToLeaving(LegacySystemData n) {
        int res = 0;
        if (this.leavingDateTime.before(n.getLeavingDateTime())) {
            res = -1;
        }
        if (this.leavingDateTime.after(n.getLeavingDateTime())) {
            res = 1;
        }

        return res;
    }


    /**
     * The Compare by arrival time.
     */
    Comparator<LegacySystemData> compareByArrivalTime = new Comparator<LegacySystemData>() {
        @Override
        public int compare(LegacySystemData o1, LegacySystemData o2) {
            return o1.getArrivalDateTime().compareTo(o2.getArrivalDateTime());
        }
    };
    /**
     * The Compare by leaving time.
     */
    Comparator<LegacySystemData> compareByLeavingTime = new Comparator<LegacySystemData>() {
        @Override
        public int compare(LegacySystemData o1, LegacySystemData o2) {
            return o1.getLeavingDateTime().compareTo(o2.getLeavingDateTime());
        }
    };


}
