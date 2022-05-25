package app.domain.store;

import app.domain.model.SNSUser;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.ArrayList;
import java.util.List;

public class SNSUserStore {
    private final List<SNSUser> listSNSUser = new ArrayList<>();
    private final AuthFacade authFacade;

    public SNSUserStore(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    public boolean importSNSUserCSV(List<SNSUser> list){
        for (int counter = 0; counter < list.size(); counter++) {
            SNSUser oSNSUser = list.get(counter);
            if(validateSNSUser(oSNSUser.getPhoneNumber(),oSNSUser.getHomeAddress(),oSNSUser.getEmailAddress()))
                addSNSUser(oSNSUser);
            else
                return false;
        }
        return true;
    }

    public List<SNSUser> validateTempList(List<SNSUser> list){
        int size = list.size();
        List<SNSUser> listCopy = new ArrayList<>();
        for (int counter = 0; counter < size; counter++) {
            SNSUser oSNSUser = list.get(counter);
            if(validateSNSUser(oSNSUser.getPhoneNumber(),oSNSUser.getHomeAddress(),oSNSUser.getEmailAddress())) {
                listCopy.add(oSNSUser);
            }else{
                System.out.println("O " + oSNSUser + " já existe no sistema!");
            }
        }
        return listCopy;
    }

    public boolean validateSNSUser(String phoneNumber, String homeAddress, String emailAddress)
    {
        for(SNSUser user: listSNSUser)
        {
            if(user.getPhoneNumber().contains(phoneNumber)
                    || user.getEmailAddress().contains(emailAddress)
                    || user.getHomeAddress().contains(homeAddress))
                return false;
        }
        if (authFacade.existsUser(emailAddress)) {
            return false;
        } else
            return true;
    }

    private boolean addSNSUser(SNSUser user){return this.listSNSUser.add(user);}
}