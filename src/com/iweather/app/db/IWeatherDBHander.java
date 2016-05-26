package com.iweather.app.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.iweather.app.model.City;
import com.iweather.app.model.County;
import com.iweather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class IWeatherDBHander {
    /**
     * the name of Db 
     */
    public static final String DB_NAME = "iweather";
    /**
     * the version of Db
     */
    public static final int DB_VERSION = 1;
    public static IWeatherDBHander iWeatherDBHandler;
    private SQLiteDatabase db;
    
    private IWeatherDBHander(Context context) {
        IWeatherDbHelper dbHelper = new IWeatherDbHelper(context, DB_NAME, null, DB_VERSION);
        db = dbHelper.getWritableDatabase();
    }
    
    public synchronized static IWeatherDBHander getInstance(Context context) {
        if (iWeatherDBHandler == null) {
            iWeatherDBHandler = new IWeatherDBHander(context);
        }
        return iWeatherDBHandler;
    }
    
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProviceName());
            values.put("province_code", province.getProviceCode());
            db.insert("province", null, values);
        }
    }
    
    public List<Province> loadProvinces() {
        List<Province> provinceList = new ArrayList<Province>();
        Cursor cursor =null;
        if (db != null) {
            try {
                cursor = db.query("province", null, null, null,null, null, null);
                if (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String provinceName = cursor.getString(cursor.getColumnIndex("province_name"));
                    String proviceCode = cursor.getString(cursor.getColumnIndex("province_code"));
                    Province province = new Province(id, provinceName, proviceCode);
                    provinceList.add(province);
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return provinceList;
    }
    
    public void saveCities(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_code", city.getCityCode());
            values.put("province_id", city.getProvinceId());
            db.insert("city", null, values);
        }
    }
    
    public List<City> loadCities() {
        List<City> cityList = new ArrayList<City>();
        Cursor cursor =null;
        if (db != null) {
            try {
                cursor = db.query("city", null, null, null,null, null, null);
                if (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String cityName = cursor.getString(cursor.getColumnIndex("city_name"));
                    String cityCode = cursor.getString(cursor.getColumnIndex("city_code"));
                    int provinceId = cursor.getInt(cursor.getColumnIndex("province_id"));
                    City city = new City(id, cityName, cityCode, provinceId);
                    cityList.add(city);
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return cityList;
    }
    
    public void saveCounties(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_code", county.getCountyCode());
            values.put("city_id", county.getCityId());
            db.insert("county", null, values);
        }
    }
    
    public List<County> loadCounties() {
        List<County> countyList = new ArrayList<County>();
        Cursor cursor =null;
        if (db != null) {
            try {
                cursor = db.query("county", null, null, null,null, null, null);
                if (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String countyName = cursor.getString(cursor.getColumnIndex("county_name"));
                    String countyCode = cursor.getString(cursor.getColumnIndex("county_code"));
                    int cityId = cursor.getInt(cursor.getColumnIndex("city_id"));
                    County county = new County(id, countyName, countyCode, cityId);
                    countyList.add(county);
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return countyList;
    }
}