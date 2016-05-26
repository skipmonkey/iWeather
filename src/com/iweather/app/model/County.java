package com.iweather.app.model;

public class County {
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;

    public County(int id, String countyName, String countyCode, int cityId) {
        this.id = id;
        this.countyName = countyName;
        this.countyCode = countyCode;
        this.cityId = cityId;
    }

    public int getCountyId() {
        return this.id;
    }

    public String getCountyName() {
        return this.countyName;
    }

    public String getCountyCode() {
        return this.countyCode;
    }

    public int getCityId() {
        return this.cityId;
    }
}