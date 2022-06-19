package app.controller.centerCoordinator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LegacySystemDataImporterControllerTest {

    LegacySystemDataImporterController controller = new LegacySystemDataImporterController();
    List list = new ArrayList();

    @Test
    void newLegacySystemDataReader() {
    }

    @Test
    void getListLegacySystemData() {
    }

    @Test
    void sortLegacySystemData() {
    }

    @Test
    void getSortAlgorithms() {
        list.clear();
        list.add("Bubble Sort");
        list.add("Collection Sort");
        controller.setSortAlgorithms();
        assertEquals(list,controller.getSortAlgorithms());
    }

    @Test
    void setSortAlgorithms() {
    }

    @Test
    void getSortOrder() {
        list.clear();
        list.add("Ascending");
        list.add("Descending");
        controller.setSortOrder();
        assertEquals(list,controller.getSortOrder());
    }

    @Test
    void setSortOrder() {
    }

    @Test
    void getSortArrivalLeaving() {
        list.clear();
        list.add("Sort By Arrival Time");
        list.add("Sort by leaving Time");
        controller.setSortArrivalLeaving();
        assertEquals(list,controller.getSortArrivalLeaving());
    }

    @Test
    void setSortArrivalLeaving() {
    }

    @Test
    void sortByParameters() {
    }


    @Test
    void getLeavingList() {
    }
}