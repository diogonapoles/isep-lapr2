package app.controller;

import app.domain.model.Company;
import app.domain.model.systemUser.Employee;
import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.util.List;

/**
 * The type Choosing vaccination center controller.
 */
public class ChoosingVaccinationCenterController{

    private App app;
    private Company company;

    /**
     * Instantiates a new Choosing vaccination center controller.
     */
    public ChoosingVaccinationCenterController(){
        this.app = App.getInstance();
        this.company = app.getCompany();
    }

    /**
     * Get vaccination centers list.
     *
     * @return the list
     */
    public List<VaccinationCenter> getVaccinationCenters(){
        return this.company.getVaccinationCenterStore().getVaccinationCenters();
    }

    /**
     * Set working.
     *
     * @param vaccinationCenter the vaccination center
     */
    public void setWorking(Object vaccinationCenter){
        String email = app.getCurrentUserSession().getUserId().getEmail();


        VaccinationCenter vc = (VaccinationCenter) vaccinationCenter;
        Employee employee = company.getEmployeeStore().getEmployeeUsingEmail(email);
        employee.setWorking(vc);
    }
}