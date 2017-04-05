package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import java.io.File;
/**
 * Created by Violet on 2/11/2017.
 * controls activity that helps sign or register a user up/log them in
 * Authors: Violet, Mary
 */

public class WelcomeActivity extends Activity{

    private final UserFacade uf = UserFacade.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/PAPYRUS.TTF");

        TextView loginButton = (TextView) findViewById(R.id.welcome_loginbutton_textView);
        loginButton.setTypeface(font);
        TextView registerButton = (TextView) findViewById(R.id.welcome_registerbutton_textView);
        registerButton.setTypeface(font);

        // Set up the login button

        ImageView loginPressButton = (ImageView) findViewById(R.id.login_imageView);

        loginPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        });

        //Set up Register button

        ImageView registerPressButton = (ImageView) findViewById(R.id.register_imageView);

        registerPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });

        //Load from json
        File file;

        file = new File(this.getFilesDir(), UserFacade.USER_JSON_FILE_NAME);
        uf.loadJson(file);

        file = new File(this.getFilesDir(), UserFacade.SOURCE_JSON_FILE_NAME);
        uf.loadJson(file);

        file = new File(this.getFilesDir(), UserFacade.PURITY_JSON_FILE_NAME);
        uf.loadJson(file);

        file = new File(this.getFilesDir(), UserFacade.HISTORICAL_JSON_FILE_NAME);
        uf.loadJson(file);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
