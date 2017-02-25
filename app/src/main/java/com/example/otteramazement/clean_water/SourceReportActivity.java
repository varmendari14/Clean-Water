package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Violet on 2/24/2017.
 */

public class SourceReportActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts: need to find a better way

        TextView title = (TextView) findViewById(R.id.sourceReport_title);
        title.setTypeface(font);
        TextView datePrompt = (TextView) findViewById(R.id.sourceReport_date_textView);
        datePrompt.setTypeface(font);
        EditText dateInput = (EditText) findViewById(R.id.sourceReport_date_input);
        dateInput.setTypeface(font1);
        TextView reportNumberPrompt = (TextView) findViewById(R.id.sourceReport_reportNumber_textView);
        reportNumberPrompt.setTypeface(font);
        TextView reportNumberText = (TextView) findViewById(R.id.sourceReport_reportNumber_generation);
        reportNumberText.setTypeface(font1);
        TextView reporterPrompt = (TextView) findViewById(R.id.sourceReport_reporter_textView);
        reporterPrompt.setTypeface(font);
        EditText reporterInput = (EditText) findViewById(R.id.sourceReport_reporter_input);
        reporterInput.setTypeface(font1);
        TextView locationPrompt = (TextView) findViewById(R.id.sourceReport_location_textView);
        locationPrompt.setTypeface(font);
        EditText locationInput = (EditText) findViewById(R.id.sourceReport_location_input);
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

        //Below is how we automatically put the generated report number onto the screen for the user to see
        //we can also use this for filling in the reporter blank, if we decide that whoever is logged in is responsible for reporting
        //also can be used for the date and time if we auto generate that
        //if we auto generate all of the above, i only need to change their types from EditTexts to TextViews

//        TextView reportNumber = (TextView) findViewById(R.id.sourceReport_reportNumber_generation);
//        reportNumber.setText("the number will go here");

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
