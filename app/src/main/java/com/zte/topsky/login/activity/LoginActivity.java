package com.zte.topsky.login.activity;

import android.os.Bundle;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

/**
 * Created by NobShiny
 * on 2016/10/11 16:12.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_login);
        addActivity(this);
        if (savedInstanceState == null) {

        }
    }

}
