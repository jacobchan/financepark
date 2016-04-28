package com.member.hotel.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.service.BaseManager;
import com.member.hotel.entity.HotelConditions;


public interface HotelInfoService extends BaseManager{
	/*
	 * 调用方式 GET 参数 agent_id 联盟ID agent_md 联盟加密字符串 cid 城市ID params 可选参数： pagesize
	 * int 每页显示多少记录 pg int 第几页 px int 酒店排序方式0自然排序 1网站默认 2价格由低到高 3星级由低到高
	 * 4客户评价由高到低 5距离排序（在按地标，坐标查询时可用） minprice int 最小价格 （一般与maxprice使用） maxprice
	 * int 最大价格 (一般与minprice使用) hn string 酒店关键字 cityname string 城市名称 lsid int
	 * 连锁id bid string 商业区id areaid string 行政区id（如北京：朝阳区 0003） rank int 星级
	 * (2,3,4,5二星，三星，四星，五星) hid int 酒店id x int 经度 y int 纬度 lng float 经度 lat
	 * float 纬度 juli int 根据经纬度查询时的搜索半径（单位米，最大为3000米） field string 输出字段名(区分大小写
	 * 例:field=ID,HotelName,Address)，参考酒店数据结构 key string 地标名称 (utf-8
	 * 进行urlEncode编码,不推荐效率较低，推荐用经纬度查询) promotion 1为只显示特惠酒店 （由于数量较少建议只加城市id和此参数）
	 * is_kezhan 1为只显示客栈类型的酒店
	 */
//	public List<JsonNode> searchHotelByConditions(String agent_id, String agent_md, String cid, int pagesize,
//			int pg, int px, int minprice, int maxprice, String hn, String cityname, 
//			int lsid, String bid, String areaid, int rank, int hid, float lng,float lat,
//			int juli,int promotion, int is_kezhan) throws BusException;
	
	public List<JsonNode> searchHotelByConditions(HotelConditions conditions) throws BusException;
	
	public List<JsonNode> searchHotel(String cid) throws BusException;//is pagesize,pg,px,minprice,maxprice,rank

	// 酒店详情
	public List<JsonNode> getHotelInfo(String hid) throws BusException;

	// 某城市的酒店评论
	public List<JsonNode> getCityHotelComment(String cityid, int pagesize, int page) throws BusException;// params
																									// 包含cityid城市ID
																									// pagesize每页显示几条评论
																									// page第几页
	// 某酒店的评论
	public List<JsonNode> getHotelComment(String hid,String nums) throws BusException;

	// 某酒店的图片
	public List<JsonNode> getHotelPic(String hid) throws BusException;

	// 某城市的酒店附近
	public String getHotelNearby(Collection<Condition> conditions) throws BusException;// params
																								// 包含lng经度
																								// lat纬度
																								// pagesize每页显示几条评论
																								// page第几页
	//获取酒店房型信息
	public List<JsonNode> getHotelData(String hid,String tm1, String tm2) throws BusException;

	
}
