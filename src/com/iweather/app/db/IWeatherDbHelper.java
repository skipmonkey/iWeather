package com.iweather.app.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class IWeatherDbHelper extends SQLiteOpenHelper {

    public static final String CREATE_PROVINCE_TABLE = "create table province ("
            + "id integer primary key autoincrement, "
            + "province_name text, "
            + "province_code text)";
    public static final String CREATE_CITY_TABLE = "create table city ("
            + "id integer primary key autoincrement, "
            + "city_name text, "
            + "city_code text, "
            + "province_id integer)";
    public static final String CREATE_COUNTY_TABLE = "create table county ("
            + "id integer primary key autoincrement, "
            + "county_name text, "
            + "county_code text, "
            + "city_id integer)";
    
    public IWeatherDbHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE_TABLE);
        db.execSQL(CREATE_CITY_TABLE);
        db.execSQL(CREATE_CITY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }
    
}