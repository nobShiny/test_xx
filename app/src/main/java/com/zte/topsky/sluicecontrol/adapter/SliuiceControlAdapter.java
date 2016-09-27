package com.zte.topsky.sluicecontrol.adapter;

import android.content.Context;

import com.zte.topsky.R;
import com.zte.topsky.home.adapter.CommonAdapter;
import com.zte.topsky.home.adapter.ViewHolder;
import com.zte.topsky.sluicecontrol.bean.PumpData;

import java.util.List;

/**
 * Created by NobShiny
 * on 2016/9/27 11:20.
 */

public class SliuiceControlAdapter extends CommonAdapter<PumpData> {
    /**
     * 初始化通用Adapter
     *
     * @param context      上下文
     * @param mDatas       需要显示的数据集合
     * @param itemLayoutId 子布局文件
     */
    public SliuiceControlAdapter(Context context, List<PumpData> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder holder, PumpData item, int position) {
        holder.setText(R.id.tv_pump_appellation,mDatas.get(position).getPumpDes());
        holder.setText(R.id.tv_run_state,mDatas.get(position).getRunState());
        holder.setText(R.id.tv_run_speed,mDatas.get(position).getRunSpeed());
        holder.setText(R.id.tv_run_flow,mDatas.get(position).getRunFlow());
    }
}
