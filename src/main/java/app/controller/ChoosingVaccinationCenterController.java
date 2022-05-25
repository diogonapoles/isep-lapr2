package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.VaccinationCenter;

import java.util.List;

public class ChoosingVaccinationCenterController{

    private App app;
    private Company company;

    public ChoosingVaccinationCenterController(){
        this.app = App.getInstance();
        this.company = app.getCompany();
    }

    public List<VaccinationCenter> getVaccinationCenters(){
        return this.company.getVaccinationCenterStore().getVaccinationCenters();
    }

    public void setWorking(Object vaccinationCenter){
        String email = app.getCurrentUserSession().getUserId().getEmail();


        VaccinationCenter vc = (VaccinationCenter) vaccinationCenter;
        Employee employee = company.getEmployeeStore().getEmployeeUsingEmail(email);
        employee.setWorking(vc);
    }
}