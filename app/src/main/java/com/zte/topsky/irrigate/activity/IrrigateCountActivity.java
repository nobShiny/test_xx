package com.zte.topsky.irrigate.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.common.utils.DividerItemDecoration;
import com.zte.topsky.common.utils.OnClickEvent;
import com.zte.topsky.irrigate.bean.IrrigateData;
import com.zte.topsky.irrigate.customui.IrrigateColumnDiagramView;

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
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.ir_chart)
    IrrigateColumnDiagramView irChart;

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
        tvTitleText.setText("灌溉统计");
        mList = textData();
        rlIrrigateList.setLayoutManager(new LinearLayoutManager(this));
        rlIrrigateList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new CommonAdapter(this, R.layout.item_irrigate_data, mList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_data_name, mList.get(position).getIrrigateDataName());
                holder.setText(R.id.tv_count, String.valueOf(mList.get(position).getIrrigateDataCount()));
                holder.setText(R.id.tv_cumulation, String.valueOf(mList.get(position).getIrrigateDataCumulation()));
                holder.setText(R.id.tv_last, String.valueOf(mList.get(position).getIrrigateDataLast()));
                holder.setText(R.id.tv_sum, String.valueOf(mList.get(position).getIrrigationSum()));
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
        IrrigateData data1 = new IrrigateData("1号机井", 8,228,272,500);
        IrrigateData data2 = new IrrigateData("2号机井", 6,126,347,500);
        mList.add(data1);
        mList.add(data2);

        return mList;

    }
}
