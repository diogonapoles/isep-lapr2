package app.controller.snsUser;

import app.controller.App;
import app.domain.model.*;
import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccinationProcess.VaccineSchedule;
import app.domain.model.vaccine.VaccineType;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.UserSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
    private VaccinationCenter vaccinationCenter;

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

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter){
        this.vaccinationCenter = vaccinationCenter;
    }

    public SNSUser getSNSUser(){
        UserSession session = this.oApp.getCurrentUserSession();
        return this.oApp.getCompany().getSNSUserStore().getSNSUserByEmail(session.getUserId().getEmail());
    }

    public List<VaccineType> getAvailableVaccineTypes(VaccinationCenter vaccinationCenter){
        return vaccinationCenter.getListVaccineType();
    }

    public List<Date> getAvailableTimes(VaccinationCenter vaccinationCenter, Date day){
        Date date1 = (Date) day;
        return vaccinationCenter.getAvailableSlots(vaccinationCenter, date1);
    }

    public VaccineSchedule createVaccineSchedule(SNSUser user, VaccinationCenter vaccinationCenter, VaccineType vaccineType, List<Vaccine> vaccineList, Date time){
        return vaccinationCenter.createVaccineSchedule( user, vaccineType,vaccineList, time);
    }

    public boolean addVaccineSchedule(VaccinationCenter vaccinationCenter, VaccineSchedule schedule){
        return vaccinationCenter.addVaccineSchedule(schedule);
    }

    public boolean validateVaccineSchedule(SNSUser user, VaccineType vaccineType, VaccinationCenter vaccinationCenter, Date timeSelector){
        return vaccinationCenter.validateVaccineSchedule(vaccineType, user, timeSelector);
    }

    public List<Vaccine> vaccineAge(SNSUser user, VaccineType vaccineType, VaccinationCenter vaccinationCenter) {
        return vaccinationCenter.vaccineAge(vaccineType, user);
    }

    public boolean validateAdministratedVaccines(VaccineType vaccineType, SNSUser snsUser){
        return vaccinationCenter.validateAdministratedVaccines(vaccineType, snsUser);
    }

    public VaccineAdministration ongoingVaccine(VaccineType vaccineType, SNSUser snsUser, Date date){
        return vaccinationCenter.validateOngoingVaccine(vaccineType, date);
    }

    public boolean timeSinceLastDose(VaccineAdministration administration, Date schedule){
        return vaccinationCenter.validateTimeSinceLastDose(administration, schedule);
    }

    public int calculateDaysLeftTimeSinceLastDose(Date lastDose, Date newDose){
        LocalDate d1 = lastDose.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate d2 = newDose.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (Period.between(d1, d2)).getDays();
    }

    public Date readDate(String prompt)
    {
        System.out.println("\n" + prompt);
        System.out.println("");
        System.out.println("0 - Cancel");
        do
        {
            try
            {
                String strDate = Utils.readLineFromConsole("");
                if (strDate.equals("0"))
                    return null;

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




