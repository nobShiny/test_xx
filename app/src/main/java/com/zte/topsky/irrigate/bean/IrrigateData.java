package com.zte.topsky.irrigate.bean;

/**
 * Created by NobShiny
 * on 2016/10/9 10:22.
 */

public class IrrigateData {

    public String IrrigateDataName;
    public int IrrigateDataCount;
    public int IrrigateDataLast;
    public int IrrigateDataCumulation;
    public int IrrigationSum;

    public IrrigateData(String irrigateDataName, int irrigateDataCount, int irrigateDataLast, int irrigateDataCumulation, int irrigationSum) {
        IrrigateDataName = irrigateDataName;
        IrrigateDataCount = irrigateDataCount;
        IrrigateDataLast = irrigateDataLast;
        IrrigateDataCumulation = irrigateDataCumulation;
        IrrigationSum = irrigationSum;
    }

    public String getIrrigateDataName() {
        return IrrigateDataName;
    }

    public void setIrrigateDataName(String irrigateDataName) {
        IrrigateDataName = irrigateDataName;
    }

    public int getIrrigateDataCount() {
        return IrrigateDataCount;
    }

    public void setIrrigateDataCount(int irrigateDataCount) {
        IrrigateDataCount = irrigateDataCount;
    }

    public int getIrrigateDataLast() {
        return IrrigateDataLast;
    }

    public void setIrrigateDataLast(int irrigateDataLast) {
        IrrigateDataLast = irrigateDataLast;
    }

    public int getIrrigateDataCumulation() {
        return IrrigateDataCumulation;
    }

    public void setIrrigateDataCumulation(int irrigateDataCumulation) {
        IrrigateDataCumulation = irrigateDataCumulation;
    }

    public int getIrrigationSum() {
        return IrrigationSum;
    }

    public void setIrrigationSum(int irrigationSum) {
        IrrigationSum = irrigationSum;
    }
}
