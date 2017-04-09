package com.example.otteramazement.clean_water;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Violet
 */

@SuppressWarnings("ChainedMethodCall")
public class PapyrusTextView extends android.support.v7.widget.AppCompatTextView {

    /**
     * constructor
     * @param context the pakage name
     */

        public PapyrusTextView(Context context) {

            super(context);

        }

    /**
     * constructor
     * @param context the pakage name
     * @param attrs the attributes
     */
        public PapyrusTextView(Context context, AttributeSet attrs) {

            super(context, attrs);

        }

    /**
     * constructor
     * @param context the pakage name
     * @param attrs the attributes
     * @param defStyle the default style
     */

        public PapyrusTextView(Context context, AttributeSet attrs, int defStyle) {

            super(context, attrs, defStyle);

        }

    /**
     * constructor
     * @param tf the typeface
     * @param style the style
     */

    @Override

        public void setTypeface(Typeface tf, int style) {

            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                    "fonts/PAPYRUS.TTF"));

        }

}