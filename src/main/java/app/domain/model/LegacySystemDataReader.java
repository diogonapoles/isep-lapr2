package app.domain.model;


import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LegacySystemDataReader {


    private final String HEADER = ("SNSUSerNumber;VaccineName;Dose;LotNumber;ScheduledDateTime;ArrivalDateTime;NurseAdministrationDateTime;LeavingDateTime");

    public void csvReaderLegacyData(String fileName) throws Exception {


        List<LegacySystemData> listLegacySystemData = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                LegacySystemData legacySystemData = createLegacySystemData(attributes);
                listLegacySystemData.add(legacySystemData);
                line = br.readLine();
            }
        } catch (Exception ex) {
            throw new Exception("Couldn't read from the presented file");
        }
        //return listLegacySystemData;














/*        List<Object> listLegacySystemData;
        BufferedReader br = null;
        Path pathToFile = Paths.get(fileName);

        try {
            br = new BufferedReader(new FileReader(pathToFile));
            listLegacySystemData = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            throw new IOException("Couldn't open the file");
        }finally {
            if (br!=null){
                try {
                    br.close();
                }catch (IOException e){
                    throw new IOException("Could't close the file");
                }
            }
        }

        listLegacySystemData.forEach(System.out::println);

        return listLegacySystemData;

 */









       /* try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String header = br.readLine();
            if (header == HEADER) {
                String[] columns = header.split(";");
            }

            return null;

        } catch (IOException ex) {
            throw new IOException("Couldn't read the data in the given file");
        }finally {
            br.close();
        }

        */


    }

    private LegacySystemData createLegacySystemData(String[] attributes) throws Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            int snsUserNumber = Integer.parseInt(attributes[0]);
            String vaccineName = attributes[1];
            String dose = attributes[2];
            String lotNumber = attributes[3];
            Date scheduledDateTime = dateFormat.parse(attributes[4]);
            Date arrivalDateTime = dateFormat.parse(attributes[5]);
            Date leavingDateTime = dateFormat.parse(attributes[6]);
            return new LegacySystemData(snsUserNumber, vaccineName, dose, lotNumber,
                    scheduledDateTime, arrivalDateTime, leavingDateTime);
        }catch (Exception ex){
            throw new Exception("Couldn´t read the date from the file");
        }
    }


}
