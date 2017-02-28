package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/28/2017.
 */

public enum WaterType {
    BOTTLED, WELL, STREAM, LAKE, SPRING, OTHER;

    /**
     * Returns a water type from a given string.
     * @param type  String name of water type
     * @return      Corresponding water type
     */
    public static WaterType getWaterTypeFromString(String type) {
        switch(type) {
            default:
            case "BOTTLED":
                return WaterType.BOTTLED;
            case "WELL":
                return WaterType.WELL;
            case "STREAM":
                return WaterType.STREAM;
            case "LAKE":
                return WaterType.LAKE;
            case "SPRING":
                return WaterType.SPRING;
            case "OTHER":
                return WaterType.OTHER;
        }
    }
}
