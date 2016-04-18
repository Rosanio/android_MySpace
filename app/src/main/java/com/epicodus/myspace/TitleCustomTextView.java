package com.epicodus.myspace;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Guest on 4/18/16.
 */
public class TitleCustomTextView extends TextView {

    public TitleCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts/IndieFlower.ttf"));
    }
}
