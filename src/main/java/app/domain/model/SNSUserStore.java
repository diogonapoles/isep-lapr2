package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class SNSUserStore {
    private final List<SNSUser> listSNSUser = new ArrayList<>();

    public SNSUserStore() {
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

    public boolean validateSNSUser(String phoneNumber, String homeAddress, String emailAddress)
    {
        for(SNSUser user: listSNSUser)
        {
            if(user.getPhoneNumber().contains(phoneNumber)
                    || user.getEmailAddress().contains(emailAddress)
                    || user.getHomeAddress().contains(homeAddress))
                return false;
        }

        return true;
    }

    private boolean addSNSUser(SNSUser user){return this.listSNSUser.add(user);}
}
