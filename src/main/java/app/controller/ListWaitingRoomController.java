package app.controller;

import app.domain.systemUsers.SNSUser;

import java.util.List;

/**
 * The type List waiting room controller.
 */
public class ListWaitingRoomController {
    private App oApp;

    /**
     * Instantiates a new List waiting room controller.
     */
    public ListWaitingRoomController() {this.oApp = App.getInstance();}


    /**
     * Gets list users in waiting room.
     *
     * @return the list users in waiting room
     */
    public List<SNSUser>  getListUsersInWaitingRoom() {return this.oApp.getCompany().getUserArrivalStore().getListUserToWaitingRoom();}




}
