package com.example.otteramazement.clean_water;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Represents a User's profile.
 * Created by Cat on 2/19/2017.
 * Authors: Cat, Mary
 */

public class UserProfile implements Serializable {
    private ProfileType profileType;
    private String name;
    private String username;
    private String email;
    private String password;
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
        //email = "";
        //address = "";
        //city = "";
        //state = "";
        //country = "";
        //phoneNumber = "";
        //title = "";
    }

    /**
     * Constructor for full profile, including additional info such as address, city, etc.
     * @param profileType   Profile Type
     * @param name          Real Name
     * @param username      Username
     * @param password      Password
     * @param email         Email
     * @param address       Street Address
     * @param city          City
     * @param state         State
     * @param country       Country
     * @param phoneNumber   Phone Number
     * @param title         Title
     */
    public UserProfile(ProfileType profileType, String name, String username, String password,
                       String email, String address, String city, String state, String country,
                       String phoneNumber, String title) {
        this(profileType, name, username, password);
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.title = title;
    }

    /*
     * Basic Getters and Setters for all Profile fields.
     */
    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() { return title; }

    public void setTitle(String aTitle) { this.title = aTitle; }


    //These methods are required by Parcelable

    private UserProfile(Parcel in) {
        profileType = (ProfileType) in.readSerializable();
        name = in.readString();
        username = in.readString();
        email = in.readString();
        password = in.readString();
        address = in.readString();
        city = in.readString();
        state = in.readString();
        country = in.readString();
        phoneNumber = in.readString();
        title = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeSerializable(profileType);
        dest.writeString(password);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(country);
        dest.writeString(phoneNumber);
        dest.writeString(title);
    }

    public static final Parcelable.Creator<UserProfile> CREATOR
            = new Parcelable.Creator<UserProfile>() {
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };
}
