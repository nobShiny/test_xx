package com.zte.topsky.register.activity;

import android.os.Bundle;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

/**
 * Created by NobShiny
 * on 2016/10/11 16:13.
 */

public class RegisterActivity  extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_register);
        addActivity(this);
        if (savedInstanceState == null) {

        }
    }
}
