package app.domain.model;

import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The type Schedule dates.
 */
public class ScheduleDates {

    private VaccinationCenter vaccinationCenter;

    private List<Slot> slots;

    /**
     * Instantiates a new Schedule dates.
     *
     * @param vaccinationCenter the vaccination center
     */
    public ScheduleDates(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }


    /**
     * Gets difference in minutes open close.
     *
     * @param vaccinationCenter the vaccination center
     * @return the difference in minutes open close
     * @throws ParseException the parse exception
     */
    public long getDifferenceInMinutesOpenClose(VaccinationCenter vaccinationCenter) throws ParseException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String closingHours = vaccinationCenter.getClosingHours();
        String openingHours = vaccinationCenter.getOpeningHours();

        Date dateClosingHours = simpleDateFormat.parse(closingHours);
        Date dateOpeningHours = simpleDateFormat.parse(openingHours);

        long differenceInMinutes = ((Math.abs(dateOpeningHours.getTime() - dateClosingHours.getTime())) / (60 * 1000) % 60);
        return differenceInMinutes;
    }

    /**
     * Gets number available dates for day.
     *
     * @param vaccinationCenter the vaccination center
     * @param day               the day
     * @return the number available dates for day
     * @throws ParseException the parse exception
     */
    public int getNumberAvailableDatesForDay(VaccinationCenter vaccinationCenter, Date day) throws ParseException {
        int minutes = Integer.parseInt(vaccinationCenter.getSlotDuration());
        int slots = Integer.parseInt(vaccinationCenter.getMaxNumVaccinesPerSlot());

        int numberOfVaccinesToVaccinationCenter= (int) (getDifferenceInMinutesOpenClose(vaccinationCenter) % minutes);

        return numberOfVaccinesToVaccinationCenter;
    }

    /**
     * Gets number available dates for hour.
     *
     * @param vaccinationCenter the vaccination center
     * @param hour              the hour
     * @return the number available dates for hour
     * @throws ParseException the parse exception
     */
    public int getNumberAvailableDatesForHour(VaccinationCenter vaccinationCenter, Date hour) throws ParseException {
        int minutes = Integer.parseInt(vaccinationCenter.getSlotDuration());
        int slots = Integer.parseInt(vaccinationCenter.getMaxNumVaccinesPerSlot());

        int numberOfVaccinesPerHour = 60 %minutes;

        return numberOfVaccinesPerHour;
    }

    /**
     * Gets available dates for vaccine.
     *
     * @param vaccinationCenter the vaccination center
     * @param hour              the hour
     * @throws ParseException the parse exception
     */
    public void getAvailableDatesForVaccine(VaccinationCenter vaccinationCenter,Date hour) throws ParseException {
        System.out.printf(String.valueOf(hour));
        for (int x = 1; x < getNumberAvailableDatesForHour(vaccinationCenter, hour); x++) {
            System.out.println(hour+vaccinationCenter.getSlotDuration());


        }



    }
}
