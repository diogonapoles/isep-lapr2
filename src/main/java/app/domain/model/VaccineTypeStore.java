package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine type store.
 */
public class VaccineTypeStore {
    private final List<VaccineType> listVaccineType = new ArrayList<>();

    /**
     * Instantiates a new Vaccine type store.
     */
    public VaccineTypeStore() {
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

    private boolean addVaccineType(VaccineType vt){return this.listVaccineType.add(vt);}

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
}
