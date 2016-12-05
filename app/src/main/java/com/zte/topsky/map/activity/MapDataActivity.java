package com.zte.topsky.map.activity;

import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.MapView;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.map.bean.PumpDataBean;
import com.zte.topsky.map.net.MapNet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/11/23 10:48.
 */

public class MapDataActivity extends BaseActivity implements AMap.OnMarkerClickListener,
        AMap.InfoWindowAdapter, AMap.OnMapClickListener, AMap.OnInfoWindowClickListener {

    @BindView(R.id.map_content)
    FrameLayout mContainerLayout;
    @BindView(R.id.tv_title_text)
    TextView tvTitleText;
    private MapView mMapView;
    private AMap aMap;
    private UiSettings mUiSettings;
    private List<PumpDataBean> mPump;
    private MarkerOptions markerOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_map_data);
        addActivity(this);
        tvTitleText.setText("工情地图");
        AMapOptions aOptions = new AMapOptions();
        aOptions.camera(MapNet.getNeedCityPosition(this));
        mMapView = new MapView(this, aOptions);
        mMapView.onCreate(savedInstanceState);
        mContainerLayout.addView(mMapView, new RelativeLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        init();
    }

    private void init() {
        if (aMap == null) {
            aMap = mMapView.getMap();
            aMap.setOnMapClickListener(this);
            aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
            mUiSettings = aMap.getUiSettings();
            mUiSettings.setScaleControlsEnabled(true);
            mUiSettings.setCompassEnabled(true);
            mUiSettings.setLogoPosition(AMapOptions.LOGO_POSITION_BOTTOM_RIGHT);
            mUiSettings.setZoomPosition(AMapOptions.ZOOM_POSITION_RIGHT_BUTTOM);
            setUpMap();
        }
    }

    private void setUpMap() {
        initData();
        aMap.setOnMarkerClickListener(this);// 设置点击marker事件监听器
        aMap.setOnInfoWindowClickListener(this);// 设置点击infoWindow事件监听器
        aMap.setInfoWindowAdapter(this);
        addMarkersToMap();
    }

    /**
     * 向地图上添加marker
     */
    private void addMarkersToMap() {
        ArrayList<MarkerOptions> markerOptionlst = new ArrayList<>();
        for (int i = 0; i < mPump.size(); i++) {
            markerOption = new MarkerOptions();
            markerOption.position(mPump.get(i).getPosition());
            markerOption.title(mPump.get(i).getPumpTitle());
            markerOption.draggable(false);
            markerOption.icon(
                    BitmapDescriptorFactory.fromBitmap(BitmapFactory
                            .decodeResource(getResources(),
                                    R.drawable.location_marker))).setFlat(true);
            markerOptionlst.add(markerOption);
        }
        aMap.addMarkers(markerOptionlst, true);
    }

    private void initData() {
        mPump = MapNet.getInitPumpDetailedData(getApplicationContext());
    }

    /**
     * marker点击时跳动动画
     */
    public void jumpPoint(final Marker marker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = aMap.getProjection();
        final LatLng markerLatlng = marker.getPosition();
        Point markerPoint = proj.toScreenLocation(markerLatlng);
        markerPoint.offset(0, -100);
        final LatLng startLatLng = proj.fromScreenLocation(markerPoint);
        final long duration = 1500;

        final Interpolator interpolator = new BounceInterpolator();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed
                        / duration);
                double lng = t * markerLatlng.longitude + (1 - t)
                        * startLatLng.longitude;
                double lat = t * markerLatlng.latitude + (1 - t)
                        * startLatLng.latitude;
                marker.setPosition(new LatLng(lat, lng));
                if (t < 1.0) {
                    handler.postDelayed(this, 16);
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        if (aMap != null) {
            jumpPoint(marker);
        }

        return false;
    }

    private void render(Marker marker, View infoWindowView, PumpDataBean data) {
        TextView name = (TextView) infoWindowView.findViewById(R.id.tv_map_window_name);
        if (!data.getPumpTitle().isEmpty()) {
            name.setText(data.getPumpTitle());
        } else {
            name.setText("");
        }

        TextView admin = (TextView) infoWindowView.findViewById(R.id.tv_map_window_administrator);
        if (!data.getAdministrtor().isEmpty()) {
            admin.setText(data.getAdministrtor());
        } else {
            admin.setText("");
        }

        TextView phone = (TextView) infoWindowView.findViewById(R.id.tv_map_window_phone_number);
        if (!data.getPhoneNumber().isEmpty()) {
            phone.setText(data.getPhoneNumber());
        } else {
            phone.setText("");
        }

        TextView state = (TextView) infoWindowView.findViewById(R.id.tv_map_window_state);
        if (!data.getState().isEmpty()) {
            state.setText(data.getState());
        } else {
            state.setText("");
        }

        TextView deep = (TextView) infoWindowView.findViewById(R.id.tv_map_window_deep);
        if (!data.getDeep().isEmpty()) {
            deep.setText(data.getDeep());
        } else {
            deep.setText("");
        }

        TextView num = (TextView) infoWindowView.findViewById(R.id.tv_map_window_sum);
        if (!data.getSum().isEmpty()) {
            num.setText(data.getSum());
        } else {
            num.setText("");
        }

        TextView size = (TextView) infoWindowView.findViewById(R.id.tv_map_window_size);
        if (!data.getSize().isEmpty()) {
            size.setText(data.getSize());
        } else {
            size.setText("");
        }

    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindow = getLayoutInflater().inflate(
                R.layout.layout_map_datail, null);
        for (int i = 0; i < mPump.size(); i++) {
            if (marker.getTitle().equals(mPump.get(i).getPumpTitle())) {
                render(marker, infoWindow, mPump.get(i));
            }
        }

        return infoWindow;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (aMap != null) {
            aMap.clear();
            addMarkersToMap();
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (aMap != null) {
            aMap.clear();
            addMarkersToMap();
        }
    }
}
