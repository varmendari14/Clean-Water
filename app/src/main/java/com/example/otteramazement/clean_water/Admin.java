package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/20/2017.
 * Represents the Admin, a subclass of UserProfile
 * Authors: Emma
 */

/**
 * This class represents the administrator, which is a subclass of a user
 */
class Admin extends UserProfile {
    public Admin(ProfileType profileType, String name, String username, String password) {
        super(profileType, name, username, password);
    }

    /**
     * constructor for admin
     * @param profileType admin
     * @param name name of user
     * @param username username of user
     * @param password password
     * @param email email
     * @param address street address
     * @param city city address
     * @param state state
     * @param country country
     * @param phoneNumber phone number
     * @param title dr, mr, mrs, etc
     */
    public Admin(ProfileType profileType, String name, String username, String password,
                       String email, String address, String city, String state, String country,
                       String phoneNumber, String title) {
        super(profileType, name, username, password, email, address, city, state, country, phoneNumber, title);
    }
}
