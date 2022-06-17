package app.domain.model;

import app.domain.model.vaccinationCenter.VaccinationCenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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
        list.add(getFullyVaccinatedPatients()+DELIMITER+getFullyVaccinatedString());
        return list;
    }


    public void writeToFile(String fileName) throws IOException {
        FileWriter fileT = null;


        try {
            fileT = new FileWriter(fileName);
            //Add header
            fileT.append(HEADER);
            //Add a new line after the header
            fileT.append(SEPARATOR);
            //Iterate through bookList
            Iterator it = getList().iterator();
            while (it.hasNext()) {
                VaccinatedToFile vtf = (VaccinatedToFile) it.next();
                fileT.append((char) vtf.getFullyVaccinatedPatients());
                fileT.append(DELIMITER);
                fileT.append(vtf.getFullyVaccinatedString());
                fileT.append(SEPARATOR);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fileT.close();
        }

    }
}
