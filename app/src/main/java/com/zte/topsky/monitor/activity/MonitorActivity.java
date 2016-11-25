package com.zte.topsky.monitor.activity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
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

    private JCVideoPlayer.JCAutoFullscreenListener mSensorEventListener;
    private SensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_monitor);
        addActivity(this);
        if (savedInstanceState == null) {
            tvTitleText.setText("监控");
        }

        videoUrl = "http://111.206.109.135/youku/6575DE60BE73C8310504A26364/03000201004D86B095F1A701ED892DE6F39CFE-EA7F-C587-B677-D6A8EE9CCF37.flv";
//        videoUrl = "http://us.sinaimg.cn/003xaEf8jx076hcqKZ8H05040100gmch0k01.mp4?Expires=1478663683&KID=unistore,video&ssig=ENub0YD4Hq";
//        videoUrl = "http://121.29.55.49/youku/6979DD10DDB4979FA97006DBD/03000801004EEABAEC9CEF0017BD61BD8A187B-3461-8D31-947B-32C563039C6A.mp4";
        svViewContent.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        svViewContent.startWindowFullscreen();
        initVideoView();
        svViewContent.prepareVideo();
    }

    private void initVideoView() {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
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
        mSensorManager.unregisterListener(mSensorEventListener);
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(mSensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
