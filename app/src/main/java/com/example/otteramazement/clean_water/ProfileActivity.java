package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Violet on 2/18/2017.
 * Authors: Violet
 */

public class ProfileActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Setting Fonts, and getting EditText variables

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        TextView acceptButton = (TextView) findViewById(R.id.profile_acceptbutton_tetView);
        acceptButton.setTypeface(font1);
        TextView namePrompt = (TextView) findViewById(R.id.profile_name_textView);
        namePrompt.setTypeface(font);
        EditText nameInput = (EditText) findViewById(R.id.profile_name_input);
        nameInput.setTypeface(font);
        TextView titlePrompt = (TextView) findViewById(R.id.profile_title_textView);
        titlePrompt.setTypeface(font);
        EditText titleInput = (EditText) findViewById(R.id.profile_title_input);
        titleInput.setTypeface(font);
        TextView emailPrompt = (TextView) findViewById(R.id.profile_email_textView);
        emailPrompt.setTypeface(font);
        EditText emailInput = (EditText) findViewById(R.id.profile_email_input);
        emailInput.setTypeface(font);
        TextView streetAddress = (TextView) findViewById(R.id.profile_staddress_textView);
        streetAddress.setTypeface(font);
        EditText streetAddressInput = (EditText) findViewById(R.id.profile_staddress_input);
        streetAddressInput.setTypeface(font);
        TextView cityPrompt = (TextView) findViewById(R.id.profile_city_textView);
        cityPrompt.setTypeface(font);
        EditText cityInput = (EditText) findViewById(R.id.profile_city_input);
        cityInput.setTypeface(font);
        TextView statePrompt = (TextView) findViewById(R.id.profile_state_textView);
        statePrompt.setTypeface(font);
        EditText stateInput = (EditText) findViewById(R.id.profile_state_input);
        stateInput.setTypeface(font);
        TextView countryPrompt = (TextView) findViewById(R.id.profile_country_textView);
        countryPrompt.setTypeface(font);
        EditText countryInput = (EditText) findViewById(R.id.profile_country_input);
        countryInput.setTypeface(font);
        TextView phonePrompt = (TextView) findViewById(R.id.profile_phone_textView);
        phonePrompt.setTypeface(font);
        EditText phoneInput = (EditText) findViewById(R.id.profile_phone_editText);
        phoneInput.setTypeface(font);

        //Done Setting Fonts

        //Setting Button Functions

        ImageView acceptButtonImage = (ImageView) findViewById(R.id.profile_acceptbutton_imageView);
        acceptButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfileData();
            }
        });

        TextView acceptButtonText = (TextView) findViewById(R.id.profile_acceptbutton_tetView);
        acceptButtonText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfileData();
            }
        });

        ImageView backButtonImage = (ImageView) findViewById(R.id.profile_backbutton_imageView);
        backButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), AppActivity.class));
            }
        });

    }

    private void saveProfileData() {
        startActivity(new Intent(getBaseContext(), AppActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
