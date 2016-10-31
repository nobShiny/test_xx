package com.zte.topsky.chartdata.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by NobShiny
 * on 2016/10/31 15:26.
 */

public class WeatherWebView extends WebView {

    public WeatherWebView(Context context, AttributeSet attrs, int defStyle,
                          boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        // TODO Auto-generated constructor stub
    }

    public WeatherWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public WeatherWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public WeatherWebView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        Log.d("touchevent", "touchevent" + super.onTouchEvent(ev));
//            return super.onTouchEvent(ev);
        return false;
    }

}
