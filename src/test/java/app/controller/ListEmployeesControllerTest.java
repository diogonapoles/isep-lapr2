package app.controller;

import app.domain.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListEmployeesControllerTest {
    Employee oEmployee = new Employee("joao", "987654321", "teste",
            "teste@isep.ipp.pt", "12341234"){};

    ListEmployeesController controller = new ListEmployeesController();


    @Test
    public void getEmployeeRoles() {

        List<String> roles = new ArrayList<>();
        roles.add("NURSE");
        roles.add("CENTER_COORDINATOR");
        roles.add("RECEPTIONIST");

        assertEquals( roles , controller.getEmployeeRoles() );

    }
    @Test
    public void getEmployeesByRole() {
    }
}