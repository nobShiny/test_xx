package com.zte.topsky.sluicecontrol.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.sluicecontrol.bean.PumpData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/9/27 10:02.
 */

public class SluiceControlActivity extends BaseActivity {

    @BindView(R.id.pump_recycler_list)
    RecyclerView pump_recycler_list;
    private List<PumpData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_sluicecontrol);
        addActivity(this);
        initView();
    }

    private void initView() {
        list = textData();
        pump_recycler_list.setLayoutManager(new LinearLayoutManager(this));
        pump_recycler_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        pump_recycler_list.setAdapter(new CommonAdapter(this, R.layout.item_pump, list) {
            @Override
            protected void convert(final ViewHolder holder, Object o, final int position) {
                holder.setText(R.id.tv_pump_appellation,list.get(position).getPumpDes());
                holder.setText(R.id.tv_run_state,list.get(position).getRunState());
                holder.setText(R.id.tv_run_speed,list.get(position).getRunSpeed());
                holder.setText(R.id.tv_run_flow,list.get(position).getRunFlow());
                holder.setText(R.id.tv_run_time,list.get(position).getRunTime());
                holder.setChecked(R.id.tv_run_switch,list.get(position).isRunSwitch());
                holder.setOnClickListener(R.id.tv_run_switch, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (list.get(position).isRunSwitch()) {
                            AlertDialog dialog = new AlertDialog.Builder(SluiceControlActivity.this)
                                    .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            list.get(position).setRunSwitch(false);
                                            holder.setChecked(R.id.tv_run_switch,list.get(position).isRunSwitch());
                                            holder.setText(R.id.tv_run_state,list.get(position).getRunState());
                                            dialog.dismiss();
                                        }
                                    })
                                    .setMessage("是否关闭此机井？")
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            holder.setChecked(R.id.tv_run_switch,list.get(position).isRunSwitch());
                                            holder.setText(R.id.tv_run_state,list.get(position).getRunState());
                                            dialog.dismiss();
                                        }
                                    })
                                    .setCancelable(false).create();
                            dialog.show();
                        }else{
                            AlertDialog dialog = new AlertDialog.Builder(SluiceControlActivity.this)
                                    .setPositiveButton("开启", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            list.get(position).setRunSwitch(true);
                                            holder.setChecked(R.id.tv_run_switch,list.get(position).isRunSwitch());
                                            holder.setText(R.id.tv_run_state,list.get(position).getRunState());
                                            dialog.dismiss();
                                        }
                                    })
                                    .setMessage("是否开启此机井？")
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            holder.setChecked(R.id.tv_run_switch,list.get(position).isRunSwitch());
                                            holder.setText(R.id.tv_run_state,list.get(position).getRunState());
                                            dialog.dismiss();
                                        }
                                    })
                                    .setCancelable(false).create();
                            dialog.show();
                        }
                    }
                });
            }
        });
    }


    //fixme
    private List textData() {
        list = new ArrayList<>();
        PumpData pump1 = new PumpData();
        pump1.setPumpDes("一号机井");
        pump1.setRunFlow("16立方米/秒");
        pump1.setRunSpeed("22米/秒");
        pump1.setRunTime("2小时");
        pump1.setRunSwitch(true);
        if(pump1.isRunSwitch()){
            pump1.setRunState("开启");
        }else{
            pump1.setRunState("关闭");
        }
        list.add(pump1);

        PumpData pump2 = new PumpData();
        pump2.setPumpDes("二号机井");
        pump2.setRunFlow("16立方米/秒");
        pump2.setRunSpeed("22米/秒");
        pump2.setRunTime("5小时");
        pump2.setRunSwitch(false);
        if(pump2.isRunSwitch()){
            pump2.setRunState("开启");
        }else{
            pump2.setRunState("关闭");
        }
        list.add(pump2);

        return list;
    }

}