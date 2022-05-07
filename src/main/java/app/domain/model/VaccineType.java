package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public abstract class VaccineType {
    private String code;
    private String designation;

    public VaccineType(String code, String designation){
        if((code == null) || (code.isEmpty()) ||
                (designation == null) || (designation.isEmpty()) ||
                (code.length() != 5) || !StringUtils.isNumeric(code))
            throw new IllegalArgumentException("None of the arguments can be null or empty. Code must be 5 digits");

        this.code = code;
        this.designation = designation;
    }

    public VaccineType(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "VaccineType{" +
                "code='" + code + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
