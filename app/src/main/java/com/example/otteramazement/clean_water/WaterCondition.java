package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/28/2017.
 * Authors: Emma, Violet
 */

@SuppressWarnings("DefaultNotLastCaseInSwitch")
public enum WaterCondition {
    WASTE, TREATABLE_MUDDY, TREATABLE_CLEAR, POTABLE;

    /**
     * Returns a Water Condition from a given string.
     * @param type  String name of condition
     * @return      Corresponding condition
     */
    public static String waterConditionToString(WaterCondition type) {
        switch(type) {
            default:
            case WASTE:
                return "WASTE";
            case TREATABLE_MUDDY:
                return "TREATABLE_MUDDY";
            case TREATABLE_CLEAR:
                return "TREATABLE_CLEAR";
            case POTABLE:
                return "POTABLE";
        }
    }
}
