package com.member.hotel.entity;

import org.hibernate.annotations.Entity;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
public class HotelConditions implements Domain { 
	
	private static final long serialVersionUID = 1473224553868973360L;
	
	private String cid;//城市ID
	private String pagesize;//一页多少记录，默认10条
	private String pg;//第几页
	private String px;//酒店排序方式0自然排序 1网站默认 2价格由低到高 3星级由低到高 * 4客户评价由高到低 5距离排序（在按地标，坐标查询时可用）
	private String minprice; //最低价格
	private String maxprice; //最高价格
	private String hn;//酒店关键字
	private String cityname; //城市名
	private String lsid;//连锁ID
	private String bid;//商业圈ID
	private String areaid; //行政区ID
	private String rank; //星级 (2,3,4,5二星，三星，四星，五星)
	private String hid; //酒店ID
	private String lng;//经度
	private String lat;//纬度
	private String juli;//距离
	private String promotion;//是否特惠  1为只显示特惠酒店
	private String is_kezhan;//是否为客栈  1为只显示客栈类型的酒店
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getPx() {
		return px;
	}
	public void setPx(String px) {
		this.px = px;
	}
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}
	public String getHn() {
		return hn;
	}
	public void setHn(String hn) {
		this.hn = hn;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getLsid() {
		return lsid;
	}
	public void setLsid(String lsid) {
		this.lsid = lsid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getJuli() {
		return juli;
	}
	public void setJuli(String juli) {
		this.juli = juli;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getIs_kezhan() {
		return is_kezhan;
	}
	public void setIs_kezhan(String is_kezhan) {
		this.is_kezhan = is_kezhan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
