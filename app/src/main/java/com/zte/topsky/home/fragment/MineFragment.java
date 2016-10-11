package com.zte.topsky.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.bind.activity.BindMonitorActivity;
import com.zte.topsky.bind.activity.BindShaftActivity;
import com.zte.topsky.common.utils.OnClickEvent;
import com.zte.topsky.login.activity.LoginActivity;
import com.zte.topsky.mine.SettingsActivity;
import com.zte.topsky.register.activity.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shiny.
 */
public class MineFragment extends BaseFragment {
    private static final String KEY_CONTENT = "MineFragment";
    private static Context mContext;
    @BindView(R.id.mine_settings)
    LinearLayout settingLayout;
    @BindView(R.id.mine_user_image)
    CircleImageView userImage;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.ll_monitor_bind)
    LinearLayout llMonitorBind;
    @BindView(R.id.ll_shaft_bind)
    LinearLayout llShaftBind;

    public static MineFragment newInstance(Context context) {
        MineFragment fragment = new MineFragment();
        mContext = context;
        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, layout);
        initView(layout);
        return layout;
    }

    private void initView(View layout) {
        settingLayout.setOnClickListener(new OnClickEvent() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent(mContext, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
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

    @Override
    public void onPause() {
        super.onPause();
    }

    @OnClick({R.id.tv_login, R.id.tv_register, R.id.ll_monitor_bind, R.id.ll_shaft_bind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                Intent intentLogin = new Intent(mContext,LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.tv_register:
                Intent intentRegister = new Intent(mContext,RegisterActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.ll_monitor_bind:
                Intent intentBindM = new Intent(mContext,BindMonitorActivity.class);
                startActivity(intentBindM);
                break;
            case R.id.ll_shaft_bind:
                Intent intentBindS = new Intent(mContext,BindShaftActivity.class);
                startActivity(intentBindS);
                break;
        }
    }
}
