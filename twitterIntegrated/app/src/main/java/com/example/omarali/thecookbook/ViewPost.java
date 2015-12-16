package com.example.omarali.thecookbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omarali.thecookbook.model.Comment;
import com.example.omarali.thecookbook.model.Recipe;
import com.example.omarali.thecookbook.util.ApiRouter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ViewPost extends ActionBarActivity implements View.OnClickListener {

    static int commentContentID;
    int recipeId;
    Recipe recipe = new Recipe();
    ArrayList<Comment> comments = new ArrayList<Comment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        commentContentID = View.generateViewId();
        Intent from = getIntent();
        recipeId = from.getExtras().getInt("recipeId");
        Log.i("Test", recipeId + "");
//        Post currPost = ((CookBook) this.getApplication()).getPosts().get(postId);
        //retrievePost(currPost, postId);
        TextView viewProfile = (TextView) this.findViewById(R.id.profile_view);
        viewProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent toProfile = new Intent(getApplicationContext(), ProfileActivity.class);
                toProfile.putExtra("userId", 1);
                startActivity(toProfile);
            }
        });

        TextView viewTimeline = (TextView) this.findViewById(R.id.my_timeline_link);
        viewTimeline.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
            }
        });

        ApiRouter.withoutToken().getRecipe(recipeId, new Callback<Recipe>() {

            @Override
            public void success(Recipe rec, Response response) {
                recipe = rec;
//                Log.i("Sucess", userProfile.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });

        ApiRouter.withoutToken().getRecipeComments(recipeId, new Callback<List<Comment>>() {

            @Override
            public void success(List<Comment> com, Response response) {
                comments.addAll(com);
//                Log.i("Sucess", userProfile.toString());
                drawPage();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });

    }

    private void drawPage() {
        LinearLayout myView = (LinearLayout) findViewById(R.id.linearLayout);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView postTitle = new TextView(this);
        TextView postDescription = new TextView(this);
        TextView postOwner = new TextView(this);
        TextView postRecipe = new TextView(this);
        TextView commentsTitle = new TextView(this);
        postTitle.setText(recipe.getName());
        postDescription.setText(recipe.getDescription());
        postOwner.setText("By: " + recipe.getUser_name());
        postRecipe.setText(recipe.getDescription());
        commentsTitle.setText("Comments :");
        postTitle.setLayoutParams(layout);
        postDescription.setLayoutParams(layout);
        postRecipe.setLayoutParams(layout);
        commentsTitle.setLayoutParams(layout);
        postDescription.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Large);
        postTitle.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Large);
        postTitle.setTextColor(Color.BLACK);
        postDescription.setTextColor(Color.BLACK);
        myView.addView(postOwner);
        myView.addView(postTitle);
        myView.addView(postDescription);
        layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setMargins(0, 20, 0, 20);
        myView.addView(commentsTitle);
//        ArrayList<Comment> comments = ((CookBook) this.getApplication()).getComments().get(recipeId);
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
            commentContent.setText(comments.get(i).getBody());
            commentOwner.setText(comments.get(i).getUser_id() + "");
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
//                    ((CookBook) getApplication()).setComments(new Comment(content.getText().toString(), "Omar", postId), postId);
            ApiRouter.withoutToken().setRecipeComment(recipeId, content.getText().toString(), new Callback<Comment>() {
                @Override
                public void success(Comment comment, Response response) {
                    Toast sucess = Toast.makeText(getApplicationContext(), "Comment Successfully Created!", Toast.LENGTH_SHORT);
                    sucess.show();
                    Intent refresh = new Intent(getApplicationContext(), ViewPost.class);
                    refresh.putExtra("recipeId", recipeId);
                    startActivity(refresh);
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
        }
    }
}