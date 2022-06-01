package app.domain.model.vaccinationProcess;

import app.domain.model.vaccinationCenter.VaccinationCenter;
import app.domain.model.systemUser.SNSUser;

/**
 * The type User arrival.
 */
public class UserArrival {

    /**
     * The Sns user.
     */
    SNSUser snsUser;
    /**
     * The Vaccination center.
     */
    VaccinationCenter vaccinationCenter;

    /**
     * Instantiates a new User arrival.
     *
     * @param snsUser           the sns user
     * @param vaccinationCenter the vaccination center
     */
    public UserArrival(SNSUser snsUser, VaccinationCenter vaccinationCenter) {
        this.snsUser = snsUser;
        this.vaccinationCenter = vaccinationCenter;
    }

    /**
     * Gets sns user.
     *
     * @return the sns user
     */
    public SNSUser getSnsUser() {
        return snsUser;
    }


    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Sets vaccination center.
     *
     * @param vaccinationCenter the vaccination center
     */
    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }
}
