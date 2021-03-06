package com.member.hotel.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MessageCenter.service.McMsgdatasManager;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpGetAndPostUtil;
import com.member.hotel.dao.HotelOrderDao;
import com.member.hotel.dao.HotelOrderItemDao;
import com.member.hotel.entity.HotelOrder;
import com.member.hotel.entity.HotelOrderConditions;
import com.member.hotel.entity.HotelOrderItem;
import com.member.hotel.entity.HotelOrderVo;
import com.member.hotel.service.HotelOrderService;

import net.sf.json.JSONObject;


@Service("hotelOrderService")
@Transactional
public class HotelOrderServiceImpl extends BaseManagerImpl implements HotelOrderService {
	@Value("${agent.id}")
	private String agent_id;
	@Value("${agent.md}")
	private String agent_md;
	@Value("${hotel.order.number.code}")
	private String hotelOrderCode;
	
	@Autowired
	private HotelOrderDao hotelOrderDao;
	@Autowired
	private HotelOrderItemDao hotelOrderItemDao;
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;

	@Override
	@EsbServiceMapping
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
	@EsbServiceMapping
	public HotelOrderVo getOrderInfo(@ServiceParam(name="orderid")String orderid) {
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
			if (resultJson.get("retmsg").asText().equals("1")) {
				JsonNode reqdata = resultJson.get("reqdata");
				JsonNode retHeader = resultJson.get("retHeader");
				HotelOrderVo orderVo = new HotelOrderVo();
				orderVo.setOrderid(retHeader.get("orderid").asText());
				Method ms[] = orderVo.getClass().getDeclaredMethods();  
	            for (Method m : ms) {  
	                if (m.getName().startsWith("set")) {  
	                      
	                    String propertyName = m.getName().substring(3);  
	                    String name = propertyName;  
	                      
	                    StringBuffer sb = new StringBuffer(propertyName);    
	                    sb.replace(0, 1, (propertyName.charAt(0)+"").toLowerCase());    
	                    propertyName = sb.toString();  
	                    if (reqdata.get(propertyName) != null && !"".equals(reqdata.get(propertyName).asText())) {
		                	 m.invoke(orderVo, reqdata.get(propertyName).asText());
						} 
	                }  
	            }
				/*Field[] fields = orderVo.getClass().getDeclaredFields();
			    for(int j=0 ; j<fields.length ; j++){     //遍历所有属性
			    	 String name1 = fields[j].getName();
			    	 String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
		             String type = fields[j].getGenericType().toString();    //获取属性的类型
		             if (!name1.equals("orderid")) {
		            	 if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
			                 Method m = orderVo.getClass().getMethod("set"+name2);
			                 if (!"".equals(reqdata.get(name1).asText()) && reqdata.get(name1).asText() != null) {
			                	 String value = (String) m.invoke(orderVo, reqdata.get(name1).asText());
							}
			             }
					}
			    }*/
				return orderVo;
				
			}else
				return null;
	    } catch (Exception e) {
	    	throw new BusException("获取订单详情失败："+e.getMessage());
	    	//return "";
	    }
	  }

	@EsbServiceMapping
	public List<JsonNode> postBook(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@ServiceParam(name="captcha") String captcha,@ServiceParam(name="totalprice")String totalprice,
			HotelOrderConditions hotelOrderConditions) {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		//校验验证码
		TempDemo tempDemo = mcMsgdatasManager.checkPhoneCode(hotelOrderConditions.getMobile(), captcha);
		if (!tempDemo.isFlag()) {
			ObjectMapper mapper = new ObjectMapper();  
	        JsonNode node = mapper.createObjectNode(); 
	        ((ObjectNode) node).put("flag",tempDemo.isFlag());  
	        ((ObjectNode) node).put("buff", tempDemo.getBuff());
	        resultList.add(node);
	        return resultList;
		}		
		HotelOrder hotelOrder = new HotelOrder();
		HotelOrderItem hotelOrderItem = new HotelOrderItem();
		Map<String,Object> params = new HashMap();
	    params.put("agentid", agent_id);
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
		    String orderNumber = BizCodeUtil.getInstance().getBizCodeDate(hotelOrderCode);
		    params.put("guid", orderNumber);//UUID.fromString(orderNumber).toString()
		    hotelOrder.setOrderNum(orderNumber);
		    hotelOrder.setComingTime(hotelOrderConditions.getTm1());//入住
		    hotelOrder.setOutTime(hotelOrderConditions.getTm2());//离店
		    hotelOrder.setRoomCount(hotelOrderConditions.getRm());//房间数量
		    hotelOrder.setOrderAmount(totalprice);
		    hotelOrder.setRzMobile(hotelOrderConditions.getMobile());
		    hotelOrder.setOrderInfo(hotelOrderConditions.getGuest());
		    hotelOrder.setHotelId(hotelOrderConditions.getHid());
		} catch (Exception e) {
			System.out.println("获取HotelOrderConditions实体类属性 异常:" + e);
		    throw new BusException("获取HotelOrderConditions实体类属性 异常: "+e.getMessage());
		}
	    //酒店订单写入数据库
	    hotelOrder.setMemberId(userId);
	    //hotelOrder.setOrderAmount(orderAmount);
	    hotelOrder.setOrderStatus("1");
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    hotelOrder.setOrderTime(format.format(new Date()));
	    try {
			result = HttpGetAndPostUtil.HotelSendPost(HttpGetAndPostUtil.url2, params);
			ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode resultJson = objectMapper.readTree(result);
		    resultList.add(resultJson);
		    System.out.println("result:" + resultJson.get("error")+"   orderId:" + resultJson.get("orderid"));
		    if(resultJson.get("orderid")!=null && !"0".equals(resultJson.get("orderid").asText())){
		    	hotelOrder.setOrderIdThird(resultJson.get("orderid").asText());
			    hotelOrderDao.save(hotelOrder);
		    }
		    return resultList;
		} catch (Exception e) {
			throw new BusException("提交订单失败："+e.getMessage());
		}
	}

	@Override
	@EsbServiceMapping
	public String cancelOrder(String orderid) {
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
