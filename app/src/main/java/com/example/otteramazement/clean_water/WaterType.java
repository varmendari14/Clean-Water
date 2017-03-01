package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/28/2017.
 * Authors: Emma, Violet
 */

public enum WaterType {
    BOTTLED, WELL, STREAM, LAKE, SPRING, OTHER;

    /**
     * Returns a water type from a given string.
     * @param type  String name of water type
     * @return      Corresponding water type
     */
    public static String waterTypeToString(WaterType type) {
        switch(type) {
            default:
            case BOTTLED:
                return "BOTTLED";
            case WELL:
                return "WELL";
            case STREAM:
                return "STREAM";
            case LAKE:
                return "LAKE";
            case SPRING:
                return "SPRING";
            case OTHER:
                return "OTHER";
        }
    }
}
