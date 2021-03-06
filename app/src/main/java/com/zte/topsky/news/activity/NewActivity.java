package com.zte.topsky.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/9/27 16:13.
 */

public class NewActivity extends BaseActivity {

    @BindView(R.id.wv_news_content)
    WebView wv;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_new_content);
        addActivity(this);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        if (intent.getStringExtra("url")!=null && !"".equals(url)) {
            wv.loadUrl(url);
        }else{
            Toast.makeText(this, "url有误", Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public void sendURL(String url) {
//        if (url!=null && !"".equals(url)) {
//            wv.loadUrl(url);
//        }else{
//            Toast.makeText(this, "url有误", Toast.LENGTH_SHORT).show();
//        }
//    }
}
