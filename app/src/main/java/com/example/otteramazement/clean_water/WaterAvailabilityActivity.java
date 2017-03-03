package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Violet on 3/3/2017.
 */

public class WaterAvailabilityActivity extends Activity {

    UserProfile _user;

    public static final String ARG_USER = "user";

    protected void onCreate(Bundle savedInstanceState) {

        _user = (UserProfile) getIntent().getSerializableExtra(AppActivity.ARG_USER);
        if (_user == null) {
            _user = (UserProfile) getIntent().getSerializableExtra(SourceReportActivity.ARG_USER);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_availability);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView title = (TextView) findViewById(R.id.water_availability_title);
        title.setTypeface(font);


        ImageView backButton = (ImageView) findViewById(R.id.water_availability_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), WaterReportActivity.class);
                backIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(backIntent);
            }
        });

        ImageView mapButton = (ImageView) findViewById(R.id.water_availability_mapholder_imageView);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), MapsActivity.class);
                startActivity(sourceIntent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
