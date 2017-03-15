package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Violet on 3/14/2017.
 */

public class HistoricalReportActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts: need to find a better way

        TextView title = (TextView) findViewById(R.id.historicalReport_title);
        title.setTypeface(font);
        TextView datePrompt = (TextView) findViewById(R.id.historicalReport_date_textView);
        datePrompt.setTypeface(font);
        EditText dateInput = (EditText) findViewById(R.id.historicalReport_date_input);
        dateInput.setTypeface(font1);
        TextView reporterPrompt = (TextView) findViewById(R.id.historicalReport_reporter_textView);
        reporterPrompt.setTypeface(font);
        EditText reporterInput = (EditText) findViewById(R.id.historicalReport_reporter_input);
        reporterInput.setTypeface(font1);
        TextView locationPrompt = (TextView) findViewById(R.id.historicalReport_location_textView);
        locationPrompt.setTypeface(font);
        EditText locationInput = (EditText) findViewById(R.id.historicalReport_location_input);
        locationInput.setTypeface(font1);
        TextView contPrompt = (TextView) findViewById(R.id.historicalReport_cont_textView);
        contPrompt.setTypeface(font);
        EditText contInput = (EditText) findViewById(R.id.historicalReport_cont_input);
        contInput.setTypeface(font1);
        TextView acceptButton = (TextView) findViewById(R.id.historicalReport_acceptbutton_tetView);
        acceptButton.setTypeface(font);

        //setting buttons
        ImageView backButton = (ImageView) findViewById(R.id.historicalReport_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), HistoricalReportChoiceActivity.class);
                startActivity(backIntent);
            }
        });

        //reporterInput.setText(_report.getReporter());
        Date date = new Date();
        dateInput.setText(DateFormat.getDateInstance().format(date));

        ImageView acceptButtonImageView = (ImageView) findViewById(R.id.historicalReport_acceptbutton_imageView);
        acceptButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getBaseContext(), HistoricalReportGraphActivity.class);
                startActivity(startIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
