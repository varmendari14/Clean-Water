package com.example.otteramazement.clean_water;

/**
 * Created by Emma
 * Enum for types of water purity conditions
 */

@SuppressWarnings("DefaultNotLastCaseInSwitch")
public enum WaterPurityCondition {
    SAFE, TREATABLE, UNSAFE;

    /**
     * Returns a Water Purity Condition from a given string.
     * @param type  String name of condition
     * @return      Corresponding condition
     */
    public static String waterPurityConditionToString(WaterPurityCondition type) {
        switch(type) {
            default:
            case SAFE:
                return "SAFE";
            case TREATABLE:
                return "TREATABLE";
            case UNSAFE:
                return "SAFE";
        }
    }
}

