package com.zte.topsky.bind.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/10/11 16:16.
 */

public class BindMonitorActivity extends BaseActivity {

    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.tv_title_text)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_bind_monitor);
        addActivity(this);
        if (savedInstanceState == null) {
            title.setText("监控绑定");
        }
    }

    @OnClick(R.id.btn_confirm)
    public void onClick() {
        Toast.makeText(this, "绑定成功", Toast.LENGTH_SHORT).show();
    }
}
