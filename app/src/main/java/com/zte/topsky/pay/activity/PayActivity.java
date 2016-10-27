package com.zte.topsky.pay.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.pay.fragment.PayFragment;
import com.zte.topsky.pay.fragment.PayRecordFragment;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/9/28 12:03.
 */

public class PayActivity extends BaseActivity {

    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.btn_record)
    Button btnRecord;
    @BindView(R.id.ll_function_list)
    LinearLayout llFunctionList;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;

    private PayFragment payFragment;
    private PayRecordFragment payRecordFragment;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_pay);
        addActivity(this);
        if (savedInstanceState == null) {
            tvTitleText.setText("在线购水");
            payFragment = PayFragment.newInstance(this);
            payRecordFragment = PayRecordFragment.newInstance(this);
        }
    }

    @OnClick({R.id.btn_pay, R.id.btn_record})
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btn_pay:
                transaction.replace(R.id.pay_container, payFragment);
                break;
            case R.id.btn_record:
                transaction.replace(R.id.pay_container, payRecordFragment);
                break;
        }
        transaction.addToBackStack(null).commit();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        if (payFragment == null && payRecordFragment == null) {
            transaction = getSupportFragmentManager().beginTransaction();
            payFragment = new PayFragment();
            payRecordFragment = new PayRecordFragment();
        }
    }
}
