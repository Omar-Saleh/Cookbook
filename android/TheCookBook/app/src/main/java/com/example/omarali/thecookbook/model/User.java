package com.example.omarali.thecookbook.model;

import java.util.Date;

/**
 * Created by omarali on 12/14/15.
 */
public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private String country;
    private Date dateOfBirth;
    private String token;
    private int sourceMedia;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getSourceMedia() {
        return sourceMedia;
    }

    public void setSourceMedia(int sourceMedia) {
        this.sourceMedia = sourceMedia;
    }
}
