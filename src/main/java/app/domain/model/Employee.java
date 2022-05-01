package app.domain.model;

public class Employee {


    private String name;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private int citizenCardNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public void setCitizenCardNumber(int citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }


    public String toString(){
        return String.format("Employee [name = "+ name+", Phone Number = "+phoneNumber+
                ", Address = "+address+", Email Address = "+emailAddress+
                ", Citizen Card Number = "+citizenCardNumber+"]");
    }




}
