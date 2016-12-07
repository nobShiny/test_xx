package com.zte.topsky.disaster.net;

import android.content.Context;

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.zte.topsky.disaster.bean.RainDataBean;
import com.zte.topsky.disaster.bean.ReservoirDataBean;
import com.zte.topsky.disaster.bean.RiverDataBean;
import com.zte.topsky.map.utils.MapUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NobShiny
 * on 2016/12/6 16:49.
 */

public class DisasterMapNet {

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

    public static List<RainDataBean> getInitRainDetailedData(Context context){
        List<RainDataBean> list = new ArrayList<>();
        RainDataBean test1 = new RainDataBean(MapUtils.getAMP(context,new LatLng(40.444190,107.234390),
                     CoordinateConverter.CoordType.BAIDU),"新华西街","临河区","0.5");
        RainDataBean test2 = new RainDataBean(MapUtils.getAMP(context,new LatLng(40.451261,107.253475),
                     CoordinateConverter.CoordType.BAIDU),"兴隆街","临河区","0.3");
        RainDataBean test3 = new RainDataBean(MapUtils.getAMP(context,new LatLng(40.434717,107.244245),
                     CoordinateConverter.CoordType.BAIDU),"湿地公园","临河区","0");
        RainDataBean test4 = new RainDataBean(MapUtils.getAMP(context,new LatLng(40.20409,107.01625),
                     CoordinateConverter.CoordType.BAIDU),"巴音路","磴口县","0");
        RainDataBean test5 = new RainDataBean(MapUtils.getAMP(context,new LatLng(41.035288,108.17809),
                     CoordinateConverter.CoordType.BAIDU),"荣丰","五原县","0");
        RainDataBean test6 = new RainDataBean(MapUtils.getAMP(context,new LatLng(40.522829,107.094206),
                     CoordinateConverter.CoordType.BAIDU),"生态公园","杭锦后旗","0.2");
        RainDataBean test7 = new RainDataBean(MapUtils.getAMP(context,new LatLng(40.441839,107.381319),
                     CoordinateConverter.CoordType.BAIDU),"乌拉山镇","乌拉特前旗","0");
        RainDataBean test8 = new RainDataBean(MapUtils.getAMP(context,new LatLng(41.342014,108.305153),
                     CoordinateConverter.CoordType.BAIDU),"川井南路","乌拉特中旗","0");
        RainDataBean test9 = new RainDataBean(MapUtils.getAMP(context,new LatLng(41.045681,107.041754),
                     CoordinateConverter.CoordType.BAIDU),"八音宝利格","乌拉特后旗","0");
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test6);
        list.add(test7);
        list.add(test8);
        list.add(test9);

        return list;
    }

    public static List<RiverDataBean> getInitRiverDetailedData(Context context){
        List<RiverDataBean> list = new ArrayList<>();
        RiverDataBean test1 = new RiverDataBean(MapUtils.getAMP(context,new LatLng(41.214951,108.355671),
                     CoordinateConverter.CoordType.BAIDU),"德岭山水库","263.56","6190","270.06","80.43%");
        RiverDataBean test2 = new RiverDataBean(MapUtils.getAMP(context,new LatLng(41.20948,107.303585),
                     CoordinateConverter.CoordType.BAIDU),"狼山水库","118.05","5939","120.19","87.34%");
        RiverDataBean test3 = new RiverDataBean(MapUtils.getAMP(context,new LatLng(41.372720,109.112606),
                     CoordinateConverter.CoordType.BAIDU),"新呼热水库","122.51","4982","126.44","79.71%");
        RiverDataBean test4 = new RiverDataBean(MapUtils.getAMP(context,new LatLng(41.084419,106.294648),
                     CoordinateConverter.CoordType.BAIDU),"哈布其盖水库","135.62","5733","140.00","81.18%");
        RiverDataBean test5 = new RiverDataBean(MapUtils.getAMP(context,new LatLng(41.344170,108.192315),
                     CoordinateConverter.CoordType.BAIDU),"洪高日水库","122.51","2598","142.18","85.80%");
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);

        return list;
    }

    public static List<ReservoirDataBean> getInitReservoirDetailedData(Context context){
        List<ReservoirDataBean> list = new ArrayList<>();
        ReservoirDataBean test1 = new ReservoirDataBean(MapUtils.getAMP(context,new LatLng(41.214951,108.355671),
                     CoordinateConverter.CoordType.BAIDU),"德岭山水库","263.56","6190","270.06","80.43%");
        ReservoirDataBean test2 = new ReservoirDataBean(MapUtils.getAMP(context,new LatLng(41.20948,107.303585),
                     CoordinateConverter.CoordType.BAIDU),"狼山水库","118.05","5939","120.19","87.34%");
        ReservoirDataBean test3 = new ReservoirDataBean(MapUtils.getAMP(context,new LatLng(41.372720,109.112606),
                     CoordinateConverter.CoordType.BAIDU),"新呼热水库","122.51","4982","126.44","79.71%");
        ReservoirDataBean test4 = new ReservoirDataBean(MapUtils.getAMP(context,new LatLng(41.084419,106.294648),
                     CoordinateConverter.CoordType.BAIDU),"哈布其盖水库","135.62","5733","140.00","81.18%");
        ReservoirDataBean test5 = new ReservoirDataBean(MapUtils.getAMP(context,new LatLng(41.344170,108.192315),
                     CoordinateConverter.CoordType.BAIDU),"洪高日水库","122.51","2598","142.18","85.80%");
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);

        return list;
    }
}
