package com.example.otteramazement.clean_water;

/**
 * Created by Violet on 3/7/17
 * A purity/quality report that can be created by Workers and Managers
 */

class PurityReport {

    private final int reportNum;

    private String date;
    private String time;
    private String reporter;
    private double lat;
    private double lon;
    private WaterPurityCondition condition;
    private double virus;
    private double contaminant;


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
     * get report number
     * @return numerically ordered report number
     */
    public String getReportNumber() {
        return Integer.toString(reportNum);
    }

    /**
     * set virus ppm of water
     * @param aVirus the virus ppm of the water
     */
    public void setVirus(double aVirus) { virus = aVirus; }

    /**
     * get virus ppm
     * @return the virus ppm of the water
     */
    public double getVirus() { return virus; }

    /**
     * set contaminant of water
     * @param aContaminant the contaminant ppm of the water
     */
    public void setContaminant(double aContaminant) { contaminant = aContaminant; }

    /**
     * get contaminant ppm
     * @return the contaminant ppm of the water
     */
    public double getContaminant() {return contaminant; }
    // ***

    /**
     * to string for purity report list
     * @return string with report details
     */
    public String toString() {
        return reportNum + ": " +
                date +
                "\n" + time +
                "\nCondition: " + WaterPurityCondition.waterPurityConditionToString(condition)
                + "\nVirus ppm: " + virus
                + "\nContaminant ppm: " + contaminant
                + "\n@Location: " + lat + "-" + lon +
                "\nVia: " + reporter;
    }


}
