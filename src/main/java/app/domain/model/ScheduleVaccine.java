package app.domain.model;

public class ScheduleVaccine {

    private int SNSUserNumber;
    private String vaccinationCenter;
    private String date;
    private String time;

    public ScheduleVaccine(int SNSUserNumber, String vaccinationCenter, String date, String time) {
        if((vaccinationCenter == null) || (vaccinationCenter.isEmpty()) ||
                (SNSUserNumber == 0) ||
                (date == null) || (date.isEmpty()) ||
                (time == null) || (time.isEmpty()) )
            throw new IllegalArgumentException("None of the arguments can be null or empty.");

        this.SNSUserNumber = SNSUserNumber;
        this.vaccinationCenter = vaccinationCenter;
        this.date = date;
        this.time = time;
    }

    public int getSNSUserNumber() {
        return SNSUserNumber;
    }

    public void setSNSUserNumber(int SNSUserNumber) {
        this.SNSUserNumber = SNSUserNumber;
    }

    public String getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(String vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString() {
        return "The SNS User number " + SNSUserNumber + " vaccine appointment is at " + vaccinationCenter + ", at " + time + ", of " + date + ".";
    }
}
