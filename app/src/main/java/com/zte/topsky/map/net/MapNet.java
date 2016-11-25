package com.zte.topsky.map.net;

import android.content.Context;

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.zte.topsky.map.utils.MapUtils;

/**
 * Created by NobShiny
 * on 2016/11/25 15:25.
 */

public class MapNet {

    private static CameraPosition mCameraPosition;
    private static LatLng latLng;

    public static LatLng getNeedCityPosition(Context context){

        //TODO 从网络获取中心城市
        latLng = new LatLng(40.761887,107.393554);//latitude,longitude
//        mCameraPosition = new CameraPosition.Builder()
//                .target()
//                .zoom(1)
//                .bearing(0)
//                .tilt(0)
//                .build();
        return MapUtils.getAMP(context,latLng, CoordinateConverter.CoordType.BAIDU);
    }

    //监测点1：107.343249,40.679212
    //监测点2：107.597937,40.780245
    //监测点3：107.138579,40.737402
    //监测点4：107.519748,40.832233
    //监测点5：107.311629,40.838346

    //机井1：
    //机井2：
    //机井3：
    //机井4：
    //机井5：
    //机井6：



}
