package com.zte.topsky.pay.bean;

/**
 * Created by NobShiny
 * on 2016/10/27 15:45.
 */

public class PaymentWay {
    private String name;
    private boolean isCheck;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
