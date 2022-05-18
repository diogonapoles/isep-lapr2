package app.domain.model;

import java.io.*;
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
        if (validateHeader(typeSelection, fileLocation)) {
            if (typeSelection == 0) {
                splitBy = ";";
            } else {
                splitBy = ",";
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileLocation));

                if (typeSelection == 0) {
                    br.readLine();
                }

                while ((line = br.readLine()) != null) {
                    String[] SNSUser = line.split(splitBy);
                    System.out.println("SNSUser[Name=" + SNSUser[0] + ", Gender=" + SNSUser[1] + ", Birth Date=" + SNSUser[2] + ", Home Address= " + SNSUser[3] + ", Phone Number= " + SNSUser[4] + ", E-Mail Address= " + SNSUser[5] + ", SNS User Number= " + SNSUser[6] + ", Citizen Card Number= " + SNSUser[7] + "]");
                    SNSUser tempUser = new SNSUser(SNSUser[0], SNSUser[1], SNSUser[2], SNSUser[3], SNSUser[4], SNSUser[5], SNSUser[6], SNSUser[7]);
                    tempSave.add(tempUser);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            return null;
        }

        if (tempSave == null)
            return null;
        else
            return tempSave;
    }

    private boolean validateHeader(int typeSelection, String fileLocation){
        String line = "";
        String splitBy = ";";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            if (typeSelection == 0) {
                if ((line = br.readLine()) != null) {
                    String[] column = line.split(splitBy);
                    try {
                        if (!column[0].toLowerCase().equals("name") &&
                                !column[1].toLowerCase().equals("sex") &&
                                !column[2].toLowerCase().equals("birth date") &&
                                !column[3].toLowerCase().equals("address") &&
                                !column[4].toLowerCase().equals("phone number") &&
                                !column[5].toLowerCase().equals("e-mail") &&
                                !column[6].toLowerCase().equals("sns user number") &&
                                !column[7].toLowerCase().equals("citizen card number"))
                            throw new Exception("Header doesn't exist or doesn't respect the guidelines: (Name | Sex | Birth Date | Address | Phone Number | E-mail | SNS User Number | Citizen Card Number)");
                    } catch (Exception e) {
                        System.out.println(e);
                        return false;
                    }
                }
            }if (typeSelection == 1){
                if ((line = br.readLine()) != null) {
                    String[] column = line.split(splitBy);
                    try {
                        if (column[0].toLowerCase().equals("name") ||
                                (column[1].toLowerCase().equals("gender") || column[1].toLowerCase().equals("sex")) ||
                                (column[2].toLowerCase().equals("birthdate") || column[2].toLowerCase().equals("birth-date") || column[2].toLowerCase().equals("birth date")) ||
                                (column[3].toLowerCase().equals("homeaddress") || column[3].toLowerCase().equals("home-address") || column[3].toLowerCase().equals("home address") || column[3].toLowerCase().equals("address")) ||
                                (column[4].toLowerCase().equals("phonenumber") || column[4].toLowerCase().equals("phone-number") || column[4].toLowerCase().equals("phone number")) ||
                                (column[5].toLowerCase().equals("e-mail") || column[5].toLowerCase().equals("email") || column[5].toLowerCase().equals("e-mail address") || column[5].toLowerCase().equals("email address")) ||
                                (column[6].toLowerCase().equals("sns user number") || column[6].toLowerCase().equals("snsusernumber") || column[6].toLowerCase().equals("sns-user-number")) ||
                                (column[7].toLowerCase().equals("citizen card number") || column[7].toLowerCase().equals("citizencardnumber") || column[7].toLowerCase().equals("citizen-card-number")))
                            throw new Exception("It seems like there might be a header in this file");
                    } catch (Exception e) {
                        System.out.println(e);
                        return false;
                    }
                }
            }
        }
        catch(IOException e) {
            System.out.println("Can't find/open file");
            return false;
        }
        return true;
    }
}
