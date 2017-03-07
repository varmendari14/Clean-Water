package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.HashMap;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Violet on 2/16/2017.
 * Authors: Violet, Avery, Mary, Cat, Emma
 */

/**
 * This class controls the registration of new users
 */
public class RegisterActivity extends Activity {

    private EditText nameInput;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText passwordRedo;
    private Spinner typeSpinner;

    //private static HashMap<String, UserProfile> userMap = new HashMap<>();

    public static final String ARG_USER = "user";


    private static List<ProfileType> ProfileAdapter = Arrays.asList(ProfileType.USER, ProfileType.WORKER,
            ProfileType.MANAGER, ProfileType.ADMIN);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Setting Fonts, and getting EditText variables

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        TextView registerButton = (TextView) findViewById(R.id.register_registerbutton_textView);
        registerButton.setTypeface(font1);

        TextView namePrompt = (TextView) findViewById(R.id.register_name_textView);
        namePrompt.setTypeface(font);
        nameInput = (EditText) findViewById(R.id.register_name_input);
        nameInput.setTypeface(font1);

        TextView usernamePrompt = (TextView) findViewById(R.id.register_username_textView);
        usernamePrompt.setTypeface(font);
        usernameInput = (EditText) findViewById(R.id.register_username_input);
        usernameInput.setTypeface(font1);

        TextView passwordPrompt = (TextView) findViewById(R.id.register_password_textView);
        passwordPrompt.setTypeface(font);
        passwordInput = (EditText) findViewById(R.id.register_password_input);
        passwordInput.setTypeface(font1);

        TextView passwordRedoPrompt1 = (TextView) findViewById(R.id.register_retype_textView);
        passwordRedoPrompt1.setTypeface(font);
        TextView passwordRedoPrompt2 = (TextView) findViewById(R.id.register_retypepass_textView);
        passwordRedoPrompt2.setTypeface(font);
        passwordRedo = (EditText) findViewById(R.id.register_retypepassword_input);
        passwordRedo.setTypeface(font1);

        TextView typePrompt = (TextView) findViewById(R.id.register_type_textView);
        typePrompt.setTypeface(font);


        //Done Setting Fonts

        //Setting Button Functions

        ImageView registerButtonImage = (ImageView) findViewById(R.id.register_imageView);
        registerButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });

        ImageView backButtonImage = (ImageView) findViewById(R.id.register_backbuttonimageView);
        backButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), WelcomeActivity.class));
            }
        });

        //Spinner

        typeSpinner = (Spinner) findViewById(R.id.register_typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, ProfileAdapter);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

    }

    /**
     * Attempts to register the account specified by the register form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */

    private void attemptRegistration() {
        if (passwordInput.getText().toString().equals(passwordRedo.getText().toString())
                && usernameInput.getText().toString().length() >= 3
                && nameInput.getText().toString().length() >= 1
                && !OurHashMap.userMap.containsKey(usernameInput.getText().toString())) {

            UserProfile newUser = new UserProfile((ProfileType) typeSpinner.getSelectedItem(),
                    nameInput.getText().toString(),
                    usernameInput.getText().toString(),
                    passwordInput.getText().toString());

            OurHashMap.userMap.put(usernameInput.getText().toString(), newUser);
            Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
            intent.putExtra(RegisterActivity.ARG_USER, newUser);
            startActivity(intent);

        } else if (! passwordInput.getText().toString().equals(passwordRedo.getText().toString())) {

            AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
            alert.setTitle("Invalid Registration");
            alert.setMessage("Your passwords do not match");
            alert.show();

        } else if (usernameInput.getText().toString().length() < 3 ||
                nameInput.getText().toString().length() == 0) {

            AlertDialog.Builder nameProblem = new AlertDialog.Builder(RegisterActivity.this);
            nameProblem.setTitle("Invalid Registration");
            nameProblem.setMessage("Your name or username isn't long enough");
            nameProblem.show();
        } else if (OurHashMap.userMap.containsKey(usernameInput.getText().toString())) {
            AlertDialog.Builder nameProblem = new AlertDialog.Builder(RegisterActivity.this);
            nameProblem.setTitle("Invalid Registration");
            nameProblem.setMessage("This username is already being used.");
            nameProblem.show();
        }
    }

    /**
     * This is a getter for the hashmap that holds all of the users info
     * @return hash map of users and passwords
     */
    public static HashMap<String,UserProfile> getUserMap() {
        return OurHashMap.userMap;
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
