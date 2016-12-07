package com.zte.topsky.disaster.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.disaster.adapter.ReservoirListAdapter;
import com.zte.topsky.disaster.bean.ReservoirDataBean;
import com.zte.topsky.disaster.net.DisasterMapNet;
import com.zte.topsky.map.net.MapNet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NobShiny
 * on 2016/12/2 16:07.
 */
public class ReservoirActivity extends BaseActivity implements AMap.OnMarkerClickListener,AMap.OnMapClickListener{

    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    @BindView(R.id.tv_reservoir_list)
    TextView tvReservoirList;
    @BindView(R.id.iv_reservoir_list_indicator)
    ImageView ivReservoirListIndicator;
    @BindView(R.id.ll_reservoir_list)
    LinearLayout llReservoirList;
    @BindView(R.id.map_content)
    FrameLayout mapContent;

    private MapView mMapView;
    private AMap aMap;
    private UiSettings mUiSettings;
    private DialogPlus dialog;
    private MarkerOptions markerOption;
    private List<ReservoirDataBean> mData;
    private ReservoirListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_disaster_reservoir);
        addActivity(this);
        tvTitleText.setText("水库水情");
    }

    private void initData() {
        mData = DisasterMapNet.getInitReservoirDetailedData(getApplicationContext());
    }

    private void setUpMap(Bundle savedInstanceState) {
        AMapOptions aOptions = new AMapOptions();
        aOptions.camera(MapNet.getNeedCityPosition(this));
        mMapView = new MapView(this, aOptions);
        mMapView.onCreate(savedInstanceState);
        mapContent.addView(mMapView, new RelativeLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        if (aMap == null) {
            aMap = mMapView.getMap();
            aMap.setOnMapClickListener(this);
            aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
            mUiSettings = aMap.getUiSettings();
            mUiSettings.setScaleControlsEnabled(true);
            mUiSettings.setCompassEnabled(true);
            mUiSettings.setLogoPosition(AMapOptions.LOGO_POSITION_BOTTOM_RIGHT);
            mUiSettings.setZoomPosition(AMapOptions.ZOOM_POSITION_RIGHT_BUTTOM);
            // 设置点击marker事件监听器
            aMap.setOnMarkerClickListener(this);
            addMarkersToMap();
        }

    }

    /**
     * 向地图上添加marker
     */
    private void addMarkersToMap() {
        ArrayList<MarkerOptions> markerOptionlst = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            markerOption = new MarkerOptions();
            markerOption.position(mData.get(i).getPosition());
            markerOption.title(mData.get(i).getName());
            markerOption.snippet("当前水位：" + mData.get(i).getCurrentLevel());
            markerOption.draggable(false);
            markerOption.icon(
                    BitmapDescriptorFactory.fromBitmap(BitmapFactory
                            .decodeResource(getResources(),
                                    R.drawable.ic_water_marker))).setFlat(true);
            markerOptionlst.add(markerOption);
        }
        aMap.addMarkers(markerOptionlst, true);
    }

    @OnClick(R.id.ll_reservoir_list)
    public void onClick() {
        listAdapter = new ReservoirListAdapter(this, mData);
        dialog = DialogPlus.newDialog(ReservoirActivity.this)
                .setAdapter(listAdapter)
                .setHeader(R.layout.layout_river_list_header)
                .setGravity(Gravity.BOTTOM)
                .setCancelable(true)
                .setExpanded(true, 800)
                .create();
        dialog.show();
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

}
