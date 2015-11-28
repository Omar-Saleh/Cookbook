package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NotFriendProfileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_friend_profile);

        TextView seeFriends = (TextView) this.findViewById(R.id.others_friend_link_text_view);
        seeFriends.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OthersFriendsActivity.class));
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
