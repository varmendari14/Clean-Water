package com.example.otteramazement.clean_water;

import java.util.Random;

/**
 * Created by Mary Prouty on 2/26/17.
 */

public class WaterSourceReport {

    private Random rand = new Random();
    private int reportNum;

    private String date;
    private String time;
    private String reporter;
    private String location;

    //No-arg constructor creates random number for report

    public WaterSourceReport() {
        reportNum = rand.nextInt(10000);
    }

    //Getters and setters for report data

    public void setDate(String aDate) {
        date = aDate;
    }

    public String getDate() {
        return date;
    }

    public void setTime(String aTime) {
        time = aTime;
    }

    public String getTime() {
        return time;
    }

    public void setReporter(String userName) {
        reporter = userName;
    }

    public String getReporter() {
        return reporter;
    }

    public void setLocation(String loc) {
        location = loc;
    }

    public String getLocation() {
        return location;
    }

    public String getReportNumber() {
        return Integer.toString(reportNum);
    }
}
