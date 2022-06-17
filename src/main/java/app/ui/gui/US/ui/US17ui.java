package app.ui.gui.US.ui;


import app.controller.centerCoordinator.LegacySystemDataImporterController;
import app.ui.console.centerCoordinator.CenterCoordinatorUI;
import app.ui.console.utils.Utils;
import app.ui.gui.Appfx;
import app.ui.gui.US.ctrl.US17ctrl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class US17ui implements Initializable {

    private  US17ctrl controller;
    private  CenterCoordinatorUI ccUI;
    private Appfx mainAppfx;

    private List listLegacyData = new ArrayList<>();
    private Stage stage;


    public US17ui() {
        controller = new US17ctrl();
        ccUI = new CenterCoordinatorUI();
}
    @FXML
    private ChoiceBox<Object> arrivalCombo;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnConfirm;

    @FXML
    private ChoiceBox<Object> choiceCombo;

    @FXML
    private ChoiceBox<Object> orderCombo;

    @FXML
    private TextField pathTF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        controller = new US17ctrl();
        ccUI = new CenterCoordinatorUI();
        addSortStuff();
        List<Object> choice = new ArrayList<>();
        choice = controller.getSortAlgorithms();
        choiceCombo.getItems().addAll(choice);
        List<Object> order = new ArrayList<>();
        order = controller.getSortOrder();
        orderCombo.getItems().addAll(order);
        List<Object> arrival = new ArrayList<>();
        arrival = controller.getSortArrivalLeaving();
        arrivalCombo.getItems().addAll(arrival);
        choiceCombo.setValue("Bubble Sort");
        orderCombo.setValue("Ascending");
        arrivalCombo.setValue("Sort by Arrival time");
    }

    @FXML
    void btnConfirm(ActionEvent event) {
        try {
            if (inputData()) {
                listLegacyData = controller.getListLegacySystemData();

                addSortStuff();

                String sortChoice = choiceCombo.getValue().toString();
                String sortOrder = orderCombo.getValue().toString();
                String sortArrivalLeaving = arrivalCombo.getValue().toString();

                try {
                    controller.sortByParameters(sortChoice, sortOrder, sortArrivalLeaving, listLegacyData);
                }catch (Exception ex){
                    ccUI.run();
                }


/*
                if (Utils.confirm("Confirm data?(s/n)")) {
                    controller.importLegacySystemDataCSV();
                    controller.clearTempArray();
                    System.out.println("Operation finished");
                } else
                    run();

 */
            } else
                try {
                    var loader = new FXMLLoader(getClass().getResource("/fxml/US/17s3.fxml"));
                    Parent root = loader.load();
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
                    String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
                    scene.getStylesheets().add(css);
                    stage.setScene(scene);

                }catch (Exception ex){
                    ex.printStackTrace();
                }



        } catch (Exception e) {
            System.out.println("ola");
            throw new RuntimeException(e);

        }
    }

    public boolean inputData() throws Exception {
        String fileLocation = Utils.readLineFromConsole("File Location:");
        return controller.newLegacySystemDataReader(fileLocation);
    }
    public void setMainApp(Appfx mainAppfx) {
        this.mainAppfx = mainAppfx;

    }


    public void run() {

        try {
            if (inputData()) {
                listLegacyData = controller.getListLegacySystemData();

                addSortStuff();

                String sortChoice = (String) Utils.showAndSelectOne(controller.getSortAlgorithms(), "\n\nChoose the intended sort algorithm\n");
                String sortOrder = (String) Utils.showAndSelectOne(controller.getSortOrder(), "\n\nChoose the intended sorting method\n");
                String sortArrivalLeaving = (String) Utils.showAndSelectOne(controller.getSortArrivalLeaving(), "\n\n \n");

                try {
                    controller.sortByParameters(sortChoice, sortOrder, sortArrivalLeaving, listLegacyData);
                }catch (Exception ex){
                    ccUI.run();
                }


/*
                if (Utils.confirm("Confirm data?(s/n)")) {
                    controller.importLegacySystemDataCSV();
                    controller.clearTempArray();
                    System.out.println("Operation finished");
                } else
                    run();

 */
            } else
                System.out.println("There is a problem with the file");


        } catch (Exception e) {
            System.out.println("ola");
            throw new RuntimeException(e);

        }


    }

    private void addSortStuff() {

        this.controller.setSortAlgorithms();
        this.controller.setSortOrder();
        this.controller.setSortArrivalLeaving();


    }

    private void getSortedData() {
        // Utils.showList(controller.getli(), "Sorted Data:");
    }
@FXML
    void btnBack(ActionEvent event) {
        try {
            var loader = new FXMLLoader(getClass().getResource("/fxml/CenterCoordinator.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
            String css = this.getClass().getResource("/styles/Styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
