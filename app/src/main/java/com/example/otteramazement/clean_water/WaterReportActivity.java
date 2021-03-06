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
 * controls creation of water reports
 * Authors: Violet, Mary
 */

@SuppressWarnings("ChainedMethodCall")
public class WaterReportActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView sourceButton = (TextView) findViewById(R.id.waterReport_sourceReport_textView);
        sourceButton.setTypeface(font1);
        TextView availabilityButton =
                (TextView) findViewById(R.id.waterReport_avalabilityReport_textView);
        availabilityButton.setTypeface(font1);
        TextView purityButton = (TextView) findViewById(R.id.waterReport_purityReport_textView);
        purityButton.setTypeface(font1);
        TextView title = (TextView) findViewById(R.id.sourceReportChoice_title);
        title.setTypeface(font);


        //button functionality
        ImageView sourceButtonImage =
                (ImageView) findViewById(R.id.waterReport_sourceReport_imageView);
        sourceButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent =
                        new Intent(getBaseContext(), SourceReportChoiceActivity.class);
                startActivity(sourceIntent);
            }
        });

        ImageView availabilityButtonImage =
                (ImageView) findViewById(R.id.waterReport_avalabilityReport_imageView);
        availabilityButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), WaterAvailabilityActivity.class);
                startActivity(sourceIntent);
            }
        });

        ImageView purityButtonImage =
                (ImageView) findViewById(R.id.waterReport_purityReport_imageView);
        purityButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent =
                        new Intent(getBaseContext(), PurityReportChoiceActivity.class);
                startActivity(sourceIntent);
            }
        });

        if (CurrentUser.currentUser.get(0).getProfileType().equals(ProfileType.WORKER) ||
                CurrentUser.currentUser.get(0).getProfileType().equals(ProfileType.MANAGER)) {
            purityButtonImage.setVisibility(View.VISIBLE);
            purityButton.setVisibility(View.VISIBLE);
        }

        ImageView backButton = (ImageView) findViewById(R.id.waterReport_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), AppActivity.class);
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
