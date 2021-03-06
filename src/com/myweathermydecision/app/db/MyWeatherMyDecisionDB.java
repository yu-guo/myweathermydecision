package com.myweathermydecision.app.db;

import java.util.ArrayList;
import java.util.List;

import com.myweathermydecision.app.model.City;
import com.myweathermydecision.app.model.County;
import com.myweathermydecision.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyWeatherMyDecisionDB {
	
	/**
	 * 数据库名
	 */
	public static final String DB_NAME = "MyWeatherMyDecision";
	/**
	 * 数据库的版本号
	 */
	public static final int VERSION = 1;
	
	private static MyWeatherMyDecisionDB myWeatherMyDecisionDB;

	private SQLiteDatabase db;
	
	/**
	 * 将构造方法私有化
	 * @param context
	 */
	private MyWeatherMyDecisionDB(Context context){
		MyWeatherMyDecisionOpenHelper dbHelper = new MyWeatherMyDecisionOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/**
	 * 获取MyWeatherMyDecisionDB的实例，保证全局范围内只会有一个MyWeatherMyDecisionDB实例
	 * @param context
	 * @return MyWeatherMyDecisionDB
	 */
	public synchronized static MyWeatherMyDecisionDB getIntance(Context context){
		if(myWeatherMyDecisionDB == null){
			myWeatherMyDecisionDB = new MyWeatherMyDecisionDB(context);
		}
		return myWeatherMyDecisionDB;
	}
	
	/**
	 * 将Province实例存储到数据库中
	 * @param province
	 */
	public void saveProvince(Province province){
		if(province != null){
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}
	
	/**
	 * 从数据库中读取全国所有的省份信息
	 * @return List<Province>
	 */
	public List<Province> loadProvice(){
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			Province province = new Province();
			province.setId(cursor.getInt(cursor.getColumnIndex("id")));
			province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
			province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
			list.add(province);
		}
		if(cursor != null){
			cursor.close();
		}
		return list;
	}

	
	/**
	 * 将City实例存储到数据库中
	 * @param city
	 */
	public void saveCity(City city){
		if(city != null){
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}
	}
	
	/**
	 * 从数据库读取某省下所有的城市信息
	 * @return List<City>
	 */
	public List<City> loadCity(){
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			City city = new City();
			city.setId(cursor.getInt(cursor.getColumnIndex("id")));
			city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
			city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
			city.setProvinceId(cursor.getInt(cursor.getColumnIndex("province_id")));
			list.add(city);
		}
		if(cursor != null){
			cursor.close();
		}
		return list;
	}
	
	/**
	 * 将County实例存储到数据库中
	 * @param county
	 */
	public void saveCounty(County county){
		if(county != null ){
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCountyName());
			values.put("county_code", county.getCountyCode());
			values.put("city_id", county.getCityID());
			db.insert("County", null, values);
		}
	}
	
	/**
	 * 从数据库中读取某城市下所有县的信息
	 * @return List<County>
	 */
	public List<County> loadCounty(){
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query("County", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			County county = new County();
			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
			county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
			county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
			county.setCityID(cursor.getInt(cursor.getColumnIndex("city_id")));
			list.add(county);
		}
		if(cursor != null){
			cursor.close();
		}
		return list;
	}
}
