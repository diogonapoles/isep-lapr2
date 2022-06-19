package app.domain.model;


import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Legacy system data reader.
 */
public class LegacySystemDataReader {

    private List listLegacy = new ArrayList();


    /**
     * Csv reader legacy data list.
     *
     * @param fileName the file name
     * @return the list
     * @throws Exception the exception
     */
    public List csvReaderLegacyData(String fileName) throws Exception {


        List<LegacySystemData> listLegacySystemData = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);


        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String header = br.readLine();
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
        return listLegacySystemData;

    }

    private LegacySystemData createLegacySystemData(String[] attributes) throws Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            int snsUserNumber = Integer.parseInt(attributes[0]);
            String vaccineName = attributes[1];
            String dose = attributes[2];
            String lotNumber = attributes[3];
            Date scheduledDateTime = dateFormat.parse(attributes[4]);
            Date arrivalDateTime = dateFormat.parse(attributes[5]);
            Date nurseAdministrationTime = dateFormat.parse(attributes[6]);
            Date leavingDateTime = dateFormat.parse(attributes[7]);
            return new LegacySystemData(snsUserNumber, vaccineName, dose, lotNumber,
                    scheduledDateTime, arrivalDateTime, nurseAdministrationTime, leavingDateTime);
        } catch (Exception ex) {
            throw new Exception("Couldn´t read the date from the file");
        }
    }


}
