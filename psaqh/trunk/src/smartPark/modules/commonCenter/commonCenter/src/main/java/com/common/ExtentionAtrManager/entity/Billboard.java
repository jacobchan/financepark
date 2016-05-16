package com.common.ExtentionAtrManager.entity;

public class Billboard {
	private String size;
	
	private String unit;
	
	private String loopType;
	
	private String adr;
	
	
	public String getSizefieldName() {
		return "size";
	}
	
	public String getUnitfieldName() {
		return "unit";
	}
	
	public String getLoopTypefieldName() {
		return "loopType";
	}
	
	public String getAdrfieldName() {
		return "adr";
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLoopType() {
		return loopType;
	}

	public void setLoopType(String loopType) {
		this.loopType = loopType;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	
}
