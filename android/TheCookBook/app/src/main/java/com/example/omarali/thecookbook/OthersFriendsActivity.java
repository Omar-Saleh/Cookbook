package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OthersFriendsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_friends);

        TextView viewProfile = (TextView) this.findViewById(R.id.not_friend_profile_link);
        viewProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NotFriendProfileActivity.class));
            }
        });

        TextView viewTimeline = (TextView) this.findViewById(R.id.my_timeline_link);
        viewTimeline.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
            }
        });

    }
}
