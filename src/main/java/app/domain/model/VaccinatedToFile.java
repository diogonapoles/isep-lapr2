package app.domain.model;

import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.vaccinationProcess.VaccineAdministration;
import app.domain.model.vaccine.Vaccine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The type Vaccinated to file.
 */
public class VaccinatedToFile {


    private static final String SEPARATOR = "\n";
    private static final String HEADER = "Number of Fully Vaccinated Patients per Day";

    private List<VaccineAdministration> listVaccinated = new ArrayList<>();
    private List<VaccineAdministration> listFullyVaccinated = new ArrayList();


    /**
     * Instantiates a new Vaccinated to file.
     */
    public VaccinatedToFile() {

    }

    /**
     * Validate file name boolean.
     *
     * @param fileName the file name
     * @return the boolean
     */
    public boolean validateFileName(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }


    /**
     * Gets fully vaccinated patients.
     *
     * @return the fully vaccinated patients
     */
    public List getFullyVaccinatedPatients() {
        for (VaccineAdministration administration : listVaccinated){
            if (administration.getDoses() == administration.getVaccine().getDoseNumber()){
                listFullyVaccinated.add(administration);
            }
        }
        return listFullyVaccinated;
    }


    /**
     * Write to file.
     *
     * @param fileName                  the file name
     * @param listAdministratedVaccines the list administrated vaccines
     * @throws Exception the exception
     */
    public void writeToFile(String fileName, List<VaccineAdministration> listAdministratedVaccines) throws Exception {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);


            listVaccinated = listAdministratedVaccines;
            listFullyVaccinated = getFullyVaccinatedPatients();

            System.out.println(HEADER + "\n");
            System.out.println(listFullyVaccinated.size());
            System.out.printf(String.valueOf(listFullyVaccinated));

            writer.write(HEADER);
            writer.write(SEPARATOR+SEPARATOR);
            writer.write(listFullyVaccinated.size()+" Users Vaccinated");
            writer.write(SEPARATOR);
            writer.write(String.valueOf(listFullyVaccinated));

        } catch (Exception e) {
            throw new Exception("couldn´t write on the file");
        } finally {
            writer.close();
        }


    }
}
