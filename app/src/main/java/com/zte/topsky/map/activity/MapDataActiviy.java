package com.zte.topsky.map.activity;

import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.zte.topsky.R;
import com.zte.topsky.base.activity.BaseActivity;
import com.zte.topsky.map.net.MapNet;

import butterknife.BindView;

/**
 * Created by NobShiny
 * on 2016/11/23 10:48.
 */

public class MapDataActiviy extends BaseActivity {

    @BindView(R.id.map_main)
    MapView mMapView;
    private AMap aMap;
    private static CameraPosition mCamerPosition;
    private UiSettings mUiSettings;
    private SupportMapFragment aMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_map_data);
        addActivity(this);
        mMapView.onCreate(savedInstanceState);
        initView();
    }

    private void init() {
//        mCamerPosition = MapNet.getNeedCityPosition(this);
//        AMapOptions aOptions = new AMapOptions();
//        aOptions.camera(mCamerPosition);
//        if (aMapFragment == null) {
//            aMapFragment = SupportMapFragment.newInstance(aOptions);
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
//                    .beginTransaction();
//            fragmentTransaction.add(android.R.id.content, aMapFragment,
//                    "");
//            fragmentTransaction.commit();
//        }

    }

    private void initView() {
        if (mMapView != null) {
            if (aMap == null) {
                aMap = mMapView.getMap();
                aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MapNet.getNeedCityPosition(this),1));
                mUiSettings = aMap.getUiSettings();
                mUiSettings.setScaleControlsEnabled(true);
                mUiSettings.setCompassEnabled(true);
                mUiSettings.setLogoPosition(AMapOptions.LOGO_POSITION_BOTTOM_RIGHT);
                mUiSettings.setZoomPosition(AMapOptions.ZOOM_POSITION_RIGHT_CENTER);

            }
        }
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
}
