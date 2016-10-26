package com.zte.topsky.pay.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.zte.topsky.R;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/9/28 15:34.
 */

public class PayFragment extends Fragment {

    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.rb_check_alipay)
    RadioButton rbCheckAlipay;
    @BindView(R.id.rb_check_wx)
    RadioButton rbCheckWx;
    @BindView(R.id.rb_check_yl)
    RadioButton rbCheckYl;
    @BindView(R.id.confirm_pay)
    Button confirmPay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.pay_page_fragment, null);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        getFragmentManager().popBackStack();
    }
}
