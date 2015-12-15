package com.example.omarali.thecookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.omarali.thecookbook.model.Recipe;
import com.example.omarali.thecookbook.model.User;
import com.example.omarali.thecookbook.util.ApiRouter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TimelineActivity extends ActionBarActivity implements View.OnClickListener {

//    private ArrayAdapter<Recipe> recipeList = new ArrayAdapter<Recipe>(this, 0);

    private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Intent from = getIntent();
        ApiRouter.withoutToken().getTimeLine(1, new Callback<List<Recipe>>() {
            @Override
            public void success(List<Recipe> recipes, Response response) {
                recipeList.addAll(recipes);
                paintMyWindow();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });
//        ArrayList<Post> posts = ((CookBook) this.getApplication()).getPosts();
        Log.i("Test", recipeList.size() + "");


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
            toPostView.putExtra("recipeId" , Integer.parseInt(v.getTag().toString()));
            startActivity(toPostView);
        }
    }

    public void imageButtonOnClick(View v) {
        startActivity(new Intent(getApplicationContext(), ViewPost.class));
    }

    public void paintMyWindow() {
        int i = 11;
        for(int k = recipeList.size() - 1 ; k >= 0 ; k--) {
            Recipe newRecipe = recipeList.get(k);
            TextView nameToBePut = new TextView(this);
            GridLayout.LayoutParams layout = new GridLayout.LayoutParams();
            layout.columnSpec = GridLayout.spec(1);
            layout.rowSpec = GridLayout.spec(i);
            layout.height = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.width = GridLayout.LayoutParams.WRAP_CONTENT;
            nameToBePut.setText(newRecipe.getName());
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
            descriptionToBePut.setText(newRecipe.getDescription());
            descriptionToBePut.setTextAppearance(this, android.R.style.TextAppearance_Large);
            descriptionToBePut.setLayoutParams(layout);
            myGrid.addView(descriptionToBePut);
            TextView ownerToBePut = new TextView(this);
            layout = new GridLayout.LayoutParams();
            layout.columnSpec = GridLayout.spec(2);
            layout.rowSpec = GridLayout.spec(i);
            layout.height = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.width = GridLayout.LayoutParams.WRAP_CONTENT;
            layout.setMargins(20, 0, 0, 0);
            ownerToBePut.setText("By: " + newRecipe.getName());
            ownerToBePut.setTextAppearance(this, android.R.style.TextAppearance_DeviceDefault_Medium);
            ownerToBePut.setLayoutParams(layout);
            myGrid.addView(ownerToBePut);
            nameToBePut.setTag(newRecipe.getId());
            ownerToBePut.setTag(newRecipe.getId());
            descriptionToBePut.setTag(newRecipe.getId());
//            Log.i("IDs", nameToBePut.getId() + " " + ownerToBePut.getId() + " " + descriptionToBePut.getId());
            nameToBePut.setOnClickListener(this);
            ownerToBePut.setOnClickListener(this);
            descriptionToBePut.setOnClickListener(this);
            i += 4;
        }
    }
}
