package com.zte.topsky.disaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.home.bean.GridCutItem;
import com.zte.topsky.home.customui.homeScrollView.ControlScrollView;
import com.zte.topsky.home.customui.homeScrollView.DragGridView;
import com.zte.topsky.home.utils.AppUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/11/30 10:44.
 */

public class DisasterMessageMainActivity extends BaseActivity {

    @BindView(R.id.grid_view)
    DragGridView gridView;
    @BindView(R.id.scroller_view)
    ControlScrollView scroller;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;

    private ArrayList<GridCutItem> mDatas = new ArrayList<>();
    private DisasterControlGirdViewAdapter mAdapter;

    private String[][] gridDatas = {{"汛情摘要", ""},
            {"实时雨情", ""},
            {"卫星云图", ""},
            {"江河水情", ""},
            {"水库水情", ""},
            {"紧急联系", ""},
    };

    private int[] iconId = {R.drawable.ic_disaster_messages,
            R.drawable.ic_disaster_rain,
            R.drawable.ic_disaster_cloud,
            R.drawable.ic_disaster_water_conditions,
            R.drawable.ic_disaster_reservoirs,
            R.drawable.ic_disaster_emergency};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_message);
        addActivity(this);
        tvTitleText.setText("防汛信息");
        scroller.smoothScrollTo(0, 0);
        mDatas.clear();
        for (int i = 0; i < gridDatas.length; i++) {
            GridCutItem gridCutItem = new GridCutItem(gridDatas[i][0], gridDatas[i][1]);
            mDatas.add(gridCutItem);
        }
        initFunctionArea();
    }

    private void initFunctionArea() {
        mAdapter = new DisasterControlGirdViewAdapter(this, mDatas, gridView);
        gridView.setAdapter(mAdapter);
        scroller.setScrollState(new ControlScrollView.ScrollState() {
            @Override
            public void stopTouch() {
                gridView.stopDrag();
            }

            @Override
            public void isCanDrag(boolean isCanDrag) {
                gridView.setCanDrag(isCanDrag);
            }
        });

        gridView.setOnDragStartListener(new DragGridView.OnDragStartListener() {
            @Override
            public void onDragStart() {
                scroller.requestDisallowInterceptTouchEvent(true);
                scroller.setInControl(false);
            }
        });
        gridView.setOnDragEndListener(new DragGridView.OnDragEndListener() {
            @Override
            public void onDragEnd() {
                scroller.requestDisallowInterceptTouchEvent(false);
                scroller.setInControl(true);
                gridView.postInvalidate();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent summary_intent = new Intent(DisasterMessageMainActivity.this, SummaryActivity.class);
                        startActivity(summary_intent);
                        break;
                    case 1:
                        Intent rain_intent = new Intent(DisasterMessageMainActivity.this, RainActivity.class);
                        startActivity(rain_intent);
                        break;
                    case 2:
                        Intent clouds_intent = new Intent(DisasterMessageMainActivity.this, CloudsActivity.class);
                        startActivity(clouds_intent);
                        break;
                    case 3:
                        Intent river_intent = new Intent(DisasterMessageMainActivity.this, RiverActivity.class);
                        startActivity(river_intent);
                        break;
                    case 4:
                        Intent reservoir_intent = new Intent(DisasterMessageMainActivity.this, ReservoirActivity.class);
                        startActivity(reservoir_intent);
                        break;
                    case 5:
                        Intent emergency_intent = new Intent(DisasterMessageMainActivity.this, EmergencyActivity.class);
                        startActivity(emergency_intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    class DisasterControlGirdViewAdapter extends BaseAdapter {

        private DragGridView grid;
        private LayoutInflater mInflater;
        private Context mContext;
        private ArrayList<GridCutItem> mDatas;

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

}
