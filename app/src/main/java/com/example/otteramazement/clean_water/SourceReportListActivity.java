package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Violet on 2/26/2017.
 * Authors: Violet, Cat
 */

public class SourceReportListActivity extends Activity {


    UserProfile _user;

    public static final String ARG_USER = "user";

    protected void onCreate(Bundle savedInstanceState) {

        _user = (UserProfile) getIntent().getSerializableExtra(SourceReportChoiceActivity.ARG_USER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report_list);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts


        //button functionalities

        ImageView backButton = (ImageView) findViewById(R.id.sourceReportList_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), SourceReportChoiceActivity.class);
                backIntent.putExtra(SourceReportListActivity.ARG_USER, _user);
                startActivity(backIntent);
            }
        });


        //***

        //list view
        ListView listView = (ListView) findViewById(R.id.report_list);
        assert listView != null;
        ArrayAdapter reportAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterReportList.waterSourceList);
        listView.setAdapter(reportAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
