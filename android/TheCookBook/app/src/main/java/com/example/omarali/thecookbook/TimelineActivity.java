package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TimelineActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Intent from = getIntent();
//        if(from.getSerializableExtra("Post") != null) {
//            Post newPost = (Post) from.getSerializableExtra("Post");
//            boolean isNull = newPost == null? true:false;
//            Log.i("Test " + isNull, newPost.toString());
        int i = 11;
        ArrayList<Post> posts = ((CookBook) this.getApplication()).getPosts();
        Log.i("Test", posts.size() + "");
        for(int k = posts.size() - 1 ; k >= 0 ; k--) {
            Post newPost = posts.get(k);
            TextView nameToBePut = new TextView(this);
            GridLayout.LayoutParams layout = new GridLayout.LayoutParams();
            layout.columnSpec = GridLayout.spec(1);
            layout.rowSpec = GridLayout.spec(i);
            layout.height = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.width = GridLayout.LayoutParams.WRAP_CONTENT;
            nameToBePut.setText(newPost.name);
            nameToBePut.setTextAppearance(this, android.R.style.TextAppearance_Large);
            nameToBePut.setLayoutParams(layout);
            GridLayout myGrid = (GridLayout) findViewById(R.id.gridLayout);
            myGrid.addView(nameToBePut);
            TextView descriptionToBePut = new TextView(this);
            layout = new GridLayout.LayoutParams();
            layout.columnSpec = GridLayout.spec(1);
            layout.rowSpec = GridLayout.spec(i + 1);
            layout.height = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.width = GridLayout.LayoutParams.WRAP_CONTENT;
            descriptionToBePut.setText(newPost.description);
            descriptionToBePut.setTextAppearance(this, android.R.style.TextAppearance_Large);
            descriptionToBePut.setLayoutParams(layout);
            myGrid.addView(descriptionToBePut);
            TextView ownerToBePut = new TextView(this);
            layout = new GridLayout.LayoutParams();
            layout.columnSpec = GridLayout.spec(2);
            layout.rowSpec = GridLayout.spec(i);
            layout.height = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.width = GridLayout.LayoutParams.WRAP_CONTENT;
            ownerToBePut.setText("By: " + newPost.owner);
            ownerToBePut.setTextAppearance(this, android.R.style.TextAppearance_DeviceDefault_Medium);
            ownerToBePut.setLayoutParams(layout);
            myGrid.addView(ownerToBePut);
            nameToBePut.setTag(k);
            ownerToBePut.setTag(k);
            descriptionToBePut.setTag(k);
//            Log.i("IDs", nameToBePut.getId() + " " + ownerToBePut.getId() + " " + descriptionToBePut.getId());
            nameToBePut.setOnClickListener(this);
            ownerToBePut.setOnClickListener(this);
            descriptionToBePut.setOnClickListener(this);
            i += 4;
        }
        TextView viewProfile = (TextView) this.findViewById(R.id.view_profile_link_text_view);
        viewProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

        TextView viewMessages = (TextView) this.findViewById(R.id.view_messages_link_text_view);
        viewMessages.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PrivateMessaging.class));
            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v.getTag() != null) {
//            Log.i("tagToString" , v.getTag().toString());
            Intent toPostView = new Intent(getApplicationContext(), ViewPost.class);
            toPostView.putExtra("postId" , Integer.parseInt(v.getTag().toString()));
            startActivity(toPostView);
        }
    }

    public void imageButtonOnClick(View v) {
        startActivity(new Intent(getApplicationContext(), ViewPost.class));
    }
}
