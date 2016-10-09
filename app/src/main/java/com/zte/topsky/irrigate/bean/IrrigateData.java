package com.zte.topsky.irrigate.bean;

/**
 * Created by NobShiny
 * on 2016/10/9 10:22.
 */

public class IrrigateData {

    public String IrrigateDateTime;
    public String IrrigationVolume;

    public IrrigateData(String irrigateDateTime, String irrigationVolume) {
        IrrigateDateTime = irrigateDateTime;
        IrrigationVolume = irrigationVolume;
    }

    public String getIrrigateDateTime() {
        return IrrigateDateTime;
    }

    public void setIrrigateDateTime(String irrigateDateTime) {
        IrrigateDateTime = irrigateDateTime;
    }

    public String getIrrigationVolume() {
        return IrrigationVolume;
    }

    public void setIrrigationVolume(String irrigationVolume) {
        IrrigationVolume = irrigationVolume;
    }
}
