package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/20/2017.
 * Represents the Manager, a subclass of UserProfile
 * Authors: Emma
 */

public class Manager extends UserProfile {
    public Manager(ProfileType profileType, String name, String username, String password) {
        super(profileType, name, username, password);
    }

    public Manager(ProfileType profileType, String name, String username, String password,
                 String email, String address, String city, String state, String country,
                 String phoneNumber, String title) {
        super(profileType, name, username, password, email, address, city, state, country, phoneNumber, title);
    }
}
