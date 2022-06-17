package app.domain.shared;

import app.domain.model.systemUser.SNSUser;
import app.ui.console.utils.Data;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Csv reader.
 */
public class CSVReader {

    /**
     * Instantiates a new Csv reader.
     */
    public CSVReader() {}

    private enum HEADER_COLUMNS{
        /**
         * Atributes of the header.
         */
        HEADER0("name"),
        /**
         * Header 1 header columns.
         */
        HEADER1("sex", "gender"),
        /**
         * The Header 2.
         */
        HEADER2("birthdate", "birth date", "birth-date"),
        /**
         * The Header 3.
         */
        HEADER3("address", "home-address", "home address", "homeaddress"),
        /**
         * The Header 4.
         */
        HEADER4("phonenumber", "phone-number", "phone number"),
        /**
         * The Header 5.
         */
        HEADER5("email", "email", "e-mail address", "email address"),
        /**
         * The Header 6.
         */
        HEADER6("snsusernumber", "sns user number", "sns-user-number"),
        /**
         * The Header 7.
         */
        HEADER7("citizencardnumber", "citizen card number", "citizen-card-number");
        private String columnValue;
        private HashSet<String> similarValues;
        HEADER_COLUMNS(String... similarValues){
            this.columnValue = similarValues[0];
            this.similarValues = new HashSet<String>(Arrays.asList(similarValues));
        }

        /**
         * Get column value string.
         *
         * @return the string
         */
        public String getColumnValue(){
            return columnValue;
        }

        /**
         * Get similar values hash set.
         *
         * @return the hash set
         */
        public HashSet<String> getSimilarValues(){
            return similarValues;
        }
    }

    private static final String SEPARATOR_A = ";";
    private static final String SEPARATOR_B = ",";
    private String separator = SEPARATOR_A;

    /**
     * Read csv file list .
     *
     * @param fileLocation the file location
     * @return the list
     */
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

            if (separator.equals(SEPARATOR_A)) {
                line = br.readLine();
            }

            while (line != null) {
                String[] user = line.split(separator);
                if(user[1].equals("")){
                    SNSUser tempUser = new SNSUser(user[0], stringToDate(user[2]), user[3], user[4], user[5], user[6], user[7]);
                    if(tempUser.getName() != null)
                        tempSave.add(tempUser);
                }else{
                    if (stringToDate(user[2]) != null) {
                        SNSUser tempUser = new SNSUser(user[0], user[1], stringToDate(user[2]), user[3], user[4], user[5], user[6], user[7]);
                        if (tempUser.getName() != null)
                            tempSave.add(tempUser);
                    } else {
                        System.out.println(user[2] + " is not a valid date, it should be in the dd/MM/yyyy format");
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return tempSave;
    }

    /**
     * Validate header int.
     *
     * @param line the line
     * @return the int
     */
    public int validateHeader(String line){
        try {
            String header = getCompleteHeader();
            line = line.toLowerCase();
            line = line.replaceAll(" ", "");
            line = line.replaceAll("-", "");
            if (line.contains(SEPARATOR_A)) {
                separator = SEPARATOR_A;
                // Validating if header is in the expected format
                try {
                    if (line.equals(header))
                        throw new IllegalArgumentException("Invalid header. Should be: " + header);
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

    private static Date stringToDate(String birthDate)
    {
        String separator = "/";
        String[] date = birthDate.split(separator);
        Data d1 = new Data(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            try {
                if (d1.isMaior(Data.dataAtual())){
                    return null;
                }

                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);

                return date1;
            } catch (ParseException ex){
                System.out.println("Couldn't read birthdate");
                return null;
            }
    }
}