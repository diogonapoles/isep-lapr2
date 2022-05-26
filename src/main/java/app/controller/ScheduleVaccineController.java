package app.controller;

import app.domain.model.Company;
import app.domain.model.ScheduleVaccine;

import java.util.List;

/**
 * The type Schedule vaccine controller.
 */
public class ScheduleVaccineController {
/*
        private App oApp;
        private Company oCompany;
        private ScheduleVaccine oScheduleVaccine;

    /**
     * Instantiates a new Schedule vaccine controller.
     */
    public ScheduleVaccineController(){
            this.oApp = App.getInstance();
            this.oCompany = oApp.getCompany();
        }

    /**
     * New schedule vaccine boolean.
     *
     * @param SNSUserNumber     the sns user number
     * @param vaccinationCenter the vaccination center
     * @param date              the date
     * @param time              the time
     * @return the boolean
     */
    public boolean newScheduleVaccine(int SNSUserNumber, String vaccinationCenter, String date, String time){
            this.oScheduleVaccine = oCompany.getScheduleVaccineStore().newScheduleVaccine(SNSUserNumber, vaccinationCenter, date, time);
            if (this.oScheduleVaccine != null){
                return true;
            }else{
                return false;
            }
        }

    /**
     * Gets schedule vaccine.
     *
     * @return the schedule vaccine
     */
    public List<String> getScheduleVaccine() {return this.oCompany.getScheduleVaccineStore().listScheduleVaccine();}

    /**
     * Get schedule vaccine string string.
     *
     * @return the string
     */
    public String getScheduleVaccineString(){return this.oScheduleVaccine.toString();}

<<<<<<< Updated upstream
        public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}


 */
}
=======
    /**
     * New schedule vaccine boolean.
     *
     * @return the boolean
     */
    public boolean newScheduleVaccine(){return this.oCompany.getScheduleVaccineStore().newScheduleVaccine(oScheduleVaccine);}
}
*/
>>>>>>> Stashed changes
