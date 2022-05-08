package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee oEmployee1 = new Employee("maria", "123456789", "travessa 1",
            "tgr@gmail.com", "12341234"){};
    Employee oEmployee2 = new Employee("tiago", "912234572", "rua 2",
            "tiago11@gmail.com", "12347623"){};

    @Test
    void getName() {
        assertEquals("maria", oEmployee1.getName());
        assertEquals("tiago", oEmployee2.getName());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("123456789", oEmployee1.getPhoneNumber());
        assertEquals("912234572", oEmployee2.getPhoneNumber());
    }


    @Test
    void getAddress() {
        assertEquals("travessa 1", oEmployee1.getAddress());
        assertEquals("rua 2", oEmployee2.getAddress());
    }


    @Test
    void getEmailAddress() {
        assertEquals("tgr@gmail.com", oEmployee1.getEmailAddress());
        assertEquals("tiago11@gmail.com", oEmployee2.getEmailAddress());
    }


    @Test
    void getCitizenCardNumber() {
        assertEquals("12341234", oEmployee1.getCitizenCardNumber());
        assertEquals("12347623", oEmployee2.getCitizenCardNumber());
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