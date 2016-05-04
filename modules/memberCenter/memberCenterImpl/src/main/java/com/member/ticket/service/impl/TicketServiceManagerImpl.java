package com.member.ticket.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.DomainCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.util.Dom4jUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.utils.HttpGetAndPostUtil;
import com.member.ticket.entity.AvailableFlightWithPriceAndCommisionRequest;
import com.member.ticket.entity.CreateOrderByPassengerRequest;
import com.member.ticket.entity.DailyLowestPrice;
import com.member.ticket.entity.WsBookPnr;
import com.member.ticket.entity.WsFlightWithPriceAndCommision;
import com.member.ticket.entity.WsFlightWithPriceAndCommisionItem;
import com.member.ticket.entity.WsPolicyData;
import com.member.ticket.entity.WsSeatWithPriceAndCommisionItem;
import com.member.ticket.service.TicketServiceManager;

@Service("TicketServiceManager")
@Transactional
public class TicketServiceManagerImpl extends BaseManagerImpl implements TicketServiceManager {
	@Value("${agent.test.agencyCode}")
	private String agencyCode;
	@Value("${agent.test.safeCode}")
	private String safeCode;
	@Value("${agent.test.ticket.query.url}")
	private String query_url;
	@Value("${agent.test.ticket.lowestprice.url}")
	private String lowest_price_url;
	@Value("${agent.test.ticket.create.url}")
	private String create_url;
	
	private static final int PERIOD_TIME = 30;

	@SuppressWarnings("unchecked")
	@EsbServiceMapping
	@Override
	public List<WsFlightWithPriceAndCommisionItem> getFlights(AvailableFlightWithPriceAndCommisionRequest conditions) {
		String result = "";
		List<WsFlightWithPriceAndCommisionItem> resultList = new ArrayList<WsFlightWithPriceAndCommisionItem>();
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
			result = HttpGetAndPostUtil.TicketSendPost(query_url, params);
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
				resultList.add(flightItem);
				return resultList;
			}else{
				return null;
			}
			//List<Element> elements = root.elements();
		} catch (Exception e) {
			throw new BusException("查询机票异常:"+e.getLocalizedMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public List<DailyLowestPrice> getDailyLowestPrice(@ServiceParam(name="startDate")String startDate,
			@ServiceParam(name="deptCode")String deptCode,
			@ServiceParam(name="arrCode")String arrCode) throws Exception{
		
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		startDate = df.format(df.parse(startDate));
		String endDate = df.format(getDateAfter(df.parse(startDate),PERIOD_TIME));
		List<DailyLowestPrice> resultList = new ArrayList<DailyLowestPrice>();
		Map<String,Object> params = new HashMap();
		params.put("agencyCode", agencyCode);
		if (startDate==null||"".equals(startDate)||deptCode==null||"".equals(deptCode)||arrCode==null||"".equals(arrCode)) {
			return null;
		}else{
			params.put("startDate", startDate);
			params.put("endDate", endDate);
			params.put("deptCode", deptCode);
			params.put("arrCode", arrCode);
		}
		String signString = agencyCode + arrCode + deptCode + endDate + startDate + safeCode;
		String sign = PasswordUtils.md5Password(signString);
		params.put("sign", sign);
		try {
			result = HttpGetAndPostUtil.TicketSendPost(lowest_price_url, params);
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())) {
				List<Element> elements = root.elements("lowestPriceList");
				for (int i = 0; i < elements.size(); i++) {
					resultList.add(parseLowestPriceXml(elements.get(i)));
				}
				//去除可能存在的重复项
				int len = resultList.size();
				for(int i=len-1; i>=1; i--){
					if (resultList.get(i).getDepDate().equals(resultList.get(i-1).getDepDate())){
						if (Double.parseDouble(resultList.get(i).getTicketPrice()) > Double
								.parseDouble(resultList.get(i-1).getTicketPrice()))  {
							resultList.remove(i);
						}else{
							resultList.remove(i-1);
						}
					}
				}
				return resultList;
			}else
				return null;
		} catch (Exception e) {
			throw new BusException("获取每日低价异常："+e.getMessage());
		}
		
	}
	
	public String bookTicket(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@DomainCollection(domainClazz=CreateOrderByPassengerRequest.class) CreateOrderByPassengerRequest conditions) {
		String result = "";
		Map<String,Object> params = new HashMap();
		conditions.setAgencyCode(agencyCode);
		String signString = conditions.getAgencyCode() + conditions.getPolicyId() + safeCode;
		String sign = PasswordUtils.md5Password(signString);
		conditions.setSign(sign);
		//conditions.setNotifiedUrl(notifiedUrl);//确认链接
		//conditions.setPaymentReturnUrl(paymentReturnUrl);//支付完成后确认链接，已弃用，可随填
		//conditions.setOutOrderNo(outOrderNo);//自己平台的订单号
		
		try {
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
	             }else if (type.equals("class com.member.ticket.entity.WsBookPnr")) {
	            	 Method m = conditions.getClass().getMethod("get"+name2);
	                 WsBookPnr value = (WsBookPnr) m.invoke(conditions);    //调用getter方法获取属性值
	                 if(value != null && !"".equals(value)){
	                	 params.put(name1, value);
	                 }
				}
		    }
			result = HttpGetAndPostUtil.TicketSendPost(create_url, params);
		} catch (Exception e) {
			throw new BusException("机票下订单异常:"+e.getLocalizedMessage());
		}
		
		return null;
	}
	/***********************************|解析方法|*******************************/
	
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
			throw new BusException("解析政策异常："+e.getMessage());
		}
		return tmp;
	}

	private DailyLowestPrice parseLowestPriceXml(Element element) {
		DailyLowestPrice result = new DailyLowestPrice();
		Field[] fields = result.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name1 = fields[i].getName();
					String name2 = name1.substring(0,1).toUpperCase()+name1.substring(1); //将属性的首字符大写，方便构造get，set方法
		            String type = fields[i].getGenericType().toString();    //获取属性的类型
		            if (element.element(fields[i].getName())!=null) {
		            	if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
			                Method m = result.getClass().getMethod("set"+name2,String.class);
			                m.invoke(result,element.element(fields[i].getName()).getText());
			            }else if (type.equals("class java.lang.Boolean")) {
			            	Method m = result.getClass().getMethod("set"+name2,Boolean.class);
			                if ("false".equals(element.element(fields[i].getName()).getText())) {
			                	m.invoke(result,Boolean.FALSE);
							}else{
								m.invoke(result, Boolean.TRUE);
							}
						}else if (type.equals("class java.lang.Double")) {
							Method m = result.getClass().getMethod("set"+name2,Double.class);
			                m.invoke(result,Double.parseDouble(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = result.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(result,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析每日最低价异常："+e.getMessage());
		}
		return result;
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
	
	/*@SuppressWarnings("unchecked")
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
 	}*/
	public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }

}
