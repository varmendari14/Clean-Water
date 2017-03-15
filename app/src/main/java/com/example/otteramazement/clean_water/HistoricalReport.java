package com.example.otteramazement.clean_water;

/**
 * Created by Violet on 3/15/2017.
 */

public class HistoricalReport {

    private int reportNum;
    private String date;
    private String reporter;
    private String location;
    private String contaminant;

    //No-arg constructor creates number for report

    public HistoricalReport() {
        reportNum = WaterReportList.historicalReportList.size();
    }

    //Getters and setters for report data

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

    /**
     * set contaminant of water
     * @param aContaminant the contaminant ppm of the water
     */
    public void setContaminant(String aContaminant) { contaminant = aContaminant; }

    /**
     * get contaminant ppm
     * @return the contaminant ppm of the water
     */
    public String getContaminant() {return contaminant; }
    // ***

    /**
     * to string for purity report list
     * @return string with report details
     */
    public String toString() {
        return reportNum + ": " +
                date
                + "\nContaminant ppm: " + contaminant
                + "\n@Location: " + location +
                "\nVia: " + reporter;
    }

}
