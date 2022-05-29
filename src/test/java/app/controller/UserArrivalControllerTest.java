package app.controller;

import app.domain.model.Employee;
import app.domain.systemUsers.SNSUser;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserArrivalControllerTest {

    SNSUser oSnsUser = new SNSUser("maria","feminine",new Date(21-10-2001),"avenue 32","avenue 1","912663663","maria@gmail.com",
           "12341234"){};

    UserArrivalController snsU = new UserArrivalController();

    boolean result1 = snsU.newUserArrival("13322453");
    boolean result2 = snsU.newUserArrival("12349776");



    @Test
    void getWorking() {
    }


    @Test
    void newUserArrival() {
    }


    @Test
    void registerUserArrival() {
        assertEquals(true, result1);
        assertEquals(true, result2);
        boolean result3=true;
        try{
            result3 = snsU.newUserArrival("133324412");
        }catch (IllegalArgumentException ex){
            result3=false;
        }
        assertEquals(false, result3);

    }


}