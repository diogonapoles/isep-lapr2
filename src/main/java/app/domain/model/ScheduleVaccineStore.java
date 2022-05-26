package app.domain.model;

import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;
import java.util.List;

public class ScheduleVaccineStore {

    private final List<ScheduleVaccine> listScheduleVaccine = new ArrayList<>();

    public ScheduleVaccineStore() {
    }

    public List<ScheduleVaccine> getListScheduleVaccine(){
        return listScheduleVaccine;
    }

 /*   public boolean newScheduleVaccine (ScheduleVaccine oScheduleVaccine)
    {
        if(validateScheduleVaccine(oScheduleVaccine.getSNSUserNumber(),oScheduleVaccine.getVaccinationCenter(),oScheduleVaccine.getDate(),oScheduleVaccine.getTime()))
            return addScheduleVaccine(oScheduleVaccine);
        else
            return false;
    }

    public boolean validateScheduleVaccine(String SNSUserNumber, String vaccinationCenter, String date, String time){
       for (ScheduleVaccine schedule: listScheduleVaccine)
                || !schedule.getSNSUserNumber().isEmpty
            ||schedule.getDate().contains(date)
            ||schedule.getVaccinationCenter().contains(vaccinationCenter)
            ||schedule.getTime().contains(time))
                    return false;
        }
        return true;
    }





    private boolean addScheduleVaccine(ScheduleVaccine shedule){return this.listScheduleVaccine.add(shedule);}
    */


}


