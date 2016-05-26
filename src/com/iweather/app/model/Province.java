package com.iweather.app.model;

public class Province {
    private int id;
    private String proviceName;
    private String proviceCode;

    public Province(int id, String proviceName, String proviceCode) {
        this.id = id;
        this.proviceName = proviceName;
        this.proviceCode = proviceCode;
    }

    public int getProviceId() {
        return this.id;
    }

    public String getProviceName() {
        return this.proviceName;
    }

    public String getProviceCode() {
        return this.proviceCode;
    }
}