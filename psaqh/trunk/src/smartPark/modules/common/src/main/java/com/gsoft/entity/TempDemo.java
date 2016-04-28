package com.gsoft.entity;

import java.util.Map;

import com.gsoft.framework.core.dataobj.Domain;

public class TempDemo implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String buff;
	private boolean flag ;
	private Map<String,Object> resMap;
	
	public Map<String, Object> getResMap() {
		return resMap;
	}

	public void setResMap(Map<String, Object> resMap) {
		this.resMap = resMap;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getBuff() {
		return buff;
	}

	public void setBuff(String buff) {
		this.buff = buff;
	}
	
	
}
