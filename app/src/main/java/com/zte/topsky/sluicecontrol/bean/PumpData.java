package com.zte.topsky.sluicecontrol.bean;


/**
 * Created by NobShiny
 * on 2016/9/27 10:54.
 */

public class PumpData {
    public String pumpDes;
    public String runState;
    public String runFlow;
    public String runSpeed;
    public String runTime;
    public boolean runSwitch;

    public String getPumpDes() {
        return pumpDes;
    }

    public void setPumpDes(String pumpDes) {
        this.pumpDes = pumpDes;
    }

    public String getRunState() {
        return runState;
    }

    public void setRunState(String runState) {
        this.runState = runState;
    }

    public String getRunFlow() {
        return runFlow;
    }

    public void setRunFlow(String runFlow) {
        this.runFlow = runFlow;
    }

    public String getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(String runSpeed) {
        this.runSpeed = runSpeed;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public boolean isRunSwitch() {
        return runSwitch;
    }

    public void setRunSwitch(boolean runSwitch) {
        this.runSwitch = runSwitch;
    }
}
