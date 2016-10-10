package com.zte.topsky.weatherdata.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.weatherdata.view.SoilLineChartView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * Created by NobShiny
 * on 2016/9/22 14:50.
 */

public class WeatherDateActivity extends BaseActivity {

    @BindView(R.id.chart)
    SoilLineChartView chart;
    @BindView(R.id.btn_date)
    Button btnDate;
    @BindView(R.id.rl_chart_line)
    RecyclerView rlChartLine;
    private DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_weather);
        addActivity(this);
        if (savedInstanceState == null) {
            initView();
        }
    }

    private void initView() {

    }

    @OnClick(R.id.btn_date)
    public void onClick() {
        final AlertDialog dialog = new AlertDialog.Builder(WeatherDateActivity.this).create();
        dialog.show();
        initDatePicker(dialog);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setContentView(picker, params);
        dialog.getWindow().setGravity(Gravity.CENTER);
    }

    private DatePicker initDatePicker(final AlertDialog dialog) {
        picker = new DatePicker(WeatherDateActivity.this);
        picker.setDate(2016, 10);
        picker.setMode(DPMode.SINGLE);
        picker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                Toast.makeText(WeatherDateActivity.this, date, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        return picker;
    }


}
