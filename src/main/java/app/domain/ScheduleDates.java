package app.domain;

import app.domain.model.VaccinationCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ScheduleDates {

    private VaccinationCenter vaccinationCenter;

    private List<Slot> slots;

    public ScheduleDates(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }



    public long getDifferenceInMinutesOpenClose(VaccinationCenter vaccinationCenter) throws ParseException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String closingHours = vaccinationCenter.getClosingHours();
        String openingHours = vaccinationCenter.getOpeningHours();

        Date dateClosingHours = simpleDateFormat.parse(closingHours);
        Date dateOpeningHours = simpleDateFormat.parse(openingHours);

        long differenceInMinutes = ((Math.abs(dateOpeningHours.getTime() - dateClosingHours.getTime())) / (60 * 1000) % 60);
        return differenceInMinutes;
    }

    public int getNumberAvailableDatesForDay(VaccinationCenter vaccinationCenter, Date day) throws ParseException {
        int minutes = Integer.parseInt(vaccinationCenter.getSlotDuration());
        int slots = Integer.parseInt(vaccinationCenter.getMaxNumVaccinesPerSlot());

        int numberOfVaccinesToVaccinationCenter= (int) (getDifferenceInMinutesOpenClose(vaccinationCenter) % minutes);

        return numberOfVaccinesToVaccinationCenter;
    }
    public int getNumberAvailableDatesForHour(VaccinationCenter vaccinationCenter, Date hour) throws ParseException {
        int minutes = Integer.parseInt(vaccinationCenter.getSlotDuration());
        int slots = Integer.parseInt(vaccinationCenter.getMaxNumVaccinesPerSlot());

        int numberOfVaccinesPerHour = 60 %minutes;

        return numberOfVaccinesPerHour;
    }

    public void getAvailableDatesForVaccine(VaccinationCenter vaccinationCenter,Date hour) throws ParseException {
        System.out.printf(String.valueOf(hour));
        for (int x = 1; x < getNumberAvailableDatesForHour(vaccinationCenter, hour); x++) {
            System.out.println(hour+vaccinationCenter.getSlotDuration());


        }



    }
}
