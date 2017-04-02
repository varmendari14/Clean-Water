package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Violet
 * Activity for viewing list of Purity Reports
 */

public class PurityReportListActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report_list);

        //setting fonts


        //button functionality

        ImageView backButton = (ImageView) findViewById(R.id.purityReportList_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), PurityReportChoiceActivity.class);
                startActivity(backIntent);
            }
        });

        //list view
        ListView listView = (ListView) findViewById(R.id.purity_report_list);
        assert listView != null;
        ArrayAdapter reportAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, WaterReportList.waterPurityList);
        listView.setAdapter(reportAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
