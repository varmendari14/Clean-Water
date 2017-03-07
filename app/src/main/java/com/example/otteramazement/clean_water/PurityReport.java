package com.example.otteramazement.clean_water;

/**
 * Created by Violet on 3/7/2017.
 */

public class PurityReport {

    private int reportNum;

    private String date;
    private String time;
    private String reporter;
    private String location;
    private WaterType type;
    private WaterPurityCondition condition;

    //No-arg constructor creates number for report

    public PurityReport() {
        reportNum = WaterReportList.waterPurityList.size();
    }

    //Getters and setters for report data

    /**
     * sets condition
     * @param aCondition safe, unsafe, treatable
     */
    public void setCondition(WaterPurityCondition aCondition) { condition = aCondition; }

    /**
     * get condition
     * @return condition of water -- safe, unsafe, treatable
     */
    public WaterPurityCondition getCondition() {return condition;}

    /**
     * set date of report
     * @param aDate date report is made
     */
    public void setDate(String aDate) {
        date = aDate;
    }

    /**
     * get date report was written
     * @return date report was written
     */
    public String getDate() {
        return date;
    }

    /**
     * set time report is written
     * @param aTime time report is written
     */
    public void setTime(String aTime) {
        time = aTime;
    }

    /**
     * getter for time report is written
     * @return time report was written
     */
    public String getTime() {
        return time;
    }

    /**
     * set name of user who is writing report
     * @param userName name of user writing report
     */
    public void setReporter(String userName) {
        reporter = userName;
    }

    /**
     * get name of who wrote report
     * @return name of who wrote report
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * set location of report
     * @param loc location of report
     */
    public void setLocation(String loc) {
        location = loc;
    }

    /**
     * get location report is for
     * @return location of report
     */
    public String getLocation() {
        return location;
    }

    /**
     * get report number
     * @return numerically ordered report number
     */
    public String getReportNumber() {
        return Integer.toString(reportNum);
    }

    // ***

    /**
     * to string for purity report list
     * @return string with report details
     */
    public String toString() {
        return reportNum + ": " +
                date +
                "\n" + time +
                "\nCondition: " + WaterPurityCondition.waterPurityContiditionToString(condition)
                + "\n@Location: " + location +
                "\nVia: " + reporter;
    }

    /**
     * to string for google maps
     * @return string for google maps
     */
    public String mapMarkerToString() {
        return reportNum + ": " +
                "\nType: " + WaterType.waterTypeToString(type) +
                "\nCondition: " + WaterPurityCondition.waterPurityContiditionToString(condition) +
                "\nVia: " + reporter;
    }

}
