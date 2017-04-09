package com.example.otteramazement.clean_water;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mary 4/2/17
 * Junit tests for report check method in water source report
 */

public class ReportCheckTest {

    private final WaterSourceReport validReport = new WaterSourceReport();
    private final WaterSourceReport locReport = new WaterSourceReport();
    private final WaterSourceReport invalidReport = new WaterSourceReport();

    /**
     * Initialize values for each report before testing
     */
    @Before
    public void beforeTest() {
        validReport.setReporter("Carlos");
        validReport.setDate("01/12/13");
        validReport.setTime("12:30");
        validReport.setLat(25);
        validReport.setLon(25);
        validReport.setType(WaterType.BOTTLED);
        validReport.setCondition(WaterCondition.POTABLE);

        locReport.setReporter("Andrew");
        locReport.setDate("07/17/17");
        locReport.setTime("9:45");
        locReport.setLat(120);
        locReport.setType(WaterType.SPRING);
        locReport.setCondition(WaterCondition.TREATABLE_CLEAR);

        invalidReport.setReporter("Bartholomew");
        invalidReport.setDate("11/03/16");
        invalidReport.setTime("4:15");
        invalidReport.setLat(60);
        invalidReport.setLon(45);
        invalidReport.setType(WaterType.WELL);
    }

    /**
     * Tests a valid water source report
     */
    @Test
    public void reportIsValid() {

        assertEquals(WaterSourceReport.reportCheck(validReport.getDate(), validReport.getTime(),
                validReport.getLat(), validReport.getLon(), validReport.getType(),
                validReport.getCondition()), 0);

    }

    /**
     * Tests if a water source report will be considered invalid upon having location without
     * a dash mark
     */
    @Test
    public void hasInvalidLocation() {

        assertEquals(WaterSourceReport.reportCheck(locReport.getDate(), locReport.getTime(),
                locReport.getLat(), locReport.getLon(), locReport.getType(),
                locReport.getCondition()), 1);
    }

    /**
     * Tests if a water source report will be considered invalid upon having a null
     * water condition
     */
    @Test
    public void reportIsInvalid() {

        assertEquals(WaterSourceReport.reportCheck(invalidReport.getDate(), invalidReport.getTime(),
                invalidReport.getLat(), invalidReport.getLon(), invalidReport.getType(),
                invalidReport.getCondition()), 2);
    }

}
