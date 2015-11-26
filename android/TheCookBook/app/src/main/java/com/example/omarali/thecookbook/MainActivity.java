package com.example.omarali.thecookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void login_buttonOnClick(View v) {

        TextView warning = (TextView) findViewById(R.id.warning_text_view);
        EditText usernameEditText = (EditText) findViewById(R.id.username_text_field);
        EditText passwordEditText = (EditText) findViewById(R.id.password_text_field);

        if(usernameEditText.getText().toString().equals("") || passwordEditText.getText().toString().equals(""))
        {
            warning.setVisibility(View.VISIBLE);
            return;
        }

        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}