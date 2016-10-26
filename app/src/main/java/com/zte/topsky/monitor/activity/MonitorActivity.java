package com.zte.topsky.monitor.activity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/9/27 14:54.
 */

public class MonitorActivity extends BaseActivity {

    @BindView(R.id.sv_view_content)
    SurfaceView svViewContent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_monitor);
        addActivity(this);
        if (savedInstanceState == null) {
            tvTitleText.setText("监控");
        }
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
}
