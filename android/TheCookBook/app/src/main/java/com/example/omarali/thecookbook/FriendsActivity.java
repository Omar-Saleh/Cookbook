package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FriendsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        TextView viewProfile = (TextView) this.findViewById(R.id.friend_profile_link);
        viewProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FriendsPofileActivity.class));
            }
        });

    }
}
