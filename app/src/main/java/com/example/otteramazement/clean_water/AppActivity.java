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
import android.widget.TextView;

/**
 * Created by maryprouty on 2/12/17.
 * Authors: Mary, Violet
 */

public class AppActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        TextView logoutButton = (TextView) findViewById(R.id.logout_button);
        logoutButton.setTypeface(font);

        Button logoutButtonPress = (Button) findViewById(R.id.logout_button);

        logoutButtonPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), WelcomeActivity.class));
            }
        });

    }

}
