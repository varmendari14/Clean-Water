package com.example.otteramazement.clean_water;

/**Enums that specify what type each account is
 *
 * Created by Avery on 2/19/2017.
 * Authors: Avery, Cat
 */

public enum ProfileType {
    USER, WORKER, MANAGER, ADMIN;

    /**
     * Returns a Profile type from a given string.
     * @param type  String name of profile type
     * @return      Corresponding profile type
     */
    public static ProfileType getTypeFromString(String type) {
        switch(type) {
            default:
            case "USER":
                return ProfileType.USER;
            case "WORKER":
                return ProfileType.WORKER;
            case "MANAGER":
                return ProfileType.MANAGER;
            case "ADMIN":
                return ProfileType.ADMIN;
        }
    }
}
