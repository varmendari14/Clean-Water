package com.example.otteramazement.clean_water;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mary on 2/12/17.
 * This activity controls the app
 * Authors: Mary, Violet
 */

@SuppressWarnings("ChainedMethodCall")
public class AppActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        //Font Set up

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");

        TextView logoutButton = (TextView) findViewById(R.id.app_logout_textView);
        logoutButton.setTypeface(font);
        TextView editProfileButton = (TextView) findViewById(R.id.app_profile_textView);
        editProfileButton.setTypeface(font);
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
                CurrentUser.currentUser.remove();
                startActivity(new Intent(getBaseContext(), WelcomeActivity.class));
            }
        });

        ImageView profileButtonPress = (ImageView) findViewById(R.id.app_profile_imageView);
        profileButtonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateIntent = new Intent(getBaseContext(), ProfileActivity.class);
                startActivity(updateIntent);
            }
        });

        ImageView waterButtonPress = (ImageView) findViewById(R.id.app_water_imageView);
        waterButtonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIntent = new Intent(getBaseContext(), WaterReportActivity.class);
                startActivity(reportIntent);
            }
        });

        ImageView manageUserImage = (ImageView) findViewById(R.id.app_manage_imageView);

        if (CurrentUser.currentUser.get(0).getProfileType().equals(ProfileType.ADMIN)) {
            manageUserImage.setVisibility(View.VISIBLE);
            manageButton.setVisibility(View.VISIBLE);
        }

        ImageView historicalUserImage = (ImageView) findViewById(R.id.app_historical_imageView);
        historicalUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIntent = new Intent(getBaseContext(),
                                    HistoricalReportChoiceActivity.class);
                startActivity(reportIntent);
            }
        });

        if (CurrentUser.currentUser.get(0).getProfileType().equals(ProfileType.MANAGER)) {
            historicalUserImage.setVisibility(View.VISIBLE);
            historicalButton.setVisibility(View.VISIBLE);
        }

    }

}
