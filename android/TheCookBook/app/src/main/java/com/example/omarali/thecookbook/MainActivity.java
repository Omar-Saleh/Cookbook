package com.example.omarali.thecookbook;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity extends ActionBarActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        ((CookBook) this.getApplication()).initiate();
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
//
//    }
//
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.menu_main, menu);
////        return true;
////    }
////
//    public void login_buttonOnClick(View v) {
//
//        TextView warning = (TextView) findViewById(R.id.warning_text_view);
//        EditText usernameEditText = (EditText) findViewById(R.id.username_text_field);
//        EditText passwordEditText = (EditText) findViewById(R.id.password_text_field);
//
//        if(usernameEditText.getText().toString().equals("") || passwordEditText.getText().toString().equals(""))
//        {
//            warning.setVisibility(View.VISIBLE);
//            return;
//        }
//        Intent toTimeline = new Intent(this, TimelineActivity.class);
//        toTimeline.putExtra("userId", 1);
//        startActivity(toTimeline);
//      }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.identity.*;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;


public class MainActivity extends Activity {
    private TwitterLoginButton twitterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        twitterButton.onActivityResult(requestCode, resultCode, data);
    }

    private void setUpViews() {
        setUpTwitterButton();
    }

    private void setUpTwitterButton() {
        twitterButton = (TwitterLoginButton) findViewById(R.id.twitter_button);
        twitterButton.setCallback(new Callback() {
            @Override
            public void success(Result result) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.app_name),
                        Toast.LENGTH_SHORT).show();

                setUpViewsForTweetComposer();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.app_name),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpViewsForTweetComposer() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Just setting up my Fabric!");
        builder.show();
    }
}