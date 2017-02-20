package com.example.otteramazement.clean_water;

/**
 * Created by Emma on 2/20/2017.
 */

public class Admin extends UserProfile {
    public Admin(ProfileType profileType, String name, String username, String password) {
        super(profileType, name, username, password);
    }

    public Admin(ProfileType profileType, String name, String username, String password,
                       String email, String address, String city, String state, String country,
                       String phoneNumber, String title) {
        super(profileType, name, username, password, email, address, city, state, country, phoneNumber, title);
    }
}
