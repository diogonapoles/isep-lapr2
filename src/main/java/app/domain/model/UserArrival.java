package app.domain.model;

import app.domain.systemUsers.SNSUser;

public class UserArrival {

    SNSUser snsUser;
    VaccinationCenter vaccinationCenter;

    public UserArrival(SNSUser snsUser, VaccinationCenter vaccinationCenter) {
        this.snsUser = snsUser;
        this.vaccinationCenter = vaccinationCenter;
    }

    public SNSUser getSnsUser() {
        return snsUser;
    }

    public void setSnsUser(SNSUser snsUser) {
        this.snsUser = snsUser;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }
}
