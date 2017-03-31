package com.example.otteramazement.clean_water;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Represents a User's profile.
 * Created by Cat on 2/19/2017.
 * Authors: Cat, Mary Prouty, Violet Armendariz, Emma
 */

/**
 * represents user
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
    UserProfile(ProfileType profileType, String name, String username, String password,
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

    /**
     * Get the Profile Type field.
     * @return profileType the type of the profile
     */

    public ProfileType getProfileType() {
        return profileType;
    }

    /**
     * Set the Profile Type field.
     * @param profileType the type of the profile
     */

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
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
     * Set the username field.
     * @param username the username of the profile
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password field.
     * @return password the password of the profile
     */

    public String getPassword() {
        return password;
    }

    /**
     * Set the password field.
     * @param password the password of the profile
     */

    public void setPassword(String password) {
        this.password = password;
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


    //These methods are required by Parcelable
    /**
     *
     * Method Required for parcelable
     * @param in Parcel
     *
     */
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

    /**
     *
     * Method Required for parcelable
     * @return 0
     *
     */

    @SuppressWarnings("SameReturnValue")
    public int describeContents() {
        return 0;
    }

    /**
     *
     * Method Required for parcelable
     * used for writing to the parcel destination
     * @param dest Parcel
     * @param flags Int
     *
     */

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

    //These Lines create the userProfile Parcelable

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
