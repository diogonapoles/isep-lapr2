package app.controller;

import app.domain.model.Employee;
import app.domain.model.HealthcareCenter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RegisterEmployeeControllerTest {

    Employee oEmployee = new Employee("maria", "123456789", "tgr",
            "tgr@gmail.com", "12341234"){};

    RegisterEmployeeController emp = new RegisterEmployeeController();

    boolean result1 = emp.newEmployee("maria", "123456789", "tgr",
            "tgr@gmail.com", "12341234", 0);
    boolean result2 = emp.newEmployee("maria", "912834737", "tigas streat",
            "tigas@gmail.com", "12345678", 0);


    @Test
    void newEmployee() {

        assertEquals(true, result1);
        assertEquals(true, result2);
        boolean result3=true;
        try{
            result3 = emp.newEmployee("maria", "123456789", "",
                    "maria@gmail.com", "12341234", 0);
        }catch (IllegalArgumentException ex){
            result3=false;
        }
        assertEquals(false, result3);


    }

    @Test
    void registerEmployee() {
        assertEquals(true, result1);
        assertEquals(true, result2);
        boolean result3=true;
        try{
            result3 = emp.newEmployee("maria", "123456789", "",
                    "maria@gmail.com", "12341234", 0);
        }catch (IllegalArgumentException ex){
            result3=false;
        }
        assertEquals(false, result3);

    }

    @Test
    void getEmployeeRoles() {
    }

    @Test
    void getEmployeeString() {
        assertEquals((String.format("Employee [name = "+ "maria"+", Phone Number = "+"123456789"+
                ", Address = "+"tgr"+", Email Address = "+"tgr@gmail.com"+
                ", Citizen Card Number = "+"12341234"+"]")),oEmployee.toString());

    }
}