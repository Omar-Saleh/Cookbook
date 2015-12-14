package com.example.omarali.thecookbook.model;

/**
 * Created by omarali on 12/14/15.
 */
public class Friendship {

    private User user1;
    private User user2;
    private boolean accepted = false;

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
