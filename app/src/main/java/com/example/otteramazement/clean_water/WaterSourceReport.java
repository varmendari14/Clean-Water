package com.example.otteramazement.clean_water;


/**
 * Created by Mary on 2/26/17.
 * represents source reports
 * Authors: Mary, Cat
 */

class WaterSourceReport {

    private final int reportNum;

    private String date;
    private String time;
    private String reporter;
    private double lat;
    private double lon;
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
     * set location of report
     * @param loc location of report
     */
    public void setLat(double loc) {
        lat = loc;
    }

    /**
     * get location report is for
     * @return location of report
     */
    public double getLat() {
        return lat;
    }


    /**
     * set location of report
     * @param loc2 location of report
     */
    public void setLon(double loc2) {
        lon = loc2;
    }

    /**
     * get location report is for
     * @return location of report
     */
    public double getLon() {
        return lon;
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
                + "\n@Location: " + lat + "-" + lon +
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

    /**
     *
     * @param cDate date to be checked
     * @param cTime time to be checked
     * @param cLat lat to be checked
     * @param cLon long to be checked
     * @param cType water type to be checked
     * @param cCondition water condition to be checked
     * @return 0 if good to go, 1 or 2 to display alert dialogue in view
     */
    static int reportCheck(String cDate, String cTime, double cLat, double cLon, WaterType cType,
                           WaterCondition cCondition) {
        if (cCondition != null && cType != null && cTime.length() > 0 && cDate.length() > 0
                && cLat >= -90
                && cLat <= 90
                && cLon <= 180
                && cLon >= -180) {
            return 0;
        } else if (!(cLat >= -90)
                || !(cLat <= 90)
                || !(cLon <= 180)
                || !(cLon >= -180)) {
            return 1;
        } else {
            return 2;
        }
    }
}
