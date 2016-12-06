package com.zte.topsky.disaster.bean;

import com.amap.api.maps.model.LatLng;

/**
 * Created by NobShiny
 * on 2016/12/6 16:33.
 */

public class RainDataBean {

    private LatLng position;
    private String name;
    private String area;
    private String volume;

    public RainDataBean(LatLng position, String name, String area, String volume) {
        this.position = position;
        this.name = name;
        this.area = area;
        this.volume = volume;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
