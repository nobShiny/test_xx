package com.zte.topsky.pay.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zte.topsky.R;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/9/28 15:48.
 */

public class MenuFragment extends Fragment{

    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.btn_record)
    Button btnRecord;
    private PayFragment payFragment;
    private PayRecordFragment payRecordFragment;
    private FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.pay_menu_fragment, null);
        ButterKnife.bind(this,layout);
        if(savedInstanceState ==null){
            payFragment = new PayFragment();
            transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.pay_container, payFragment)
                    .addToBackStack(null);
            payRecordFragment = new PayRecordFragment();
            transaction.add(R.id.pay_container, payRecordFragment)
                    .addToBackStack(null);
        }
        return layout;
    }

    @OnClick({R.id.btn_pay, R.id.btn_record})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pay:
                switchContent(this,payFragment);
                break;
            case R.id.btn_record:
                switchContent(this,payRecordFragment);
                break;
        }
    }

    public void switchContent(Fragment from, Fragment to) {
        getFragmentManager().beginTransaction().setCustomAnimations(
                android.R.anim.fade_in, android.R.anim.fade_out);
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.pay_container, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }
}
