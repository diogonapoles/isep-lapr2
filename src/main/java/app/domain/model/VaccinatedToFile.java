package app.domain.model;

import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class VaccinatedToFile {

    private static final String DELIMITER = ";";
    private static final String SEPARATOR = "\n";
    private static final String HEADER = "Number of Fully Vaccinated Patients per Day";

    private final List list = new ArrayList<>();

    private int fullyVaccinated;

    public VaccinatedToFile(int fullyVaccinated){
        this.fullyVaccinated= fullyVaccinated;
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

    public String getFullyVaccinatedString(){
        String str = (" vaccinations fully completed");
        return str;
    }
    public int getFullyVaccinatedPatients(){
        return 5;
    }
    public List getList(){
        list.add(getFullyVaccinatedPatients()+" Users");
        list.add("10"+" Users");
        return list;
    }


    public void writeToFile(String fileName) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);

            List test;
  //          test.add("ola");
            test = getList();


            String collect = (String) test.stream().collect(Collectors.joining(SEPARATOR));
            System.out.println(HEADER + "\n");
            System.out.println(collect);

            writer.write(HEADER);
            writer.write(SEPARATOR);
            writer.write(collect);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }


    }
}
