package app.domain.model;


import java.util.*;

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


    final int ARRIVAL_POSITION = 7;
    final int LEAVING_POSITION = 9;

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

    public LegacySystemData() {
    }

    public Date getNurseAdministrationTime() {
        return nurseAdministrationTime;
    }

    public void setNurseAdministrationTime(Date nurseAdministrationTime) {
        this.nurseAdministrationTime = nurseAdministrationTime;
    }


    public int getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(int snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Date getLeavingDateTime() {
        return leavingDateTime;
    }

    public void setLeavingDateTime(Date leavingDateTime) {
        this.leavingDateTime = leavingDateTime;
    }

    public void setSortAlgorithms() {
        listSortAlgorithms.clear();
        listSortAlgorithms.add("Bubble Sort");
        listSortAlgorithms.add("Collection Sort");
    }

    public List<Object> getSortAlgorithms() {
        return listSortAlgorithms;
    }

    public void setSortOrder() {
        listSortOrder.clear();
        listSortOrder.add("Ascending");
        listSortOrder.add("Descending");
    }

    public List<Object> getSortOrder() {
        return listSortOrder;
    }

    public void setSortArrivalLeaving() {
        listSortArrivalLeaving.clear();
        listSortArrivalLeaving.add("Sort By Arrival Time");
        listSortArrivalLeaving.add("Sort by leaving Time");
    }

    public List<Object> getSortArrivalLeaving() {
        return listSortArrivalLeaving;
    }


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

    public List<Date> getLeavingList() {
        List listLeaving = new ArrayList<>();
        for (int i = 0; i < listLegacy.size(); i++) {
            listLeaving.add(listLegacy.get(i).getLeavingDateTime());
        }
        return getListSorted(listLeaving);
    }
    public List<Date> getArrivalList() {
        List listArrival=new ArrayList();
        for (int i = 0; i < listLegacy.size(); i++) {
            listArrival.add(listLegacy.get(i).getArrivalDateTime());
        }
        return getListSorted(listArrival);
    }

    public List getListSorted(List list) {
        Collections.sort(list);
        return list;
    }


    public void getName(String name){
        this.oName=name;
    }
    public void getDescription(String description){
        this.oDescription = description;
    }


    public String toString() {
        return String.format(/*oName + ";  " + oDescription + ";  " +*/ getSnsUserNumber() + ";  " + getVaccineName() + ";  " + getDose() + ";  " + getLotNumber() + ";  " +
                getScheduledDateTime() + ";  " + getArrivalDateTime() + ";  " + getNurseAdministrationTime() + ";  " +
                getLeavingDateTime());
    }


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


    Comparator<LegacySystemData> compareByArrivalTime = new Comparator<LegacySystemData>() {
        @Override
        public int compare(LegacySystemData o1, LegacySystemData o2) {
            return o1.getArrivalDateTime().compareTo(o2.getArrivalDateTime());
        }
    };
    Comparator<LegacySystemData> compareByLeavingTime = new Comparator<LegacySystemData>() {
        @Override
        public int compare(LegacySystemData o1, LegacySystemData o2) {
            return o1.getLeavingDateTime().compareTo(o2.getLeavingDateTime());
        }
    };


}
