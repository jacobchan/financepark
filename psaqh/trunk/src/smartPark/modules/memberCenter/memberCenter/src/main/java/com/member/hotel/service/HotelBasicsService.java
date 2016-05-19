package com.member.hotel.service;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.service.BaseManager;

public interface HotelBasicsService extends BaseManager {
	/*
	 * 调用方式 GET
	 * params 参数
	 * agent_id 联盟ID
	 * agent_md 联盟加密字符串
	 * px 排序（3酒店数量4城市名称5拼音） 
	 * cityId 城市ID
	 * lng 经度
	 * lat 纬度
	 */	
	public List<JsonNode> getCities();
	
	public List<JsonNode> getCities(String px);
	/*
	 * 获取城市行政区 
	 */	
	public List<JsonNode> getCityArea(String cityId);
	/*
	 * 获取城市商业区
	 */	
	public List<JsonNode> getCityCbd(String cityId);
	
	public List<JsonNode> searchNearby(String cityId,Double lng,Double lat);
	
	public TempDemo getHotelCaptcha(String phone);
}
