/*package app.controller;

import app.controller.receptionist.UserArrivalController;
import app.domain.model.vaccinationCenter.CommunityCenter;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationProcess.ScheduleVaccine;
import app.domain.model.vaccine.ToxoidVaccine;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import app.domain.model.vaccine.mRNAVaccine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserArrivalControllerTest {

    SNSUser oSnsUser = new SNSUser("maria","feminine",new Date(21-10-2001),"avenue 32","912663663","maria@gmail.com",
            "12345432","12341234"){};


    UserArrivalController snsU = new UserArrivalController();
    HealthcareCenter hc = new HealthcareCenter("Healthcare", 917876321, 493782,
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            10, 20, 3, 20);
    CommunityCenter cc = new CommunityCenter("Community", 917312756, 654253,
            "TesteRua2", "teste2@gmail.com", "community.com",
            8, 22, 5, 40);

    VaccineType vt = new ToxoidVaccine( "55563", "test");
    VaccineType vt1 = new mRNAVaccine( "56663", "test1");

    Vaccine v1 = vt.newVaccine("COVID-19 Vaccine", "Pfizer", "18-22", "2", 5, 90);
    Vaccine v2 = vt1.newVaccine("FLU Vaccine", "Pfizer", "10-45", "1", 5, 180);

    ScheduleVaccine sv = new ScheduleVaccine("12112121", hc, v1, new Date());
    ScheduleVaccine sv1 = new ScheduleVaccine("12112122", cc, v2, new Date());

    //boolean result1 = snsU.newUserArrival("13322453");
    //boolean result2 = snsU.newUserArrival("12349776");
    List<ScheduleVaccine> listScheduleVaccine = new ArrayList<>();

    public List<ScheduleVaccine> getListScheduleVaccine() {
        listScheduleVaccine.add(sv);
        listScheduleVaccine.add(sv1);
        return listScheduleVaccine;
    }

    @Test
    void getWorking() {
        App.getInstance().doLogin("receptionist@lei.sem2.pt","123456");
        ChoosingVaccinationCenterController cvcc = new ChoosingVaccinationCenterController();
        cvcc.setWorking((cvcc.getVaccinationCenters().get(0)));

        assertFalse(snsU.getWorking().toString().contains(hc.toString()));
        App.getInstance().doLogout();
    }


    @Test
    void registerUserArrival() {
       // assertEquals(true,userArrival);
    }

    @Test
    void getSNSUserByNumber() {
        SNSUser user = new SNSUser("maria","feminine",new Date(21-10-2001),"avenue 32","912663663","maria@gmail.com",
                "12345432","12341234"){};
        String userNumber = "12345432";
        String snsUserNumber = "12345432";
        String snsUserNumber1 = "12234321";

        assertEquals(true, userNumber.equals(snsUserNumber));
        assertEquals(false, userNumber.equals(snsUserNumber1));
    }



    @Test
    void newUserArrival() {
        getListScheduleVaccine();
        boolean result3=true;
        try{
            result3 = snsU.newUserArrival(new SNSUser("maria","feminine",new Date(21-10-2001),"avenue 32","912663663","maria@gmail.com",
                    "12345432","12341234"), sv.getVaccinationCenter());
        }catch (IllegalArgumentException ex){
            result3=false;
        }
        assertEquals(false, result3);

    }


}*/