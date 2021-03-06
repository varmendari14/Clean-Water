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
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Violet on 3/7/2017.
 * Authors: Violet
 */

@SuppressWarnings("ChainedMethodCall")
public class PurityReportActivity extends Activity {

    private final PurityReport _report = new PurityReport();
    private WaterPurityCondition condition;

    private EditText dateInput;
    private EditText latInput;
    private EditText lonInput;
    private EditText timeInput;
    private EditText virusInput;
    private EditText contInput;
    private final Calendar myCalendar = Calendar.getInstance();

    private final int LAT_MIN = -90;
    private final int LAT_MAX = 90;
    private final int LONG_MIN = -180;
    private final int LONG_MAX = 180;

    @SuppressLint("StaticFieldLeak")
    private PurityReportActivity obj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        obj = this;

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
        TextView reportNumberPrompt =
                (TextView) findViewById(R.id.purityReport_reportNumber_textView);
        reportNumberPrompt.setTypeface(font);
        TextView reportNumberText =
                (TextView) findViewById(R.id.purityReport_reportNumber_generation);
        reportNumberText.setTypeface(font1);
        TextView reporterPrompt =
                (TextView) findViewById(R.id.purityReport_reporter_textView);
        reporterPrompt.setTypeface(font);
        EditText reporterInput = (EditText) findViewById(R.id.purityReport_reporter_input);
        reporterInput.setTypeface(font1);
        TextView locationPrompt = (TextView) findViewById(R.id.purityReport_location_textView);
        locationPrompt.setTypeface(font);
        latInput = (EditText) findViewById(R.id.lat_input);
        latInput.setTypeface(font1);
        lonInput = (EditText) findViewById(R.id.long_input);
        lonInput.setTypeface(font1);
        TextView safePrompt = (TextView) findViewById(R.id.purityReport_safe_textView);
        safePrompt.setTypeface(font);
        TextView treatablePrompt = (TextView) findViewById(R.id.purityReport_treatable_textView);
        treatablePrompt.setTypeface(font);
        TextView unsafePrompt = (TextView) findViewById(R.id.purityReport_unsafe_textView);
        unsafePrompt.setTypeface(font);
        TextView virusPrompt = (TextView) findViewById(R.id.purityReport_virus_textView);
        virusPrompt.setTypeface(font);
        virusInput = (EditText) findViewById(R.id.purityReport_virus_input);
        virusInput.setTypeface(font1);
        TextView contPrompt = (TextView) findViewById(R.id.purityReport_cont_textView);
        contPrompt.setTypeface(font);
        contInput = (EditText) findViewById(R.id.purityReport_cont_input);
        contInput.setTypeface(font1);
        TextView acceptButton = (TextView) findViewById(R.id.purityReport_acceptbutton_tetView);
        acceptButton.setTypeface(font);

        //setting buttons
        ImageView backButton = (ImageView) findViewById(R.id.purityReport_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), PurityReportChoiceActivity.class);
                startActivity(backIntent);
            }
        });

        ImageView safeImage = (ImageView) findViewById(R.id.purityReport_safe_imageView);
        safeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterPurityCondition.SAFE;
            }
        });

        ImageView treatImage = (ImageView) findViewById(R.id.purityReport_treatable_imageView);
        treatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterPurityCondition.TREATABLE;
            }
        });

        ImageView unsafeImage = (ImageView) findViewById(R.id.purityReport_unsafe_imageView);
        unsafeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = WaterPurityCondition.UNSAFE;
            }
        });

        _report.setReporter(CurrentUser.currentUser.get(0).getName());
        reporterInput.setText(_report.getReporter());
        Date date1 = new Date();
        //dateInput.setText(DateFormat.getDateInstance().format(date));
        timeInput.setText(DateFormat.getTimeInstance().format(date1));
        reportNumberText.setText(_report.getReportNumber());

        ImageView acceptButtonImageView =
                (ImageView) findViewById(R.id.purityReport_acceptbutton_imageView);
        acceptButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateReport();
                if ((_report.getCondition() != null) && !_report.getTime().isEmpty()
                        && !_report.getDate().isEmpty()
                        && (_report.getVirus() >= 0) && (_report.getContaminant() >= 0)
                        && (_report.getLat() >= LAT_MIN)
                        && (_report.getLat() <= LAT_MAX)
                        && (_report.getLon() <= LONG_MAX)
                        && (_report.getLon() >= LONG_MIN)) {
                    Intent backIntent = new Intent(getBaseContext(),
                            PurityReportChoiceActivity.class);
                    WaterReportList.waterPurityList.add(_report);

                    //save to json
                    UserFacade uf = UserFacade.getInstance();
                    File file = new File(obj.getFilesDir(), UserFacade.PURITY_JSON_FILE_NAME);
                    uf.saveJson(file);

                    startActivity(backIntent);
                } else if (!(_report.getLat() >= LAT_MIN)
                        || !(_report.getLat() <= LAT_MAX)
                        || !(_report.getLon() <= LONG_MAX)
                        || !(_report.getLon() >= LONG_MIN)) {
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
                new DatePickerDialog(PurityReportActivity.this, date, myCalendar
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

    // ***

    /**
     *  Updates the report class with the entered data.
     */
    private void updateReport() {
        _report.setCondition(condition);
        _report.setDate(dateInput.getText().toString());
        _report.setTime(timeInput.getText().toString());
        _report.setLat(Integer.parseInt(latInput.getText().toString()));
        _report.setLon(Integer.parseInt(lonInput.getText().toString()));
        _report.setVirus(Integer.parseInt(virusInput.getText().toString()));
        _report.setContaminant(Integer.parseInt(contInput.getText().toString()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }

}

