package app.domain.model;

import app.domain.systemUsers.CenterCoordinator;
import app.domain.systemUsers.Nurse;
import app.domain.systemUsers.Receptionist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class EmployeeTest {

    Nurse oEmployee1 = new Nurse("maria", "123456789", "travessa 1",
            "tgr@gmail.com", "12341234");
    Receptionist oEmployee2 = new Receptionist("tiago", "912234572", "rua 2",
            "tiago11@gmail.com", "12347623");

    CenterCoordinator oEmployee3 = new CenterCoordinator("fernando", "913434572", "avenida 3",
            "nando23@gmail.com", "12349876");

    @Test
    void getName() {
        assertEquals("maria", oEmployee1.getName());
        assertEquals("tiago", oEmployee2.getName());
        assertEquals("fernando", oEmployee3.getName());
    }

    @Test
    void setName() {
        oEmployee1.setName("tiago");
        oEmployee2.setName("fernando");
        oEmployee3.setName("maria");
        assertEquals(oEmployee1.getName(), "tiago");
        assertEquals(oEmployee2.getName(), "fernando");
        assertEquals(oEmployee3.getName(), "maria");

    }

    @Test
    void getPhoneNumber() {
        assertEquals("123456789", oEmployee1.getPhoneNumber());
        assertEquals("912234572", oEmployee2.getPhoneNumber());
        assertEquals("913434572", oEmployee3.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        oEmployee1.setPhoneNumber("913434572");
        oEmployee2.setPhoneNumber("123456789");
        oEmployee3.setPhoneNumber("912234572");
        assertEquals(oEmployee1.getPhoneNumber(), "913434572");
        assertEquals(oEmployee2.getPhoneNumber(), "123456789");
        assertEquals(oEmployee3.getPhoneNumber(), "912234572");

    }


    @Test
    void getAddress() {
        assertEquals("travessa 1", oEmployee1.getAddress());
        assertEquals("rua 2", oEmployee2.getAddress());
        assertEquals("avenida 3", oEmployee3.getAddress());
    }

    @Test
    void setAddress() {
        oEmployee1.setAddress("avenida 3");
        oEmployee2.setAddress("travessa 1");
        oEmployee3.setAddress("rua 2");
        assertEquals(oEmployee1.getAddress(), "avenida 3");
        assertEquals(oEmployee2.getAddress(), "travessa 1");
        assertEquals(oEmployee3.getAddress(), "rua 2");

    }


    @Test
    void getEmailAddress() {
        assertEquals("tgr@gmail.com", oEmployee1.getEmailAddress());
        assertEquals("tiago11@gmail.com", oEmployee2.getEmailAddress());
        assertEquals("nando23@gmail.com", oEmployee3.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        oEmployee1.setEmailAddress("nando23@gmail.com");
        oEmployee2.setEmailAddress("tgr@gmail.com");
        oEmployee3.setEmailAddress("tiago11@gmail.com");
        assertEquals(oEmployee1.getEmailAddress(), "nando23@gmail.com");
        assertEquals(oEmployee2.getEmailAddress(), "tgr@gmail.com");
        assertEquals(oEmployee3.getEmailAddress(), "tiago11@gmail.com");

    }



    @Test
    void getCitizenCardNumber() {
        assertEquals("12341234", oEmployee1.getCitizenCardNumber());
        assertEquals("12347623", oEmployee2.getCitizenCardNumber());
        assertEquals("12349876", oEmployee3.getCitizenCardNumber());
    }

    @Test
    void setCitizenCardNumber() {
        oEmployee1.setCitizenCardNumber("12349876");
        oEmployee2.setCitizenCardNumber("12341234");
        oEmployee3.setCitizenCardNumber("12347623");
        assertEquals(oEmployee1.getCitizenCardNumber(), "12349876");
        assertEquals(oEmployee2.getCitizenCardNumber(), "12341234");
        assertEquals(oEmployee3.getCitizenCardNumber(), "12347623");

    }



    @Test
    void testToString() {
        Assertions.assertEquals((String.format("Employee [name = "+ "maria"+", Phone Number = "+"123456789"+
                ", Address = "+"travessa 1"+", Email Address = "+"tgr@gmail.com"+
                ", Citizen Card Number = "+"12341234"+"]")),oEmployee1.toString());
        Assertions.assertEquals((String.format("Employee [name = "+ "tiago"+", Phone Number = "+"912234572"+
                ", Address = "+"rua 2"+", Email Address = "+"tiago11@gmail.com"+
                ", Citizen Card Number = "+"12347623"+"]")),oEmployee2.toString());
    }
}