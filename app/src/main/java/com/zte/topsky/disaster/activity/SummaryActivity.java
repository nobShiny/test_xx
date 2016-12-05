package com.zte.topsky.disaster.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/12/2 16:03.
 */
public class SummaryActivity extends BaseActivity {

    @BindView(R.id.tv_title_text)
    TextView tvTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_summary);
        addActivity(this);
        tvTitleText.setText("汛情摘要");
    }

}
