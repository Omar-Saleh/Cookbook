package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    public void addFriend_unfriend_buttonClick(View v)
    {
        Button button = (Button) this.findViewById(R.id.add_friend_button);
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

    public void follow_unfollow_buttonClick(View v)
    {
        Button button = (Button) this.findViewById(R.id.follow_button);
        if(button.getText().toString().equals("unfollow"))
        {
            button.setText("follow");
            Toast sucess = Toast.makeText(getApplicationContext(), "You unfollowed Martin", Toast.LENGTH_SHORT);
            sucess.show();
        }
        else if(button.getText().toString().equals("follow"))
        {
            button.setText("unfollow");
            Toast sucess = Toast.makeText(getApplicationContext(), "You now follow Martin", Toast.LENGTH_SHORT);
            sucess.show();
        }
    }

}
