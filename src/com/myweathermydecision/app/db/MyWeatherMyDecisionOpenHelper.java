package com.myweathermydecision.app.db;

import com.myweathermydecision.app.util.MyLogUtil;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyWeatherMyDecisionOpenHelper extends SQLiteOpenHelper {

	/**
	 * Province��Ľ������
	 */
	public static final String CREATE_PROVINCE = "create table Province(" 
			+ "id integer primary key autoincrement,province_name text,province_code text)";
	

	/**
	 * City��Ľ������
	 */
	public static final String CREATE_CITY = "create table City(" 
			+ "id integer primary key autoincrement,city_name text,city_code text,province_id integer)";
	

	/**
	 * County��Ľ������
	 */
	public static final String CREATE_COUNTY = "create table County(" 
			+ "id integer primary key autoincrement,county_name text,county_code text,city_id integer)";


	private static final String TAG = "MyWeatherMyDecisionOpenHelper";
	
	private Context myContext;

	public MyWeatherMyDecisionOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		myContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);//����ʡ�ݣ�Province����
		MyLogUtil.d(TAG, "ʡ�ݣ�Province�������ɹ�");
		db.execSQL(CREATE_CITY);    //�������У�City����
		MyLogUtil.d(TAG, "���У�City�������ɹ�");
		db.execSQL(CREATE_COUNTY);  //�����أ�County����
		MyLogUtil.d(TAG, "�أ�County�������ɹ�");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
