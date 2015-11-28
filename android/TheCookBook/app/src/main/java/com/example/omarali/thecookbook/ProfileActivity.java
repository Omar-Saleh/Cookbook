package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView viewFriends = (TextView) this.findViewById(R.id.friends_link_text_view);
        viewFriends.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FriendsActivity.class));
            }
        });

        TextView postRecipe = (TextView) this.findViewById(R.id.post_recipe_link_text_view);
        postRecipe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateRecipeActivity.class));
            }
        });

        TextView accessSettings = (TextView) this.findViewById(R.id.settings_link_text_view);
        accessSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            }
        });

        TextView viewInbox = (TextView) this.findViewById(R.id.private_messaging);
        viewInbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PrivateMessaging.class));
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




//    void friends_OnClickLink(View v)
//    {
//        startActivity(new Intent(this, FriendsActivity.class));
//    }
}
