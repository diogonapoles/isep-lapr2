package app.domain.model;

import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import app.domain.store.*;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * The type Company.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;
    private EmployeeStore oEmployeeStore;
    private VaccinationCenterStore oVaccinationCenterStore;
    private SNSUserStore oSNSUserStore;
    private CSVReader oCSVReader;
    private Vaccine oVaccine;
    private LegacySystemData oLegacySystemData;
    private LegacySystemDataReader oLegacySystemDataReader;
    private BruteForce oBruteForce;
    private Benchmark oBenchmark;
    private FileUtils oFileUtils;



    /**
     * Instantiates a new Company.
     *
     * @param designation the designation
     */
    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.oVaccinationCenterStore = new VaccinationCenterStore();
        this.oCSVReader = new CSVReader();
        this.oLegacySystemDataReader = new LegacySystemDataReader();
        this.oLegacySystemData = new LegacySystemData();
        this.oBruteForce = new BruteForce();
        this.oBenchmark = new Benchmark();
        this.oFileUtils = new FileUtils();
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets auth facade.
     *
     * @return the auth facade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Get csv reader csv reader.
     *
     * @return the csv reader
     */
    public CSVReader getCSVReader(){return this.oCSVReader;}

    public FileUtils getFileUtils(){return this.oFileUtils;}

    public BruteForce getBruteForceAlgorithm(){return this.oBruteForce;}

    public Benchmark getBenchmarkAlgorithm(){return this.oBenchmark;}

    public Vaccine getVaccine(){return this.oVaccine;}

    public LegacySystemDataReader getLegacySystemDataReader(){return this.oLegacySystemDataReader;}

    public LegacySystemData getLegacySystemData(){return this.oLegacySystemData;}

    /**
     * Get employee store.
     *
     * @return the employee store
     */
    public EmployeeStore getEmployeeStore(){return this.oEmployeeStore;}

    /**
     * Default register.
     *
     * @param authFacade the auth facade
     */
    public void defaultRegister(AuthFacade authFacade){
        this.oEmployeeStore = new EmployeeStore(this.authFacade);
        this.oSNSUserStore = new SNSUserStore(this.authFacade);
    }

    /**
     * Get vaccination center store vaccination center store.
     *
     * @return the vaccination center store
     */
    public VaccinationCenterStore getVaccinationCenterStore(){return this.oVaccinationCenterStore;}

    /**
     * Get sns user store sns user store.
     *
     * @return the sns user store
     */
    public SNSUserStore getSNSUserStore(){return this.oSNSUserStore;}


}