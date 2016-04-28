package com.member.hotel.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.utils.HttpGetAndPostUtil;
import com.member.hotel.entity.HotelConditions;
import com.member.hotel.entity.HotelOrder;
import com.member.hotel.service.HotelInfoService;

@Service("hotelInfoService")
@Transactional
public class HotelInfoServiceImpl extends BaseManagerImpl implements HotelInfoService {

	@Value("${agent.id}")
	private String agent_id;
	@Value("${agent.md}")
	private String agent_md;
	//@EsbServiceMapping
	/*
	public List<JsonNode> searchHotelByConditions_(String cid, int pagesize, int pg, int px,
			int minprice, int maxprice, String hn, String cityname, int lsid, String bid, String areaid, int rank,
			int hid, float lng, float lat, int juli, int promotion, int is_kezhan) throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("method", "search");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("cid", cid);
	    params.put("pagesize", pagesize);
	    params.put("pg", pg);
	    params.put("px", px);
	    params.put("minprice", minprice);
	    params.put("maxprice", maxprice);
	    params.put("hn", hn);
	    params.put("cityname",cityname);
	    params.put("lsid", lsid);
	    params.put("bid", bid);
	    params.put("areaid", areaid);
	    params.put("rank", rank);
	    params.put("hid", hid);
	    params.put("lng", lng);
	    params.put("lat", lat);
	    params.put("juli", juli);
	    params.put("promotion", promotion);
	    params.put("is_kezhan", is_kezhan);
	    try
	    {
		      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
		      ObjectMapper objectMapper = new ObjectMapper();
		      JsonNode resultJson = objectMapper.readTree(result);
		      JsonNode reqHeader = resultJson.get("retHeader");
		      JsonNode reqdata = resultJson.get("reqdata");
		      if (resultJson.get("retmsg").asText().equals("1")) {
		    	  resultList.add(reqHeader);//头信息，totalput 总记录数； totalpg 总页数；
					for (Iterator it = reqdata.elements(); it.hasNext();) {
						JsonNode avator = (JsonNode) it.next();
						
						System.out.println(avator.get("xingji"));
						System.out.println(avator.get("df_haoping"));
						System.out.println(avator.get("Service"));
						
						if (avator.get("xingji").asInt() > 6 && avator.get("xingji").asInt() < 17) {
							((ObjectNode) avator).put("xingji", 2); //经济型
					    } else if (avator.get("xingji").asInt() > 4 && avator.get("xingji").asInt() < 7) {
					    	((ObjectNode) avator).put("xingji", 3); //舒适型
					    } else if (avator.get("xingji").asInt() > 2 && avator.get("xingji").asInt() < 5) {
					    	((ObjectNode) avator).put("xingji", 4); //高档型
					    } else if (avator.get("xingji").asInt() > 0 && avator.get("xingji").asInt() < 3) {
					    	((ObjectNode) avator).put("xingji", 5); //豪华型
					    } else {
					    	((ObjectNode) avator).put("xingji", 1);
					    }
						String[] tmp = avator.get("df_haoping").asText().split("$");
						
						resultList.add(avator);
					}
					for (int i = 0; i < lists.size(); i++) {
						Map<String, Object> map = lists.get(i);
						Set<String> set = map.keySet();
						for (Iterator<String> it = set.iterator(); it.hasNext();) {
							String key = it.next();
							System.out.println(key + ":" + map.get(key));
						}
					}
				}
		    } catch (Exception e) {
	      System.out.println("查询酒店 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}*/

