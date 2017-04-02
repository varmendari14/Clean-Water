package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * Created by Violet
 * Activity lets you choose to create H reports or view graph
 */

public class HistoricalReportChoiceActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report_choice);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView reportButton = (TextView) findViewById(R.id.historicalReportChoice_newReport);
        reportButton.setTypeface(font1);
        TextView graphButton = (TextView) findViewById(R.id.historicalReportChoice_reportGraph);
        graphButton.setTypeface(font1);
        TextView title = (TextView) findViewById(R.id.historicalReportChoice_title);
        title.setTypeface(font);


        //button functionality
        ImageView sourceButtonImage = (ImageView) findViewById(R.id.historicalReportChoice_newReport_imageView);
        sourceButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIntent = new Intent(getBaseContext(), HistoricalReportActivity.class);
                startActivity(reportIntent);
            }
        });

        ImageView listButtonImage = (ImageView) findViewById(R.id.historicalReportChoice_graphReports_imageView);
        listButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getBaseContext(), HistoricalReportGraphActivity.class);
                startActivity(listIntent);
            }
        });

        ImageView backButton = (ImageView) findViewById(R.id.historicalReportChoice_backbutton_imageView);
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
