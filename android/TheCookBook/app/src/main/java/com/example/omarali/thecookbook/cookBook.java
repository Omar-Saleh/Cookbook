package com.example.omarali.thecookbook;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Omar on 11/30/2015.
 */
public class cookBook extends Application {

    private ArrayList<Post> posts;

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(Post post) {
        this.posts.add(post);
    }

    public void initiate() {
        this.posts = new ArrayList<Post>();
    }
}
