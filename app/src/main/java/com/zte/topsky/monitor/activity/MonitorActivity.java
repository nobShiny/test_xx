package com.zte.topsky.monitor.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by NobShiny
 * on 2016/9/27 14:54.
 */

public class MonitorActivity extends BaseActivity {

    @BindView(R.id.sv_view_content)
    JCVideoPlayerStandard svViewContent;
    @BindView(R.id.btn_control_up)
    Button btnControlUp;
    @BindView(R.id.btn_control_enter)
    Button btnControlEnter;
    @BindView(R.id.btn_control_left)
    Button btnControlLeft;
    @BindView(R.id.btn_control_right)
    Button btnControlRight;
    @BindView(R.id.btn_control_down)
    Button btnControlDown;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    String videoUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_monitor);
        addActivity(this);
        if (savedInstanceState == null) {
            tvTitleText.setText("监控");
        }
        videoUrl = "http://123.6.0.82/youku/6575D9DC83B447335B4186A83/03000801004D86B1D7F1A701ED892DE6F39CFE-EA7F-C587-B677-D6A8EE9CCF37.mp4?special=true";
//        svViewContent.setAllControlsVisible(View.GONE,View.GONE,View.GONE,View.GONE,View.GONE,View.GONE,View.GONE,View.GONE);
        svViewContent.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_LIST,"");
        svViewContent.prepareVideo();
    }

    @OnClick({R.id.btn_control_up, R.id.btn_control_enter, R.id.btn_control_left, R.id.btn_control_right, R.id.btn_control_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_control_up:
                Toast.makeText(this, "摄像头上移", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_control_enter:
                Toast.makeText(this, "截屏已保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_control_left:
                Toast.makeText(this, "摄像头左移", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_control_right:
                Toast.makeText(this, "摄像头右移", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_control_down:
                Toast.makeText(this, "摄像头下移", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
