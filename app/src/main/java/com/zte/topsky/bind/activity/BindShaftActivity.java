package com.zte.topsky.bind.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/10/11 16:16.
 */

public class BindShaftActivity extends BaseActivity {

    @BindView(R.id.et_coordinate)
    EditText etCoordinate;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_bind_shaft);
        addActivity(this);
        if (savedInstanceState == null) {

        }
    }

    @OnClick(R.id.btn_confirm)
    public void onClick() {
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
    }
}
