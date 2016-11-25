package com.zte.topsky.map.utils;

import android.content.Context;

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;

/**
 * Created by NobShiny
 * on 2016/11/25 12:03.
 */

public class MapUtils {

    private static CoordinateConverter converter;

    /**
     * 其他坐标系转到高德坐标系
    */

    public static LatLng getAMP(Context context,LatLng sourceLatLng, CoordinateConverter.CoordType coord){
        converter = new CoordinateConverter(context);
        converter.from(coord);
        converter.coord(sourceLatLng);
        LatLng desLatLng = converter.convert();
        return desLatLng;
    }

}
