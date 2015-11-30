package com.example.omarali.thecookbook;

import java.io.Serializable;

/**
 * Created by Omar on 11/29/2015.
 */
public class Post {

    String description, name, owner, firstIngredient, secondIngredient, thirdIngredient, recipe;

    public Post(String description, String name, String owner, String firstIngredient, String secondIngredient, String thirdIngredient
    , String recipe) {
        this.description = description;
        this.name = name;
        this.owner = owner;
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.thirdIngredient = thirdIngredient;
        this.recipe = recipe;
    }

}
