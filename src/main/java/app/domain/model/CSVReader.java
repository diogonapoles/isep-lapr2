package app.domain.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CSVReader {

    public CSVReader() {}

    private enum HEADER_COLUMNS{
        HEADER0("name"),
        HEADER1("sex", "gender"),
        HEADER2("birth date", "birthdate", "birth-date"),
        HEADER3("homeaddress", "home-address", "home address", "address"),
        HEADER4("phonenumber", "phone-number", "phone number"),
        HEADER5("e-mail", "email", "e-mail address", "email address"),
        HEADER6("sns user number", "snsusernumber", "sns-user-number"),
        HEADER7("citizen card number", "citizencardnumber", "citizen-card-number"),
        HEADER8;
        private String columnValue;
        private HashSet<String> similarValues;
        HEADER_COLUMNS(String... similarValues){
            this.columnValue = similarValues[0];
            this.similarValues = new HashSet<String>(Arrays.asList(similarValues));
        }

        public String getColumnValue(){
            return columnValue;
        }

        public HashSet<String> getSimilarValues(){
            return similarValues;
        }
    }

    private static final String SEPARATOR_A = ";";
    private static final String SEPARATOR_B = ",";
    private String separator = SEPARATOR_A;
    public List <SNSUser> readCSVFile(String fileLocation) {
        List<SNSUser> tempSave = new ArrayList<>();
        String line = "";
        try {
        BufferedReader br = new BufferedReader(new FileReader(fileLocation));
        line = br.readLine();
            try {
                switch (validateHeader(line)) {
                    case -1:
                        return null;
                    case 0:
                        System.out.println("Loading CSV file with header:");
                        separator = SEPARATOR_A;
                        break;
                    case 1:
                        System.out.println("Loading CSV file without header:");
                        separator = SEPARATOR_B;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + validateHeader(fileLocation));
                }
            }catch (Exception e){
                System.out.println("There was a problem validating the header");
                return null;
            }

            if (separator.equals(SEPARATOR_B)) {
                line = br.readLine();
            }

            while (line != null) {
                String[] SNSUser = line.split(separator);
                SNSUser tempUser = new SNSUser(SNSUser[0], SNSUser[1], SNSUser[2], SNSUser[3], SNSUser[4], SNSUser[5], SNSUser[6], SNSUser[7]);
                if(tempUser.getName() != null)
                    tempSave.add(tempUser);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return tempSave;
    }

    public int validateHeader(String line){
        try {
            line = line.toLowerCase();
            if (line.contains(SEPARATOR_A)) {
                separator = SEPARATOR_A;
                // Validating if header is in the expected format
                try {
                    if (!line.equals(getCompleteHeader()))
                        throw new IllegalArgumentException("Invalid header. Should be: " + getCompleteHeader());
                } catch (Exception e) {
                    System.out.println(e);
                    return -1;
                }
                return 0;
            } else if (line.contains(SEPARATOR_B)) {
                separator = SEPARATOR_B;
                // Validating if there is a possible header
                String[] columns = line.split(separator);
                try {
                    if (columns.length == HEADER_COLUMNS.values().length) {
                        for (int i = 0; i < columns.length; i++) {
                            if (HEADER_COLUMNS.values()[i].getSimilarValues().contains(columns[i]))
                                throw new IllegalArgumentException("An unexpected header was found.");
                        }
                    } else {
                        throw new IllegalArgumentException("Number of columns is wrong.");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    return -1;
                }
                return 1;
            } else {
                throw new IllegalArgumentException("No separator was found.");
            }
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
    }

    private static String getCompleteHeader(){
        String expectedHeader = "";
        for (HEADER_COLUMNS headerColumn : HEADER_COLUMNS.values()) {
            expectedHeader += headerColumn.getColumnValue() + SEPARATOR_A;
        }
        expectedHeader = expectedHeader.substring(0, expectedHeader.length()-1);
        return expectedHeader;
    }
}