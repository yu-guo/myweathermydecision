package com.myweathermydecision.app.model;

public class County {
	
	private int id;
	private String countyName;
	private String countyCode;
	private int cityID;
	
	public County() {
		super();
	}
	
	public County(int id, String countyName, String countyCode, int cityID) {
		super();
		this.id = id;
		this.countyName = countyName;
		this.countyCode = countyCode;
		this.cityID = cityID;
	}
	
	@Override
	public String toString() {
		return "County [id=" + id + ", countyName=" + countyName
				+ ", countyCode=" + countyCode + ", cityID=" + cityID + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	
	
	

}
