package com.example.otteramazement.clean_water;

import java.io.Serializable;

/**
 * Represents a User's profile.
 * Created by Cat on 2/19/2017.
 * Authors: Cat, Mary, Violet, Emma
 */

/**
 * represents user
 */
class UserProfile implements Serializable {
    private final ProfileType profileType;
    private String name;
    private final String username;
    private String email;
    private final String password;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phoneNumber;
    private String title;

    /**
     * Constructor for basic profile, barring additional info such as address, city, etc.
     * @param profileType   Profile Type
     * @param name          Real Name
     * @param username      Username
     * @param password      Password
     */
    public UserProfile(ProfileType profileType, String name, String username, String password) {
        this.profileType = profileType;
        this.name = name;
        this.username = username;
        this.password = password;
    }

// --Commented out by Inspection START (4/1/17, 8:41 PM):
//    /**
//     * Constructor for full profile, including additional info such as address, city, etc.
//     * @param profileType   Profile Type
//     * @param name          Real Name
//     * @param username      Username
//     * @param password      Password
//     * @param email         Email
//     * @param address       Street Address
//     * @param city          City
//     * @param state         State
//     * @param country       Country
//     * @param phoneNumber   Phone Number
//     * @param title         Title
//     */
//    UserProfile(ProfileType profileType, String name, String username, String password,
//                String email, String address, String city, String state, String country,
//                String phoneNumber, String title) {
//        this(profileType, name, username, password);
//        this.email = email;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.phoneNumber = phoneNumber;
//        this.title = title;
//    }
// --Commented out by Inspection STOP (4/1/17, 8:41 PM)

    /**
     * Get the Profile Type field.
     * @return profileType the type of the profile
     */

    public ProfileType getProfileType() {
        return profileType;
    }

    /**
     * Get the name field.
     * @return name the name of the profile
     */

    public String getName() {
        return name;
    }

    /**
     * Set the name field.
     * @param name the name of the profile
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the username field.
     * @return username the username of the profile
     */

    public String getUsername() {
        return username;
    }

    /**
     * Get the email field.
     * @return email the email of the profile
     */

    public String getEmail() {
        return email;
    }

    /**
     * Set the email field.
     * @param email the email of the profile
     */


    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the address field.
     * @return address the address of the profile
     */

    public String getAddress() {
        return address;
    }

    /**
     * Set the address field.
     * @param address the address of the profile
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the city field.
     * @return city the city of the profile
     */

    public String getCity() {
        return city;
    }

    /**
     * Set the city field.
     * @param city the city of the profile
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state field.
     * @return state the state of the profile
     */

    public String getState() {
        return state;
    }

    /**
     * Set the state field.
     * @param state the state of the profile
     */

    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the country field.
     * @return country the country of the profile
     */

    public String getCountry() {
        return country;
    }

    /**
     * Set the country field.
     * @param country the country of the profile
     */

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the phoneNumber field.
     * @return phoneNumber the phoneNumber of the profile
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phoneNumber field.
     * @param phoneNumber the phoneNumber of the profile
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the title field.
     * @return title the title of the user
     */

    public String getTitle() { return title; }

    /**
     * Set the title field.
     * @param aTitle the title of the user
     */

    public void setTitle(String aTitle) { this.title = aTitle; }

    public String getPassword() { return password; }

}
