package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

/**
 * Created by Violet on 2/16/2017.
 * Authors: Violet
 */

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
