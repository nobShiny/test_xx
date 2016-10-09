package com.zte.topsky.weatherdata.activity;

import android.os.Bundle;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

/**
 * Created by NobShiny
 * on 2016/9/22 14:50.
 */

public class WeatherDateActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_weather);
        addActivity(this);
        if (savedInstanceState == null) {
            initView();
        }
    }

    private void initView() {

    }

}
