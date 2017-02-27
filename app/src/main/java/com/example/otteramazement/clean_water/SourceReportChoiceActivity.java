package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Violet on 2/26/2017.
 */

public class SourceReportChoiceActivity extends Activity {

    //UserProfile _user;
    //WaterSourceReport _report = new WaterSourceReport();

    public static final String ARG_USER = "user";

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


        //button functionalities
        ImageView sourceButtonImage = (ImageView) findViewById(R.id.sourceReportChoice_newReport_imageView);
        sourceButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), SourceReportActivity.class);
                //sourceIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(sourceIntent);
            }
        });

        ImageView listButtonImage = (ImageView) findViewById(R.id.sourceReportChoice_listReports_imageView);
        listButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sourceIntent = new Intent(getBaseContext(), SourceReportListActivity.class);
                //sourceIntent.putExtra(WaterReportActivity.ARG_USER, _user);
                startActivity(sourceIntent);
            }
        });

        ImageView backButton = (ImageView) findViewById(R.id.sourceReportChoice_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), WaterReportActivity.class);
                //backIntent.putExtra(WaterReportActivity.ARG_USER, _user);
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
