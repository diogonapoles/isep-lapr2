package app.domain.model;

import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class VaccinatedToFile {


    private static final String SEPARATOR = "\n";
    private static final String HEADER = "Number of Fully Vaccinated Patients per Day";

    private List listVaccinated = new ArrayList<>();
    private List listFullyVaccinated = new ArrayList();



    public VaccinatedToFile() {

    }

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


    public List getFullyVaccinatedPatients() {
        for (int i = 0; i < listVaccinated.size(); i++) {
            if (Collections.frequency(listVaccinated, listVaccinated.get(i)) == 1) {
                listFullyVaccinated.add(listVaccinated.get(i));
            }
        }
        return listFullyVaccinated;
    }

    public List getListVaccinated() {
        return VaccinationCenter.getListAdministratedVaccines();
    }


    public void writeToFile(String fileName) throws Exception {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);


            listVaccinated = getListVaccinated();
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
