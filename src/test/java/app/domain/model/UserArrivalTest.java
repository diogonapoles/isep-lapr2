/*package app.domain.model;

import app.domain.model.vaccinationCenter.CommunityCenter;
import app.domain.model.vaccinationCenter.HealthcareCenter;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationProcess.UserArrival;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

class UserArrivalTest {

    SNSUser oSnsUser = new SNSUser("maria", "feminine", new Date(21 - 10 - 2001), "avenue 32", "912663663", "maria@gmail.com",
            "12345432", "12341234") {
    };
    SNSUser oSnsUser1 = new SNSUser("teresa", "feminine", new Date(21 - 11 - 2004), "avenue 42", "912772663", "teresa@gmail.com",
            "12346432", "12341235") {
    };


    HealthcareCenter hc = new HealthcareCenter("Healthcare", 917876321, 493782,
            "TesteRua1", "teste1@gmail.com", "healthcare.com",
            10, 20, 3, 20);
    CommunityCenter cc = new CommunityCenter("Community", 917312756, 654253,
            "TesteRua2", "teste2@gmail.com", "community.com",
            8, 22, 5, 40);

    UserArrival ua = new UserArrival(oSnsUser, hc);
    UserArrival ua1 = new UserArrival(oSnsUser1,cc);


    @Test
    void getSnsUser() {
        assertEquals(oSnsUser, ua.getSnsUser());
        assertEquals(oSnsUser1, ua1.getSnsUser());

    }


    @Test
    void getVaccinationCenter() {
        assertEquals(hc,ua.getVaccinationCenter());
        assertEquals(cc,ua1.getVaccinationCenter());
    }


}*/