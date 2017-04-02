package com.example.otteramazement.clean_water;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/*
 * Created by Violet
 * Activity for creating Historical Reports
 */

public class HistoricalReportActivity extends Activity {

    private final HistoricalReport _report = new HistoricalReport();

    private EditText dateInput;
    private EditText locationInput;
    private EditText contInput;
    private final Calendar myCalendar = Calendar.getInstance();

    @SuppressLint("StaticFieldLeak")
    private static HistoricalReportActivity obj;

    protected void onCreate(Bundle savedInstanceState) {

        obj = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts: need to find a better way

        TextView title = (TextView) findViewById(R.id.historicalReport_title);
        title.setTypeface(font);
        TextView datePrompt = (TextView) findViewById(R.id.historicalReport_date_textView);
        datePrompt.setTypeface(font);
        dateInput = (EditText) findViewById(R.id.historicalReport_date_input);
        dateInput.setTypeface(font1);
        TextView reporterPrompt = (TextView) findViewById(R.id.historicalReport_reporter_textView);
        reporterPrompt.setTypeface(font);
        EditText reporterInput = (EditText) findViewById(R.id.historicalReport_reporter_input);
        reporterInput.setTypeface(font1);
        TextView locationPrompt = (TextView) findViewById(R.id.historicalReport_location_textView);
        locationPrompt.setTypeface(font);
        locationInput = (EditText) findViewById(R.id.historicalReport_location_input);
        locationInput.setTypeface(font1);
        TextView contPrompt = (TextView) findViewById(R.id.historicalReport_cont_textView);
        contPrompt.setTypeface(font);
        contInput = (EditText) findViewById(R.id.historicalReport_cont_input);
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

        _report.setReporter(CurrentUser.currentUser.get(0).getName());
        reporterInput.setText(_report.getReporter());
        //final Date date = new Date();
        //dateInput.setText(DateFormat.getDateInstance().format(date));

        ImageView acceptButtonImageView = (ImageView) findViewById(R.id.historicalReport_acceptbutton_imageView);
        acceptButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateReport();
                /*String lat = "";
                int aLong;
                int aLat;
                String num = "";
                for (int i = 0; i < _report.getLocation().length(); i++) {
                    num = num + _report.getLocation().charAt(i);
                    if (_report.getLocation().charAt(i) == '-') {
                        lat = num.substring(0, _report.getLocation().length() - 1);
                        num = "";
                    }
                }
                try {
                    aLat = Integer.parseInt(lat);
                    aLong = Integer.parseInt(num);
                } catch (NumberFormatException ex) {
                    aLat = -91;
                    aLong = -181;
                }*/
                if (_report.getDate().length() > 3 && _report.getLocation().length() > 0
                        && _report.getContaminant() >= 0
                        && _report.getLocation().contains("-")) {
                        //&& aLat >= -90 && aLat <= 90 && aLong >= -180 && aLong <= 180) {
                    Intent startIntent = new Intent(getBaseContext(), HistoricalReportGraphActivity.class);
                    WaterReportList.historicalReportList.add(_report);

                    //save to json
                    UserFacade uf = UserFacade.getInstance();
                    File file = new File(obj.getFilesDir(), UserFacade.HISTORICAL_JSON_FILE_NAME);
                    uf.saveJson(file);

                    startActivity(startIntent);
                } else if (!_report.getLocation().contains("-")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(HistoricalReportActivity.this);
                    alert.setTitle("Invalid Source Report");
                    alert.setMessage("Please include a valid location like '25-30'");
                    alert.show();
                /*} else if (aLat >= -90 && aLat <= 90 && aLong >= -180 && aLong <= 180) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(HistoricalReportActivity.this);
                    alert.setTitle("Invalid Source Report");
                    alert.setMessage("Please enter a valid location in the format latitude-longitude");
                    alert.show();*/
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(HistoricalReportActivity.this);
                    alert.setTitle("Invalid Source Report");
                    alert.setMessage("Please fill out all required fields");
                    alert.show();
                }
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HistoricalReportActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    /**
     * Updates the Date Input field with the correct format.
     */

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateInput.setText(sdf.format(myCalendar.getTime()));
    }

    /**
     *  Updates the report class with the entered data.
     */
    private void updateReport() {
        _report.setDate(dateInput.getText().toString());
        _report.setLocation(locationInput.getText().toString());
        _report.setContaminant(Integer.parseInt(contInput.getText().toString()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
