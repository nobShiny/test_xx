package com.zte.topsky.disaster.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by NobShiny
 * on 2016/12/5 15:58.
 */

public class CallUtil {

    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public static void callOfSecurity(Context context, Activity activity, String number) {
        if (isPhoneNumber(number)) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                context.startActivity(intent);
            }
        } else {
            Toast.makeText(context, "电话不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    public static void callTo(Context context, String number) {
        if (isPhoneNumber(number)) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "电话不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isPhoneNumber(String number) {
        Pattern pattern = Pattern
                .compile("^(13[0-9]|15[0-9]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$");
        Matcher matcher = pattern.matcher(number);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
