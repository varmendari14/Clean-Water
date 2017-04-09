package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Violet
 * Activity for choosing to create or view source reports
 * a way to view the list for source report versus make a new one
 */

public class SourceReportChoiceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report_choice);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView sourceButton = (TextView) findViewById(R.id.sourceReportChoice_newSourceReport);
        sourceButton.setTypeface(font1);
        TextView listButton = (TextView) findViewById(R.id.sourceReportChoice_reportLists);
        listButton.setTypeface(font1);
        TextView title = (TextView) findViewById(R.id.sourceReportChoice_title);
        title.setTypeface(font);


        //button functionality
        ImageView sourceButtonImage =
                (ImageView) findViewById(R.id.sourceReportChoice_newReport_imageView);
        sourceButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIntent = new Intent(getBaseContext(), SourceReportActivity.class);
                startActivity(reportIntent);
            }
        });

        ImageView listButtonImage =
                (ImageView) findViewById(R.id.sourceReportChoice_listReports_imageView);
        listButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getBaseContext(), SourceReportListActivity.class);
                startActivity(listIntent);
            }
        });

        ImageView backButton =
                (ImageView) findViewById(R.id.sourceReportChoice_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), WaterReportActivity.class);
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
