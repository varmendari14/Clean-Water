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
import java.util.LinkedList;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Violet on 2/24/2017.
 * Authors: Violet, Mary
 */

public class SourceReportActivity extends Activity {

    UserProfile _user;
    WaterSourceReport _report = new WaterSourceReport();
    WaterType type;
    WaterCondition condition;

    public static final String ARG_USER = "user";

    private EditText dateInput;
    private EditText reporterInput;
    private EditText locationInput;
    private TextView reportNumberText;
    private EditText timeInput;



    protected void onCreate(Bundle savedInstanceState) {

        _user = (UserProfile) getIntent().getSerializableExtra(SourceReportChoiceActivity.ARG_USER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts: need to find a better way

        TextView title = (TextView) findViewById(R.id.sourceReport_title);
        title.setTypeface(font);
        TextView datePrompt = (TextView) findViewById(R.id.sourceReport_date_textView);
        datePrompt.setTypeface(font);
        dateInput = (EditText) findViewById(R.id.sourceReport_date_input);
        dateInput.setTypeface(font1);
        TextView timePrompt = (TextView) findViewById(R.id.sourceReport_time_textView);
        timePrompt.setTypeface(font);
        timeInput = (EditText) findViewById(R.id.sourceReport_time_input);
        timeInput.setTypeface(font1);
        TextView reportNumberPrompt = (TextView) findViewById(R.id.sourceReport_reportNumber_textView);
        reportNumberPrompt.setTypeface(font);
        reportNumberText = (TextView) findViewById(R.id.sourceReport_reportNumber_generation);
        reportNumberText.setTypeface(font1);
        TextView reporterPrompt = (TextView) findViewById(R.id.sourceReport_reporter_textView);
        reporterPrompt.setTypeface(font);
        reporterInput = (EditText) findViewById(R.id.sourceReport_reporter_input);
        reporterInput.setTypeface(font1);
        TextView locationPrompt = (TextView) findViewById(R.id.sourceReport_location_textView);
        locationPrompt.setTypeface(font);
        locationInput = (EditText) findViewById(R.id.sourceReport_location_input);
        locationInput.setTypeface(font1);
        TextView bottlePrompt = (TextView) findViewById(R.id.sourceReport_bottled_textView);
        bottlePrompt.setTypeface(font);
        TextView wellPrompt = (TextView) findViewById(R.id.sourceReport_well_textView);
        wellPrompt.setTypeface(font);
        TextView streamPrompt = (TextView) findViewById(R.id.sourceReport_stream_textView);
        streamPrompt.setTypeface(font);
        TextView lakePrompt = (TextView) findViewById(R.id.sourceReport_lake_textView);
        lakePrompt.setTypeface(font);
        TextView springPrompt = (TextView) findViewById(R.id.sourceReport_spring_textView);
        springPrompt.setTypeface(font);
        TextView otherPrompt = (TextView) findViewById(R.id.sourceReport_other_textView);
        otherPrompt.setTypeface(font);
        TextView wastePrompt = (TextView) findViewById(R.id.sourceReport_waste_textView);
        wastePrompt.setTypeface(font);
        TextView tmPrompt = (TextView) findViewById(R.id.sourceReport_treatable_muddy_textView);
        tmPrompt.setTypeface(font);
        TextView tcPrompt = (TextView) findViewById(R.id.sourceReport_treatable_clear_textView);
        tcPrompt.setTypeface(font);
        TextView potPrompt = (TextView) findViewById(R.id.sourceReport_potable_textView);
        potPrompt.setTypeface(font);
        TextView acceptButton = (TextView) findViewById(R.id.sourceReport_acceptbutton_tetView);
        acceptButton.setTypeface(font);

        //setting buttons
        ImageView backButton = (ImageView) findViewById(R.id.sourceReport_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), SourceReportChoiceActivity.class);
                backIntent.putExtra(SourceReportActivity.ARG_USER, _user);
                startActivity(backIntent);
            }
        });

        ImageView bottleImage = (ImageView) findViewById(R.id.sourceReport_bottle_imageView);
        bottleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = WaterType.BOTTLED;
            }
        });

        ImageView wellImage = (ImageView) findViewById(R.id.sourceReport_well_imageView);
        wellImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = WaterType.WELL;
            }
        });

        ImageView streamImage = (ImageView) findViewById(R.id.sourceReport_stream_imageView);
        streamImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = WaterType.STREAM;
            }
        });

        ImageView lakeImage = (ImageView) findViewById(R.id.sourceReport_lake_imageView);
        lakeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = WaterType.LAKE;
            }
        });

        ImageView springImage = (ImageView) findViewById(R.id.sourceReport_spring_imageView);
        springImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = WaterType.SPRING;
            }
        });

        ImageView otherImage = (ImageView) findViewById(R.id.sourceReport_other_imageView);
        otherImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = WaterType.OTHER;
            }
        });

        ImageView wasteImage = (ImageView) findViewById(R.id.sourceReport_waste_imageView);
        wasteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterCondition.WASTE;
            }
        });

        ImageView treatmuddImage = (ImageView) findViewById(R.id.sourceReport_treatable_muddy_imageView);
        treatmuddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterCondition.TREATABLE_MUDDY;
            }
        });

        ImageView treatclearImage = (ImageView) findViewById(R.id.sourceReport_treatable_clear_imageView);
        treatclearImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterCondition.TREATABLE_CLEAR;
            }
        });

        ImageView potImage = (ImageView) findViewById(R.id.sourceReport_potable_imageView);
        potImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterCondition.POTABLE;
            }
        });

        _report.setReporter(_user.getUsername());
        reporterInput.setText(_report.getReporter());
        Date date = new Date();
        dateInput.setText(DateFormat.getDateInstance().format(date));
        timeInput.setText(DateFormat.getTimeInstance().format(date));
        reportNumberText.setText(_report.getReportNumber());

        ImageView acceptButtonImageView = (ImageView) findViewById(R.id.sourceReport_acceptbutton_imageView);
        acceptButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateReport();
                if (_report.getCondition() != null && _report.getType() != null && _report.getTime().length() > 0
                        && _report.getDate().length() > 0 && _report.getLocation().length() > 0) {
                    Intent backIntent = new Intent(getBaseContext(), SourceReportChoiceActivity.class);
                    backIntent.putExtra(SourceReportActivity.ARG_USER, _user);
                    WaterReportList.waterSourceList.add(_report);
                    startActivity(backIntent);
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(SourceReportActivity.this);
                    alert.setTitle("Invalid Source Report");
                    alert.setMessage("Please fill out all required fields");
                    alert.show();
                }

            }
        });
    }

    // ***

    /**
     *  Updates the report class with the entered data.
     */
    protected void updateReport() {
        _report.setCondition(condition);
        _report.setType(type);
        _report.setDate(dateInput.getText().toString());
        _report.setTime(timeInput.getText().toString());
        _report.setLocation(locationInput.getText().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
