package com.member.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.utils.HotelUtil;
import com.member.hotel.service.HotelBasicsService;

@Service("hotelBasicsService")
@Transactional
public class HotelBasicsServiceImpl extends BaseManagerImpl implements HotelBasicsService {

	@Value("${agent.id}")
	private String agent_id;
	@Value("${agent.md}")
	private String agent_md;
	@EsbServiceMapping
	public List<JsonNode> getCities() {
		List<JsonNode> resultList  = new ArrayList<JsonNode>();
		String result = "";
		Map<String,Object> params = new HashMap();
	    params.put("method", "city");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    try {
	        result = HotelUtil.net(HotelUtil.url1, params, "GET");
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode resultJson = objectMapper.readTree(result);
	        JsonNode list = resultJson.get("reqdata");
	        if (list.isArray()&&resultJson.get("retmsg").asText().equals("1")) {
	        	for (Iterator it = list.elements(); it.hasNext(); ){
        	        JsonNode avator = (JsonNode) it.next();
        	        resultList.add(avator);
        	    }
			}
	      }
	      catch (Exception e) {
	    	  System.out.println("查询城市列表 请求出现异常:" + e);
	    	  e.printStackTrace();	        
	      }
	      return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getCities(int px) {
		List<JsonNode> resultList  = new ArrayList<JsonNode>();
		String result = "";
		Map<String,Object> params = new HashMap();
	    params.put("method", "city");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("px", px);
	    try {
	        result = HotelUtil.net(HotelUtil.url1, params, "GET");
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode resultJson = objectMapper.readTree(result);
	        JsonNode list = resultJson.get("reqdata");
	        if (resultJson.get("retmsg").asText().equals("1") && list.isArray()) {
	        	for (Iterator it = list.elements(); it.hasNext(); ){
        	        JsonNode avator = (JsonNode) it.next();
        	        resultList.add(avator);
        	    }
			}
	      }
	      catch (Exception e) {
	    	  System.out.println("查询城市列表 请求出现异常:" + e);
	    	  e.printStackTrace();	        
	      }
	      return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getCityArea(String cityId) {
		List<JsonNode> resultList  = new ArrayList<JsonNode>();
		String result = "";
	    Map<String,Object> params = new HashMap();
	    params.put("method", "cityarea");
	    params.put("agent_id", agent_id);
	    params.put("agent_md",agent_md);
	    params.put("cityid",cityId);
	    try {
	        result = HotelUtil.net(HotelUtil.url1, params, "GET");
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode resultJson = objectMapper.readTree(result);
	        JsonNode list = resultJson.get("reqdata");
	        if (resultJson.get("retmsg").asText().equals("1") && list.isArray()) {
	        	for (Iterator it = list.elements(); it.hasNext(); ){
        	        JsonNode avator = (JsonNode) it.next();
        	        resultList.add(avator);
        	    }
			}
	      } catch (Exception e) {
	      System.out.println("查询行政区 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getCityCbd(String cityId) {
		List<JsonNode> resultList  = new ArrayList<JsonNode>();
		String result = "";
		Map<String,Object> params = new HashMap();
	    params.put("method", "cbd");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("cityid",cityId);
	    try {
	        result = HotelUtil.net(HotelUtil.url1, params, "GET");
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode resultJson = objectMapper.readTree(result);
	        JsonNode list = resultJson.get("reqdata");
	        if (resultJson.get("retmsg").asText().equals("1")&&list.isArray()) {
	        	for (Iterator it = list.elements(); it.hasNext(); ){
        	        JsonNode avator = (JsonNode) it.next();
        	        resultList.add(avator);
        	    }
			}
	      } catch (Exception e) {
	      System.out.println("查询商圈 请求出现异常！" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> searchNearby(String cityId, Double lng, Double lat) {
		List<JsonNode> resultList  = new ArrayList<JsonNode>();
		String result = "";
		Map<String,Object> params = new HashMap();
	    params.put("method", "lable.search.nearby");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("cityid",cityId);
	    params.put("lng",lng);
	    params.put("lat",lat);
	    params.put("nums","10");
	    try {
	      result = HotelUtil.net(HotelUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode list = resultJson.get("reqdata");
			if (resultJson.get("retmsg").asText().equals("1") && list.isArray()) {
				for (Iterator it = list.elements(); it.hasNext();) {
					JsonNode avator = (JsonNode) it.next();
					resultList.add(avator);
				}
			}
	      
	    } catch (Exception e) {
	      System.out.println("查询商圈 请求出现异常！" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

}
