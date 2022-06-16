package app.controller.nurse;

import app.controller.App;
import app.controller.ChoosingVaccinationCenterController;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccinationProcess.VaccineSchedule;
import app.domain.model.vaccine.ToxoidVaccine;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VaccineAdministrationControllerTest {

    VaccineAdministrationController controller = new VaccineAdministrationController();

    HealthcareCenter hc = new HealthcareCenter("Healthcare", 917876321, 493782,
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            10, 20, 3, 20);



    VaccineType vt = new ToxoidVaccine( "55563", "test");
    Vaccine v1 = vt.newVaccine("COVID-19 Vaccine", "Pfizer", "18-22", 2, 5, 90);


    @Test
    void getWorking() {
        App.getInstance().doLogin("nurse@lei.sem2.pt","123456");
        ChoosingVaccinationCenterController cvcc = new ChoosingVaccinationCenterController();
        cvcc.setWorking((cvcc.getVaccinationCenters().get(0)));

        assertFalse(controller.getWorking().toString().contains(hc.toString()));
        App.getInstance().doLogout();
    }

    @Test
    void getWaitingRoom() {
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        controller.setWorking(hc);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);
            hc.moveToWaitingRoom(arrival);

            List <UserArrival> expected = new ArrayList<>();
            expected.add(arrival);

            assertTrue(expected.equals(controller.getWaitingRoom()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getAvailableVaccinesForUser() {
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);

            assertTrue(controller.getAvailableVaccinesForUser(arrival).equals(vaccineList));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getVaccinationCenter() {
        controller.setWorking(hc);

        assertEquals(hc, controller.getVaccinationCenter());
    }

    @Test
    void createVaccineAdministration() {
        controller.setWorking(hc);
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);

            VaccineAdministration administration = new VaccineAdministration(arrival, v1, schedule.getTime(), hc.getRECOVERY_ROOM_TIME());

            assertEquals(administration.getVaccine(), controller.createVaccineAdministration(arrival, v1, schedule.getTime()).getVaccine());
            assertEquals(administration.getUserArrival(), controller.createVaccineAdministration(arrival, v1, schedule.getTime()).getUserArrival());
            assertEquals(administration.getVaccinationTime(), controller.createVaccineAdministration(arrival, v1, schedule.getTime()).getVaccinationTime());
            assertEquals(administration.getDoses(), controller.createVaccineAdministration(arrival, v1, schedule.getTime()).getDoses());
            assertEquals(administration.getRecoveryRoomTime(), controller.createVaccineAdministration(arrival, v1, schedule.getTime()).getRecoveryRoomTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addVaccineAdministration() {
        controller.setWorking(hc);
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);
            VaccineAdministration administration = new VaccineAdministration(arrival, v1, schedule.getTime(), hc.getRECOVERY_ROOM_TIME());

            assertEquals(controller.addVaccineAdministration(administration), true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeFromWaitingRoom() {
        controller.setWorking(hc);
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);
            VaccineAdministration administration = new VaccineAdministration(arrival, v1, schedule.getTime(), hc.getRECOVERY_ROOM_TIME());

            controller.addVaccineAdministration(administration);
            controller.removeFromWaitingRoom(arrival);
            assertEquals(hc.getWaitingRoom().contains(administration), false);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void moveToRecoveryRoom() {
        controller.setWorking(hc);
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);
            VaccineAdministration administration = new VaccineAdministration(arrival, v1, schedule.getTime(), hc.getRECOVERY_ROOM_TIME());

            controller.addVaccineAdministration(administration);
            controller.moveToRecoveryRoom(administration, v1);
            assertEquals(hc.getRecoveryRoom().contains(administration), true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void validateVaccineAdministration() {
        controller.setWorking(hc);
        List<Vaccine> vaccineList = new ArrayList<>();
        vaccineList.add(v1);
        try {
            SNSUser user = new SNSUser("Joao", "male", new SimpleDateFormat("yyyy-MM-dd").parse("2001-10-10"), "teste rua",
                    "917312423", "teste@gmail.com", "345645432", "12341234");
            VaccineSchedule schedule = new VaccineSchedule(user, vt, vaccineList, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:03"));
            UserArrival arrival = new UserArrival(user, new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-10-10 10:05"), schedule);
            VaccineAdministration administration = new VaccineAdministration(arrival, v1, schedule.getTime(), hc.getRECOVERY_ROOM_TIME());

            assertEquals(null, controller.validateVaccineAdministration(arrival, v1));
            controller.addVaccineAdministration(administration);
            controller.moveToRecoveryRoom(administration, v1);
            hc.removeFromRecoveryRoom(administration, v1);

            administration.setVaccinationTime(new Date());
            assertEquals(administration, controller.validateVaccineAdministration(arrival, v1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}