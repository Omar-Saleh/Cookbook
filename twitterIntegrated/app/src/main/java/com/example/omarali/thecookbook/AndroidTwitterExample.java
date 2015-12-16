package com.example.omarali.thecookbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.omarali.thecookbook.model.User;
import com.example.omarali.thecookbook.util.ApiRouter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import retrofit.RetrofitError;
import retrofit.client.Response;


public class AndroidTwitterExample extends Activity {
    private TwitterLoginButton twitterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
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
        twitterButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
//                Toast.makeText(getApplicationContext(),
//                        getResources().getString(R.string.app_name),
//                        Toast.LENGTH_SHORT).show();
//
//                setUpViewsForTweetComposer();
                TwitterSession Session = result.data;
                Log.i("Hellofrom theother side", Session.getUserName() + "");
                startUp(Session);
            }

            @Override
            public void failure(TwitterException exception) {
//                Toast.makeText(getApplicationContext(),
//                        getResources().getString(R.string.app_name),
//                        Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), test.class);
//                startActivity(intent);

            }
        });
    }

    private void setUpViewsForTweetComposer() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Just setting up my Fabric!");
        builder.show();
    }

    public void startUp(TwitterSession Session) {
        ApiRouter.withoutToken().setUser(Session.getUserName(), Session.getAuthToken().token, new retrofit.Callback<User>() {
            @Override
            public void success(User result, Response response) {
                setAppResult(result);
                fireUp();
            }

            @Override
            public void failure(RetrofitError e) {

            }
        });
    }

    public void fireUp() {
//        Log.i("User ID", app.getCurrentUser().getId() + "");
        Intent toTimeline = new Intent(this, TimelineActivity.class);
        toTimeline.putExtra("userId",  ((CookBook) this.getApplication()).getCurrentUser().getId());
        startActivity(toTimeline);
    }

    public void setAppResult(User user) {
        ((CookBook) this.getApplication()).setCurrentUser(user);
    }
}
