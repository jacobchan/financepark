package com.member.hotel.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpGetAndPostUtil;
import com.member.hotel.entity.HotelOrderConditions;
import com.member.hotel.service.HotelOrderService;


@Service("hotelOrderService")
@Transactional
public class HotelOrderServiceImpl extends BaseManagerImpl implements HotelOrderService {
	@Value("${agent.id}")
	private String agent_id;
	@Value("${agent.md}")
	private String agent_md;

	@Override
	public List<JsonNode> getOrderList(String dateandtime) {
	    String result = "";
	    List<JsonNode> resultList = new ArrayList<JsonNode>();
	    boolean a = false;
	    Map<String,Object> params = new HashMap();
	    params.put("method", "order");
	    params.put("dateandtime", dateandtime);
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    try {
			result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode resultJson = objectMapper.readTree(result);
			JsonNode reqdata = resultJson.get("reqdata");
			if (resultJson.get("retmsg").asText().equals("1")) {
				for (Iterator it = reqdata.elements(); it.hasNext();) {
					JsonNode avator = (JsonNode) it.next();
					resultList.add(avator);
				}
			}
	    } catch (Exception e) {
	    	throw new BusException("获取订单失败："+e.getMessage());
	    	//return "";
	    }
	    return resultList;
	  }

	@Override
	public String getOrderInfo(int orderid) {
	    String result = "";
	    boolean a = false;
	    Map<String,Object> params = new HashMap();
	    params.put("method", "order.info");
	    params.put("orderid", orderid);
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    try {
			result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode resultJson = objectMapper.readTree(result);
	    } catch (Exception e) {
	    	throw new BusException("获取订单详情失败："+e.getMessage());
	    	//return "";
	    }
	    return result;
	  }

	@EsbServiceMapping
	public List<JsonNode> postBook(HotelOrderConditions hotelOrderConditions) {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    try {//遍历实体类的所有属性，并取值判断
	    	Field[] fields = hotelOrderConditions.getClass().getDeclaredFields();
		    for(int j=0 ; j<fields.length ; j++){     //遍历所有属性
		    	 String name1 = fields[j].getName();
		    	 String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
	             String type = fields[j].getGenericType().toString();    //获取属性的类型
	             if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
	                 Method m = hotelOrderConditions.getClass().getMethod("get"+name2);
	                 String value = (String) m.invoke(hotelOrderConditions);    //调用getter方法获取属性值
	                 if(value != null){
	                	 params.put(name1, value);
	                 }
	             }
		    }
		    String orderNumber = BizCodeUtil.getInstance().getBizCodeDate("JD");
		    params.put("guid", orderNumber);//UUID.fromString(orderNumber).toString()
		} catch (Exception e) {
			System.out.println("获取HotelOrderConditions实体类属性 异常:" + e);
		    throw new BusException("获取HotelOrderConditions实体类属性 异常: "+e.getMessage());
		}
	    try {
			result = HttpGetAndPostUtil.HotelSendPost(HttpGetAndPostUtil.url2, params);
			ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode resultJson = objectMapper.readTree(result);
		    //Map<String, Object> resultMap = objectMapper.convertValue(resultJson, Map.class);
		    resultList.add(resultJson);
		    System.out.println("result:" + resultJson.get("error")+"   orderId:" + resultJson.get("orderid"));
		    return resultList;
		} catch (Exception e) {
			throw new BusException("提交订单失败："+e.getMessage());
		}
	}

	@Override
	public String cancelOrder(int orderid) {
	    String result = "";
	    boolean a = false;
	    Map<String,Object> params = new HashMap();
	    params.put("method", "order.cancel");
	    params.put("orderid", orderid);
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    try {
			result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode resultJson = objectMapper.readTree(result);
	    } catch (Exception e) {
	    	throw new BusException("取消订单失败："+e.getMessage());
	    	//return "";
	    }
	    return "1";
	  }

}
