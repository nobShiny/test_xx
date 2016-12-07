package com.zte.topsky.disaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.disaster.bean.RainDataBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NobShiny
 * on 2016/12/6 16:21.
 */

public class RainListAdapter extends BaseAdapter {


    private List<RainDataBean> mData;
    private Context mContext;

    public RainListAdapter(Context context, List<RainDataBean> data) {
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
                    inflate(R.layout.item_disaster_rain_list, null);
            viewHolder = new ViewHolder(convertView);

            if (position % 2 == 0) {
                viewHolder.llItem.setBackgroundColor(mContext.getResources().
                        getColor(R.color.emergency_item_background_light_color));
            } else {
                viewHolder.llItem.setBackgroundColor(mContext.getResources().
                        getColor(R.color.emergency_item_background_dark_color));
            }

            viewHolder.tvRainArea.setText(mData.get(position).getArea());
            viewHolder.tvRainName.setText(mData.get(position).getName());
            viewHolder.tvRainVolume.setText(mData.get(position).getVolume());

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_rain_area)
        TextView tvRainArea;
        @BindView(R.id.tv_rain_name)
        TextView tvRainName;
        @BindView(R.id.tv_rain_volume)
        TextView tvRainVolume;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
