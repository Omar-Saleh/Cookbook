package com.example.omarali.thecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.omarali.thecookbook.model.Comment;
import com.example.omarali.thecookbook.model.Recipe;
import com.example.omarali.thecookbook.util.ApiRouter;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    private ArrayAdapter<Recipe> recipeList;
    private ArrayAdapter<Comment> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ((CookBook) this.getApplication()).initiate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        refreshViews();
        setUpViews();

    }

    void setUpViews() {
        recipeList = new ArrayAdapter<Recipe>(this, 0);
        commentList = new ArrayAdapter<Comment>(this, 0);
//        refreshViews();

    }



    void refreshViews() {
        ApiRouter.withoutToken().getRecipes(new Callback<List<Recipe>>() {
            @Override
            public void success(List<Recipe> recipes, Response response) {
                recipeList.addAll(recipes);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.toString().toString());
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
    public void login_buttonOnClick(View v) {

        TextView warning = (TextView) findViewById(R.id.warning_text_view);
        EditText usernameEditText = (EditText) findViewById(R.id.username_text_field);
        EditText passwordEditText = (EditText) findViewById(R.id.password_text_field);

        if(usernameEditText.getText().toString().equals("") || passwordEditText.getText().toString().equals(""))
        {
            warning.setVisibility(View.VISIBLE);
            return;
        }

        startActivity(new Intent(this, TimelineActivity.class));
      }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
