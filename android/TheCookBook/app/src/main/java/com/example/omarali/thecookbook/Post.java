package com.example.omarali.thecookbook;

import java.io.Serializable;

/**
 * Created by Omar on 11/29/2015.
 */
public class Post implements Serializable {

    String description, name, owner;

    public Post(String description, String name, String owner) {
        this.description = description;
        this.name = name;
        this.owner = owner;
    }

}
