package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VaccineTypeTest {

    mRNAVaccine vaccine1 = new mRNAVaccine("31265", "unittest1");
    ViralVectorVaccine vaccine2 = new ViralVectorVaccine("67823", "unittest2");
    ToxoidVaccine vaccine3 = new ToxoidVaccine("42375", "unittest3");
    SubunitVaccine vaccine4 = new SubunitVaccine("78942", "unittest4");
    LiveAttenuatedVaccine vaccine5 = new LiveAttenuatedVaccine("43267", "unittest5");
    InactivatedVaccine vaccine6 = new InactivatedVaccine("53497", "unittest6");

    @Test
    public void getCode() {
        assertEquals("31265", vaccine1.getCode());
        assertEquals("67823", vaccine2.getCode());
        assertEquals("42375", vaccine3.getCode());
        assertEquals("78942", vaccine4.getCode());
        assertEquals("43267", vaccine5.getCode());
        assertEquals("53497", vaccine6.getCode());
    }

    @Test
    public void getDesignation() {
        assertEquals("unittest1", vaccine1.getDesignation());
        assertEquals("unittest2", vaccine2.getDesignation());
        assertEquals("unittest3", vaccine3.getDesignation());
        assertEquals("unittest4", vaccine4.getDesignation());
        assertEquals("unittest5", vaccine5.getDesignation());
        assertEquals("unittest6", vaccine6.getDesignation());
    }


    @Test
    public void testToString() {
        assertEquals("VaccineType [" +
                "code: " + "31265" +
                ", description: " + "unittest1" +
                "]", vaccine1.toString());
        assertEquals("VaccineType [" +
                "code: " + "67823" +
                ", description: " + "unittest2" +
                "]", vaccine2.toString());
        assertEquals("VaccineType [" +
                "code: " + "42375" +
                ", description: " + "unittest3" +
                "]", vaccine3.toString());
        assertEquals("VaccineType [" +
                "code: " + "78942" +
                ", description: " + "unittest4" +
                "]", vaccine4.toString());
        assertEquals("VaccineType [" +
                "code: " + "43267" +
                ", description: " + "unittest5" +
                "]", vaccine5.toString());
        assertEquals("VaccineType [" +
                "code: " + "53497" +
                ", description: " + "unittest6" +
                "]", vaccine6.toString());
    }
}