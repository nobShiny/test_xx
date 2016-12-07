package com.zte.topsky.disaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.disaster.bean.ReservoirDataBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NobShiny
 * on 2016/12/6 16:21.
 */

public class ReservoirListAdapter extends BaseAdapter {


    private List<ReservoirDataBean> mData;
    private Context mContext;

    public ReservoirListAdapter(Context context, List<ReservoirDataBean> data) {
        mData = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.item_disaster_reservoir_list, null);
            viewHolder = new ViewHolder(convertView);

            if (position % 2 == 0) {
                viewHolder.llItem.setBackgroundColor(mContext.getResources().
                        getColor(R.color.emergency_item_background_light_color));
            } else {
                viewHolder.llItem.setBackgroundColor(mContext.getResources().
                        getColor(R.color.emergency_item_background_dark_color));
            }

            viewHolder.tvRiverName.setText(mData.get(position).getName());
            viewHolder.tvRiverWaterLevel.setText(mData.get(position).getCurrentLevel());
            viewHolder.tvRiverWaterCapacity.setText(mData.get(position).getCapacity());
            viewHolder.tvRiverRestrictLevel.setText(mData.get(position).getRestrictLevel());
            viewHolder.tvRiverStorageRate.setText(mData.get(position).getStorageRate());

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_reservoir_name)
        TextView tvRiverName;
        @BindView(R.id.tv_reservoir_water_level)
        TextView tvRiverWaterLevel;
        @BindView(R.id.tv_reservoir_water_capacity)
        TextView tvRiverWaterCapacity;
        @BindView(R.id.tv_reservoir_restrict_level)
        TextView tvRiverRestrictLevel;
        @BindView(R.id.tv_reservoir_storage_rate)
        TextView tvRiverStorageRate;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
