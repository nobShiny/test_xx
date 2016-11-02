
package com.zte.topsky.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zte.topsky.R;
import com.zte.topsky.base.fragment.BaseFragment;
import com.zte.topsky.chartdata.activity.RainFallDataActivity;
import com.zte.topsky.home.bean.GridCutItem;
import com.zte.topsky.home.customui.homeScrollView.ControlScrollView;
import com.zte.topsky.home.customui.homeScrollView.DragGridView;
import com.zte.topsky.home.customui.homeScrollView.ViewWithSign;
import com.zte.topsky.home.utils.AppUtils;
import com.zte.topsky.irrigate.activity.IrrigateCountActivity;
import com.zte.topsky.monitor.activity.MonitorActivity;
import com.zte.topsky.pay.activity.PayActivity;
import com.zte.topsky.sluicecontrol.activity.SluiceControlActivity;
import com.zte.topsky.weatherdata.activity.WeatherDateActivity;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nobShiny.
 */
public class HomeFragment extends BaseFragment {
    private static final String KEY_CONTENT = "HomeFragment";
    private static Context mContext;
    private ViewWithSign viewWithSign;
    @BindView(R.id.scroller)
    ControlScrollView scroller;
    @BindView(R.id.grid)
    DragGridView grid;
    @BindView(R.id.banner)
    Banner banner;

    private String[][] gridDatas = {{"气象", ""},
            {"数据", ""},
            {"阀门管理", ""},
            {"监控", ""},
            {"灌溉统计", ""},
            {"在线购水", ""}
    };

    private int[] iconId = {R.drawable.ic_home_item_weather,
            R.drawable.ic_home_item_statics,
            R.drawable.ic_home_item_sluice,
            R.drawable.ic_home_item_monitor,
            R.drawable.ic_home_item_data,
            R.drawable.ic_home_item_pay};

    private ArrayList<GridCutItem> mDatas = new ArrayList<>();
    private HomeGirdViewAdapter mAdapter;


    public static HomeFragment newInstance(Context context) {
        HomeFragment fragment = new HomeFragment();
        mContext = context;
        return fragment;
    }

    private String mContent = "???";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, layout);
        initView(layout);
        return layout;
    }

    private void initView(View layout) {
        scroller.smoothScrollTo(0, 0);
        mDatas.clear();
        for (int i = 0; i < gridDatas.length; i++) {
            GridCutItem gridCutItem = new GridCutItem(gridDatas[i][0], gridDatas[i][1]);
            mDatas.add(gridCutItem);
        }

        initBanner(layout);
        initFunctionArea(layout);

    }

    private void initFunctionArea(View layout) {
//        mAdapter = new CommonAdapter<GridCutItem>(getContext(), mDatas, R.layout.item_home_grid,grid) {
//            @Override
//            public void convert(ViewHolder helper, final GridCutItem item, int position) {
//
////                viewWithSign = helper.getView(R.id.icon);
////                viewWithSign.addDrawText(item.getTip());
//            }
////        };
        mAdapter = new HomeGirdViewAdapter(mContext,mDatas,grid);
        grid.setAdapter(mAdapter);

        //设置拖拽数据交换
        /*grid.setOnChangeListener(new DragGridView.OnChangeListener() {
            @Override
            public void onChange(int from, int to) {
                GridCutItem temp = mDatas.get(from);
                if (from < to) {
                    for (int i = from; i < to; i++) {
                        Collections.swap(mDatas, i, i + 1);
                    }
                } else if (from > to) {
                    for (int i = from; i > to; i--) {
                        Collections.swap(mDatas, i, i - 1);
                    }
                }
                mDatas.set(to, temp);
                mAdapter.notifyDataSetChanged();
            }
        });*/
//        mAdapter.notifyDataSetChanged();
        scroller.setScrollState(new ControlScrollView.ScrollState() {
            @Override
            public void stopTouch() {
                grid.stopDrag();
            }

            @Override
            public void isCanDrag(boolean isCanDrag) {
                grid.setCanDrag(isCanDrag);
            }
        });

        grid.setOnDragStartListener(new DragGridView.OnDragStartListener() {
            @Override
            public void onDragStart() {
                scroller.requestDisallowInterceptTouchEvent(true);
                scroller.setInControl(false);
            }
        });
        grid.setOnDragEndListener(new DragGridView.OnDragEndListener() {
            @Override
            public void onDragEnd() {
                scroller.requestDisallowInterceptTouchEvent(false);
                scroller.setInControl(true);
                grid.postInvalidate();
            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent rainfall_intent = new Intent(getContext(), RainFallDataActivity.class);
                        startActivity(rainfall_intent);
                        break;
                    case 1:
                        Intent weather_intent = new Intent(getContext(), WeatherDateActivity.class);
                        startActivity(weather_intent);
                        break;
                    case 2:
                        Intent sluice_intent = new Intent(getContext(), SluiceControlActivity.class);
                        startActivity(sluice_intent);
                        break;
                    case 3:
                        Intent monitor_intent = new Intent(getContext(), MonitorActivity.class);
                        startActivity(monitor_intent);
                        break;
                    case 4:
                        Intent irrigate_intent = new Intent(getContext(), IrrigateCountActivity.class);
                        startActivity(irrigate_intent);
                        break;
                    case 5:
                        Intent pay_intent = new Intent(getContext(), PayActivity.class);
                        startActivity(pay_intent);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void initBanner(View layout) {
        TypedArray images = this.getResources().obtainTypedArray(R.array.banner_images);
        Integer[] resIds = new Integer[images.length()];
        for (int i = 0; i < images.length(); i++) {
            resIds[i] = images.getResourceId(i, 0);
        }
        images.recycle();
        String[] titles = this.getResources().getStringArray(R.array.title);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerTitles(Arrays.asList(titles));
        banner.setImages(Arrays.asList(resIds)).setImageLoader(new GlideImageLoader());
        banner.start();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);

    }

    @Override
    protected int getlayoutId() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void lazyLoadData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    class GlideImageLoader implements ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    class HomeGirdViewAdapter extends BaseAdapter{

        private DragGridView grid;
        private LayoutInflater mInflater;
        private Context mContext;
        private ArrayList<GridCutItem> mDatas;

        public HomeGirdViewAdapter(Context context, ArrayList<GridCutItem> data,DragGridView grid) {
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
                    (grid.getHeight()-(AppUtils.Dp2Px(mContext,4)))/2);
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_home_grid, null, false);

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
