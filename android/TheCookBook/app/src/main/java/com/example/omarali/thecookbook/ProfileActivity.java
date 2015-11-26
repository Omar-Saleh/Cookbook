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


    }




//    void friends_OnClickLink(View v)
//    {
//        startActivity(new Intent(this, FriendsActivity.class));
//    }
}
