package app.controller;

import app.domain.systemUsers.SNSUser;

import java.util.List;

public class ListWaitingRoomController {
    private App oApp;

    public ListWaitingRoomController() {this.oApp = App.getInstance();}


    public List<SNSUser>  getListUsersInWaitingRoom() {return this.oApp.getCompany().getUserArrivalStore().getListUserToWaitingRoom();}




}
