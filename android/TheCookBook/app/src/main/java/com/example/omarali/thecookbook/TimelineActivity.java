package com.example.omarali.thecookbook;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TimelineActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Intent from = getIntent();
        if(from.getSerializableExtra("Post") != null) {
            Post newPost = (Post) from.getSerializableExtra("Post");
//            boolean isNull = newPost == null? true:false;
//            Log.i("Test " + isNull, newPost.toString());
//          Log.i("Test", newPost.description);
            TextView nameToBePut = new TextView(this);
            GridLayout.LayoutParams layout = new GridLayout.LayoutParams();
            layout.columnSpec = GridLayout.spec(1);
            layout.rowSpec = GridLayout.spec(12);
            layout.height = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.width= GridLayout.LayoutParams.WRAP_CONTENT;
            nameToBePut.setText(newPost.name);
            nameToBePut.setTextAppearance(this, android.R.style.TextAppearance_Large);
            nameToBePut.setLayoutParams(layout);
            GridLayout myGrid = (GridLayout) findViewById(R.id.gridLayout);
            myGrid.addView(nameToBePut);
            TextView descriptionToBePut = new TextView(this);
            layout.columnSpec = GridLayout.spec(2);
            descriptionToBePut.setText(newPost.description);
            descriptionToBePut.setTextAppearance(this, android.R.style.TextAppearance_Large);
            descriptionToBePut.setLayoutParams(layout);
            myGrid.addView(descriptionToBePut);
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

    public void imageButtonOnClick(View v) {
        startActivity(new Intent(getApplicationContext(), ViewPost.class));
    }
}
