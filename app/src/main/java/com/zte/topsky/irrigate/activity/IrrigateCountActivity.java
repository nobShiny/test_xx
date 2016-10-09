package com.zte.topsky.irrigate.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.common.utils.OnClickEvent;
import com.zte.topsky.irrigate.bean.IrrigateData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/10/9 10:13.
 */

public class IrrigateCountActivity extends BaseActivity {

    @BindView(R.id.rl_irrigate_list)
    RecyclerView rlIrrigateList;
    @BindView(R.id.ll_notice)
    LinearLayout llNotice;
    private CommonAdapter<String> mAdapter;
    private List<IrrigateData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_irrigate_count);
        addActivity(this);
        if (savedInstanceState == null) {
            initView();
        }
    }

    private void initView() {
        mList = textData();
        rlIrrigateList.setLayoutManager(new LinearLayoutManager(this));
        rlIrrigateList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new CommonAdapter(this, R.layout.item_irrigate_data, mList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_data_time, mList.get(position).getIrrigateDateTime());
                holder.setText(R.id.tv_data, mList.get(position).getIrrigationVolume());
            }
        };
        rlIrrigateList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                llNotice.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        llNotice.setOnClickListener(new OnClickEvent() {
            @Override
            protected void onNoDoubleClick(View v) {
                llNotice.setVisibility(View.GONE);
            }
        });

    }

    private List<IrrigateData> textData() {
        mList = new ArrayList<>();
        IrrigateData data1 = new IrrigateData("2016年1月16日15时-2016年2月16日15时", "100m³");

        IrrigateData data2 = new IrrigateData("2016年2月16日15时-2016年3月16日15时", "100m³");

        IrrigateData data3 = new IrrigateData("2016年3月16日15时-2016年4月16日15时", "100m³");

        IrrigateData data4 = new IrrigateData("2016年4月16日15时-2016年5月16日15时", "100m³");

        IrrigateData data5 = new IrrigateData("2016年5月16日15时-2016年6月16日15时", "100m³");

        IrrigateData data6 = new IrrigateData("2016年6月16日15时-2016年7月16日15时", "100m³");

        IrrigateData data7 = new IrrigateData("2016年7月16日15时-2016年8月16日15时", "100m³");

        IrrigateData data8 = new IrrigateData("2016年8月16日15时-2016年9月16日15时", "100m³");
        mList.add(data8);
        mList.add(data7);
        mList.add(data6);
        mList.add(data5);
        mList.add(data4);
        mList.add(data3);
        mList.add(data2);
        mList.add(data1);

        return mList;

    }
}
