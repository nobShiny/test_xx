package com.zte.topsky.map.net;

import android.content.Context;

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.zte.topsky.map.bean.PumpDataBean;
import com.zte.topsky.map.utils.MapUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NobShiny
 * on 2016/11/25 15:25.
 */

public class MapNet {

    private static CameraPosition mCameraPosition;
    private static LatLng latLng;

    public static CameraPosition getNeedCityPosition(Context context){

        //TODO 从网络获取中心城市
        latLng = new LatLng(40.761887,107.393554);//latitude,longitude
        mCameraPosition = new CameraPosition.Builder()
                .target(latLng)//MapUtils.getAMP(context,latLng, CoordinateConverter.CoordType.GOOGLE)
                .zoom(8.6f)
                .bearing(0)
                .tilt(0)
                .build();
        return mCameraPosition;
    }

    public static List<PumpDataBean> getInitPumpDetailedData(Context context){
        List<PumpDataBean> list = new ArrayList<>();
        PumpDataBean test1 = new PumpDataBean(MapUtils.getAMP(context,new LatLng(40.679212,107.343249),
                CoordinateConverter.CoordType.BAIDU),"1#机井","开启","陈明","13901338139","100m","1000mm","500吨");
        PumpDataBean test2 = new PumpDataBean(MapUtils.getAMP(context,new LatLng(40.780245,107.597937),
                CoordinateConverter.CoordType.BAIDU),"2#机井","开启","王浩","13501344330","90m","6500mm","500吨");
        PumpDataBean test3 = new PumpDataBean(MapUtils.getAMP(context,new LatLng(40.737402,107.138579),
                CoordinateConverter.CoordType.BAIDU),"3#机井","关闭","李华","13801241425","60m","200mm","500吨");
        PumpDataBean test4 = new PumpDataBean(MapUtils.getAMP(context,new LatLng(40.832233,107.519748),
                CoordinateConverter.CoordType.BAIDU),"4#机井","开启","张军","13701095623","100m","290mm","500吨");
        PumpDataBean test5 = new PumpDataBean(MapUtils.getAMP(context,new LatLng(40.838346,107.311629),
                CoordinateConverter.CoordType.BAIDU),"5#机井","关闭","李琦","13901191433","120m","370mm","500吨");
//        PumpDataBean test6 = new PumpDataBean(new LatLng(,),"1#机井","开启","陈明","13901338139","100m","1000mm","500吨");
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        return list;
    }

    //监测点5：107.311629,40.838346

    //机井1：
    //机井2：
    //机井3：
    //机井4：
    //机井5：
    //机井6：



}
