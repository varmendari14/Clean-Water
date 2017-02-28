package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/28/2017.
 */

public enum WaterCondition {
    WASTE, TREATABLE_MUDDY, TREATABLE_CLEAR, POTABLE;

    /**
     * Returns a Water Condition from a given string.
     * @param type  String name of condition
     * @return      Corresponding condition
     */
    public static WaterCondition getConditionFromString(String type) {
        switch(type) {
            default:
            case "WASTE":
                return WaterCondition.WASTE;
            case "TREATABLE_MUDDY":
                return WaterCondition.TREATABLE_MUDDY;
            case "TREATABLE_CLEAR":
                return WaterCondition.TREATABLE_CLEAR;
            case "POTABLE":
                return WaterCondition.POTABLE;
        }
    }
}
