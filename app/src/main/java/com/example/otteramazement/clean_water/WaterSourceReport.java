package com.example.otteramazement.clean_water;


/**
 * Created by Mary Prouty on 2/26/17.
 * Authors: Mary, Cat
 */

public class WaterSourceReport {

    private int reportNum;

    private String date;
    private String time;
    private String reporter;
    private String location;
    private WaterType type;
    private WaterCondition condition;

    //No-arg constructor creates number for report

    public WaterSourceReport() {
        reportNum = WaterReportList.waterSourceList.size();
    }

    //Getters and setters for report data

    public void setType(WaterType aType) { type = aType; }

    public WaterType getType() {return type;}

    public void setCondition(WaterCondition aCondition) { condition = aCondition; }

    public WaterCondition getCondition() {return condition;}

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

    // ***

    public String toString() {
        return reportNum + ": " +
                date +
                "\n" + time +
                "\nType: " + WaterType.waterTypeToString(type) +
                "\nCondition: " + WaterCondition.waterContiditionToString(condition)
                + "\n@Location: " + location +
                "\nVia: " + reporter;
    }

    public String mapMarkerToString() {
        return reportNum + ": " +
                "\nType: " + WaterType.waterTypeToString(type) +
                "\nCondition: " + WaterCondition.waterContiditionToString(condition) +
                "\nVia: " + reporter;
    }
}
