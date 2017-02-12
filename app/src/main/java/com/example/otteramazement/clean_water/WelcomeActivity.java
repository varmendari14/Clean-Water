package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

/**
 * Created by Violet on 2/11/2017.
 * Authors: Violet, Mary
 */

public class WelcomeActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");

        TextView loginButton = (TextView) findViewById(R.id.welcome_loginbutton_textView);
        loginButton.setTypeface(font);
        TextView registerButton = (TextView) findViewById(R.id.welcome_registerbutton_textView);
        registerButton.setTypeface(font);

        // Set up the login form

        ImageView loginPressButton = (ImageView) findViewById(R.id.login_imageView);

        loginPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        });
    }

}
