
package com.zte.topsky.home.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by wuyexiong on 4/25/15.
 */
public class MineFragment extends BaseFragment {
    private static final String KEY_CONTENT = "HomeFragment";
    private Banner banner;
    private static Context mContext;


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
//        TextView text = new TextView(getActivity());
//        text.setGravity(Gravity.CENTER);
//        text.setText(mContent);
//        text.setTextSize(20 * getResources().getDisplayMetrics().density);
//        text.setPadding(20, 20, 20, 20);
//
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
//        layout.setGravity(Gravity.CENTER);
//        layout.addView(text);
        View layout = inflater.inflate(R.layout.home_fragment, null);
        ButterKnife.bind(this, layout);
        initView(layout);
        return layout;
    }

    private void initView(View layout) {
        initBanner(layout);
        initFunctionArea(layout);

    }

    private void initFunctionArea(View layout) {

    }

    private void initBanner(View layout) {
        banner = (Banner) layout.findViewById(R.id.banner);
        banner.isAutoPlay(true);
        TypedArray images = this.getResources().obtainTypedArray(R.array.banner_images);
        Integer[] resIds = new Integer[images.length()];
        for (int i = 0; i < images.length(); i++) {
            resIds[i] = images.getResourceId(i, 0);
        }
        images.recycle();
        String[] titles = this.getResources().getStringArray(R.array.title);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerTitle(titles);
        banner.setImages(resIds);
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
        banner.isAutoPlay(false);
    }
}
