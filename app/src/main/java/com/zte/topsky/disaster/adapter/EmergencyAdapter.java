package com.zte.topsky.disaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zte.topsky.R;

/**
 * Created by NobShiny
 * on 2016/12/6 15:06.
 */

public class EmergencyAdapter extends BaseAdapter {

    private Context mContext;
    private String mNumber;

    public EmergencyAdapter(Context context, String number) {
        mContext = context;
        mNumber = number;
    }

    @Override
    public int getCount() {
        return 1;
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
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.item_emergency_contract_action, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.tv_action);
            viewHolder.textView.setText(mNumber);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }

    class ViewHolder {
        TextView textView;
    }
}
