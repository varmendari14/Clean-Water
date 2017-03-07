package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/20/2017.
 * Represents the Manager, a subclass of UserProfile
 * Authors: Emma
 */

/**
 * This class represents the manager which is a subclass of user
 */
public class Manager extends UserProfile {
    public Manager(ProfileType profileType, String name, String username, String password) {
        super(profileType, name, username, password);
    }

    /**
     * constructor for manager
     * @param profileType manager
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
    public Manager(ProfileType profileType, String name, String username, String password,
                 String email, String address, String city, String state, String country,
                 String phoneNumber, String title) {
        super(profileType, name, username, password, email, address, city, state, country, phoneNumber, title);
    }
}
