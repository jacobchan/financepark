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
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gsoft.utils.BizCodeUtil;
import com.gsoft.utils.HttpGetAndPostUtil;
import com.member.ticket.dao.TicketOrderDao;
import com.member.ticket.dao.TicketOrderItemDao;
import com.member.ticket.dao.TicketPassengerDao;
import com.member.ticket.dao.TicketPassengerRelationDao;
import com.member.ticket.entity.AvailableFlightWithPriceAndCommisionRequest;
import com.member.ticket.entity.CreateOrderByPassengerRequest;
import com.member.ticket.entity.DailyLowestPrice;
import com.member.ticket.entity.ModifyAndRefundStipulateVo;
import com.member.ticket.entity.TicketOrder;
import com.member.ticket.entity.TicketOrderItem;
import com.member.ticket.entity.TicketPassenger;
import com.member.ticket.entity.TicketPassengerRelation;
import com.member.ticket.entity.WSRefundActionType;
import com.member.ticket.entity.WsAirSegment;
import com.member.ticket.entity.WsBookPassenger;
import com.member.ticket.entity.WsBookPnr;
import com.member.ticket.entity.WsFlightWithPriceAndCommision;
import com.member.ticket.entity.WsFlightWithPriceAndCommisionItem;
import com.member.ticket.entity.WsPaymentInfo;
import com.member.ticket.entity.WsPolicyData;
import com.member.ticket.entity.WsPolicyOrder;
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
	@Value("${agent.test.ticket.order.info.url}")
	private String orderInfo_url;
	@Value("${agent.test.ticket.order.cancel.url}")
	private String cancel_url;
	@Value("${agent.test.ticket.stipulate.url}")
	private String stipulate_url;
	
	@Value("${agent.notify.url}")
	private String notifiedUrl;
	@Value("${ticket.order.number.code}")
	private String ticketOrderCode;
	
	private static Integer canclePNR = 0;
	private static final int PERIOD_TIME = 30;
	
	@Autowired
	private TicketOrderDao ticketOrderDao;
	@Autowired
	private TicketOrderItemDao ticketOrderItemDao;
	@Autowired
	private TicketPassengerDao ticketPassengerDao;
	@Autowired
	private TicketPassengerRelationDao ticketPassengerRelationDao;
//#################################################################################################################################
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
//#################################################################################################################################
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
//################################################################################################################################
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public String bookTicket(@ServiceParam(name="userId",pubProperty="userId") String userId,
			@DomainCollection(domainClazz=CreateOrderByPassengerRequest.class) CreateOrderByPassengerRequest conditions) {
		String result = "";
		TicketOrder ticketOrder = new TicketOrder();
		TicketOrderItem ticketOrderItem = new TicketOrderItem();
		TicketPassenger ticketPassenger ;
		TicketPassengerRelation ticketPassengerRelation ;
		
		Map<String,Object> params = new HashMap<String, Object>();
		conditions.setAgencyCode(agencyCode);
		String signString = conditions.getAgencyCode() + conditions.getPolicyId() + safeCode;
		String sign = PasswordUtils.md5Password(signString);
		conditions.setSign(sign);
		conditions.setNotifiedUrl(notifiedUrl);//确认链接
		conditions.setPaymentReturnUrl("");//支付完成后确认链接，已弃用，可随填
		String psaOrderNo = BizCodeUtil.getInstance().getBizCodeDate(ticketOrderCode);
		conditions.setOutOrderNo(psaOrderNo);//自己平台的订单号
		ticketOrder.setMemberId(userId);
		ticketOrder.setOrderNo(psaOrderNo);
		
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
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())){
				Element element = root.element("order");
				WsPolicyOrder policyOrder = parsePolicyOrder(element);
				ticketOrder.setOrderTime(policyOrder.getCreatedAt());
				ticketOrder.setOrderAmount(policyOrder.getPaymentInfo().getSettlePrice().toString());
				ticketOrder.setOrderType("1");//订单状态  新订单处理中
				ticketOrderItem.setTicketOrder(ticketOrderDao.save(ticketOrder));
				ticketOrderItem.setOrderIdThird(policyOrder.getLiantuoOrderNo());
				ticketOrderItem = ticketOrderItemDao.save(ticketOrderItem);
				List<WsBookPassenger> pList = policyOrder.getPassengerList();
				for(int i=0;i<policyOrder.getPassengerList().size();i++){
					ticketPassenger = new TicketPassenger();
					ticketPassengerRelation = new TicketPassengerRelation();
					ticketPassenger.setIdentityType(pList.get(i).getIdentityType());
					ticketPassenger.setIdentityNum(pList.get(i).getIdentityNo());
					ticketPassenger.setName(pList.get(i).getName());
					ticketPassengerRelation.setPassengerId(ticketPassengerDao.save(ticketPassenger).getPassengerId());
					ticketPassengerRelation.setItemId(ticketOrderItem.getItemId());
					ticketPassengerRelationDao.save(ticketPassengerRelation);
				}
			}
			return root.selectSingleNode("returnCode").getText();
		} catch (Exception e) {
			throw new BusException("机票下订单异常:"+e.getLocalizedMessage());
		}
		//return null;
	}
