package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.omarali.thecookbook.model.Friendship;
import com.example.omarali.thecookbook.model.User;
import com.example.omarali.thecookbook.util.ApiRouter;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FriendsActivity extends ActionBarActivity {

    private ArrayAdapter<User> friendshipList;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        TextView viewProfile = (TextView) this.findViewById(R.id.friend_profile_link);
        viewProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

        TextView viewTimeline = (TextView) this.findViewById(R.id.my_timeline_link);
        viewTimeline.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
            }
        });

        refreshViews();
        setUpViews();

    }

    void refreshViews()
    {
        ApiRouter.withoutToken().getFriendships(1, new Callback<List<User>>() {

            @Override
            public void success(List<User> friendships, Response response) {
                friendshipList.addAll(friendships);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });
    }

    void setUpViews()
    {
        friendshipList = new ArrayAdapter<User>(this, 0);
    }
}
