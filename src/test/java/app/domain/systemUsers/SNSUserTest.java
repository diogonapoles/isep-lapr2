package app.domain.systemUsers;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SNSUserTest {

    SNSUserTest() {
    }

    @Test
    void getGender() throws ParseException {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("male", user.getGender());
    }

    @Test
    void setGender() throws ParseException  {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        user.setGender("Male");

        String result = user.getGender();

        assertEquals("Male", result);
    }


    @Test
    void getName() throws ParseException   {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("Test", user.getName());
    }

    @Test
    void getHomeAddress() throws ParseException {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("street test", user.getHomeAddress());
    }

    @Test
    void setHomeAddress() throws ParseException {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        user.setHomeAddress("Rua");

        String result = user.getHomeAddress();

        assertEquals("Rua", result);
    }


    @Test
    void getPhoneNumber() throws ParseException {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("923456789", user.getPhoneNumber());
    }


    @Test
    void getBirthDate() throws ParseException   {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals(dtest, user.getBirthDate());
    }

    @Test
    void getEmailAddress() throws ParseException   {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("user@test.com", user.getEmailAddress());
    }

    @Test
    void getSnsUserNumber() throws ParseException   {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("123453678", user.getSnsUserNumber());
    }


    @Test
    void getCitizenCardNumber() throws ParseException   {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("12345342", user.getCitizenCardNumber());
    }


    @Test
    void testToString() throws ParseException {
        Date dtest = new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2003");
        SNSUser user = new SNSUser("Test","male",dtest ,"street test", "923456789","user@test.com","123453678","12345342");

        assertEquals("SNSUser{name='Test', address='street test', phoneNumber='923456789', birthDate='Fri May 02 00:00:00 WEST 2003', emailAddress='user@test.com', snsUserNumber='123453678', citizenCardNumber='12345342'}", user.toString());
    }

    @Test
    void toStringWaitingRoom() {
    }
}