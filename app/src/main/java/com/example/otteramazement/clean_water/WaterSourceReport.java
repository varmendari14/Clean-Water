package com.example.otteramazement.clean_water;


/**
 * Created by Mary on 2/26/17.
 * Authors: Mary, Cat
 */

/**
 * represents source reports
 */
class WaterSourceReport {

    private final int reportNum;

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

    /**
     * set type of water
     * @param aType type of water
     */
    public void setType(WaterType aType) { type = aType; }

    /**
     * getter for type of water
     * @return water type
     */
    public WaterType getType() {return type;}

    /**
     * sets condition of water
     * @param aCondition condition of water
     */
    public void setCondition(WaterCondition aCondition) { condition = aCondition; }

    /**
     * getter for condition of water
     * @return condition of water
     */
    public WaterCondition getCondition() {return condition;}

    /**
     * sets date of report
     * @param aDate date of report being made
     */
    public void setDate(String aDate) {
        date = aDate;
    }

    /**
     * getter for date report was made
     * @return date report was made
     */
    public String getDate() {
        return date;
    }

    /**
     * set time report was made
     * @param aTime time report was made
     */
    public void setTime(String aTime) {
        time = aTime;
    }

    /**
     * getter for time report was made
     * @return time report was made
     */
    public String getTime() {
        return time;
    }

    /**
     * sets person who made report
     * @param userName person making report
     */
    public void setReporter(String userName) {
        reporter = userName;
    }

    /**
     * getter for who made report
     * @return who made report
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * sets location of report
     * @param loc location person making report is at
     */
    public void setLocation(String loc) {
        location = loc;
    }

    /**
     * getter for location of report
     * @return location report made at
     */
    public String getLocation() {
        return location;
    }

    /**
     * getter for report number
     * @return next numerically ordered number
     */
    public String getReportNumber() {
        return Integer.toString(reportNum);
    }

    // ***

    /**
     * to string to print report neatly onto list
     * @return string of report
     */
    public String toString() {
        return reportNum + ": " +
                date +
                "\n" + time +
                "\nType: " + WaterType.waterTypeToString(type) +
                "\nCondition: " + WaterCondition.waterConditionToString(condition)
                + "\n@Location: " + location +
                "\nVia: " + reporter;
    }

    /**
     * to string for map (instead of for list)
     * @return string of report
     */
    public String mapMarkerToString() {
        return "Type: " + WaterType.waterTypeToString(type) +
                "Condition: " + WaterCondition.waterConditionToString(condition);
    }
}
