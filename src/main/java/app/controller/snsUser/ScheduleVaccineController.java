package app.controller.snsUser;

import app.controller.App;
import app.domain.model.*;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.VaccineSchedule;
import app.domain.model.vaccine.VaccineType;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.UserSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The type Schedule vaccine controller.
 */
public class ScheduleVaccineController {

    private App oApp;
    private Company oCompany;

    public ScheduleVaccineController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    public boolean validateUserSession(){
        UserSession session = this.oApp.getCurrentUserSession();
        return session.isLoggedInWithRole(Constants.ROLE_SNS_USER);
    }

    public List<VaccinationCenter> getVaccinationCenterList(){
        return this.oCompany.getVaccinationCenterStore().getVaccinationCenters();
    }

    public List<VaccineType> getAvailableVaccineTypes(VaccinationCenter vaccinationCenter){
        return vaccinationCenter.getListVaccineType();
    }

    public List<Date> getAvailableTimes(VaccinationCenter vaccinationCenter, Date day){
        Date date1 = (Date) day;
        return vaccinationCenter.getAvailableSlots(vaccinationCenter, date1);
    }

    public VaccineSchedule createVaccineSchedule(VaccinationCenter vaccinationCenter, VaccineType vaccineType, Date time){
        UserSession session = this.oApp.getCurrentUserSession();
        SNSUser user = this.oApp.getCompany().getSNSUserStore().getSNSUserByEmail(session.getUserId().getEmail());
        return vaccinationCenter.createVaccineSchedule(vaccinationCenter, user,vaccineType,time);
    }

    public boolean addVaccineSchedule(VaccinationCenter vaccinationCenter, VaccineSchedule schedule){
        return vaccinationCenter.addVaccineSchedule(schedule);
    }

    public boolean validateVaccineSchedule(VaccinationCenter vaccinationCenter, Date time){
        UserSession session = this.oApp.getCurrentUserSession();
        SNSUser user = this.oApp.getCompany().getSNSUserStore().getSNSUserByEmail(session.getUserId().getEmail());
        return vaccinationCenter.validateVaccineSchedule(user, time);
    }

    public Date readDate(String prompt)
    {
        do
        {
            try
            {
                String strDate = Utils.readLineFromConsole(prompt);
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
}


