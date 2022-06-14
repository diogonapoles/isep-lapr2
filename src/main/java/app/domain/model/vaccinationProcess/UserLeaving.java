package app.domain.model.vaccinationProcess;

import java.io.Serializable;
import java.util.Date;

public class UserLeaving implements Serializable {

    private VaccineAdministration schedule;
    private Date leavingDate;


    public UserLeaving(VaccineAdministration administration, Date leavingDate) {
        this.leavingDate = leavingDate;
        this.schedule = administration;
    }

    public VaccineAdministration getSchedule() {
        return schedule;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }
}
