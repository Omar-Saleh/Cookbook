package com.example.omarali.thecookbook.model;

import java.util.Date;

/**
 * Created by omarali on 12/14/15.
 */
public class User {

    private String f_name;
    private String l_name;
    private int age, id;
    private String city;
    private String country;
    private Date dateOfBirth;
    private String token;
    private int sourceMedia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return f_name;
    }

    public void setFirstName(String firstName) {
        this.f_name = firstName;
    }

    public String getLastName() {
        return l_name;
    }

    public void setLastName(String lastName) {
        this.l_name = lastName;
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