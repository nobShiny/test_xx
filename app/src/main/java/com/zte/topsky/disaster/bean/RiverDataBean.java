package com.zte.topsky.disaster.bean;

import com.amap.api.maps.model.LatLng;

/**
 * Created by NobShiny
 * on 2016/12/6 16:33.
 */

public class RiverDataBean {

    private LatLng position;
    private String name;
    private String currentLevel;
    private String alertLevel;
    private String criticalLevel;

    public RiverDataBean(LatLng position, String name, String currentLevel, String alertLevel, String criticalLevel) {
        this.position = position;
        this.name = name;
        this.currentLevel = currentLevel;
        this.alertLevel = alertLevel;
        this.criticalLevel = criticalLevel;
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

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getCriticalLevel() {
        return criticalLevel;
    }

    public void setCriticalLevel(String criticalLevel) {
        this.criticalLevel = criticalLevel;
    }
}
