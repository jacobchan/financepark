package com.common.ExtentionAtrManager.entity;

public class MeetingOrderEntity {
	private String publicResoIdDate;
	private String publicResoIdTime;
	private String publicResoId;
	private String driver;
	private String tea;
	
	
	public String getPublicResoIdDatefieldName() {
		return "publicResoIdDate";
	}
	public String getPublicResoIdTimefieldName() {
		return "publicResoIdTime";
	}
	public String getPublicResoIdfieldName() {
		return "publicResoId";
	}
	public String getDriverfieldName() {
		return "driver";
	}
	public String getTeafieldName() {
		return "tea";
	}
	
	public String getPublicResoIdDate() {
		return publicResoIdDate;
	}
	public void setPublicResoIdDate(String publicResoIdDate) {
		this.publicResoIdDate = publicResoIdDate;
	}
	public String getPublicResoIdTime() {
		return publicResoIdTime;
	}
	public void setPublicResoIdTime(String publicResoIdTime) {
		this.publicResoIdTime = publicResoIdTime;
	}
	public String getPublicResoId() {
		return publicResoId;
	}
	public void setPublicResoId(String publicResoId) {
		this.publicResoId = publicResoId;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getTea() {
		return tea;
	}
	public void setTea(String tea) {
		this.tea = tea;
	}
	
}
