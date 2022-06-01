package app.controller;

import app.controller.administrator.LoadSNSUsersController;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class LoadSNSUsersControllerTest {


    @Test
    void newCSVReader() {
        LoadSNSUsersController snsc = new LoadSNSUsersController();

        boolean resultHeader = snsc.newCSVReader("/Users/diogonapoles/lei-22-s2-1dc-g13/CSVHeader.csv");
        boolean resultWithoutHeader = snsc.newCSVReader("/Users/diogonapoles/lei-22-s2-1dc-g13/CSVWithoutHeader.csv");
        boolean resultEmpty = snsc.newCSVReader("/Users/diogonapoles/lei-22-s2-1dc-g13/EmptyCSV.csv");
        assertEquals(true, resultHeader);
        assertEquals(true, resultWithoutHeader);
        assertEquals(false, resultEmpty);
    }

    @Test
    void importSNSUserCSV() {
        LoadSNSUsersController snsc = new LoadSNSUsersController();
        snsc.newCSVReader("/Users/diogonapoles/lei-22-s2-1dc-g13/CSVHeader.csv");
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");

            boolean result = snsc.importSNSUserCSV();
            assertEquals(true, result);

            snsc.clearTempArray();
            boolean result2 = snsc.importSNSUserCSV();
            assertEquals(false, result2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    @Test
    void getCSVFileString() {
        LoadSNSUsersController snsc = new LoadSNSUsersController();
        snsc.newCSVReader("/Users/diogonapoles/lei-22-s2-1dc-g13/CSVHeader.csv");

        String result = "[SNSUser{name='Joao', address='Rua Pereira', phoneNumber='917156542', birthDate='Fri May 02 00:00:00 WEST 2003', emailAddress='teste@isep.ipp.pt', snsUserNumber='411451234', citizenCardNumber='67837561'}, SNSUser{name='Mario', address='Rua Marco', phoneNumber='917312456', birthDate='Sat May 03 00:00:00 WEST 2003', emailAddress='teste2@isep.ipp.pt', snsUserNumber='424236543', citizenCardNumber='56738093'}]";
        assertEquals(result, snsc.getCSVFileString());
    }
}