package com.zte.topsky.monitor.customui;

import android.content.Context;
import android.view.MotionEvent;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by NobShiny
 * on 2016/10/28 12:27.
 */

public class VideoPlayer extends JCVideoPlayerStandard {
    public VideoPlayer(Context context) {
        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
