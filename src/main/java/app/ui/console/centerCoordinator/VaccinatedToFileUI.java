package app.ui.console.centerCoordinator;

import app.controller.centerCoordinator.VaccinatedToFileController;
import app.ui.console.utils.Utils;
import com.sun.javafx.fxml.expression.LiteralExpression;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VaccinatedToFileUI implements Runnable {
    private final VaccinatedToFileController controller;

    private List lista= new ArrayList();

    public VaccinatedToFileUI() {
        controller = new VaccinatedToFileController();
    }

    @Override
    public void run() {
        String fileName = inputData();
        // controller.getListAdministratedVaccines();
        System.out.println(controller.getListAdministratedVaccines());

        if (controller.validateFileName(fileName)) {
            try {
                controller.writeToFile(fileName);
            } catch (IOException e) {
                throw new RuntimeException("couldn't write the data on the file");
            }
        }
        else {
            System.out.println("Invalid File Name");
            run();
        }

    }

    private String inputData() {
        String fileName = Utils.readLineFromConsole("Insert the File Name to Export Data");
        return fileName;
    }
}
