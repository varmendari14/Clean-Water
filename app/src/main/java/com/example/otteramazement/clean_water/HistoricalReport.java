package com.example.otteramazement.clean_water;

/*
 * Created by Violet
 * A Historical Report that can be made by Workers and Managers
 */

class HistoricalReport {

    private final int reportNum;
    private String date;
    private String reporter;
    private String location;
    private double contaminant;
    //private double month;

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

// --Commented out by Inspection START (4/1/17, 8:32 PM):
//    /**
//     * get report number
//     * @return numerically ordered report number
//     */
//    public String getReportNumber() {
//        return Integer.toString(reportNum);
//    }
// --Commented out by Inspection STOP (4/1/17, 8:32 PM)

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

// --Commented out by Inspection START (4/1/17, 8:33 PM):
//    /**
//     * set contaminant of water
//     * @param aMonth the month of the water
//     */
//    public void setMonth(int aMonth) { month = aMonth; }
// --Commented out by Inspection STOP (4/1/17, 8:33 PM)

// --Commented out by Inspection START (4/1/17, 8:33 PM):
//    /**
//     * get contaminant ppm
//     * @return the month of the water
//     */
//    public double getMonth() {return month; }
// --Commented out by Inspection STOP (4/1/17, 8:33 PM)
    // ***

    /**
     * month calc for Graphs
     * @return the number of the month from the string
     */

    public int monthDate() {
        String month = this.getDate().substring(0, 2).trim();

        if (month.equals("01")) {
            return 1;
        } else if (month.equals("02")) {
            return 2;
        } else if (month.equals("03")) {
            return 3;
        } else if (month.equals("04")) {
            return 4;
        } else if (month.equals("05")) {
            return 5;
        } else if (month.equals("06")) {
            return 6;
        } else if (month.equals("07")) {
            return 7;
        } else if (month.equals("08")) {
            return 8;
        } else if (month.equals("09")) {
            return 9;
        } else if (month.equals("10")) {
            return 10;
        } else if (month.equals("11")) {
            return 11;
        } else if (month.equals("12")) {
            return 12;
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
