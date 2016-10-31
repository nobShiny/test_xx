package com.zte.topsky.weatherdata.bean;

/**
 * Created by NobShiny
 * on 2016/10/31 12:09.
 */

public class DataSummy {
    private String time;
    private String soil;
    private String relative;

    public DataSummy(String time, String soil, String relative) {
        this.time = time;
        this.soil = soil;
        this.relative = relative;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }
}
