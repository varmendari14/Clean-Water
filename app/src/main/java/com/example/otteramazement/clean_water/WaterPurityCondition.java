package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 3/7/2017.
 */

public enum WaterPurityCondition {
    SAFE, TREATABLE, UNSAFE;

    /**
     * Returns a Water Purity Condition from a given string.
     * @param type  String name of condition
     * @return      Corresponding condition
     */
    public static String waterPurityContiditionToString(WaterPurityCondition type) {
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

