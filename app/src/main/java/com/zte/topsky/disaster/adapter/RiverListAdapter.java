package com.zte.topsky.disaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.disaster.bean.RiverDataBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NobShiny
 * on 2016/12/6 16:21.
 */

public class RiverListAdapter extends BaseAdapter {


    private List<RiverDataBean> mData;
    private Context mContext;

    public RiverListAdapter(Context context, List<RiverDataBean> data) {
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
                    inflate(R.layout.item_disaster_river_list, null);
            viewHolder = new ViewHolder(convertView);

            if (position % 2 == 0) {
                viewHolder.llItem.setBackgroundColor(mContext.getResources().
                        getColor(R.color.emergency_item_background_light_color));
            } else {
                viewHolder.llItem.setBackgroundColor(mContext.getResources().
                        getColor(R.color.emergency_item_background_dark_color));
            }

            viewHolder.tvRiverName.setText(mData.get(position).getName());
            viewHolder.tvRiverCurrentLevel.setText(mData.get(position).getCurrentLevel());
            viewHolder.tvRiverAlertLevel.setText(mData.get(position).getAlertLevel());
            viewHolder.tvRiverCriticalLevel.setText(mData.get(position).getCriticalLevel());

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_river_name)
        TextView tvRiverName;
        @BindView(R.id.tv_river_current_level)
        TextView tvRiverCurrentLevel;
        @BindView(R.id.tv_river_alert_level)
        TextView tvRiverAlertLevel;
        @BindView(R.id.tv_river_critical_level)
        TextView tvRiverCriticalLevel;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
