package com.common.ExtentionAtrManager.entity;

/**
 * 会议室商品扩展属性
 * @author jack
 *
 */
public class MeetingEntity {
	
	private String adr;//dz
	private String gm; //gm
	private String lx; //lx
	private String tyy; //tyy
	
	private String adrName;//地址名称
	
	private String tea; //增值服务：茶水
	
	public String getTea() {
		return tea;
	}

	public void setTea(String tea) {
		this.tea = tea;
	}

	public String getAdrfieldName() {
		return "dz";
	}
	
	public String getGmfieldName() {
		return "gm";
	}
	
	public String getLxfieldName() {
		return "lx";
	}
	
	public String getTyyfieldName() {
		return "tyy";
	}
	
	public String getAdrNamefieldName() {
		return "adrName";
	}
	
	public String getTeafieldName() {
		return "tea";
	}
	
	public String getAdr() {
		return adr;
	}
	
	public String getGm() {
		return gm;
	}
	
	public String getLx() {
		return lx;
	}
	
	public String getTyy() {
		return tyy;
	}
	
	public void setTyy(String tyy) {
		this.tyy = tyy;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public void setGm(String gm) {
		this.gm = gm;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getAdrName() {
		return adrName;
	}

	public void setAdrName(String adrName) {
		this.adrName = adrName;
	}
	
	
}
