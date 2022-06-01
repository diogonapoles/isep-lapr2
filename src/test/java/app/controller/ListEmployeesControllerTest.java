package app.controller;

import app.controller.administrator.ListEmployeesController;
import app.controller.administrator.RegisterEmployeeController;
import app.domain.model.systemUser.CenterCoordinator;
import app.domain.model.systemUser.Employee;
import app.domain.model.systemUser.Nurse;
import app.domain.model.systemUser.Receptionist;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListEmployeesControllerTest {
    Employee oEmployee = new Employee("joao", "987654321", "teste",
            "teste@isep.ipp.pt", "12341234"){};

    ListEmployeesController controller = new ListEmployeesController();
    RegisterEmployeeController emp = new RegisterEmployeeController();

    @Test
    public void getEmployeeRoles() {

        List<String> roles = new ArrayList<>();
        roles.add("RECEPTIONIST");
        roles.add("NURSE");
        roles.add("CENTER_COORDINATOR");

        assertEquals( roles , controller.getEmployeeRoles() );

    }
    @Test
    public void getEmployeesByRole() {

        Receptionist emp1 = new Receptionist("maria", "123456789", "tgr",
                "1120947@isep.ipp.pt", "12341234");
        Receptionist emp4 = new Receptionist("lucas", "123987669", "rua santos lessa",
                "1120985@isep.ipp.pt", "13562763");
        Nurse emp2 = new Nurse("joao", "912834739", "tigas streat",
                "1243555@isep.ipp.pt", "12345678");
        CenterCoordinator emp3 = new CenterCoordinator ("camila", "812834567", "avenida da liberdade",
                "1238146@isep.ipp.pt", "12344678");


        List<Employee> rolesReceptionist = new ArrayList<>();
        rolesReceptionist.add(emp1);
        rolesReceptionist.add(emp4);
        List<Employee> rolesNurse = new ArrayList<>();
        rolesNurse.add(emp2);
        List<Employee> rolesCoordinator = new ArrayList<>();
        rolesCoordinator.add(emp3);




        assertEquals( rolesReceptionist, controller.getEmployeesByRole(0));


    }
}