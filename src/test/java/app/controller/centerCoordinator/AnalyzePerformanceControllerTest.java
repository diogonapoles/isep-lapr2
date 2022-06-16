package app.controller.centerCoordinator;

import app.controller.App;
import app.controller.ChoosingVaccinationCenterController;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzePerformanceControllerTest {

    AnalyzePerformanceController controller = new AnalyzePerformanceController();

    HealthcareCenter hc = new HealthcareCenter("Healthcare", 917876321, 493782,
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            10, 20, 3, 20);

    LegacySystemDataImporterController legacyController = new LegacySystemDataImporterController();

    @Test
    void getWorking() {
        App.getInstance().doLogin("coordinator@lei.sem2.pt","123456");
        ChoosingVaccinationCenterController cvcc = new ChoosingVaccinationCenterController();
        cvcc.setWorking((cvcc.getVaccinationCenters().get(0)));

        assertFalse(controller.getWorking().toString().contains(hc.toString()));
        App.getInstance().doLogout();
    }

    @Test
    void validateTimeIntervalForVaccinationCenter() {
        controller.setWorking(hc);
        int timeIntervalTrue = 20;
        int timeIntervalFalse = 21;

        assertEquals(true, controller.validateTimeIntervalForVaccinationCenter(timeIntervalTrue));
        assertEquals(false, controller.validateTimeIntervalForVaccinationCenter(timeIntervalFalse));
    }

    @Test
    void createInputList() {
        try {
            legacyController.newLegacySystemDataReader("performanceDataFromGaoFuNationalCenterDoPortoVaccinationCenter.csv");
            legacyController.sortByParameters("Bubble Sort", "Ascending", "Sort By Arrival Time", legacyController.getListLegacySystemData());

            int timeInterval = 20;
            String day = "30/05/2022";
            int [] expected = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};


            assertArrayEquals(expected, controller.createInputList(timeInterval, day));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMaxSubArrayBruteForce() {
        int [] input = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};
        int [] expected = new int[]{0, 11, 946};

        assertArrayEquals(expected, controller.getMaxSubArrayBruteForce(input));
    }

    @Test
    void findDay() {
        try {
            legacyController.newLegacySystemDataReader("performanceDataFromGaoFuNationalCenterDoPortoVaccinationCenter.csv");
            legacyController.sortByParameters("Bubble Sort", "Ascending", "Sort By Arrival Time", legacyController.getListLegacySystemData());


            String day = "30/05/2022";


            assertEquals(day, controller.findDay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void stringToFullDate() {
        try{
            String strDate = "30/05/2022 08:00";
            String strDateException = "3312352";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            df.setLenient(false);
            Date expected = df.parse(strDate);

            assertEquals(expected, controller.stringToFullDate(strDate));
            assertEquals(null, controller.stringToFullDate(strDateException));
        } catch (
        ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getMaxSubArrayBenchmark() {
        int [] input = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};
        int [] expected = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39};

        assertArrayEquals(expected, controller.getMaxSubArrayBenchmark(input));
    }

    @Test
    void getMaxSumBruteBenchmark() {
        int [] input = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39};
        int expected = 946;

        assertEquals(expected, controller.getMaxSumBenchmark(input));
    }

    @Test
    void findMaxSubarray() {
        int [] input = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39, -98, -278, -151, -53, -43, 38, 117, 204, 116, 70, 55, 11, 10, -15, -14, -118, -244, -4, 83, 222, 12, -8, -69, -117, -255};
        int [] expected = new int[]{171, 160, 105, 190, 107, 36, 33, 0, 47, 58, 39};

        assertArrayEquals(expected, controller.findMaxSubarray(input, 0, 11));
    }

    @Test
    void findTimeInterval() {
        String day = "30/05/2022";
        int timeInterval = 20;
        int i = 0;
        int length = 11;
        String expected = "[30/05/2022 08:00, 30/05/2022 11:40]";

        assertEquals(expected, controller.findTimeInterval(day,timeInterval, i, length));
    }
}