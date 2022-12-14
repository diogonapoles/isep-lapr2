package app.domain.model.vaccinationCenter;

import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.UserLeaving;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccinationProcess.VaccineSchedule;
import app.domain.model.vaccine.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * The type Vaccination center.
 */
public abstract class VaccinationCenter implements Serializable {

    private String name;
    private Integer phoneNumber;
    private Integer faxNumber;
    private String homeAddress;
    private String emailAddress;
    private String websiteAddress;
    private Integer openingHours;
    private Integer closingHours;
    private Integer slotDuration;
    private Integer maxNumVaccinesPerSlot;
    private Day vaccinationDay;
    private List<Day> listVaccinationDay;
    private List<VaccineType> listVaccineType;
    private List<Slot> listSlots;
    private List<VaccineSchedule> listSchedule;
    private List<UserArrival> listUserArrival;
    private List<UserLeaving> listUserLeaving;
    private List<VaccineAdministration> listAdministratedVaccines;

    private List<UserArrival> waitingRoom;
    private List<VaccineAdministration> recoveryRoom;

    private final int RECOVERY_ROOM_TIME = 1800; //seconds

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
        this.listVaccinationDay = new ArrayList<>();
        this.listUserArrival = new ArrayList<>();
        listAdministratedVaccines = new ArrayList<>();
        this.listUserLeaving = new ArrayList<>();
        this.waitingRoom = new ArrayList<>();
        this.recoveryRoom = new ArrayList<>();
    }

    /**
     * Gets recovery room time.
     *
     * @return the recovery room time
     */
    public int getRECOVERY_ROOM_TIME() {
        return RECOVERY_ROOM_TIME;
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
     * Gets vaccine technology types.
     *
     * @return the vaccine technology types
     */
    public List<String> getVaccineTechnologyTypes()
    {
        List<String> listOfVaccineType = new ArrayList<>();
        listOfVaccineType.add("Live-Attenuated Vaccine");
        listOfVaccineType.add("Inactivated Vaccine");
        listOfVaccineType.add("Subunit Vaccine");
        listOfVaccineType.add("Toxoid Vaccine");
        listOfVaccineType.add("Viral Vector Vaccine");
        listOfVaccineType.add("Messenger RNA (mRNA) Vaccine");

        return listOfVaccineType;
    }

    /**
     * New vaccine type.
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

    /**
     * Add vaccine type boolean.
     *
     * @param vt the vt
     * @return the boolean
     */
    public boolean addVaccineType(VaccineType vt){return this.listVaccineType.add(vt);}


    /**
     * Get list vaccine type list.
     *
     * @return the list
     */
    public List<VaccineType> getListVaccineType(){
        return listVaccineType;
    }


    /**
     * Gets available slots.
     *
     * @param vaccinationCenter the vaccination center
     * @param day               the day
     * @return the available slots
     */
    public List<Date> getAvailableSlots(VaccinationCenter vaccinationCenter, Date day) {
        if(!this.validateScheduleDate(day))
            throw new IllegalArgumentException("Date is not valid");

        vaccinationDay = newVaccinationDay(vaccinationCenter, day);

        if(!findSlot(vaccinationDay)){
            Slot slot = new Slot(vaccinationDay);
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


    /**
     * Create vaccine schedule vaccine schedule.
     *
     * @param user        the user
     * @param type        the type
     * @param vaccineList the vaccine list
     * @param day         the day
     * @return the vaccine schedule
     */
    public VaccineSchedule createVaccineSchedule(SNSUser user, VaccineType type, List<Vaccine> vaccineList, Date day){
        if (day == null)
            throw new IllegalArgumentException("There was a problem registering this schedule");
        if (!findSlot(vaccinationDay))
            throw new IllegalArgumentException("There was a problem registering this schedule");


        Slot slot = returnSlot(vaccinationDay);

        slot.addSNSUserSlot(user, day);

        VaccineSchedule schedule = new VaccineSchedule(user, type, vaccineList, day);
        return schedule;
    }

    /**
     * Add vaccine schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean addVaccineSchedule(VaccineSchedule schedule){
        return listSchedule.add(schedule);
    }

    private boolean validateScheduleDate(Date day){
        LocalDate date = day.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now(ZoneId.systemDefault());

        return !date.isBefore(today);
    }

    /**
     * Find slot boolean.
     *
     * @param vaccinationDay the vaccination day
     * @return the boolean
     */
    public boolean findSlot(Day vaccinationDay){
        for (Slot slot1 : listSlots) {
            if (slot1.getVaccineDay().equals(vaccinationDay))
                return true;
        }
        return false;
    }

    /**
     * Return slot slot.
     *
     * @param vaccinationDay the vaccination day
     * @return the slot
     */
    public Slot returnSlot(Day vaccinationDay){
        for (Slot slot : listSlots) {
            if (slot.getVaccineDay().equals(vaccinationDay))
                return slot;
        }
        return null;
    }

    /**
     * New vaccination day day.
     *
     * @param vaccinationCenter the vaccination center
     * @param day               the day
     * @return the day
     */
    public Day newVaccinationDay(VaccinationCenter vaccinationCenter, Date day){
        for (Day vaxDay : listVaccinationDay) {
            if (vaxDay.getDay().equals(day))
                return vaxDay;
        }
        Day newDay = new Day(vaccinationCenter, day, vaccinationCenter.openingHours,
                vaccinationCenter.closingHours,
                vaccinationCenter.slotDuration, vaccinationCenter.maxNumVaccinesPerSlot);
        listVaccinationDay.add(newDay);
        return newDay;
    }

    /**
     * Validate vaccine schedule boolean.
     *
     * @param type the type
     * @param user the user
     * @param date the date
     * @return the boolean
     */
    public boolean validateVaccineSchedule(VaccineType type, SNSUser user, Date date){
        for (VaccineSchedule schedule : listSchedule) {
            SNSUser snsUser = schedule.getUser();
            VaccineType vType = schedule.getVaccineType();
            Date scheduleDate = schedule.getTime();
            if (snsUser.equals(user) && vType.equals(type) && scheduleDate.equals(date))
                    return false;
        }
        return true;
    }

    /**
     * Find vaccine type vaccine type.
     *
     * @param code the code
     * @return the vaccine type
     */
    public VaccineType findVaccineType(String code) {
        for (VaccineType type : listVaccineType) {
            if (type.getCode().equals(code)){
                return type;
            }
        }
        throw new IllegalArgumentException("Couldn't find this vaccine type");
    }

    /**
     * Validate age group boolean.
     *
     * @param vaccine the vaccine
     * @param age     the age
     * @return the boolean
     */
    public boolean validateAgeGroup(Vaccine vaccine, int age) {
        if (vaccine.getAgeGroup(0) <= age && age <= vaccine.getAgeGroup(1))
            return true;
        throw new IllegalArgumentException("This user is not within the age for this vaccine");
    }


    /**
     * Validate time since last dose boolean.
     *
     * @param administration the administration
     * @param vaccineDate    the vaccine date
     * @return the boolean
     */
    public boolean validateTimeSinceLastDose(VaccineAdministration administration, Date vaccineDate){
        Calendar lastVaccine = Calendar.getInstance();
        Calendar newVaccine = Calendar.getInstance();

        lastVaccine.setTime(administration.getVaccinationTime());
        lastVaccine.add(Calendar.DATE, administration.getVaccine().getTimeSinceLastDose());
        newVaccine.setTime(vaccineDate);

        return lastVaccine.before(newVaccine);
    }


    /**
     * Vaccine age list.
     *
     * @param vaccineType the vaccine type
     * @param user        the user
     * @return the list
     */
    public List<Vaccine> vaccineAge(VaccineType vaccineType, SNSUser user){
        List<Vaccine> availableVaccines = new ArrayList<>();
        if(vaccineType.getListVaccines().isEmpty())
            return availableVaccines;
        for (Vaccine vaccine : vaccineType.getListVaccines()) {
            if (tookVaccine(vaccine, user)) {
                if (validateAgeGroup(vaccine, user.getAge()))
                    availableVaccines.add(vaccine);
            }
        }
        return availableVaccines;
    }

    /**
     * Took vaccine boolean.
     *
     * @param vaccine the vaccine
     * @param user    the user
     * @return the boolean
     */
    public boolean tookVaccine(Vaccine vaccine, SNSUser user){
        for (VaccineAdministration administration : administrationsForUserVaccine(vaccine, user)) {
            if (administration.getVaccine().equals(vaccine) && administration.getDoses().equals(vaccine.getDoseNumber())){
                return false;
            }
        }
        return true;
    }

    /**
     * New user arrival user arrival.
     *
     * @param snsUser the sns user
     * @return the user arrival
     */
    public UserArrival newUserArrival(SNSUser snsUser) {
        VaccineSchedule schedule = validateUserSchedule(snsUser);

        return new UserArrival(snsUser, new Date(), schedule);
    }


    private VaccineSchedule validateUserSchedule(SNSUser snsUser) {
        List<VaccineSchedule> scheduleList = scheduleForUserWithoutVaccineType(snsUser);
        List<UserArrival> arrivalList = arrivalForUser(snsUser);

        List<VaccineSchedule> tempList = new ArrayList<>();
        for (UserArrival arrival : arrivalList){
            tempList.add(arrival.getSchedule());
        }

        for (VaccineSchedule schedule : scheduleList){
            if (arrivalList.isEmpty()){
                return schedule;
            }

                for (UserArrival arrival : waitingRoom){
                    if (arrival.getSnsUser().equals(snsUser))
                        throw new IllegalArgumentException("User is already in the waiting room");
                }
                if (listUserArrival.size()+1 == listSchedule.size()) {
                    if (!tempList.contains(schedule))
                        return schedule;
                }

        }
        throw new IllegalArgumentException("There is no schedule available for this SNS user");
    }

    /**
     * Register user arrival boolean.
     *
     * @param userArrival the user arrival
     * @return the boolean
     */
    public boolean registerUserArrival(UserArrival userArrival) {
        return addUserToUserArrivalList(userArrival);
    }

    /**
     * Add user to user arrival list boolean.
     *
     * @param userArrival the user arrival
     * @return the boolean
     */
    public boolean addUserToUserArrivalList(UserArrival userArrival) {
        return this.listUserArrival.add(userArrival);
    }

    /**
     * Gets list user to waiting room.
     *
     * @return the list user to waiting room
     */
    public List<UserArrival> getListUserToWaitingRoom() {
        return waitingRoom;
    }

    /**
     * Get recovery room list.
     *
     * @return the list
     */
    public List<VaccineAdministration> getRecoveryRoom(){
        return recoveryRoom;
    }

    /**
     * Create vaccine administration vaccine administration.
     *
     * @param user    the user
     * @param vaccine the vaccine
     * @param date    the date
     * @return the vaccine administration
     */
    public VaccineAdministration createVaccineAdministration(UserArrival user, Vaccine vaccine, Date date) {
        return new VaccineAdministration(user, vaccine, date, RECOVERY_ROOM_TIME);
    }

    /**
     * Add vaccine administration boolean.
     *
     * @param vaccineAdministration the vaccine administration
     * @return the boolean
     */
    public boolean addVaccineAdministration(VaccineAdministration vaccineAdministration) {
        vaccineAdministration.addDose();
        for (VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSnsUser().equals(vaccineAdministration.getUserArrival().getSnsUser()) && administration.getVaccine().equals(vaccineAdministration.getVaccine())){
                int index = listAdministratedVaccines.indexOf(administration);
                listAdministratedVaccines.set(index, vaccineAdministration);
                return true;
            }
        }
        return listAdministratedVaccines.add(vaccineAdministration);
    }

    /**
     * Move to waiting room boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean moveToWaitingRoom(UserArrival user){
        return waitingRoom.add(user);
    }

    /**
     * Remove from waiting room boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean removeFromWaitingRoom(UserArrival user) {
        for(UserArrival arrival : waitingRoom){
            if (arrival.getSnsUser().equals(user.getSnsUser()) && arrival.getSchedule().getVaccineType().equals(user.getSchedule().getVaccineType()))
                return waitingRoom.remove(arrival);
        }
        return false;
    }

    /**
     * Move to recovery room boolean.
     *
     * @param vaccineAdministration the vaccine administration
     * @return the boolean
     */
    public boolean moveToRecoveryRoom(VaccineAdministration vaccineAdministration){
        return recoveryRoom.add(vaccineAdministration);
    }

    /**
     * Remove from recovery room boolean.
     *
     * @param vaccineAdministration the vaccine administration
     * @return the boolean
     */
    public boolean removeFromRecoveryRoom(VaccineAdministration vaccineAdministration) {
        for(VaccineAdministration administration : recoveryRoom){
            if (administration.getUserArrival().getSnsUser().equals(vaccineAdministration.getUserArrival().getSnsUser()) && administration.getVaccine().equals(vaccineAdministration.getVaccine()))

                return recoveryRoom.remove(administration);
        }
        return false;
    }

    /*public void recoveryRoomTimer(VaccineAdministration vaccineAdministration, Vaccine vaccine){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        removeFromRecoveryRoom(vaccineAdministration, vaccine);
                        listUserLeaving.add(new UserLeaving(vaccineAdministration, new Date()));
                    }
                },
                RECOVERY_ROOM_TIME
        );
    }*/

    /**
     * Validate administrated vaccines boolean.
     *
     * @param vaccineType the vaccine type
     * @param snsUser     the sns user
     * @return the boolean
     */
    public boolean validateAdministratedVaccines(VaccineType vaccineType, SNSUser snsUser){
        List <VaccineSchedule> scheduleList = scheduleForUser(vaccineType, snsUser);
        int administrations = administrationsForUser(vaccineType, snsUser);

        return scheduleList.size() == administrations;
    }

    /**
     * Gets waiting room.
     *
     * @return the waiting room
     */
    public List<UserArrival> getWaitingRoom() {
        return waitingRoom;
    }

    /**
     * Schedule for user list .
     *
     * @param vaccineType the vaccine type
     * @param snsUser     the sns user
     * @return the list
     */
    public List <VaccineSchedule> scheduleForUser(VaccineType vaccineType, SNSUser snsUser) {
        List<VaccineSchedule> scheduleList = new ArrayList<>();
        for (VaccineSchedule schedule : listSchedule) {
            if (schedule.getUser().equals(snsUser) && schedule.getVaccineType().equals(vaccineType)) {
                scheduleList.add(schedule);
            }
        }
        return scheduleList;
    }

    /**
     * Schedule for user without vaccine type list .
     *
     * @param snsUser the sns user
     * @return the list
     */
    public List <VaccineSchedule> scheduleForUserWithoutVaccineType(SNSUser snsUser) {
        List<VaccineSchedule> scheduleList = new ArrayList<>();
        for (VaccineSchedule schedule : listSchedule) {
            if (schedule.getUser().equals(snsUser)) {
                scheduleList.add(schedule);
            }
        }
        return scheduleList;
    }

    /**
     * Arrival for user list .
     *
     * @param snsUser the sns user
     * @return the list
     */
    public List <UserArrival> arrivalForUser(SNSUser snsUser) {
        List<UserArrival> arrivalList = new ArrayList<>();
        for (UserArrival arrival : listUserArrival) {
            if (arrival.getSchedule().getUser().equals(snsUser)) {
                arrivalList.add(arrival);
            }
        }
        return arrivalList;
    }

    /**
     * Administrations for user int.
     *
     * @param vaccineType the vaccine type
     * @param snsUser     the sns user
     * @return the int
     */
    public int administrationsForUser(VaccineType vaccineType, SNSUser snsUser){
        int counter=0;
        for (VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSchedule().getUser().equals(snsUser) && administration.getUserArrival().getSchedule().getVaccineType().equals(vaccineType)){
                counter = counter + administration.getDoses();
            }
        }
        return counter;
    }

    /**
     * Administrations for user vaccine list .
     *
     * @param vaccine the vaccine
     * @param snsUser the sns user
     * @return the list
     */
    public List <VaccineAdministration> administrationsForUserVaccine(Vaccine vaccine, SNSUser snsUser){
        List <VaccineAdministration> administrationList = new ArrayList<>();
        for (VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSchedule().getUser().equals(snsUser) && administration.getVaccine().equals(vaccine)){
                administrationList.add(administration);
            }
        }
        return administrationList;
    }

    /**
     * Validate vaccine administration vaccine administration.
     *
     * @param user    the user
     * @param vaccine the vaccine
     * @return the vaccine administration
     */
    public VaccineAdministration validateVaccineAdministration(SNSUser user, Vaccine vaccine) {
        for(VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSnsUser().equals(user) && administration.getVaccine().equals(vaccine)){
                administration.setVaccinationTime(new Date());
                return administration;
            }
        }
        return null;
    }

    /**
     * Gets list administrated vaccines.
     *
     * @return the list administrated vaccines
     */
    public List<VaccineAdministration> getListAdministratedVaccines() {
        return listAdministratedVaccines;
    }

    /**
     * Validate ongoing vaccine vaccine administration.
     *
     * @param vaccineType  the vaccine type
     * @param scheduleDate the schedule date
     * @return the vaccine administration
     */
    public VaccineAdministration validateOngoingVaccine(VaccineType vaccineType, Date scheduleDate){
        for (Vaccine vaccine : vaccineType.getListVaccines()) {
            for (VaccineAdministration administration : listAdministratedVaccines){
                if (administration.getVaccine().equals(vaccine) && administration.getDoses() < vaccine.getDoseNumber()){
                    return administration;
                }
            }
        }
        return null;
    }

    /**
     * Validate time interval for vaccination center boolean.
     *
     * @param timeInterval the time interval
     * @return the boolean
     */
    public boolean validateTimeIntervalForVaccinationCenter(int timeInterval) {
        return findDivisors(720).contains(timeInterval);
    }

    /**
     * Find divisors list.
     *
     * @param minutes the minutes
     * @return the list
     */
    public List<Integer> findDivisors(int minutes){
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= minutes; ++i)
            if (minutes % i == 0) {
                divisors.add(i);
                if (i != minutes / i)
                    divisors.add(minutes / i);
            }
        return divisors;
    }


    /**
     * Validate analyze performance time boolean.
     *
     * @param time the time
     * @param flag the flag
     * @return the boolean
     */
    public boolean validateAnalyzePerformanceTime(int time, boolean flag){
        if(flag){//startTime
            return openingHours<=time;
        }else{//endTime
            return closingHours>time;
        }
    }

    /**
     * Analyze performance time date.
     *
     * @param time the time
     * @param flag the flag
     * @return the date
     */
//true = start
    //false = end
    public Date analyzePerformanceTime(String time, boolean flag){
        String[] timeSplit = time.split(":");
        if(validateAnalyzePerformanceTime(Integer.parseInt(timeSplit[0]), flag)){
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
                dateFormat.setLenient(false);
                return dateFormat.parse(time);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid time:" + time);
            }
        }else{
            throw new IllegalArgumentException("You have to respect the Vaccination Center timetable (" + openingHours + "-" + closingHours + ")");
        }
    }

    /**
     * Issue notification.
     *
     * @param administration the administration
     */
    public void issueNotification(VaccineAdministration administration) {
        try {
            FileWriter myWriter = new FileWriter("notifications.txt");
            myWriter.write("The SNS user with the number " + administration.getUserArrival().getSnsUser().getSnsUserNumber() + " can now leave the recovery room");
            myWriter.close();
            System.out.println("Notification sent to the user with number " + administration.getUserArrival().getSnsUser().getSnsUserNumber());
        } catch (IOException e) {
            System.out.println("An error occurred while sending a notification to the user.");
            e.printStackTrace();
        }
    }
}


