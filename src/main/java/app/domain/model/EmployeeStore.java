package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    private List<Employee> listEmployee = new ArrayList<>();

    public Employee newEmployee(String name, String phoneNumber, String address,
                                String emailaddress, int citizenCardNumber ){

       

        return null;
    }

    private Boolean addEmployee(Employee employee){return  this.listEmployee.add(employee);}

    public boolean validateEmployee(Employee employee){
        for (Employee count : listEmployee){
            if (count.equals(employee))
                return false;
        }
        return true;
    }

    public List<String> getRoles(){
        List<String> rolesList = new ArrayList<>();
        rolesList.add("Nurse");
        rolesList.add("CenterCoordinator");
        rolesList.add("Receptionist");

        return rolesList;
    }




}
