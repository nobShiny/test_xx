package com.zte.topsky.disaster.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/12/2 16:08.
 */
public class EmergencyActivity extends BaseActivity {

    @BindView(R.id.tv_title_text)
    TextView tvTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_emergency);
        addActivity(this);
        tvTitleText.setText("紧急联系");
    }


}
