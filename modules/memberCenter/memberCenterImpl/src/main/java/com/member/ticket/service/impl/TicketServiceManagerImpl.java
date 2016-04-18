package com.member.ticket.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.util.Dom4jUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.utils.HttpGetAndPostUtil;
import com.member.ticket.entity.AvailableFlightWithPriceAndCommisionRequest;
import com.member.ticket.entity.WsFlightWithPriceAndCommision;
import com.member.ticket.entity.WsFlightWithPriceAndCommisionItem;
import com.member.ticket.entity.WsPolicyData;
import com.member.ticket.entity.WsSeatWithPriceAndCommisionItem;
import com.member.ticket.service.TicketServiceManager;

public class TicketServiceManagerImpl extends BaseManagerImpl implements TicketServiceManager {
	@Value("${agent.test.agencyCode}")
	private String agencyCode;
	@Value("${agent.test.safeCode}")
	private String safeCode;
	@Value("agent.ticket.url1")
	private String url1;

	@SuppressWarnings("unchecked")
	@Override
	public WsFlightWithPriceAndCommisionItem getFlights(AvailableFlightWithPriceAndCommisionRequest conditions) {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
		conditions.setAgencyCode(agencyCode);
		conditions.setOnlyAvailableSeat("1");
		conditions.setOnlyNormalCommision("1");
		conditions.setOnlyOnWorkingCommision("1");
		conditions.setOnlySelfPNR("1");
	    try {//遍历实体类的所有属性，并取值判断
	    	Field[] fields = conditions.getClass().getDeclaredFields();
		    for(int j=0 ; j<fields.length ; j++){     //遍历所有属性
		    	 String name1 = fields[j].getName();
		    	 String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
	             String type = fields[j].getGenericType().toString();    //获取属性的类型
	             if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
	                 Method m = conditions.getClass().getMethod("get"+name2);
	                 String value = (String) m.invoke(conditions);    //调用getter方法获取属性值
	                 if(value != null && !"".equals(value)){
	                	 params.put(name1, value);
	                 }
	             }
		    }
		    String signString = conditions.getAgencyCode() + conditions.getDstAirportCode() + conditions.getOnlyAvailableSeat() + conditions.getOnlyNormalCommision()
					+ conditions.getOnlyOnWorkingCommision() + conditions.getOnlySelfPNR() + conditions.getOrgAirportCode() + safeCode;
			String sign = PasswordUtils.md5Password(signString);
			params.put("sign", sign);
			result = HttpGetAndPostUtil.TicketSendPost(url1, params);
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())) {
				
				Element flightItems = root.element("flightItems");
				//解析flightItems节点

				//List<Element> elements = element.elements();
				WsFlightWithPriceAndCommisionItem flightItem = new WsFlightWithPriceAndCommisionItem();
				Field[] flightFields = flightItem.getClass().getDeclaredFields();
				for(int j = 0;j<flightFields.length;j++){
					String name1 = flightFields[j].getName();
					if ("flights".equals(flightFields[j].getName())) {
						System.out.println("List对象类型："+flightFields[j].getGenericType().toString());
						List<Element> fList = flightItems.elements("flights");
						List<WsFlightWithPriceAndCommision> Fresult = new ArrayList<WsFlightWithPriceAndCommision>();
						for(Element elem : fList){
							Fresult.add(parseFlightsXml(elem));
						}
						flightItem.setFlights(Fresult);
					}else{
						String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
			            String type = flightFields[j].getGenericType().toString();    //获取属性的类型
			            if (flightItems.element(flightFields[j].getName())!=null) {
			            	if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
				                Method m = flightItem.getClass().getMethod("set"+name2,String.class);
				                m.invoke(flightItem,flightItems.element(flightFields[j].getName()).getText());
				            }else if (type.equals("class java.lang.Boolean")) {
				            	Method m = flightItem.getClass().getMethod("set"+name2,Boolean.class);
				                if ("false".equals(flightItems.element(flightFields[j].getName()).getText())){
				            		m.invoke(flightItem,Boolean.FALSE);
								}else{
									m.invoke(flightItem,Boolean.TRUE);
								}
							}else if (type.equals("class java.lang.Double")) {
								Method m = flightItem.getClass().getMethod("set"+name2,Double.class);
				                m.invoke(flightItem,Double.parseDouble(flightItems.element(flightFields[j].getName()).getText()));
							}else if (type.equals("class java.lang.Integer")) {
								Method m = flightItem.getClass().getMethod("set"+name2,Integer.class);
				                m.invoke(flightItem,Integer.parseInt(flightItems.element(flightFields[j].getName()).getText()));
							}
						}
			            
					}
				}
				return flightItem;
			}else{
				return null;
			}
			//List<Element> elements = root.elements();
		} catch (Exception e) {
			throw new BusException("查询机票异常:"+e.getLocalizedMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	private WsFlightWithPriceAndCommision parseFlightsXml(Element element) {
		List<Element> elements = element.elements();
		WsFlightWithPriceAndCommision tmp = new WsFlightWithPriceAndCommision();
		Field[] fields = tmp.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name1 = fields[i].getName();
				if (name1.equals("seatItems")) {
					List<Element> seatItems = element.elements(name1);
					List<WsSeatWithPriceAndCommisionItem> seatList = new ArrayList<WsSeatWithPriceAndCommisionItem>();
					for(Element seatItem : seatItems){
						seatList.add(parseSeatItemsXml(seatItem));
					}
					tmp.setSeatItems(seatList);
				}else{
					String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
		            String type = fields[i].getGenericType().toString();    //获取属性的类型
		            if (element.element(fields[i].getName())!=null) {
		            	if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
			                Method m = tmp.getClass().getMethod("set"+name2,String.class);
			                m.invoke(tmp,element.element(fields[i].getName()).getText());
			            }else if (type.equals("class java.lang.Boolean")) {
			            	Method m = tmp.getClass().getMethod("set"+name2,Boolean.class);
			            	if ("false".equals(element.element(fields[i].getName()).getText())) {
			            		m.invoke(tmp,Boolean.FALSE);
							}else{
								m.invoke(tmp,Boolean.TRUE);
							}
			                
						}else if (type.equals("class java.lang.Double")) {
							Method m = tmp.getClass().getMethod("set"+name2,Double.class);
			                m.invoke(tmp,Double.parseDouble(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
		            
				}
		    	
			}
		} catch (Exception e) {
			throw new BusException("解析Flight异常："+e.getMessage());
		}
		
		return tmp;
	}
	@SuppressWarnings("unchecked")
	private WsSeatWithPriceAndCommisionItem parseSeatItemsXml(Element element) {
		List<Element> elements = element.elements();
		WsSeatWithPriceAndCommisionItem tmp = new WsSeatWithPriceAndCommisionItem();
		Field[] fields = tmp.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name1 = fields[i].getName();
				if (name1.equals("policyData")) {
					Element policy = element.element(name1);
						tmp.setPolicyData(parsePolicyDataXml(policy));
				}else{
					String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
		            String type = fields[i].getGenericType().toString();    //获取属性的类型
		            if (element.element(fields[i].getName())!=null) {
		            	if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
			                Method m = tmp.getClass().getMethod("set"+name2,String.class);
			                m.invoke(tmp,element.element(fields[i].getName()).getText());
			            }else if (type.equals("class java.lang.Boolean")) {
			            	Method m = tmp.getClass().getMethod("set"+name2,Boolean.class);
			                
			                if ("false".equals(element.element(fields[i].getName()).getText())) {
			                	m.invoke(tmp,Boolean.FALSE);
							}else{
								m.invoke(tmp,Boolean.TRUE);
							}
						}else if (type.equals("class java.lang.Double")) {
							Method m = tmp.getClass().getMethod("set"+name2,Double.class);
			                m.invoke(tmp,Double.parseDouble(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
		            
				}
		    	
			}
		} catch (Exception e) {
			throw new BusException("解析seatItems异常："+e.getMessage());
		}
		return tmp;
	}

	private WsPolicyData parsePolicyDataXml(Element element) {
		WsPolicyData tmp = new WsPolicyData();
		Field[] fields = tmp.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name1 = fields[i].getName();
					String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
		            String type = fields[i].getGenericType().toString();    //获取属性的类型
		            if (element.element(fields[i].getName())!=null) {
		            	if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
			                Method m = tmp.getClass().getMethod("set"+name2,String.class);
			                m.invoke(tmp,element.element(fields[i].getName()).getText());
			            }else if (type.equals("class java.lang.Boolean")) {
			            	Method m = tmp.getClass().getMethod("set"+name2,Boolean.class);
			                if ("false".equals(element.element(fields[i].getName()).getText())) {
			                	m.invoke(tmp,Boolean.FALSE);
							}else{
								m.invoke(tmp, Boolean.TRUE);
							}
						}else if (type.equals("class java.lang.Double")) {
							Method m = tmp.getClass().getMethod("set"+name2,Double.class);
			                m.invoke(tmp,Double.parseDouble(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析seatItems异常："+e.getMessage());
		}
		return tmp;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> XmlElememtToParams(Element element) {
		Map<String , Object> map = new HashMap<String, Object>();
		List<Element> elems = element.elements();
		for(Element elem : elems){
			Object value = "";
			if ("flightItems".equals(elem.getName())) {
				List<Element> flightList = elem.selectNodes("//flightItems//flights");
				List<Map<String , Object>> nodeList = new ArrayList<Map<String,Object>>();
				for (int i = 0; i < flightList.size(); i++) {
					//nodeList.add(XmlElememtToParams(flightList.get(i)));
				}
				//value = XmlElememtToParams(elem);
			}else if ("flights".equals(elem.getName())) {
				//dom4j Xpath 根据路径选取节点
			}else if ("seatItems".equals(elem.getName())) {
				
			}else if ("policyData".equals(elem.getName())) {
				
			}else if ("".equals(elem.getName())) {
				
			}
		}
		return null;
 	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> XmlElememts2List(Class cl,List<Element> elements) throws Exception {
		Field[] fields = cl.getDeclaredFields();
		cl.newInstance();
		for(Element elem : elements){
			for(int j=0 ; j<fields.length ; j++){     //遍历所有属性
		    	String name1 = fields[j].getName();
		    	String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
	            String type = fields[j].getGenericType().toString();    //获取属性的类型
	            if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
	                Method m = cl.getMethod("get"+name2);
	                String value = (String) m.invoke(cl);    //调用getter方法获取属性值
	                if(value != null && !"".equals(value)){
	                	
	                }
	            }
		    }
		}		
		return null;
 	}

}
