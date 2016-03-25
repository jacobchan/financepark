package com.common.ExtentionAtrManager.entity;

/**
 * 车辆商品扩展属性
 * @author jack
 *
 */
public class CarEntity {
	
	private String dw;//车辆档位
	private String zw; //车辆座位
	private String chepai; //车牌
	
	public String getDwfieldName() {
		return "dw";
	}
	
	public String getZwfieldName() {
		return "zw";
	}
	
	public String getCpfieldName() {
		return "chepai";
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getChepai() {
		return chepai;
	}

	public void setChepai(String chepai) {
		this.chepai = chepai;
	}
	
	
}
