package app.domain.model;

import app.domain.model.vaccine.Vaccine;
import app.domain.model.vaccine.VaccineType;
import app.domain.shared.CSVReader;
import app.domain.shared.FileUtils;
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

    private VaccinatedToFile oVaccinatedToFile;
    private VaccineType vaccineType;


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
        this.oBenchmark = new Benchmark();
        this.oFileUtils = new FileUtils();
        this.vaccineType = new VaccineType();
        this.oVaccinatedToFile = new VaccinatedToFile();
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

    /**
     * Get file utils file utils.
     *
     * @return the file utils
     */
    public FileUtils getFileUtils(){return this.oFileUtils;}

    /**
     * Get brute force algorithm brute force.
     *
     * @return the brute force
     */
    public BruteForce getBruteForceAlgorithm(){return this.oBruteForce;}

    /**
     * Get benchmark algorithm benchmark.
     *
     * @return the benchmark
     */
    public Benchmark getBenchmarkAlgorithm(){return this.oBenchmark;}

    /**
     * Get vaccine vaccine.
     *
     * @return the vaccine
     */
    public Vaccine getVaccine(){return this.oVaccine;}

    /**
     * Get legacy system data reader legacy system data reader.
     *
     * @return the legacy system data reader
     */
    public LegacySystemDataReader getLegacySystemDataReader(){return this.oLegacySystemDataReader;}

    /**
     * Get legacy system data legacy system data.
     *
     * @return the legacy system data
     */
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

    /**
     * Get vaccinated to file vaccinated to file.
     *
     * @return the vaccinated to file
     */
    public VaccinatedToFile getVaccinatedToFile(){return this.oVaccinatedToFile;}

    /**
     * Get vaccine type vaccine type.
     *
     * @return the vaccine type
     */
    public VaccineType getVaccineType(){return this.vaccineType;}


}