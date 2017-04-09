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
 * Activity for choosing to create or view list of purity reports
 */

@SuppressWarnings("ChainedMethodCall")
public class PurityReportChoiceActivity extends Activity {

    //UserProfile _user;

    //public static final String ARG_USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //_user = (UserProfile) getIntent().getSerializableExtra(WaterReportActivity.ARG_USER);
        //if (_user == null) {
        //    _user = (UserProfile) getIntent().getSerializableExtra(SourceReportActivity.ARG_USER);
        //}
        //if (_user == null) {
        //    _user = (UserProfile)
        // getIntent().getSerializableExtra(SourceReportListActivity.ARG_USER);
        //}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report_choice);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView sourceButton = (TextView) findViewById(R.id.purityReportChoice_newSourceReport);
        sourceButton.setTypeface(font1);
        TextView listButton = (TextView) findViewById(R.id.purityReportChoice_reportLists);
        listButton.setTypeface(font1);
        TextView title = (TextView) findViewById(R.id.purityReportChoice_title);
        title.setTypeface(font);


        //button functionality
        ImageView sourceButtonImage =
                (ImageView) findViewById(R.id.purityReportChoice_newReport_imageView);
        sourceButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportIntent = new Intent(getBaseContext(), PurityReportActivity.class);
                //reportIntent.putExtra(PurityReportChoiceActivity.ARG_USER, _user);
                startActivity(reportIntent);
            }
        });

        ImageView listButtonImage =
                (ImageView) findViewById(R.id.purityReportChoice_listReports_imageView);
        listButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getBaseContext(), PurityReportListActivity.class);
                //listIntent.putExtra(PurityReportChoiceActivity.ARG_USER, _user);
                startActivity(listIntent);
            }
        });

        if (CurrentUser.currentUser.get(0).getProfileType().equals(ProfileType.MANAGER)) {
            listButtonImage.setVisibility(View.VISIBLE);
            listButton.setVisibility(View.VISIBLE);
        }

        ImageView backButton =
                (ImageView) findViewById(R.id.purityReportChoice_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), WaterReportActivity.class);
                //backIntent.putExtra(PurityReportChoiceActivity.ARG_USER, _user);
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

