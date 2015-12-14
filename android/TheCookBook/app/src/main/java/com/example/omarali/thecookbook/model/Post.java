package com.example.omarali.thecookbook.model;

/**
 * Created by omarali on 12/14/15.
 */
public class Post {

    private User user;
    private int tagId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String type;

}