//################################################################################################################################
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public WsPolicyOrder getOrderInfo(@ServiceParam(name="userId",pubProperty="userId") String userId,@ServiceParam(name="orderid") String orderId) {
		String result = "";
		Map<String,Object> params = new HashMap();
		params.put("orderNo", orderId);
		params.put("agencyCode", agencyCode);
		String signString = agencyCode + orderId + safeCode;
		String sign = PasswordUtils.md5Password(signString);
		params.put("sign", sign);
		try {
			result = HttpGetAndPostUtil.TicketSendPost(orderInfo_url, params);
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())){
				Element element = root.element("policyOrder");
				WsPolicyOrder policyOrder = parsePolicyOrder(element);
				return policyOrder;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new BusException("获取订单详情异常："+e.getMessage());
		}
	}
//订单取消################################################################################################################################
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public String cancelOrder(@ServiceParam(name="userId",pubProperty="userId") String userId,@ServiceParam(name="orderid") String orderId) {
		String result = "";
		Map<String,Object> params = new HashMap();
		params.put("orderNo", orderId);
		params.put("agencyCode", agencyCode);
		params.put("canclePNR", canclePNR);
		String signString = agencyCode + canclePNR + orderId + safeCode;
		String sign = PasswordUtils.md5Password(signString);
		params.put("sign", sign);
		try {
			result = HttpGetAndPostUtil.TicketSendPost(cancel_url, params);
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())){
				String orderStatus = root.selectSingleNode("orderStatus").getText();
				return "SUCCESS";
			}else{
				return root.selectSingleNode("returnMessage").getText();
			}
		} catch (Exception e) {
			throw new BusException("取消订单异常："
					+ ""+e.getMessage());
		}

	}
//退票政策################################################################################################################################	
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public ModifyAndRefundStipulateVo getModifyAndRefundStipulate(@ServiceParam(name="seatId") String seatId,
			@ServiceParam(name="airlineCode") String airlineCode, @ServiceParam(name="classCode") String classCode,
			@ServiceParam(name="depDate") String depDate,@ServiceParam(name="depCode") String depCode,@ServiceParam(name="arrCode") String arrCode) {
		String result = "";
		Map<String,Object> params = new HashMap();
		params.put("agencyCode", agencyCode);
		String signString = seatId+agencyCode+airlineCode+arrCode+classCode+depCode+depDate+safeCode;
		String sign = PasswordUtils.md5Password(signString);
		params.put("sign", sign);
		params.put("seatId", seatId);
		params.put("airlineCode", airlineCode);
		params.put("classCode", classCode);
		params.put("depDate", depDate);
		params.put("depCode", depCode);
		params.put("arrCode", arrCode);
		try {
			result = HttpGetAndPostUtil.TicketSendPost(stipulate_url, params);
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())){
				Element element = root.element("modifyAndRefundStipulateList");
				ModifyAndRefundStipulateVo modifyAndRefundStipulateVo = parseStipulate(element);
				return modifyAndRefundStipulateVo;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new BusException("取消订单异常："+e.getMessage());
		}
	}
