
package com.zte.topsky.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by nobShiny.
 */
public class MessagesFragment extends BaseFragment {
    private static final String KEY_CONTENT = "HomeFragment";
    private Banner banner;
    private static Context mContext;


    public static MessagesFragment newInstance(Context context) {
        MessagesFragment fragment = new MessagesFragment();
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
        View layout = inflater.inflate(R.layout.fragment_messages, null);
        ButterKnife.bind(this, layout);
        initView(layout);
        return layout;
    }

    private void initView(View layout) {

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
