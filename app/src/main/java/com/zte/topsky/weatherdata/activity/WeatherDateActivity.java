package com.zte.topsky.weatherdata.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.weatherdata.bean.DataSummy;
import com.zte.topsky.weatherdata.view.DataPickerBG;
import com.zte.topsky.weatherdata.view.SoilLineChartView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
    private DatePicker picker;

    private String[] str;
    private int currentYear;
    private int currentMonth;
    private int currentDay;

    private StringBuilder selectYear;
    private StringBuilder selectMonth;
    private StringBuilder selectDay;

    private List<DataSummy> mList;
    private Map<String, String> soilData;
    private Map<String, String> relativeData;


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

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rlChartSoilLine.setLayoutManager(layoutManager);
        rlChartSoilLine.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rlChartSoilLine.setAdapter(new CommonAdapter(this, R.layout.item_data_soil, initData()) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                if (position == 0) {
                    holder.setVisible(R.id.ll_index, true);
                }else{
                    holder.setVisible(R.id.ll_index, false);
                }
                holder.setText(R.id.item_time, mList.get(position).getTime());
                holder.setText(R.id.item_soil, mList.get(position).getSoil());
                holder.setText(R.id.item_relative, mList.get(position).getRelative());
            }
        });
    }

    private List<DataSummy> initData() {
        mList = new ArrayList<>();
        DataSummy data1 = new DataSummy("8时", "43", "57");
        DataSummy data2 = new DataSummy("9时", "47", "58");
        DataSummy data3 = new DataSummy("10时", "52", "60");
        DataSummy data4 = new DataSummy("11时", "53", "61");
        DataSummy data5 = new DataSummy("12时", "55", "63");
        DataSummy data6 = new DataSummy("13时", "64", "69");
        DataSummy data7 = new DataSummy("14时", "77", "85");
        DataSummy data8 = new DataSummy("15时", "79", "88");
        DataSummy data9 = new DataSummy("16时", "82", "91");
        DataSummy data10 = new DataSummy("17时", "83", "93");
        DataSummy data11 = new DataSummy("18时", "82", "92");

        mList.add(data1);
        mList.add(data2);
        mList.add(data3);
        mList.add(data4);
        mList.add(data5);
        mList.add(data6);
        mList.add(data7);
        mList.add(data8);
        mList.add(data9);
        mList.add(data10);
        mList.add(data11);
//        soilData = new LinkedHashMap<>();
//        soilData.put("8时", "43");
//        soilData.put("9时", "47");
//        soilData.put("10时", "52");
//        soilData.put("11时", "53");
//        soilData.put("12时", "55");
//        soilData.put("13时", "64");
//        soilData.put("14时", "77");
//        soilData.put("15时", "79");
//        soilData.put("16时", "82");
//        soilData.put("17时", "83");
//        soilData.put("18时", "82");
//        mList.add(soilData);

//        relativeData = new LinkedHashMap<>();
//        relativeData.put("8时", "57");
//        relativeData.put("9时", "58");
//        relativeData.put("10时", "60");
//        relativeData.put("11时", "61");
//        relativeData.put("12时", "63");
//        relativeData.put("13时", "69");
//        relativeData.put("14时", "85");
//        relativeData.put("15时", "88");
//        relativeData.put("16时", "91");
//        relativeData.put("17时", "93");
//        relativeData.put("18时", "92");
//        mList.add(relativeData);
        return mList;
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
