package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FriendsPofileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_pofile);

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

    public void unfriend_addFriend_buttonClick(View v)
    {
        Button button = (Button) this.findViewById(R.id.unfriend_button);
        if(button.getText().toString().equals("unfriend"))
        {
            button.setText("add friend");
            Toast sucess = Toast.makeText(getApplicationContext(), "You unfriended Omar", Toast.LENGTH_SHORT);
            sucess.show();
        }
        else if(button.getText().toString().equals("add friend"))
        {
            button.setText("pending friend request");
            Toast sucess = Toast.makeText(getApplicationContext(), "Friend request successfully sent", Toast.LENGTH_SHORT);
            sucess.show();
        }
    }

    public void unfollow_follow_buttonClick(View v)
    {
        Button button = (Button) this.findViewById(R.id.unfollow_button);
        if(button.getText().toString().equals("unfollow"))
        {
            button.setText("follow");
            Toast sucess = Toast.makeText(getApplicationContext(), "You unfollowed Omar", Toast.LENGTH_SHORT);
            sucess.show();
        }
        else if(button.getText().toString().equals("follow"))
        {
            button.setText("unfollow");
            Toast sucess = Toast.makeText(getApplicationContext(), "You now follow Omar", Toast.LENGTH_SHORT);
            sucess.show();
        }
    }
}
