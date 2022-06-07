package app.controller.nurse;


import app.controller.App;
import app.domain.model.Company;
import app.domain.model.vaccinationProcess.UserArrival;

import java.util.List;

public class AdverseReactionsController {


    private App oApp;
    private Company oCompany;
    private String snsUserNumber;


    public AdverseReactionsController(){
        this.oApp = App.getInstance();
        this.oCompany = oApp.getCompany();
    }



    public List<UserArrival> getWaitingRoomList(){
      //  return oApp.getCompany().
        //return this.oApp.getCompany().get.getWaitingRoomList() ;
        return null;
    }



    public Boolean isUserInRecoveryList(String snsUserNumber) {

        for (UserArrival user : getWaitingRoomList()){
            if (user.getSnsUser().getSnsUserNumber().equals(snsUserNumber)){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

    public List getAdverseReactions() {
     //   return getWaitingRoomList();
        return null;
    }
}
