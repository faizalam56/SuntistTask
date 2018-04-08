package com.appendous.suntisttask.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by root on 7/4/18.
 */

public class ButtonFuturaMdBt extends android.support.v7.widget.AppCompatButton {
    public ButtonFuturaMdBt(Context context) {
        super(context);
        init(null);
    }

    public ButtonFuturaMdBt(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ButtonFuturaMdBt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    private void init(AttributeSet attrs) {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/FuturaMediumBT.ttf");
            setTypeface(tf);
        }
    }

}
