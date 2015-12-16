package com.example.omarali.thecookbook.model;

/**
 * Created by omarali on 12/14/15.
 */
public class Friendship {

    private int u1_id;
    private int u2_id;
    private boolean accepted;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getU2_id() {
        return u2_id;
    }

    public void setU2_id(int u2_id) {
        this.u2_id = u2_id;
    }

    public int getU1_id() {
        return u1_id;
    }

    public void setU1_id(int u1_id) {
        this.u1_id = u1_id;
    }




}
