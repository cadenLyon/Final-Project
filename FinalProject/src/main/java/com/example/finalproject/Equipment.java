package com.example.finalproject;
/*
Caden Lyon
Computer Science II
4/29/24
 */


public class Equipment {
    private String make;
    private String model;
    private String serial;
    private String asset;
    private String user;
    private String date;
    private String time;
    private String inUse;

    public Equipment(String make, String model, String serial, String asset, String user, String date, String time, String inUse) {
        this.make = make;
        this.model = model;
        this.serial = serial;
        this.asset = asset;
        this.user = user;
        this.date = date;
        this.time = time;
        this.inUse = inUse;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public void toggleInUse() {
        if ("yes".equals(inUse)) {
            inUse = "no";
        } else {
            inUse = "yes";
        }
    }
}
