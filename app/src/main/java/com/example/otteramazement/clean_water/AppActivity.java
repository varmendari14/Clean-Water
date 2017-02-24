package com.example.otteramazement.clean_water;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by maryprouty on 2/12/17.
 * Authors: Mary, Violet
 */

public class AppActivity extends Activity {

    UserProfile _user;

    public static final String ARG_USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        _user = (UserProfile) getIntent().getSerializableExtra(ProfileActivity.ARG_USER);
        if (_user == null) {
            _user = (UserProfile) getIntent().getSerializableExtra(LoginActivity.ARG_USER);
        }

        //Font Set up

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");

        TextView logoutButton = (TextView) findViewById(R.id.app_logout_textView);
        logoutButton.setTypeface(font);
        TextView editprofileButton = (TextView) findViewById(R.id.app_profile_textView);
        editprofileButton.setTypeface(font);
        TextView waterButton = (TextView) findViewById(R.id.app_water_textView);
        waterButton.setTypeface(font);
        TextView historicalButton = (TextView) findViewById(R.id.app_historical_textView);
        historicalButton.setTypeface(font);
        TextView manageButton = (TextView) findViewById(R.id.app_manage_textView);
        manageButton.setTypeface(font);

        //Button Set Up

        ImageView logoutButtonPress = (ImageView) findViewById(R.id.app_logout_imageView);
        logoutButtonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), WelcomeActivity.class));
            }
        });

        ImageView profileButtonPress = (ImageView) findViewById(R.id.app_profile_imageView);
        profileButtonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateIntent = new Intent(getBaseContext(), ProfileActivity.class);
                updateIntent.putExtra(AppActivity.ARG_USER, _user);
                startActivity(updateIntent);
            }
        });

        ImageView waterButtonPress = (ImageView) findViewById(R.id.app_water_imageView);
        waterButtonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), WaterReportActivity.class));
            }
        });

    }

}
