package app.domain.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public CSVReader() {}

    public List <SNSUser> readCSVFile(String fileLocation) {
        List<SNSUser> tempSave = new ArrayList<>();
        String line = "";
        String splitBy;
        try {
            switch (validateHeader(fileLocation)) {
                case -1:
                    return null;
                case 0:
                    System.out.println("Loading CSV file with header:");
                    splitBy = ";";
                    break;
                case 1:
                    System.out.println("Loading CSV file without header:");
                    splitBy = ",";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + validateHeader(fileLocation));
            }
        }catch (Exception e){
            System.out.println("There was a problem validating the header");
            return null;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));

            if (splitBy.equals(";")) {
                br.readLine();
            }

            while ((line = br.readLine()) != null) {
                String[] SNSUser = line.split(splitBy);
                SNSUser tempUser = new SNSUser(SNSUser[0], SNSUser[1], SNSUser[2], SNSUser[3], SNSUser[4], SNSUser[5], SNSUser[6], SNSUser[7]);
                if(tempUser.getName() != null)
                tempSave.add(tempUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return tempSave;
    }

    private int validateHeader(String fileLocation){
        String line = "";
        String splitBy;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            if ((line = br.readLine()) != null) {
                if(line.contains(";")) {
                    splitBy = ";";
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
                        return -1;
                    }
                    return 0;
                }
                if(line.contains(",")) {
                    splitBy = ",";
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
                        return -1;
                    }
                    return 1;
                }

            }
        }catch(IOException e) {
            System.out.println("Can't find/open file");
            return -1;
        }
        return -1;
    }
}