	@EsbServiceMapping
	public List<JsonNode> searchHotelByConditions(HotelConditions conditions) throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap<String,Object>();
	    params.put("method", "search");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
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
		} catch (Exception e) {
			System.out.println("获取HotelConditions实体类属性 异常:" + e);
		    e.printStackTrace();
		}
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode reqHeader = resultJson.get("retHeader");
	      JsonNode reqdata = resultJson.get("reqdata");
	      if (resultJson.get("retmsg").asText().equals("1")) {
	    	  resultList.add(reqHeader);//头信息，totalput 总记录数； totalpg 总页数；
				for (Iterator it = reqdata.elements(); it.hasNext();) {
					JsonNode avator = (JsonNode) it.next();
					//区分酒店星级
					if (avator.get("xingji").asInt() > 6 && avator.get("xingji").asInt() < 17) {
						((ObjectNode) avator).put("xingji", 2); //经济型
				    } else if (avator.get("xingji").asInt() > 4 && avator.get("xingji").asInt() < 7) {
				    	((ObjectNode) avator).put("xingji", 3); //舒适型
				    } else if (avator.get("xingji").asInt() > 2 && avator.get("xingji").asInt() < 5) {
				    	((ObjectNode) avator).put("xingji", 4); //高档型
				    } else if (avator.get("xingji").asInt() > 0 && avator.get("xingji").asInt() < 3) {
				    	((ObjectNode) avator).put("xingji", 5); //豪华型
				    } else {
				    	((ObjectNode) avator).put("xingji", 2);
				    }
					//划分酒店评论评分
					String[] tmp = (avator.get("df_haoping").asText()).toString().split("\\$");
					int pinglun_sum = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]) + Integer.parseInt(tmp[2]);//总数
					float haoping = (Float.parseFloat(tmp[0]) + Float.parseFloat(tmp[1])) / pinglun_sum;
					if(!Float.isNaN(haoping)){
						((ObjectNode) avator).put("haoping_num", new DecimalFormat("##0.0").format(haoping*5));//评分 5分为满分
					}else{
						((ObjectNode) avator).put("haoping_num", "0.0");
					}
					((ObjectNode) avator).put("df_scores", pinglun_sum);
					resultList.add(avator);
				}
				}
		    } catch (Exception e) {
	      System.out.println("查询酒店 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> searchHotel(@ServiceParam(name="cid") String cid) throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("method", "search");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("cid", cid);
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode reqHeader = resultJson.get("retHeader");
	      JsonNode reqdata = resultJson.get("reqdata");
	      if (resultJson.get("retmsg").asText().equals("1")) {
	    	  resultList.add(reqHeader);//头信息，totalput 总记录数； totalpg 总页数；
				for (Iterator it = reqdata.elements(); it.hasNext();) {
					JsonNode avator = (JsonNode) it.next();
					//区分酒店星级
					if (avator.get("xingji").asInt() > 6 && avator.get("xingji").asInt() < 17) {
						((ObjectNode) avator).put("xingji", 2); //经济型
				    } else if (avator.get("xingji").asInt() > 4 && avator.get("xingji").asInt() < 7) {
				    	((ObjectNode) avator).put("xingji", 3); //舒适型
				    } else if (avator.get("xingji").asInt() > 2 && avator.get("xingji").asInt() < 5) {
				    	((ObjectNode) avator).put("xingji", 4); //高档型
				    } else if (avator.get("xingji").asInt() > 0 && avator.get("xingji").asInt() < 3) {
				    	((ObjectNode) avator).put("xingji", 5); //豪华型
				    } else {
				    	((ObjectNode) avator).put("xingji", 2);
				    }
					//划分酒店评论评分
					String[] tmp = (avator.get("df_haoping").asText()).toString().split("\\$");
					int pinglun_sum = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]) + Integer.parseInt(tmp[2]);//总数
					float haoping = (Float.parseFloat(tmp[0]) + Float.parseFloat(tmp[1])) / pinglun_sum;
					((ObjectNode) avator).put("haoping_num", new  DecimalFormat("##0.0").format(haoping*5));//评分 5分为满分
					((ObjectNode) avator).put("df_scores", pinglun_sum);
					resultList.add(avator);
				}
			}
	    } catch (Exception e) {
	      System.out.println("查询酒店 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getHotelInfo(@ServiceParam(name="hid") String hid) throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("method", "hotel.info");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("hid", hid);
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode reqHeader = resultJson.get("retHeader");
	      JsonNode reqdata = resultJson.get("reqdata");
	      if (resultJson.get("retmsg").asText().equals("1")) {
	    	//区分酒店星级
				if (reqdata.get("xingji").asInt() > 6 && reqdata.get("xingji").asInt() < 17) {
					((ObjectNode) reqdata).put("xingji", 2); //经济型
			    } else if (reqdata.get("xingji").asInt() > 4 && reqdata.get("xingji").asInt() < 7) {
			    	((ObjectNode) reqdata).put("xingji", 3); //舒适型
			    } else if (reqdata.get("xingji").asInt() > 2 && reqdata.get("xingji").asInt() < 5) {
			    	((ObjectNode) reqdata).put("xingji", 4); //高档型
			    } else if (reqdata.get("xingji").asInt() > 0 && reqdata.get("xingji").asInt() < 3) {
			    	((ObjectNode) reqdata).put("xingji", 5); //豪华型
			    } else {
			    	((ObjectNode) reqdata).put("xingji", 2);
			    }
				String[] tmp = (reqdata.get("df_haoping").asText()).toString().split("\\$");
				int pinglun_sum = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]) + Integer.parseInt(tmp[2]);//总数
				float haoping = (Float.parseFloat(tmp[0]) + Float.parseFloat(tmp[1])) / pinglun_sum;
				((ObjectNode) reqdata).put("haoping_num", new  DecimalFormat("##0.0").format(haoping*5));//评分 5分为满分
				((ObjectNode) reqdata).put("df_scores", pinglun_sum);
		    	resultList.add(reqdata);
		    	resultList.add(reqHeader);
	      }else{
	    	  return null;
	      }
	    } catch (Exception e) {
	      System.out.println("查询酒店详情 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getCityHotelComment(String cityid, int pagesize, int page)
			throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("method", "comment.list");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("cityid", cityid);
	    params.put("pagesize", pagesize);
	    params.put("page", page);
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode reqHeader = resultJson.get("retHeader");
	      JsonNode reqdata = resultJson.get("reqdata");
	      if (resultJson.get("retmsg").asText().equals("1")) {
	    	  for (Iterator it = reqdata.elements(); it.hasNext(); ){
      	        JsonNode avator = (JsonNode) it.next();
      	        resultList.add(avator);
      	    }
	      }
	    } catch (Exception e) {
	      System.out.println("查询城市酒店评论 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getHotelComment(@ServiceParam(name="hid") String hid, @ServiceParam(name="nums") String nums)
			throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("method", "hotel.comment");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("hid", hid);
	    if (nums!=null&&!"".equals(nums)) {
	    	params.put("nums", nums);
		}
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode reqHeader = resultJson.get("retHeader");
	      JsonNode reqdata = resultJson.get("reqdata");
	      if (resultJson.get("retmsg").asText().equals("1")) {
	    	  for (Iterator it = reqdata.elements(); it.hasNext(); ){
      	        JsonNode avator = (JsonNode) it.next();
      	        resultList.add(avator);
      	    }
	      }
	    } catch (Exception e) {
	      System.out.println("查询酒店评论 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public List<JsonNode> getHotelPic(@ServiceParam(name="hid") String hid) throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("method", "hotel.pic");
	    params.put("agent_id", agent_id);
	    params.put("agent_md", agent_md);
	    params.put("hid", hid);
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url1, params, "GET");
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJson = objectMapper.readTree(result);
	      JsonNode reqHeader = resultJson.get("retHeader");
	      resultList.add(reqHeader);
	      JsonNode reqdata = resultJson.get("reqdata");
	      if (resultJson.get("retmsg").asText().equals("1")) {
	    	  for (Iterator it = reqdata.elements(); it.hasNext(); ){
      	        JsonNode avator = (JsonNode) it.next();
      	        resultList.add(avator);
      	    }
	      }
		} catch (Exception e) {
	      System.out.println("查询酒店图片 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}

	@EsbServiceMapping
	public String getHotelNearby(@ConditionCollection(domainClazz=HotelOrder.class) Collection<Condition> conditions) throws BusException {
		// TODO Auto-generated method stub
		return null;
	}

	@EsbServiceMapping
	public List<JsonNode> getHotelData(@ServiceParam(name="hid") String hid,
			@ServiceParam(name="tm1") String tm1, @ServiceParam(name="tm2") String tm2) throws BusException {
		String result = "";
		List<JsonNode> resultList = new ArrayList<JsonNode>();
		Map<String,Object> params = new HashMap();
	    params.put("tm1", tm1);
	    params.put("tm2", tm2);
	    params.put("hid", hid);
	    if (hid==null || "undefined".equals(hid)) {
			return null;
		}
	    try
	    {
	      result = HttpGetAndPostUtil.net(HttpGetAndPostUtil.url3, params, "GET");//该接口返回的数据是多组酒店数据，hid允许多个
	      ObjectMapper objectMapper = new ObjectMapper();
	      JsonNode resultJsonList = objectMapper.readTree(result);
	      JsonNode resultJson = resultJsonList.elements().next();//此处我们只取一个hid，即只取一组酒店房型数据
	      JsonNode reqdata = resultJson.get("rooms");
	      if (resultJson.get("status").asText().equals("0")) {
	    	  for (Iterator it = reqdata.elements(); it.hasNext(); ){
      	        JsonNode avator = (JsonNode) it.next();
      	        resultList.add(avator);
      	    }
	      }else{
	    	  return null;
	      }
		} catch (Exception e) {
	      System.out.println("查询获取酒店房型信息 请求出现异常:" + e);
	      e.printStackTrace();
	    }
	    return resultList;
	}


}
