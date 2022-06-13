package app.domain.model.vaccinationCenter;

import app.domain.model.systemUser.SNSUser;
import app.domain.model.vaccinationProcess.UserArrival;
import app.domain.model.vaccinationProcess.UserLeaving;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
        this.listAdministratedVaccines = new ArrayList<>();
        this.listUserLeaving = new ArrayList<>();
        this.waitingRoom = new ArrayList<>();
        this.recoveryRoom = new ArrayList<>();
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
        return listVaccineType.get(0);
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

        vaccinationDay = newVaccinationDay(vaccinationCenter, day);

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


    public VaccineSchedule createVaccineSchedule(VaccinationCenter vaccinationCenter, SNSUser user, VaccineType type, List<Vaccine> vaccineList, Date day){
        if (day == null)
            throw new IllegalArgumentException("There was a problem registering this schedule");
        if (!findSlot(vaccinationDay))
            throw new IllegalArgumentException("There was a problem registering this schedule");


        Slot slot = returnSlot(vaccinationDay);

        slot.addSNSUserSlot(user, day);

        VaccineSchedule schedule = new VaccineSchedule(user, type, vaccineList, day);
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
            if (slot1.getVaccineDay().equals(vaccinationDay))
                return true;
        }
        return false;
    }

    public Slot returnSlot(Day vaccinationDay){
        for (Slot slot : listSlots) {
            if (slot.getVaccineDay().equals(vaccinationDay))
                return slot;
        }
        return null;
    }

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

    public VaccineType findVaccineType(String code) {
        for (VaccineType type : listVaccineType) {
            if (type.getCode().equals(code)){
                return type;
            }
        }
        throw new IllegalArgumentException("Couldn't find this vaccine type");
    }

    public boolean validateAgeGroup(Vaccine vaccine, int age) {
        if (vaccine.getAgeGroup(0) <= age && age <= vaccine.getAgeGroup(1))
            return true;
        throw new IllegalArgumentException("This user is not within the age for this vaccine");
    }

    public int numberOfDoses(Vaccine vaccine, SNSUser user){
        int doses = 0;
        for (VaccineAdministration vaccines : listAdministratedVaccines){
            if (vaccines.getUserArrival().getSnsUser().equals(user) && vaccines.getVaccine().equals(vaccine)){
                doses++;
            }
        }
        return doses;
    }

    public List<VaccineSchedule> specificVaccineSchedule(Vaccine vaccine, SNSUser user){
        List <VaccineSchedule> userSchedule = new ArrayList<>();
        for (VaccineAdministration vaccines : listAdministratedVaccines){
            if (vaccines.getUserArrival().getSnsUser().equals(user) && vaccines.getVaccine().equals(vaccine)){
                userSchedule.add(vaccines.getUserArrival().getSchedule());
            }
        }
        return userSchedule;
    }

    public boolean validateTimeSinceLastDose(VaccineAdministration administration, Date vaccineDate){
        Calendar lastVaccine = Calendar.getInstance();
        Calendar newVaccine = Calendar.getInstance();

        lastVaccine.setTime(administration.getVaccinationTime());
        lastVaccine.add(Calendar.DATE, administration.getVaccine().getTimeSinceLastDose());
        newVaccine.setTime(vaccineDate);

        return lastVaccine.before(newVaccine);
    }



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

    public boolean tookVaccine(Vaccine vaccine, SNSUser user){
        for (VaccineAdministration administration : administrationsForUserVaccine(vaccine, user)) {
            if (administration.getVaccine().equals(vaccine) && administration.getDoses().equals(vaccine.getDoseNumber())){
                return false;
            }
        }
        return true;
    }

    public UserArrival newUserArrival(SNSUser snsUser, VaccinationCenter vc) {
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
/*    private VaccineSchedule validateUserSchedule(SNSUser snsUser) {
        List<VaccineSchedule> scheduleList = scheduleForUserWithoutVaccineType(snsUser);
        List<UserArrival> arrivalList = arrivalForUser(snsUser);
        for (VaccineSchedule schedule : scheduleList) {
            if (waitingRoom.isEmpty()) {
                VaccineSchedule vaccineSchedule = compareVaccineScheduleToUserArrival(schedule, arrivalList);
                if (vaccineSchedule != null)
                    return vaccineSchedule;
                throw new IllegalArgumentException("Couldn't find any schedule for this user");
            }else {
                for (UserArrival userArrival : waitingRoom) {
                    if (!userArrival.getSnsUser().equals(snsUser)) {
                        VaccineSchedule vaccineSchedule = compareVaccineScheduleToUserArrival(schedule, arrivalList);
                        if (vaccineSchedule != null)
                            return vaccineSchedule;
                        throw new IllegalArgumentException("Couldn't find any schedule for this user");
                    }
                }
                throw new IllegalArgumentException("User is already in the waiting room");
            }
        }
        throw new IllegalArgumentException("Couldn't find any schedule for this user");
    }

    private VaccineSchedule compareVaccineScheduleToUserArrival(VaccineSchedule schedule, List<UserArrival> arrivalList){
        for (UserArrival arrival : arrivalList){
            if (!arrival.getSchedule().equals(schedule)){
                return schedule;
            }
        }
        return null;
    }*/

    /**
     * Register user arrival boolean.
     *
     * @param userArrival the user arrival
     * @return the boolean
     */
    public boolean registerUserArrival(UserArrival userArrival) {
        return addUserToWaitingRoom(userArrival);
    }

    private boolean addUserToWaitingRoom(UserArrival userArrival) {
        return this.listUserArrival.add(userArrival);
    }

    public List<UserArrival> getListUserToWaitingRoom() {
        return waitingRoom;
    }

    public List<VaccineAdministration> getRecoveryRoom(){
        return recoveryRoom;
    }

    public VaccineAdministration createVaccineAdministration(UserArrival user, Vaccine vaccine, Date date) {
        return new VaccineAdministration(user, vaccine, date, RECOVERY_ROOM_TIME);
    }

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

    public boolean moveToWaitingRoom(UserArrival user){
        return waitingRoom.add(user);
    }

    public boolean removeFromWaitingRoom(UserArrival user) {
        for(UserArrival arrival : waitingRoom){
            if (arrival.getSnsUser().equals(user.getSnsUser()) && arrival.getSchedule().getVaccineType().equals(user.getSchedule().getVaccineType()))
                return waitingRoom.remove(arrival);
        }
        return false;
    }

    public boolean moveToRecoveryRoom(VaccineAdministration vaccineAdministration){
        return recoveryRoom.add(vaccineAdministration);
    }

    public boolean removeFromRecoveryRoom(VaccineAdministration vaccineAdministration, Vaccine vaccine) {
        for(VaccineAdministration administration : recoveryRoom){
            if (administration.getUserArrival().getSnsUser().equals(vaccineAdministration.getUserArrival().getSnsUser()) && administration.getVaccine().equals(vaccineAdministration.getVaccine()))
                return recoveryRoom.remove(administration);
        }
        return false;
    }

    public void recoveryRoomTimer(VaccineAdministration vaccineAdministration, Vaccine vaccine){
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
    }

    public boolean validateAdministratedVaccines(VaccineType vaccineType, SNSUser snsUser){
        List <VaccineSchedule> scheduleList = scheduleForUser(vaccineType, snsUser);
        int administrations = administrationsForUser(vaccineType, snsUser);

        if (scheduleList.size()==administrations)
            return true;
        return false;
    }

    public List <VaccineSchedule> scheduleForUser(VaccineType vaccineType, SNSUser snsUser) {
        List<VaccineSchedule> scheduleList = new ArrayList<>();
        for (VaccineSchedule schedule : listSchedule) {
            if (schedule.getUser().equals(snsUser) && schedule.getVaccineType().equals(vaccineType)) {
                scheduleList.add(schedule);
            }
        }
        return scheduleList;
    }

    public List <VaccineSchedule> scheduleForUserWithoutVaccineType(SNSUser snsUser) {
        List<VaccineSchedule> scheduleList = new ArrayList<>();
        for (VaccineSchedule schedule : listSchedule) {
            if (schedule.getUser().equals(snsUser)) {
                scheduleList.add(schedule);
            }
        }
        return scheduleList;
    }

    public List <UserArrival> arrivalForUser(SNSUser snsUser) {
        List<UserArrival> arrivalList = new ArrayList<>();
        for (UserArrival arrival : listUserArrival) {
            if (arrival.getSchedule().getUser().equals(snsUser)) {
                arrivalList.add(arrival);
            }
        }
        return arrivalList;
    }

    public int administrationsForUser(VaccineType vaccineType, SNSUser snsUser){
        int counter=0;
        for (VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSchedule().getUser().equals(snsUser) && administration.getUserArrival().getSchedule().getVaccineType().equals(vaccineType)){
                counter = counter + administration.getDoses();
            }
        }
        return counter;
    }

    public List <VaccineAdministration> administrationsForUserVaccine(Vaccine vaccine, SNSUser snsUser){
        List <VaccineAdministration> administrationList = new ArrayList<>();
        for (VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSchedule().getUser().equals(snsUser) && administration.getVaccine().equals(vaccine)){
                administrationList.add(administration);
            }
        }
        return administrationList;
    }

    public boolean validateDoses(SNSUser user, Vaccine vaccine) {
        for(VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSnsUser().equals(user)){
                if (administration.getVaccine().equals(vaccine) && administration.getDoses() >= vaccine.getDoseNumber()){
                    return false;
                }
                if (administration.getVaccine().equals(vaccine) && administration.getDoses() < vaccine.getDoseNumber()){
                    return true;
                }
            }
        }
        return true;
    }

    public VaccineAdministration validateVaccineAdministration(SNSUser user, Vaccine vaccine) {
        for(VaccineAdministration administration : listAdministratedVaccines){
            if (administration.getUserArrival().getSnsUser().equals(user) && administration.getVaccine().equals(vaccine)){
                administration.setVaccinationTime(new Date());
                return administration;
            }
        }
        return null;
    }

    public List<VaccineAdministration> getListAdministratedVaccines() {
        return listAdministratedVaccines;
    }

    public Vaccine validateOngoingVaccine(VaccineType vaccineType, SNSUser snsUser, Date scheduleDate){
        for (Vaccine vaccine : vaccineType.getListVaccines()) {
            for (VaccineAdministration administration : listAdministratedVaccines){
                if (administration.getVaccine().equals(vaccine) && administration.getDoses() < vaccine.getDoseNumber()){
                    if (validateTimeSinceLastDose(administration, scheduleDate)){
                        return vaccine;
                    }
                }
            }
        }
        return null;
    }

    public boolean validateTimeIntervalForVaccinationCenter(int timeInterval, String start, String end) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime t1 = LocalTime.parse(start, fmt);
        LocalTime t2 = LocalTime.parse(end, fmt);
        long minutes = ChronoUnit.MINUTES.between(t1, t2);

        if (findDivisors((int) minutes).contains(timeInterval))
            return true;
        return false;
    }

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


    public boolean validateAnalyzePerformanceTime(int time, boolean flag){
        if(flag){//startTime
            return openingHours<=time;
        }else{//endTime
            return closingHours>time;
        }
    }

    public List<UserArrival> getListUserArrival() {
        return listUserArrival;
    }

    public List<UserLeaving> getListUserLeaving() {
        return listUserLeaving;
    }

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
}


