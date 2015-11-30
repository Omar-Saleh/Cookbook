package com.example.omarali.thecookbook;

/**
 * Created by Omar on 11/30/2015.
 */
public class Comment {

    String content, owner;
    int postId;

    public Comment(String content, String owner, int postId) {
        this.content = content;
        this.owner = owner;
        this.postId = postId;
    }
}
