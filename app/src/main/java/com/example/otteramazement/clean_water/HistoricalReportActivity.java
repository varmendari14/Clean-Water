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

/**
 * Created by Violet
 * Activity for creating Historical Reports
 */

public class HistoricalReportActivity extends Activity {

    private final int LATMIN = -90;
    private final int LATMAX = 90;
    private final int LONGMIN = -180;
    private final int LONGMAX = 180;

    private final HistoricalReport _report = new HistoricalReport();

    private EditText dateInput;
    private EditText latInput;
    private EditText lonInput;
    private EditText contInput;
    private final Calendar myCalendar = Calendar.getInstance();

    @SuppressLint("StaticFieldLeak")
    private HistoricalReportActivity obj;

    @Override
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
        latInput = (EditText) findViewById(R.id.historicalReport_lat_input);
        latInput.setTypeface(font1);
        lonInput = (EditText) findViewById(R.id.historicalReport_long);
        lonInput.setTypeface(font1);
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
                Intent backIntent = new Intent(getBaseContext(),
                        HistoricalReportChoiceActivity.class);
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

                if (_report.getDate().length() > 3 && _report.getLat() >= LATMIN
                        && _report.getContaminant() >= 0
                        && _report.getLat() <= LATMAX
                        && _report.getLon() <= LONGMAX
                        && _report.getLon() >= LONGMIN) {

                    Intent startIntent = new Intent(getBaseContext(), HistoricalReportGraphActivity.class);
                    WaterReportList.historicalReportList.add(_report);

                    //save to json
                    UserFacade uf = UserFacade.getInstance();
                    File file = new File(obj.getFilesDir(), UserFacade.HISTORICAL_JSON_FILE_NAME);
                    uf.saveJson(file);

                    startActivity(startIntent);
                } else if (!(_report.getLat() >= LATMIN)
                        || !(_report.getLat() <= LATMAX)
                        || !(_report.getLon() <= LONGMAX)
                        || !(_report.getLon() >= LONGMIN)) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(HistoricalReportActivity.this);
                    alert.setTitle("Invalid Source Report");
                    alert.setMessage("Please include a valid location like '25-30'");
                    alert.show();
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
        _report.setLat(Integer.parseInt(latInput.getText().toString()));
        _report.setLon(Integer.parseInt(lonInput.getText().toString()));
        _report.setContaminant(Integer.parseInt(contInput.getText().toString()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}
