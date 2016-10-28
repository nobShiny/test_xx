package com.zte.topsky.weatherdata.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.weatherdata.view.DataPickerBG;
import com.zte.topsky.weatherdata.view.SoilLineChartView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import cn.aigestudio.datepicker.bizs.themes.DPTManager;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * Created by NobShiny
 * on 2016/9/22 14:50.
 */

public class WeatherDateActivity extends BaseActivity {

    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.btn_date)
    Button btnDate;
    @BindView(R.id.rl_chart_soil_line)
    RecyclerView rlChartSoilLine;
    @BindView(R.id.rl_chart_relative_line)
    RecyclerView rlChartRelativeLine;
    private DatePicker picker;

    private String[] str;
    private int currentYear;
    private int currentMonth;
    private int currentDay;

    private StringBuilder selectYear;
    private StringBuilder selectMonth;
    private StringBuilder selectDay;

//    private Map<String,Double> mData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_weather);
        addActivity(this);
        if (savedInstanceState == null) {
            initView();
        }
    }

    @BindView(R.id.chart)
    SoilLineChartView chart;

    private void initView() {
        tvTitleText.setText("数据");
        DPTManager.getInstance().initCalendar(new DataPickerBG());
        getCurrentData();
//        mData = getNewData();
//        if (mData.size()>0||mData!=null) {
//            chart = new SoilLineChartView(this,currentYear+"-"+(currentYear+1) ,mData);
//        }
    }

    private void getCurrentData() {
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentDay = calendar.get(Calendar.HOUR_OF_DAY);
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
        picker.setDate(currentYear, currentMonth);
        picker.setMode(DPMode.SINGLE);
        picker.setFestivalDisplay(false);
        picker.setTodayDisplay(false);
        picker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                str = date.split("-");
                picker.setDate(Integer.valueOf(str[0]), Integer.valueOf(str[1]));
                btnDate.setText(str[0] + "年" + str[1] + "月" + str[2] + "日");
                dialog.dismiss();
            }
        });
        return picker;
    }

}
