package com.zte.topsky.chartdata.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.chartdata.view.RainFallView;
import com.zte.topsky.chartdata.view.WeatherWebView;

import butterknife.BindView;


/**
 * Created by NobShiny
 * on 2016/9/22 10:52.
 */

public class RainFallDataActivity extends BaseActivity {

    @BindView(R.id.rainfall_view)
    RainFallView rainFallView;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.wv_weather)
    WeatherWebView wvWeather;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.progressBar)
    ContentLoadingProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_rainfall);
        addActivity(this);
        tvTitleText.setText("气象");
        wvWeather.loadUrl("http://m.tianqi.com/");
        wvWeather.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        wvWeather.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(android.view.View.VISIBLE);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(android.view.View.GONE);
            }
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                progressBar.setVisibility(android.view.View.GONE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        llRoot.removeView(wvWeather);
        wvWeather.destroy();
    }
}