//############################################################################################################################
	@SuppressWarnings("unchecked")
	@Override
	@EsbServiceMapping
	public List<WSRefundActionType> getActionTypeForRefund() {
		String result = "";
		List<WSRefundActionType> resultList = new ArrayList<WSRefundActionType>();
		Map<String,Object> params = new HashMap();
		params.put("agencyCode", agencyCode);
		String signString = agencyCode+safeCode;
		String sign = PasswordUtils.md5Password(signString);
		params.put("sign", sign);
		try {
			result = HttpGetAndPostUtil.TicketSendPost(create_url, params);
			Document document = Dom4jUtils.parseText(result);
			Element root = document.getRootElement();
			if ("S".equals(root.selectSingleNode("returnCode").getText())){
				List<Element> elements = root.elements("refundActionTypes");
				for(Element element : elements){
					resultList.add(parseRefundActionType(element));
				}
				return resultList;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new BusException("取消订单异常："+e.getMessage());
		}
	}
	/***********************************|解析方法|*******************************/
	private WSRefundActionType parseRefundActionType(Element element) {
		WSRefundActionType tmp = new WSRefundActionType();
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析退票规定内容异常："+e.getMessage());
		}
		return tmp;
	
	}
	
	private ModifyAndRefundStipulateVo parseStipulate(Element element) {

		ModifyAndRefundStipulateVo tmp = new ModifyAndRefundStipulateVo();
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析退票规定内容异常："+e.getMessage());
		}
		return tmp;
	}
	
	private WsPolicyOrder parsePolicyOrder(Element element) {
		WsPolicyOrder tmp = new WsPolicyOrder();
		Field[] fields = tmp.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name1 = fields[i].getName();
				if (name1.equals("flightInfoList")) {
					List<Element> items = element.elements(name1);
					if (items!=null&&items.size()!=0) {
						List<WsAirSegment> flightInfoList = new ArrayList<WsAirSegment>();
						for(Element airItem : items){
							flightInfoList.add(parseWsAirSegment(airItem));
						}
						tmp.setFlightInfoList(flightInfoList);
					}
				}else if (name1.equals("passengerList")) {
					List<Element> items = element.elements(name1);
					if (items!=null&&items.size()!=0){
						List<WsBookPassenger> passengerList = new ArrayList<WsBookPassenger>();
						for(Element passenger : items){
							passengerList.add(parseWsPassenger(passenger));
						}
						tmp.setPassengerList(passengerList);
					}
					
				}else if (name1.equals("policyData")) {
					Element item = element.element(name1);
					if (item!=null) {
						tmp.setPolicyData(parsePolicyDataXml(item));
					}
					
				}else if (name1.equals("paymentInfo")) {
					Element item = element.element(name1);
					if (item!=null) {
						tmp.setPaymentInfo(parsePaymentInfoXml(item));
					}
				}else {
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
					
			}
		} catch (Exception e) {
			throw new BusException("解析订单异常："+e.getMessage());
		}
		return tmp;
	
	}

	private WsPaymentInfo parsePaymentInfoXml(Element element) {
		WsPaymentInfo tmp = new WsPaymentInfo();
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析支付信息异常："+e.getMessage());
		}
		return tmp;
	}
	private WsBookPassenger parseWsPassenger(Element element) {
		WsBookPassenger tmp = new WsBookPassenger();
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析乘机人异常："+e.getMessage());
		}
		return tmp;
	
	}

	private WsAirSegment parseWsAirSegment(Element element) {

		WsAirSegment tmp = new WsAirSegment();
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
						}else if (type.equals("class java.lang.Integer")) {
							Method m = tmp.getClass().getMethod("set"+name2,Integer.class);
			                m.invoke(tmp,Integer.parseInt(element.element(fields[i].getName()).getText()));
						}
					}
			}
		} catch (Exception e) {
			throw new BusException("解析乘机航班段异常："+e.getMessage());
		}
		return tmp;
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = tmp.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(tmp,Float.parseFloat(element.element(fields[i].getName()).getText()));
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
						}else if (type.equals("class java.lang.Float")) {
							Method m = result.getClass().getMethod("set"+name2,Float.class);
			                m.invoke(result,Float.parseFloat(element.element(fields[i].getName()).getText()));
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
