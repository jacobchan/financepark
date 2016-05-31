package com.member.hotel.entity;

import com.gsoft.framework.core.dataobj.Domain;

public class HotelOrderVo implements Domain{

	/**
	 *         "hotelid": 11432,
        "hotelname": "莫泰168(广州天河体育中心林和西地铁站店)",
        "agent_id": 609551,
        "xinghao": "特惠大床房",
        "rztm1": "2016-05-31",
        "rztm2": "2016-06-01",
        "daily_price": "2016-05-31:180$",
        "z_price": 180,
        "rzname": "神龙",
        "orderstatus": 3,
        "formtime": 1464596765,
        "arrivelatetime": "2016-05-31 18:00:00",
        "rooms": 1,
        "estatus": "A",
        "hotelTel": "020-66852999",
        "iscard": 0,
        "cardstatus": ""
	 */
	private static final long serialVersionUID = 1L;
    private String agent_id;//联盟ID
    private String hotelname;// string 酒店名称
    private String xinghao; //string 房间型号
    private String Hotelid; //string 酒店id
    private String hotelTel;//酒店联系方式
    private String rztm1; //string 入住时间
    private String rztm2; //string 离店时间
    private String rzname; //string 客人姓名
    private String rzmobile; //string 客人手机
    private String uptime; //string 订单更新时间
    private String formtime; //int 下单时间
    private String arrivelatetime;//最晚到店时间
    private String orderstatus; //int 订单状态 1，2，3，4，5，6，7，8，9，10分别代表新订单，处理中，已处理，已入住，担保单，取消中，已点评，已取消，延迟单，特殊单。
    private String orderid; //int 订单号
    private String rooms; ///int 房间数量
    private String z_price; //int 订单总价格
    private String daily_price;// string每日价格（2013-05-01:256$2013-05-02:256$2013-05-03:256$）日期和价格以:分隔，多个日期用$分隔 
    
    private String iscard;//是否信用卡担保
    private String cardstatus;//信用卡状态
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getXinghao() {
		return xinghao;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}

	public String getRztm1() {
		return rztm1;
	}
	public void setRztm1(String rztm1) {
		this.rztm1 = rztm1;
	}
	public String getRztm2() {
		return rztm2;
	}
	public void setRztm2(String rztm2) {
		this.rztm2 = rztm2;
	}
	public String getHotelid() {
		return Hotelid;
	}
	public void setHotelid(String hotelid) {
		Hotelid = hotelid;
	}
	public String getHotelTel() {
		return hotelTel;
	}
	public void setHotelTel(String hotelTel) {
		this.hotelTel = hotelTel;
	}
	public String getRzname() {
		return rzname;
	}
	public void setRzname(String rzname) {
		this.rzname = rzname;
	}
	public String getArrivelatetime() {
		return arrivelatetime;
	}
	public void setArrivelatetime(String arrivelatetime) {
		this.arrivelatetime = arrivelatetime;
	}
	public String getRzmobile() {
		return rzmobile;
	}
	public void setRzmobile(String rzmobile) {
		this.rzmobile = rzmobile;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getFormtime() {
		return formtime;
	}
	public void setFormtime(String formtime) {
		this.formtime = formtime;
	}
	public String getOrderstatus() {
		switch (Integer.parseInt(this.orderstatus)) {
		case 1:
			return "新订单";
		case 2:
			return "处理中";
		case 3:
			return "已处理";
		case 4:
			return "已入住";
		case 5:
			return "担保单";
		case 6:
			return "取消中";
		case 7:
			return "已点评";
		case 8:
			return "已取消";
		case 9:
			return "延迟单";

		default:
			return "特殊单";
		}
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	public String getZ_price() {
		return z_price;
	}
	public void setZ_price(String z_price) {
		this.z_price = z_price;
	}
	public String getDaily_price() {
		return daily_price;
	}
	public void setDaily_price(String daily_price) {
		this.daily_price = daily_price;
	}
	public String getIscard() {
		return iscard;
	}
	public void setIscard(String iscard) {
		this.iscard = iscard;
	}
	public String getCardstatus() {
		return cardstatus;
	}
	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}
    
}
