package app.controller;

import app.domain.model.Employee;
import app.domain.systemUsers.SNSUser;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ListWaitingRoomControllerTest {
    ListWaitingRoomController controller = new ListWaitingRoomController();
    UserArrivalController cont = new UserArrivalController();
    private final App oApp;


    public ListWaitingRoomControllerTest() {
        this.oApp = App.getInstance();

    }

    @Test
    public void getListUsersInWaitingRoom() throws ParseException {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");
        String numero = user.getSnsUserNumber();
        cont.newUserArrival(numero);
        List<SNSUser> Users = new ArrayList<>();
        Users.add(user);

        assertEquals(Users , controller.getListUsersInWaitingRoom());




    }
}