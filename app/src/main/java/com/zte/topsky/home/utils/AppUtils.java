package com.zte.topsky.home.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.zte.topsky.home.MainActivity;

public class AppUtils {

    public static void init(Activity activity) {
        initActionBar(activity);
    }

    public static void urlOpen(Context context, String url) {
        Uri uriUrl = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW, uriUrl);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    private static void initActionBar(final Activity activity) {
        if (activity == null) {
            return;
        }

        ActionBar bar = activity.getActionBar();
        if (activity instanceof MainActivity) {
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM
                    | ActionBar.DISPLAY_SHOW_HOME);
        } else {
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_HOME_AS_UP
                    | ActionBar.DISPLAY_SHOW_CUSTOM);
        }
    }

    private static String getUrlInfo(String prefix, String url, String content) {
        return new StringBuilder().append(prefix).append("<a href=\"").append(url).append("\">").append(content)
                .append("</a>").toString();
    }

    public static int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}