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
 * Created by Violet on 3/7/2017.
 * Authors: Violet
 */

public class PurityReportActivity extends Activity {

    UserProfile _user;
    PurityReport _report = new PurityReport();
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
        setContentView(R.layout.activity_purity_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts: need to find a better way

        TextView title = (TextView) findViewById(R.id.purityReport_title);
        title.setTypeface(font);
        TextView datePrompt = (TextView) findViewById(R.id.purityReport_date_textView);
        datePrompt.setTypeface(font);
        dateInput = (EditText) findViewById(R.id.purityReport_date_input);
        dateInput.setTypeface(font1);
        TextView timePrompt = (TextView) findViewById(R.id.purityReport_time_textView);
        timePrompt.setTypeface(font);
        timeInput = (EditText) findViewById(R.id.purityReport_time_input);
        timeInput.setTypeface(font1);
        TextView reportNumberPrompt = (TextView) findViewById(R.id.purityReport_reportNumber_textView);
        reportNumberPrompt.setTypeface(font);
        reportNumberText = (TextView) findViewById(R.id.purityReport_reportNumber_generation);
        reportNumberText.setTypeface(font1);
        TextView reporterPrompt = (TextView) findViewById(R.id.purityReport_reporter_textView);
        reporterPrompt.setTypeface(font);
        reporterInput = (EditText) findViewById(R.id.purityReport_reporter_input);
        reporterInput.setTypeface(font1);
        TextView locationPrompt = (TextView) findViewById(R.id.purityReport_location_textView);
        locationPrompt.setTypeface(font);
        locationInput = (EditText) findViewById(R.id.purityReport_location_input);
        locationInput.setTypeface(font1);
        TextView safePrompt = (TextView) findViewById(R.id.purityReport_safe_textView);
        safePrompt.setTypeface(font);
        TextView treatablePrompt = (TextView) findViewById(R.id.purityReport_treatable_textView);
        treatablePrompt.setTypeface(font);
        TextView unsafePrompt = (TextView) findViewById(R.id.purityReport_unsafe_textView);
        unsafePrompt.setTypeface(font);
        TextView virusPrompt = (TextView) findViewById(R.id.purityReport_virus_textView);
        virusPrompt.setTypeface(font);
        EditText virusInput = (EditText) findViewById(R.id.purityReport_virus_input);
        virusInput.setTypeface(font1);
        TextView contPrompt = (TextView) findViewById(R.id.purityReport_cont_textView);
        contPrompt.setTypeface(font);
        EditText contInput = (EditText) findViewById(R.id.purityReport_cont_input);
        contInput.setTypeface(font1);
        TextView acceptButton = (TextView) findViewById(R.id.purityReport_acceptbutton_tetView);
        acceptButton.setTypeface(font);

        //setting buttons
        ImageView backButton = (ImageView) findViewById(R.id.purityReport_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), PurityReportChoiceActivity.class);
                backIntent.putExtra(PurityReportActivity.ARG_USER, _user);
                startActivity(backIntent);
            }
        });

        ImageView safeImage = (ImageView) findViewById(R.id.purityReport_safe_imageView);
        safeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterCondition.POTABLE;
            }
        });

        ImageView treatImage = (ImageView) findViewById(R.id.purityReport_treatable_imageView);
        treatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterCondition.POTABLE;
            }
        });

        ImageView unsafeImage = (ImageView) findViewById(R.id.purityReport_unsafe_imageView);
        unsafeImage.setOnClickListener(new View.OnClickListener() {
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

        ImageView acceptButtonImageView = (ImageView) findViewById(R.id.purityReport_acceptbutton_imageView);
        acceptButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateReport();
                if (_report.getCondition() != null && _report.getTime().length() > 0
                        && _report.getDate().length() > 0 && _report.getLocation().length() > 0
                        && _report.getLocation().contains("-")) {
                    Intent backIntent = new Intent(getBaseContext(), SourceReportChoiceActivity.class);
                    backIntent.putExtra(SourceReportActivity.ARG_USER, _user);
                    WaterReportList.waterPurityList.add(_report);
                    startActivity(backIntent);
                } else if (!_report.getLocation().contains("-")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(PurityReportActivity.this);
                    alert.setTitle("Invalid Source Report");
                    alert.setMessage("Please include a valid location like '25-30'");
                    alert.show();
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(PurityReportActivity.this);
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

