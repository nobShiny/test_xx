package com.zte.topsky.disaster.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/12/2 16:06.
 */
public class CloudsActivity extends BaseActivity {

    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.wv_cloud)
    WebView wvCloud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_cloud);
        addActivity(this);
        tvTitleText.setText("卫星云图");
        initView();
    }

    private void initView() {
        wvCloud.setWebChromeClient(new WebChromeClient());
        wvCloud.loadUrl("http://waptianqi.2345.com/html/wxyt/wxyt.htm");
    }
}
