package com.zte.topsky.pay.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        transaction = getSupportFragmentManager().beginTransaction();
        if (savedInstanceState == null) {
            tvTitleText.setText("在线购水");
            payFragment = new PayFragment();
            payRecordFragment = new PayRecordFragment();
        }
    }

    @OnClick({R.id.btn_pay, R.id.btn_record})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pay:
                if (!payFragment.isAdded()) {    // 先判断是否被add过
                    transaction.add(R.id.pay_container, payFragment)
                            .addToBackStack(null).commit();
                }else{
                    transaction.show(payFragment);
                }

                break;
            case R.id.btn_record:
                if (!payRecordFragment.isAdded()) {    // 先判断是否被add过
                    transaction.add(R.id.pay_container, payRecordFragment)
                            .addToBackStack(null).commit();
                }else{
                    transaction.show(payFragment);
                }
                break;
        }
    }

    public void switchContent(Fragment from, Fragment to) {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(
                android.R.anim.fade_in, android.R.anim.fade_out);
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.pay_container, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (payFragment==null&&payRecordFragment==null) {
            transaction = getSupportFragmentManager().beginTransaction();
            payFragment = new PayFragment();
            payRecordFragment = new PayRecordFragment();
        }
    }
}
