package com.zte.topsky.disaster.bean;

import com.amap.api.maps.model.LatLng;

/**
 * Created by NobShiny
 * on 2016/12/6 16:33.
 */

public class ReservoirDataBean {

    private LatLng position;
    private String name;
    private String currentLevel;
    private String capacity;
    private String restrictLevel;
    private String storageRate;
    private String quality;

    public ReservoirDataBean(LatLng position, String name, String currentLevel, String capacity, String restrictLevel, String storageRate, String quality) {
        this.position = position;
        this.name = name;
        this.currentLevel = currentLevel;
        this.capacity = capacity;
        this.restrictLevel = restrictLevel;
        this.storageRate = storageRate;
        this.quality = quality;
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getRestrictLevel() {
        return restrictLevel;
    }

    public void setRestrictLevel(String restrictLevel) {
        this.restrictLevel = restrictLevel;
    }

    public String getStorageRate() {
        return storageRate;
    }

    public void setStorageRate(String storageRate) {
        this.storageRate = storageRate;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
