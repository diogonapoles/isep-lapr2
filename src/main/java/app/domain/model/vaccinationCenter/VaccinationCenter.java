package app.domain.model.vaccinationCenter;

import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccine.*;
import app.domain.store.UserArrivalStore;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Vaccination center.
 */
public abstract class VaccinationCenter {


    private String name;
    private Integer phoneNumber;
    private Integer faxNumber;
    private String homeAddress;
    private String emailAddress;
    private String websiteAddress;
    private Integer openingHours;
    private Integer openingMinutes;
    private Integer closingHours;
    private Integer closingMinutes;
    private Integer slotDuration;
    private Integer maxNumVaccinesPerSlot;
    private Day vaccinationDay;
    private UserArrivalStore waitingRoom;
    private List<VaccineType> listVaccineType;
    private List<Slot> listSlots;
    private List<VaccineSchedule> listSchedule;

    /**
     * Instantiates a new Vaccination center.
     *
     * @param name                  the name
     * @param phoneNumber           the phone number
     * @param faxNumber             the fax number
     * @param homeAddress           the home address
     * @param emailAddress          the email address
     * @param websiteAddress        the website address
     * @param openingHours          the opening hours
     * @param closingHours          the closing hours
     * @param slotDuration          the slot duration
     * @param maxNumVaccinesPerSlot the max num vaccines per slot
     */
    public VaccinationCenter(String name, int phoneNumber, int faxNumber, String homeAddress, String emailAddress, String websiteAddress, int openingHours, int closingHours, int slotDuration, int maxNumVaccinesPerSlot) {
        if ((name == null) || (name.isEmpty()) || (homeAddress == null) ||
                (homeAddress.isEmpty()) || (emailAddress == null) ||
                (emailAddress.isEmpty()) || (websiteAddress == null) || (websiteAddress.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");

        if (String.valueOf(phoneNumber).length() != 9)
            throw new IllegalArgumentException("Phone number must be in PT format");

        if (!emailAddress.contains("@"))
            throw new IllegalArgumentException("Not a valid e-mail address");

        if (openingHours < 0 || closingHours < 0)
            throw new IllegalArgumentException("Time can't be less than 0");
        if (openingHours > 24 || closingHours > 24)
            throw new IllegalArgumentException("You can't exceed the 24h of a day");
        if (openingHours == closingHours)
            throw new IllegalArgumentException("Opening time can't be the same as closing time");


        this.name = name;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.homeAddress = homeAddress;
        this.emailAddress = emailAddress;
        this.websiteAddress = websiteAddress;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.slotDuration = slotDuration;
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
        this.listVaccineType = new ArrayList<>();
        this.listSlots = new ArrayList<>();
        this.listSchedule = new ArrayList<>();
    }

    /**
     * Instantiates a new Vaccination center.
     */
    public VaccinationCenter() {

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets fax number.
     *
     * @return the fax number
     */
    public int getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets fax number.
     *
     * @param faxNumber the fax number
     */
    public void setFaxNumber(int faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * Gets home address.
     *
     * @return the home address
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Sets home address.
     *
     * @param homeAddress the home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets website address.
     *
     * @return the website address
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Sets website address.
     *
     * @param websiteAddress the website address
     */
    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    /**
     * Gets opening hours.
     *
     * @return the opening hours
     */
    public int getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets opening hours.
     *
     * @param openingHours the opening hours
     */
    public void setOpeningHours(int openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * Gets closing hours.
     *
     * @return the closing hours
     */
    public int getClosingHours() {
        return closingHours;
    }

    /**
     * Sets closing hours.
     *
     * @param closingHours the closing hours
     */
    public void setClosingHours(int closingHours) {
        this.closingHours = closingHours;
    }

    /**
     * Gets slot duration.
     *
     * @return the slot duration
     */
    public int getSlotDuration() {
        return slotDuration;
    }

    /**
     * Sets slot duration.
     *
     * @param slotDuration the slot duration
     */
    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    /**
     * Gets max num vaccines per slot.
     *
     * @return the max num vaccines per slot
     */
    public int getMaxNumVaccinesPerSlot() {
        return maxNumVaccinesPerSlot;
    }

    /**
     * Sets max num vaccines per slot.
     *
     * @param maxNumVaccinesPerSlot the max num vaccines per slot
     */
    public void setMaxNumVaccinesPerSlot(int maxNumVaccinesPerSlot) {
        this.maxNumVaccinesPerSlot = maxNumVaccinesPerSlot;
    }

    @Override
    public String toString() {
        return "\nname: " + name +
                "\nphoneNumber: " + phoneNumber +
                "\nfaxNumber: " + faxNumber +
                "\nhomeAddress: " + homeAddress +
                "\nemailAddress: " + emailAddress +
                "\nwebsiteAddress: " + websiteAddress +
                "\nopeningHours: " + openingHours +
                "\nclosingHours: " + closingHours +
                "\nslotDuration: " + slotDuration +
                "\nmaxNumVaccinesPerSlot: " + maxNumVaccinesPerSlot +
                "\n\n";
    }

    /**
     * To string schedule vaccine string.
     *
     * @return the string
     */
    public String toStringScheduleVaccine() {
        return "\nname: " + name +
                "\nphoneNumber: " + phoneNumber +
                "\nhomeAddress: " + homeAddress +
                "\nemailAddress: " + emailAddress +
                "\nwebsiteAddress: " + websiteAddress +
                "\n\n";
    }

    /**
     * New vaccine type vaccine type.
     *
     * @param technology  the technology
     * @param code        the code
     * @param designation the designation
     * @return the vaccine type
     */
    public VaccineType newVaccineType(int technology, String code, String designation){
        if(validateVaccineType(code))
        {
            if (technology == 0)
                return new LiveAttenuatedVaccine(code, designation);
            else if (technology == 1)
                return new InactivatedVaccine(code, designation);
            else if (technology == 2)
                return new SubunitVaccine(code, designation);
            else if (technology == 3)
                return new ToxoidVaccine(code, designation);
            else if (technology == 4)
                return new ViralVectorVaccine(code, designation);
            else if (technology == 5)
                return new mRNAVaccine(code, designation);
        }
        return null;
    }

    /**
     * Validate vaccine type boolean.
     *
     * @param code the code
     * @return the boolean
     */
    public boolean validateVaccineType(String code){
        for(VaccineType vt: listVaccineType)
        {
            if(vt.getCode().contains(code))
                return false;
        }
        return true;
    }

    /**
     * Get current outbreak vaccine type.
     *
     * @return the vaccine type
     */
    public VaccineType getCurrentOutbreak(){
        VaccineType vaccineType=listVaccineType.get(0);;
        return vaccineType;
    }

    /**
     * Register vaccine type boolean.
     *
     * @param oVaccineType the o vaccine type
     * @return the boolean
     */
    public boolean registerVaccineType(VaccineType oVaccineType)
    {
        if(validateVaccineType(oVaccineType.getCode()))
            return addVaccineType(oVaccineType);
        else
            return false;
    }

    public boolean addVaccineType(VaccineType vt){return this.listVaccineType.add(vt);}

    public boolean addVaccine(VaccineType vt, Vaccine v){return vt.addVaccine(v);}

    /**
     * Get list vaccine type list.
     *
     * @return the list
     */
    public List<VaccineType> getListVaccineType(){
        return listVaccineType;
    }


    public List<Date> getAvailableSlots(VaccinationCenter vaccinationCenter, Date day) {
        if(!this.validateScheduleDate(day))
            throw new IllegalArgumentException("Date is not valid");

        vaccinationDay = newVaccinationDay(vaccinationCenter, vaccinationDay, day);

        if(!findSlot(vaccinationDay)){
            Slot slot = new Slot(vaccinationDay);
            if(slot == null)
                throw new IllegalArgumentException("Problem with the slot");
            listSlots.add(slot);
            slot.allSlots(vaccinationDay.getDaySchedule(), vaccinationCenter.maxNumVaccinesPerSlot);
            slot.startUserSlotList();
            return slot.getAvailableSlots();
        }else{
            Slot slot = returnSlot(vaccinationDay);
            if(slot == null)
                throw new IllegalArgumentException("Problem with the slot");
            return slot.getAvailableSlots();
        }
    }


    public VaccineSchedule createVaccineSchedule(VaccinationCenter vaccinationCenter, SNSUser user, VaccineType type, Date day){
        if (day == null)
            throw new IllegalArgumentException("There was a problem registering this schedule");
        if (!findSlot(vaccinationDay))
            throw new IllegalArgumentException("There was a problem registering this schedule");
        Slot slot = returnSlot(vaccinationDay);

        slot.addSNSUserSlot(user, day);

        VaccineSchedule schedule = new VaccineSchedule(user, type, day);
        return schedule;
    }

    public boolean addVaccineSchedule(VaccineSchedule schedule){
        return listSchedule.add(schedule);
    }

    private boolean validateScheduleDate(Date day){
        LocalDate date = day.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now(ZoneId.systemDefault());

        if (date.isBefore(today)) {
            return false;
        }
        return true;
    }

    public boolean findSlot(Day vaccinationDay){
        for (Slot slot1 : listSlots) {
            if (slot1.getVaccineDay() == vaccinationDay)
                return true;
        }
        return false;
    }

    public Slot returnSlot(Day vaccinationDay){
        for (Slot slot : listSlots) {
            if (slot.getVaccineDay() == vaccinationDay)
                return slot;
        }
        return null;
    }

    public Day newVaccinationDay(VaccinationCenter vaccinationCenter,Day d1, Date day){
        for (Slot slot : listSlots) {
            if (slot.getVaccineDay() == d1)
                return vaccinationDay;
        }
        return new Day(vaccinationCenter, day, vaccinationCenter.openingHours,
                vaccinationCenter.closingHours,
                vaccinationCenter.slotDuration, vaccinationCenter.maxNumVaccinesPerSlot);
    }

    public boolean validateVaccineSchedule(SNSUser user, Date date){
        for (VaccineSchedule schedule : listSchedule) {
            if (schedule.getUser() == user && schedule.getTime() == date)
                return false;
        }
        return true;
    }

}


