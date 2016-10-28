package com.zte.topsky.pay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.common.utils.OnClickEvent;
import com.zte.topsky.pay.bean.PaymentWay;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/9/28 15:34.
 */

public class PayFragment extends BaseFragment {

    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.rb_check_alipay)
    CheckBox rbCheckAlipay;
    @BindView(R.id.rb_check_wx)
    CheckBox rbCheckWx;
    @BindView(R.id.rb_check_yl)
    CheckBox rbCheckYl;
    @BindView(R.id.confirm_pay)
    Button confirmPay;
    @BindView(R.id.ll_alipay)
    LinearLayout llAlipay;
    @BindView(R.id.ll_wechat)
    LinearLayout llWechat;
    @BindView(R.id.ll_yl)
    LinearLayout llYl;
    @BindView(R.id.et_amount)
    EditText etAmount;

    private PaymentWay pay;

    private static Context mContext;

    public static PayFragment newInstance(Context context) {
        PayFragment fragment = new PayFragment();
        mContext = context;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.pay_page_fragment, null);
        ButterKnife.bind(this, layout);
        pay = new PaymentWay();
        rbCheckAlipay.setOnClickListener(new OnClickEvent() {
            @Override
            protected void onNoDoubleClick(View v) {
                rbCheckWx.setChecked(false);
                rbCheckYl.setChecked(false);
                pay.setCheck(true);
                pay.setName("支付宝");
                if (!rbCheckAlipay.isChecked()) {
                    pay.setCheck(false);
                }
            }
        });

        rbCheckWx.setOnClickListener(new OnClickEvent() {
            @Override
            protected void onNoDoubleClick(View v) {
                rbCheckYl.setChecked(false);
                rbCheckAlipay.setChecked(false);
                pay.setCheck(true);
                pay.setName("微信");
                if (!rbCheckWx.isChecked()) {
                    pay.setCheck(false);
                }
            }
        });

        rbCheckYl.setOnClickListener(new OnClickEvent() {
            @Override
            protected void onNoDoubleClick(View v) {
                rbCheckWx.setChecked(false);
                rbCheckAlipay.setChecked(false);
                pay.setCheck(true);
                pay.setName("银联");
                if (!rbCheckYl.isChecked()) {
                    pay.setCheck(false);
                }
            }
        });
        return layout;
    }

    @Override
    protected int getlayoutId() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void lazyLoadData() {

    }


    @OnClick({R.id.iv_back, R.id.confirm_pay, R.id.ll_alipay, R.id.ll_wechat, R.id.ll_yl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                getFragmentManager().popBackStack();
                break;
            case R.id.confirm_pay:
                if (!pay.isCheck()) {
                    Toast.makeText(mContext, "请选择一种付款方式", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "选择了" + pay.getName() +"支付，金额为："+
                            etAmount.getText().toString()+"元", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_alipay:
                if (rbCheckAlipay.isChecked()) {
                    rbCheckAlipay.setChecked(false);
                } else {
                    rbCheckAlipay.setChecked(true);
                }
                break;
            case R.id.ll_wechat:
                if (rbCheckWx.isChecked()) {
                    rbCheckWx.setChecked(false);
                } else {
                    rbCheckWx.setChecked(true);
                }
                break;
            case R.id.ll_yl:
                if (rbCheckYl.isChecked()) {
                    rbCheckYl.setChecked(false);
                } else {
                    rbCheckYl.setChecked(true);
                }
                break;
        }
    }
}
