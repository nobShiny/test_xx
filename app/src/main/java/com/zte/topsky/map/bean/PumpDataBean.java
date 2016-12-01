package com.zte.topsky.map.bean;

import com.amap.api.maps.model.LatLng;

/**
 * Created by NobShiny
 * on 2016/11/29 10:56.
 */

public class PumpDataBean {

    private LatLng position;
    private String pumpTitle;
    private String state;
    private String administrtor;
    private String phoneNumber;
    private String deep;
    private String size;
    private String sum;

    public PumpDataBean(LatLng position, String pumpTitle, String state, String administrtor,
                        String phoneNumber, String deep, String size, String sum) {
        this.position = position;
        this.pumpTitle = pumpTitle;
        this.state = state;
        this.administrtor = administrtor;
        this.phoneNumber = phoneNumber;
        this.deep = deep;
        this.size = size;
        this.sum = sum;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public String getPumpTitle() {
        return pumpTitle;
    }

    public void setPumpTitle(String pumpTitle) {
        this.pumpTitle = pumpTitle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdministrtor() {
        return administrtor;
    }

    public void setAdministrtor(String administrtor) {
        this.administrtor = administrtor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
