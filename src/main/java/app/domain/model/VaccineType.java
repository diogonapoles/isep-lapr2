package app.domain.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The type Vaccine type.
 */
public abstract class VaccineType {
    private String code;
    private String designation;

    /**
     * Instantiates a new Vaccine type.
     *
     * @param code        the code
     * @param designation the designation
     */
    public VaccineType(String code, String designation){
        if((code == null) || (code.isEmpty()) ||
                (designation == null) || (designation.isEmpty()) ||
                (code.length() != 5) || !StringUtils.isNumeric(code))
            throw new IllegalArgumentException("None of the arguments can be null or empty. Code must be 5 digits");

        this.code = code;
        this.designation = designation;
    }

    /**
     * Instantiates a new Vaccine type.
     */
    public VaccineType(){
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets designation.
     *
     * @param designation the designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "VaccineType [" +
                "code: " + code +
                ", description: " + designation +
                "]";
    }
}
