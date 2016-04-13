package com.common.ExtentionAtrManager.entity;

public class CarOrderEntity {
	private String publicResoIdDate;
	private String publicResoId;
	
	
	public String getPublicResoIdDatefieldName() {
		return "publicResoIdDate";
	}
	public String getPublicResoIdfieldName() {
		return "publicResoId";
	}
	
	public String getPublicResoIdDate() {
		return publicResoIdDate;
	}
	public void setPublicResoIdDate(String publicResoIdDate) {
		this.publicResoIdDate = publicResoIdDate;
	}
	public String getPublicResoId() {
		return publicResoId;
	}
	public void setPublicResoId(String publicResoId) {
		this.publicResoId = publicResoId;
	}
}
