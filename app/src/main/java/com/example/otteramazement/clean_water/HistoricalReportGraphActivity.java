package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Violet on 3/14/2017.
 */

public class HistoricalReportGraphActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report_graph);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView title = (TextView) findViewById(R.id.historicalGraph_title);
        title.setTypeface(font);


        ImageView backButton = (ImageView) findViewById(R.id.historicalGraph_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), HistoricalReportChoiceActivity.class);
                startActivity(backIntent);
            }
        });

//        ImageView mapButton = (ImageView) findViewById(R.id.historicalGraph_mapholder_imageView);
//        mapButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mapIntent = new Intent(getBaseContext(), MapsActivity.class);
//                startActivity(mapIntent);
//            }
//        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }
}
