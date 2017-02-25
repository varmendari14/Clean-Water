package com.example.otteramazement.clean_water;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Violet on 2/25/2017.
 */

public class PapyrusTextView extends TextView {

        public PapyrusTextView(Context context) {

            super(context);

        }

        public PapyrusTextView(Context context, AttributeSet attrs) {

            super(context, attrs);

        }

        public PapyrusTextView(Context context, AttributeSet attrs, int defStyle) {

            super(context, attrs, defStyle);

        }

        @Override

        public void setTypeface(Typeface tf, int style) {

            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/PAPYRUS.TTF"));

        }

}