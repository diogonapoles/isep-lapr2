package app.domain.store;

import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine store.
 */
public class VaccineStore {

    private final List<Vaccine> listVaccine = new ArrayList<>();

    /**
     * Validate vaccine boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean validateVaccine(String name){
        for(Vaccine lv: listVaccine)
        {
            if(lv.getName().contains(name))
                return false;
        }
        return true;
    }

    /**
     * Register vaccine boolean.
     *
     * @param oVaccine the o vaccine
     * @return the boolean
     */
    public boolean registerVaccine(Vaccine oVaccine)
    {
        if(validateVaccine(oVaccine.getName()))
            return addVaccine(oVaccine);
        else
            return false;
    }


    private boolean addVaccine(Vaccine lv){ return this.listVaccine.add(lv); }

    /**
     * New vaccine vaccine.
     *
     * @param type              the type
     * @param name              the name
     * @param brand             the brand
     * @param ageGroup          the age group
     * @param doseNumber        the dose number
     * @param dosage            the dosage
     * @param timeSinceLastDose the time since last dose
     * @return the vaccine
     */
    public Vaccine newVaccine(VaccineType type, String name, String brand, String ageGroup, String doseNumber, double dosage, int timeSinceLastDose){
        return new Vaccine(type, name, brand, ageGroup, doseNumber, dosage, timeSinceLastDose);
    }

    /**
     * Get list vaccines list.
     *
     * @return the list
     */
    public List<Vaccine> getListVaccines(){
        return listVaccine;
    }

}


