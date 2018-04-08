package com.appendous.suntisttask.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by root on 6/4/18.
 */

public class EditTextFuturaMdBt extends android.support.v7.widget.AppCompatEditText {
    public EditTextFuturaMdBt(Context context) {
        super(context);
        init(null);
    }

    public EditTextFuturaMdBt(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
        init(attributeSet);
    }

    public EditTextFuturaMdBt(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/FuturaMediumBT.ttf");
            setTypeface(tf);
        }
    }
}
