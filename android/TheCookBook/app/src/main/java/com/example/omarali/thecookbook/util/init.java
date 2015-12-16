package com.example.omarali.thecookbook.util;

/**
 * Created by Omar on 12/16/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.omarali.thecookbook.MainActivity;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;


public class init extends Activity {
    private static final String TWITTER_KEY = "WDuhNUL7cEztJEKuPnqfBDV2K";
    private static final String TWITTER_SECRET = "5vVNEtG2UvJBOgVbIZ6xBzb6sgwZefRMG7332JLPyeJVwGxqz4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        startLoginActivity();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}