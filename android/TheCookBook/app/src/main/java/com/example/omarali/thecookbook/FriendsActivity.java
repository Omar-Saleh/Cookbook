package com.example.omarali.thecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omarali.thecookbook.model.User;
import com.example.omarali.thecookbook.util.ApiRouter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FriendsActivity extends ActionBarActivity implements View.OnClickListener {

    private ArrayList<User> friends = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        TextView viewTimeline = (TextView) this.findViewById(R.id.my_timeline_link);
        viewTimeline.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
            }
        });

        refreshViews();

    }

    void refreshViews()
    {
        ApiRouter.withoutToken().getFriendships(1, new Callback<List<User>>() {

            @Override
            public void success(List<User> friendships, Response response) {
//                Log.i("Size", friendships.size() + "");
//                    Log.i("User" + i, friendships.get(0).getId() + "");
                    friends.addAll(friendships);
                paintMyPage();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });
    }

    public void paintMyPage() {
        LinearLayout myView = (LinearLayout) findViewById(R.id.linearLayout);
        LinearLayout.LayoutParams layout =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        for(int i = 0 ; i < friends.size() ; i++) {
            User friend = friends.get(i);
            TextView nameToBePut = new TextView(this);
            nameToBePut.setText(friend.getFirstName() + " " + friend.getLastName());
            nameToBePut.setLayoutParams(layout);
            nameToBePut.setTag(friend.getId());
            nameToBePut.setOnClickListener(this);
            myView.addView(nameToBePut);
        }
    }
    public void onClick(View v) {
        if(v.getTag() != null) {
            Intent toProfile = new Intent(getApplicationContext(), ProfileActivity.class);
            toProfile.putExtra("userId" , Integer.parseInt(v.getTag().toString()));
            startActivity(toProfile);
        }
    }
}
