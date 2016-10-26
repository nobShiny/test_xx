package com.zte.topsky.chartdata.activity;

import android.os.Bundle;
import android.widget.TextView;

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
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_rainfall);
        addActivity(this);
        tvTitleText.setText("气象");
    }

    @Override
    public void onBackPressed() {
        finishActivity();
    }
}
