package com.iweather.app.model;

public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public City(int id, String cityName, String cityCode, int provinceId) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return this.id;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public int getProvinceId() {
        return this.provinceId;
    }
}