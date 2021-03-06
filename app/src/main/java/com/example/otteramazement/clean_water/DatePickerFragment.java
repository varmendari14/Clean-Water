package com.example.otteramazement.clean_water;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * A class to help with date picking
 */

@SuppressWarnings("unused")
public class DatePickerFragment extends DialogFragment
                            implements DatePickerDialog.OnDateSetListener {

    private final int[] dateArray = new int[3];

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        dateArray[0] = year;
        dateArray[1] = month;
        dateArray[2] = day;
    }

    /**
     * gets the date from this class
     * @return dateArray the int date array
     */
    public int[] getDateArray() {
        return dateArray;
    }

}