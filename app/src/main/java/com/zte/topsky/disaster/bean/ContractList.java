package com.zte.topsky.disaster.bean;

/**
 * Created by NobShiny
 * on 2016/12/5 15:53.
 */

public class ContractList {
     private String name;
     private String phoneNumber;
     private String duties;

    public ContractList(String name, String phoneNumber, String duties) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.duties = duties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }
}
