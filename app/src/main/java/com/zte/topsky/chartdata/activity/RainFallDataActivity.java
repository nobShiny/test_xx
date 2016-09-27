package com.zte.topsky.chartdata.activity;

import android.os.Bundle;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.chartdata.view.RainFallView;

import butterknife.BindView;


/**
 * Created by NobShiny
 * on 2016/9/22 10:52.
 */

public class RainFallDataActivity extends BaseActivity {

    @BindView(R.id.rainfall_view)
    RainFallView rainFallView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_rainfall);
        addActivity(this);
    }
}
