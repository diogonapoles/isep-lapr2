package app.domain.model;

import app.controller.App;
import app.controller.centerCoordinator.LegacySystemDataImporterController;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceTest {
    LegacySystemDataImporterController legacyController = new LegacySystemDataImporterController();

    @Test
    void createInputList() {
        try {
            legacyController.newLegacySystemDataReader("performanceDataFromGaoFuNationalCenterDoPortoVaccinationCenter.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        legacyController.sortByParameters("Bubble Sort", "Ascending", "Sort By Arrival Time", legacyController.getListLegacySystemData());

        Company company = App.getInstance().getCompany();
        BruteForce controller = new BruteForce(company);

        try {
            int timeInterval = 20;
            String startStr = "30/05/2022 08:00";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            df.setLenient(false);
            Date date = df.parse(startStr);
            int [] expected = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};


            assertArrayEquals(expected, controller.createInputList(timeInterval, date));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test
    void findDay() {
        try {
            legacyController.newLegacySystemDataReader("performanceDataFromGaoFuNationalCenterDoPortoVaccinationCenter.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        legacyController.sortByParameters("Bubble Sort", "Ascending", "Sort By Arrival Time", legacyController.getListLegacySystemData());

        Company company = App.getInstance().getCompany();
        BruteForce controller = new BruteForce(company);

        String expected = "30/05/2022";
        assertEquals(expected, controller.findDay(legacyController.getLeavingList()));
    }

    @Test
    void getListLength() {
        Company company = App.getInstance().getCompany();
        BruteForce controller = new BruteForce(company);
        int timeInterval = 20;

        assertEquals(36, controller.getListLength(timeInterval));
    }

    @Test
    void maxSubArray() {
        int [] input = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};
        int [] expected = new int[]{0, 11, 946};

        Company company = App.getInstance().getCompany();
        BruteForce controller = new BruteForce(company);

        assertArrayEquals(expected, controller.maxSubArray(input));

    }

    @Test
    void findLimit() {
        int [] nums = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};
        int maxPos = 0;
        int maxSum = 946;
        int expected = 11;
        Company company = App.getInstance().getCompany();
        BruteForce controller = new BruteForce(company);

        assertEquals(expected, controller.findLimit(nums, maxPos, maxSum));
    }
}