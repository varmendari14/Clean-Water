package com.example.otteramazement.clean_water;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Violet on 3/31/2017.
 * This Is Violet's JUnit test
 * for the method monthDate()
 * in HistoricalReport.class
 */

public class HistoricalReportMonthDateTest {

    private final HistoricalReport[] correctreports = {new HistoricalReport(), new HistoricalReport(), new HistoricalReport(),
            new HistoricalReport(), new HistoricalReport(), new HistoricalReport(),
            new HistoricalReport(), new HistoricalReport(), new HistoricalReport(),
            new HistoricalReport(), new HistoricalReport(), new HistoricalReport()};
    private final HistoricalReport[] incorrectreports = {new HistoricalReport(), new HistoricalReport(), new HistoricalReport(),
            new HistoricalReport(), new HistoricalReport(), new HistoricalReport(),
            new HistoricalReport(), new HistoricalReport(), new HistoricalReport(),
            new HistoricalReport(), new HistoricalReport(), new HistoricalReport()};

    /**
     *This method creates the arrays of month strings for testing
     * one for pos direction
     * one for neg direction ->
     * for fall through to 0 ->
     * I.e invalid month
     */

    @Before
    public void setUp() {

        String arrCorrect[] = {"01/01/2017", "02/01/2017", "03/01/2017",
                        "04/01/2017", "05/01/2017", "06/01/2017",
                        "07/01/2017", "08/01/2017", "09/01/2017",
                        "10/01/2017", "11/01/2017", "12/01/2017"};

        int i = 0;
        for(String date : arrCorrect) {

            correctreports[i].setDate(date);
            i++;

        }

        String arrIncorrect[] = {"00/01/2017", "Mar 21 2017", "August 1 2017",
                "2017/01/01", "3200/02/02", "Hello",
                "MAR 21 2017", "AUGUST 21 2017", "35/01/2017",
                "1/2/2017", "1/2/17", "1/02/2017"};

        int j = 0;
        for(String date : arrIncorrect) {

            incorrectreports[j].setDate(date);
            j++;

        }

    }

    /**
     * Tests the correct array
     * testing the ifs in the pos direction
     */

    @Test
    public void month_isCorrect(){

        assertEquals(correctreports[0].monthDate(), 1);
        assertEquals(correctreports[1].monthDate(), 2);
        assertEquals(correctreports[2].monthDate(), 3);
        assertEquals(correctreports[3].monthDate(), 4);
        assertEquals(correctreports[4].monthDate(), 5);
        assertEquals(correctreports[5].monthDate(), 6);
        assertEquals(correctreports[6].monthDate(), 7);
        assertEquals(correctreports[7].monthDate(), 8);
        assertEquals(correctreports[8].monthDate(), 9);
        assertEquals(correctreports[9].monthDate(), 10);
        assertEquals(correctreports[10].monthDate(), 11);
        assertEquals(correctreports[11].monthDate(), 12);

    }

    /**
     * Tests the incorrect array
     * testing the ifs in the neg direction
     */

    @Test
    public void month_isNotCorrect(){

        assertEquals(incorrectreports[0].monthDate(), 0);
        assertEquals(incorrectreports[1].monthDate(), 0);
        assertEquals(incorrectreports[2].monthDate(), 0);
        assertEquals(incorrectreports[3].monthDate(), 0);
        assertEquals(incorrectreports[4].monthDate(), 0);
        assertEquals(incorrectreports[5].monthDate(), 0);
        assertEquals(incorrectreports[6].monthDate(), 0);
        assertEquals(incorrectreports[7].monthDate(), 0);
        assertEquals(incorrectreports[8].monthDate(), 0);
        assertEquals(incorrectreports[9].monthDate(), 0);
        assertEquals(incorrectreports[10].monthDate(), 0);
        assertEquals(incorrectreports[11].monthDate(), 0);

    }

}
