package com.zte.topsky.monitor.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by NobShiny
 * on 2016/9/27 14:52.
 */

public class MonitorRelativeLayout extends RelativeLayout{
    private static String TAG = "MyRelativeLayout";
    private OnSizeChangedListener listener;

    public MonitorRelativeLayout(Context context) {
        super(context);
    }

    public MonitorRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MonitorRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener listener){
        this.listener = listener;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        listener.onSizeChanged(w,h,oldw,oldh);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
