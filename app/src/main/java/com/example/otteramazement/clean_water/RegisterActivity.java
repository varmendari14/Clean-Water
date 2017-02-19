package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/**
 * Created by Violet on 2/16/2017.
 * Authors: Violet, Avery
 */

public class RegisterActivity extends Activity {

    private EditText registerButton;
    private EditText usernameInput;
    private EditText passwordInput;
    private EditText passwordRedo;

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
        EditText nameInput = (EditText) findViewById(R.id.register_name_input);
        nameInput.setTypeface(font);
        TextView usernamePrompt = (TextView) findViewById(R.id.register_username_textView);
        usernamePrompt.setTypeface(font);
        EditText usernameInput = (EditText) findViewById(R.id.register_username_input);
        usernameInput.setTypeface(font);
        TextView passwordPrompt = (TextView) findViewById(R.id.register_password_textView);
        passwordPrompt.setTypeface(font);
        EditText passwordInput = (EditText) findViewById(R.id.register_password_input);
        passwordInput.setTypeface(font);
        TextView passwordRedoPrompt1 = (TextView) findViewById(R.id.register_retype_textView);
        passwordRedoPrompt1.setTypeface(font);
        TextView passwordRedoPrompt2 = (TextView) findViewById(R.id.register_retypepass_textView);
        passwordRedoPrompt2.setTypeface(font);
        EditText passwordRedo = (EditText) findViewById(R.id.register_retypepassword_input);
        passwordRedo.setTypeface(font);
        TextView typePrompt = (TextView) findViewById(R.id.register_type_textView);
        typePrompt.setTypeface(font);


        Spinner typeSpinner = (Spinner) findViewById(R.id.register_typeSpinner);


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

    }

    /**
     * Attempts to register the account specified by the register form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */

    private void attemptRegistration() {
        startActivity(new Intent(getBaseContext(), ProfileActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
