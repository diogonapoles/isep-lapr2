package app.domain.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public CSVReader() {}

    public List<String> getCSVFileTypes()
    {
        List<String> listOfVaccinationCenter = new ArrayList<>();
        listOfVaccinationCenter.add("Has a header");
        listOfVaccinationCenter.add("Doesn't have a header");

        return listOfVaccinationCenter;
    }

    public List <SNSUser> readCSVFile(int typeSelection, String fileLocation) {
        List<SNSUser> tempSave = new ArrayList<>();
        String line = "";
        String splitBy;
        if(typeSelection == 0){
            splitBy = ";";
        }else{
            splitBy = ";";
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));

            if (typeSelection == 0){br.readLine();}

            while ((line = br.readLine()) != null) {
                String[] SNSUser = line.split(splitBy);
                System.out.println("SNSUser[Name=" + SNSUser[0] + ", Gender=" + SNSUser[1] + ", Birth Date=" + SNSUser[2] + ", Home Address= " + SNSUser[3] + ", Phone Number= " + SNSUser[4] + ", E-Mail Address= " + SNSUser[5] + ", SNS User Number= " + SNSUser[6] + ", Citizen Card Number= " + SNSUser[7] +"]");
                SNSUser tempUser = new SNSUser(SNSUser[0], SNSUser[1], SNSUser[2], SNSUser[3], SNSUser[4], SNSUser[5], SNSUser[6], SNSUser[7]);
                tempSave.add(tempUser);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        if (tempSave != null)
            return tempSave;
        else
            return null;
    }
}
