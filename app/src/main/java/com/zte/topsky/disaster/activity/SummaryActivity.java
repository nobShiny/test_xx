package com.zte.topsky.disaster.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
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
    @BindView(R.id.tv_summary)
    TextView tvSummary;
    @BindView(R.id.tv_river)
    TextView tvRiver;
    @BindView(R.id.tv_reservoir)
    TextView tvReservoir;
    @BindView(R.id.tv_complex)
    TextView tvComplex;
    @BindView(R.id.ll_s1)
    RelativeLayout llS1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_summary);
        addActivity(this);
        tvTitleText.setText("汛情摘要");
        initData();
    }

    private void initData() {
        tvSummary.setText("12月1日零晨1点到12月5日零晨1点，区域累计平均降雨量3.8毫米，其实1#检测点累计为0.6毫米，2#检测点累计为1.3毫米，3#检测点累计为1.9毫米，" +
                "最大降雨量监测点为3#测站，较往年，冬季雨量偏少。");
        tvRiver.setText("检测区域水量为安全水量。");
        tvReservoir.setText("目前区域3#水库总蓄水量最大，为360立方米，平均蓄水量为31.2%，各水库水位均在安全线以下。");
        tvComplex.setText("目前全区域汛情平稳。");
    }

//    @OnClick(R.id.ll_s1)
//    public void onClick() {
//        tvSummary.setText(".............");
//    }
}
