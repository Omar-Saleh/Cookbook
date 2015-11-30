package com.example.omarali.thecookbook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPost extends ActionBarActivity implements View.OnClickListener {

    static int commentContentID;
    int postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        commentContentID = View.generateViewId();
        Intent from = getIntent();
        postId = from.getExtras().getInt("postId");
//        Log.i("Test", postId + "");
        Post currPost = ((CookBook) this.getApplication()).getPosts().get(postId);
        retrievePost(currPost, postId);
        TextView viewProfile = (TextView) this.findViewById(R.id.profile_view);
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

    }

    private void retrievePost(Post currPost, int postId) {
        LinearLayout myView = (LinearLayout) findViewById(R.id.linearLayout);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView postTitle = new TextView(this);
        TextView postDescription = new TextView(this);
        TextView postOwner = new TextView(this);
        TextView postFirstIngredient = new TextView(this);
        TextView postSecondIngredient = new TextView(this);
        TextView postThirdIngredient = new TextView(this);
        TextView postRecipe = new TextView(this);
        TextView commentsTitle = new TextView(this);
        postTitle.setText(currPost.name);
        postDescription.setText(currPost.description);
        postOwner.setText("By: " + currPost.owner);
        postFirstIngredient.setText(currPost.firstIngredient);
        postSecondIngredient.setText(currPost.secondIngredient);
        postThirdIngredient.setText(currPost.thirdIngredient);
        postRecipe.setText(currPost.recipe);
        commentsTitle.setText("Comments :");
        postTitle.setLayoutParams(layout);
        postDescription.setLayoutParams(layout);
        postFirstIngredient.setLayoutParams(layout);
        postSecondIngredient.setLayoutParams(layout);
        postThirdIngredient.setLayoutParams(layout);
        postRecipe.setLayoutParams(layout);
        commentsTitle.setLayoutParams(layout);
        postDescription.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Large);
        postTitle.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Large);
        postTitle.setTextColor(Color.BLACK);
        postDescription.setTextColor(Color.BLACK);
        myView.addView(postOwner);
        myView.addView(postTitle);
        myView.addView(postDescription);
        myView.addView(postFirstIngredient);
        myView.addView(postSecondIngredient);
        myView.addView(postThirdIngredient);
        layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setMargins(0, 20, 0, 20);
        myView.addView(commentsTitle);
        ArrayList<Comment> comments = ((CookBook) this.getApplication()).getComments().get(postId);
        layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setMargins(0, 10, 0, 10);
        ImageView line = new ImageView(this);
        line.setBackgroundColor(Color.BLACK);
        line.setMinimumHeight(5);
        line.setLayoutParams(layout);
        myView.addView(line);
        for(int i = 0 ; i < comments.size() ; i++) {
            layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            TextView commentContent = new TextView(this);
            TextView commentOwner = new TextView(this);
            line = new ImageView(this);
            layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.setMargins(0, 10 , 0, 10);
            line.setBackgroundColor(Color.BLACK);
            line.setMinimumHeight(5);
            line.setLayoutParams(layout);
            commentContent.setText(comments.get(i).content);
            commentOwner.setText(comments.get(i).owner);
            commentContent.setLayoutParams(layout);
            commentOwner.setLayoutParams(layout);
            myView.addView(commentContent);
            myView.addView(commentOwner);
            myView.addView(line);

        }
        layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        EditText commentTobeAdded = new EditText(this);
        commentTobeAdded.setHint("Write a comment...");
        commentTobeAdded.setLayoutParams(layout);
        commentTobeAdded.setId(commentContentID);
        myView.addView(commentTobeAdded);
        layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.gravity = Gravity.RIGHT;
        Button comment = new Button(this);
        comment.setLayoutParams(layout);
        comment.setOnClickListener(this);
        comment.setClickable(true);
        comment.setTag("comment");
        comment.setText("Comment");
        myView.addView(comment);
    }

    @Override
    public void onClick(View v) {
        if(v.getTag().equals("comment")) {
            EditText content = (EditText) findViewById(commentContentID);
                    ((CookBook) getApplication()).setComments(new Comment(content.getText().toString(), "Omar", postId), postId);
            Intent refresh = new Intent(getApplicationContext(), ViewPost.class);
            refresh.putExtra("postId", postId);
            startActivity(refresh);
        }
    }
}
