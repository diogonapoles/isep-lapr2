/*

package app.controller;

import app.domain.model.Company;
import app.domain.model.ScheduleVaccine;

import java.util.List;

public class ScheduleVaccineController {

        private App oApp;
        private Company oCompany;
        private ScheduleVaccine oScheduleVaccine;

    public ScheduleVaccineController(){
            this.oApp = App.getInstance();
            this.oCompany = oApp.getCompany();
        }

    public boolean newScheduleVaccine(int SNSUserNumber, String vaccinationCenter, String date, String time){
            this.oScheduleVaccine = oCompany.getScheduleVaccineStore().newScheduleVaccine(SNSUserNumber, vaccinationCenter, date, time);
            if (this.oScheduleVaccine != null){
                return true;
            }else{
                return false;
            }
        }

    public List<String> getScheduleVaccine() {return this.oCompany.getScheduleVaccineStore().listScheduleVaccine();}


    public String getScheduleVaccineString(){return this.oScheduleVaccine.toString();}


        public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}

    public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}
}
*/
