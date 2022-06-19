package app.controller.receptionist;

import app.controller.App;
import app.domain.model.Company;
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

    /**
     * Instantiates a new Schedule vaccine controller.
     */
    public ScheduleVaccineController() {
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }

    /**
     * Get sns user by number sns user.
     *
     * @param snsUserNumber the sns user number
     * @return the sns user
     */
    public SNSUser getSNSUserByNumber(String snsUserNumber){
        for (SNSUser user : oCompany.getSNSUserStore().getSnsUserList()){
            if(user.getSnsUserNumber().equals(snsUserNumber))
                return user;
        }
        return null;
    }

    /**
     * Gets working.
     *
     * @return the working
     */
    public VaccinationCenter getWorking() {
        vaccinationCenter = oCompany.getEmployeeStore().getWorking(oApp.getCurrentUserSession().getUserId().getEmail());
        return vaccinationCenter;
    }


    /**
     * Validate user session boolean.
     *
     * @return the boolean
     */
    public boolean validateUserSession(){
        UserSession session = this.oApp.getCurrentUserSession();
        return session.isLoggedInWithRole(Constants.ROLE_RECEPTIONIST);
    }


    /**
     * Get available vaccine types list.
     *
     * @param vaccinationCenter the vaccination center
     * @return the list
     */
    public List<VaccineType> getAvailableVaccineTypes(VaccinationCenter vaccinationCenter){
        return vaccinationCenter.getListVaccineType();
    }

    /**
     * Get available times list.
     *
     * @param vaccinationCenter the vaccination center
     * @param day               the day
     * @return the list
     */
    public List<Date> getAvailableTimes(VaccinationCenter vaccinationCenter, Date day){
        Date date1 = (Date) day;
        return vaccinationCenter.getAvailableSlots(vaccinationCenter, date1);
    }

    /**
     * Create vaccine schedule vaccine schedule.
     *
     * @param user              the user
     * @param vaccinationCenter the vaccination center
     * @param vaccineType       the vaccine type
     * @param vaccineList       the vaccine list
     * @param time              the time
     * @return the vaccine schedule
     */
    public VaccineSchedule createVaccineSchedule(SNSUser user, VaccinationCenter vaccinationCenter, VaccineType vaccineType, List<Vaccine> vaccineList, Date time){
        return vaccinationCenter.createVaccineSchedule(user, vaccineType,vaccineList, time);
    }

    /**
     * Add vaccine schedule boolean.
     *
     * @param vaccinationCenter the vaccination center
     * @param schedule          the schedule
     * @return the boolean
     */
    public boolean addVaccineSchedule(VaccinationCenter vaccinationCenter, VaccineSchedule schedule){
        return vaccinationCenter.addVaccineSchedule(schedule);
    }

    /**
     * Validate vaccine schedule boolean.
     *
     * @param user              the user
     * @param vaccineType       the vaccine type
     * @param vaccinationCenter the vaccination center
     * @param timeSelector      the time selector
     * @return the boolean
     */
    public boolean validateVaccineSchedule(SNSUser user, VaccineType vaccineType, VaccinationCenter vaccinationCenter, Date timeSelector){
        return vaccinationCenter.validateVaccineSchedule(vaccineType, user, timeSelector);
    }

    /**
     * Vaccine age list.
     *
     * @param user              the user
     * @param vaccineType       the vaccine type
     * @param vaccinationCenter the vaccination center
     * @return the list
     */
    public List<Vaccine> vaccineAge(SNSUser user, VaccineType vaccineType, VaccinationCenter vaccinationCenter) {
        return vaccinationCenter.vaccineAge(vaccineType, user);
    }

    /**
     * Validate administrated vaccines boolean.
     *
     * @param vaccineType the vaccine type
     * @param snsUser     the sns user
     * @return the boolean
     */
    public boolean validateAdministratedVaccines(VaccineType vaccineType, SNSUser snsUser){
        return vaccinationCenter.validateAdministratedVaccines(vaccineType, snsUser);
    }

    /**
     * Ongoing vaccine vaccine administration.
     *
     * @param vaccineType the vaccine type
     * @param snsUser     the sns user
     * @param date        the date
     * @return the vaccine administration
     */
    public VaccineAdministration ongoingVaccine(VaccineType vaccineType, SNSUser snsUser, Date date){
        return vaccinationCenter.validateOngoingVaccine(vaccineType, date);
    }

    /**
     * Time since last dose boolean.
     *
     * @param administration the administration
     * @param schedule       the schedule
     * @return the boolean
     */
    public boolean timeSinceLastDose(VaccineAdministration administration, Date schedule){
        return vaccinationCenter.validateTimeSinceLastDose(administration, schedule);
    }

    /**
     * Calculate days left time since last dose int.
     *
     * @param lastDose the last dose
     * @param newDose  the new dose
     * @return the int
     */
    public int calculateDaysLeftTimeSinceLastDose(Date lastDose, Date newDose){
        LocalDate d1 = lastDose.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate d2 = newDose.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (Period.between(d1, d2)).getDays();
    }

    /**
     * Read date date.
     *
     * @param prompt the prompt
     * @return the date
     */
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


