package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Violet on 2/24/2017.
 * Authors: Violet, Mary
 */

/**
 * controls creation of water reports
 */
public class WaterReportActivity extends Activity {

    UserProfile _user;

    public static final String ARG_USER = "user";

    protected void onCreate(Bundle savedInstanceState) {

        _user = (UserProfile) getIntent().getSerializableExtra(AppActivity.ARG_USER);
        if (_user == null) {
            _user = (UserProfile) getIntent().getSerializableExtra(SourceReportActivity.ARG_USER);
        }
        if (_user == null) {
            _user = (UserProfile) getIntent().getSerializableExtra(WaterAvailabilityActivity.ARG_USER);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView sourceButton = (TextView) findViewById(R.id.waterReport_sourceReport_textView);
        sourceButton.setTypeface(font1);
        TextView availabilityButton = (TextView) findViewById(R.id.waterReport_avalabilityReport_textView);
        availabilityButton.setTypeface(font1);
        TextView purityButton = (TextView) findViewById(R.id.waterReport_purityReport_textView);
        purityButton.setTypeface(font1);
        TextView title = (TextView) findViewById(R.id.sourceReportChoice_title);
        title.setTypeface(font);


        //button functionalities
        ImageView sourceButtonImage = (ImageView) findViewById(R.id.waterReport_sourceReport_imageView);
        sourceButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), SourceReportChoiceActivity.class);
                sourceIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(sourceIntent);
            }
        });

        ImageView availabilityButtonImage = (ImageView) findViewById(R.id.waterReport_avalabilityReport_imageView);
        availabilityButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), WaterAvailabilityActivity.class);
                sourceIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(sourceIntent);
            }
        });

        ImageView purityButtonImage = (ImageView) findViewById(R.id.waterReport_purityReport_imageView);
        purityButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), PurityReportChoiceActivity.class);
                sourceIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(sourceIntent);
            }
        });

        ImageView backButton = (ImageView) findViewById(R.id.waterReport_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), AppActivity.class);
                backIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(backIntent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
