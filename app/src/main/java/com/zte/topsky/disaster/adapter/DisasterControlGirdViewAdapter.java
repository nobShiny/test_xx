package com.zte.topsky.disaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.home.bean.GridCutItem;
import com.zte.topsky.home.customui.homeScrollView.DragGridView;
import com.zte.topsky.home.utils.AppUtils;

import java.util.ArrayList;

public class DisasterControlGirdViewAdapter extends BaseAdapter {

    private DragGridView grid;
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<GridCutItem> mDatas;

    private int[] iconId = {R.drawable.ic_disaster_messages,
            R.drawable.ic_disaster_rain,
            R.drawable.ic_disaster_cloud,
            R.drawable.ic_disaster_water_conditions,
            R.drawable.ic_disaster_reservoirs,
            R.drawable.ic_disaster_emergency};


    public DisasterControlGirdViewAdapter(Context context, ArrayList<GridCutItem> data, DragGridView grid) {
        mContext = context;
        mDatas = data;
        this.grid = grid;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (grid.getHeight() - (3 * AppUtils.Dp2Px(mContext, 4))) / 3);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_home_grid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.iv_item_icon);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mImageView.setImageResource(iconId[position]);
        viewHolder.mTextView.setText(mDatas.get(position).getName());
        convertView.setLayoutParams(param);
        return convertView;
    }

    class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}