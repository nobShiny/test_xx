
package com.zte.topsky.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.common.utils.OnClickEvent;
import com.zte.topsky.mine.SettingsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wuyexiong on 4/25/15.
 */
public class MineFragment extends BaseFragment {
    private static final String KEY_CONTENT = "MineFragment";
    private static Context mContext;
    @BindView(R.id.mine_settings)
    LinearLayout settingLayout;
    @BindView(R.id.mine_user_image)
    CircleImageView userImage;

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
                Intent intent = new Intent(mContext,SettingsActivity.class);
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
}
