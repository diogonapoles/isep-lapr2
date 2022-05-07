package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class VaccineStore {

    private final List<Vaccine> listVaccine = new ArrayList<>();

    public boolean validateVaccine(String name){
        for(Vaccine lv: listVaccine)
        {
            if(lv.getName().contains(name))
                return false;
        }
        return true;
    }

    public boolean registerVaccine(Vaccine oVaccine)
    {
        if(validateVaccine(oVaccine.getName()))
            return addVaccine(oVaccine);
        else
            return false;
    }

    private boolean addVaccine(Vaccine lv){return this.listVaccine.add(lv);}

    public Vaccine newVaccine(String name, String brand, String ageGroup, String doseNumber, double dosage, int timeSinceLastDose){
        return new Vaccine(name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
    }

}


