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
 * Authors: Violet, Mary
 */

public class ProfileActivity extends Activity{

    UserProfile _user;

    public static final String ARG_USER = "user";

    private EditText nameInput;
    private EditText titleInput;
    private EditText emailInput;
    private EditText streetAddressInput;
    private EditText cityInput;
    private EditText stateInput;
    private EditText countryInput;
    private EditText phoneInput;

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
        nameInput = (EditText) findViewById(R.id.profile_name_input);
        nameInput.setTypeface(font);
        TextView titlePrompt = (TextView) findViewById(R.id.profile_title_textView);
        titlePrompt.setTypeface(font);
        titleInput = (EditText) findViewById(R.id.profile_title_input);
        titleInput.setTypeface(font);
        TextView emailPrompt = (TextView) findViewById(R.id.profile_email_textView);
        emailPrompt.setTypeface(font);
        emailInput = (EditText) findViewById(R.id.profile_email_input);
        emailInput.setTypeface(font);
        TextView streetAddress = (TextView) findViewById(R.id.profile_staddress_textView);
        streetAddress.setTypeface(font);
        streetAddressInput = (EditText) findViewById(R.id.profile_staddress_input);
        streetAddressInput.setTypeface(font);
        TextView cityPrompt = (TextView) findViewById(R.id.profile_city_textView);
        cityPrompt.setTypeface(font);
        cityInput = (EditText) findViewById(R.id.profile_city_input);
        cityInput.setTypeface(font);
        TextView statePrompt = (TextView) findViewById(R.id.profile_state_textView);
        statePrompt.setTypeface(font);
        stateInput = (EditText) findViewById(R.id.profile_state_input);
        stateInput.setTypeface(font);
        TextView countryPrompt = (TextView) findViewById(R.id.profile_country_textView);
        countryPrompt.setTypeface(font);
        countryInput = (EditText) findViewById(R.id.profile_country_input);
        countryInput.setTypeface(font);
        TextView phonePrompt = (TextView) findViewById(R.id.profile_phone_textView);
        phonePrompt.setTypeface(font);
        phoneInput = (EditText) findViewById(R.id.profile_phone_editText);
        phoneInput.setTypeface(font);

        //Done Setting Fonts

        //Setting Name and other various inputs provided by user
        _user = (UserProfile) getIntent().getSerializableExtra(AppActivity.ARG_USER);
        if (_user == null) {
            _user = (UserProfile) getIntent().getSerializableExtra(RegisterActivity.ARG_USER);
        }
        nameInput.setText(_user.getName());
        streetAddressInput.setText(_user.getAddress());
        cityInput.setText(_user.getCity());
        stateInput.setText(_user.getState());
        phoneInput.setText(_user.getPhoneNumber());
        countryInput.setText(_user.getCountry());
        emailInput.setText(_user.getEmail());
        titleInput.setText(_user.getTitle());



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
        _user.setName(nameInput.getText().toString());
        _user.setAddress(streetAddressInput.getText().toString());
        _user.setCity(cityInput.getText().toString());
        _user.setState(stateInput.getText().toString());
        _user.setCountry(countryInput.getText().toString());
        _user.setPhoneNumber(phoneInput.getText().toString());
        _user.setEmail(emailInput.getText().toString());
        _user.setTitle(titleInput.getText().toString());
        Intent profIntent = new Intent(getBaseContext(), AppActivity.class);
        profIntent.putExtra(ProfileActivity.ARG_USER, _user);
        startActivity(profIntent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
