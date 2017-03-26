package com.example.otteramazement.clean_water;

/**
 * Created by Violet on 3/15/2017.
 */

public class HistoricalReport {

    private int reportNum;
    private String date;
    private String reporter;
    private String location;
    private int contaminant;
    private int month;

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
    public void setContaminant(int aContaminant) { contaminant = aContaminant; }

    /**
     * get contaminant ppm
     * @return the contaminant ppm of the water
     */
    public int getContaminant() {return contaminant; }

    /**
     * set contaminant of water
     * @param aMonth the month of the water
     */
    public void setMonth(int aMonth) { month = aMonth; }

    /**
     * get contaminant ppm
     * @return the month of the water
     */
    public int getMonth() {return month; }
    // ***

    /**
     * month calc for Graphs
     * @return the number of the month from the string
     */

    public int monthDate() {
        String month = this.getDate().substring(0, 2).toUpperCase().trim();

        if (month == "01") {
            return 0;
        } else if (month == "02") {
            return 1;
        } else if (month == "03") {
            return 2;
        } else if (month == "04") {
            return 3;
        } else if (month == "05") {
            return 4;
        } else if (month == "06") {
            return 5;
        } else if (month == "07") {
            return 6;
        } else if (month == "08") {
            return 7;
        } else if (month == "09") {
            return 8;
        } else if (month == "10") {
            return 9;
        } else if (month == "11") {
            return 10;
        } else if (month == "12") {
            return 11;
        }

        return 0;
    }

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
