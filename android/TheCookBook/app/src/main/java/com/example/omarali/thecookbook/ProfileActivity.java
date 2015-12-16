package com.example.omarali.thecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.omarali.thecookbook.model.User;
import com.example.omarali.thecookbook.util.ApiRouter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProfileActivity extends ActionBarActivity {

    //    ArrayList<User> userArrayList = new ArrayList<User>();
    User userProfile;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent from = getIntent();
        userId = from.getExtras().getInt("userId");
        ApiRouter.withoutToken().getUserProfile(userId, new Callback<User>() {

            @Override
            public void success(User user, Response response) {
                userProfile = user;
//                Log.i("Sucess", userProfile.toString());
                drawPage();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });
    }

    void drawPage()
    {
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
                Intent toTimeline = new Intent(getApplicationContext(), TimelineActivity.class);
                toTimeline.putExtra("userId", userId);
                startActivity(toTimeline);
            }
        });

        if(userId != 1)
            viewTimeline.setText(userProfile.getFirstName() + "'s Timeline");





        TextView name = (TextView) this.findViewById(R.id.name_text_view);
        name.setText( userProfile.getFirstName() + " " + userProfile.getLastName());

        TextView age = (TextView) this.findViewById(R.id.age_text_view);
        age.setText("Age: " + userProfile.getAge());

        TextView location = (TextView) this.findViewById(R.id.location_text_view);
        location.setText("Location: " + userProfile.getCountry());



    }



}




//    void friends_OnClickLink(View v)
//    {
//        startActivity(new Intent(this, FriendsActivity.class));
//    }
