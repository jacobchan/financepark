package com.member.hotel.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.gsoft.framework.core.service.BaseManager;
import com.member.hotel.entity.HotelOrderConditions;

public interface HotelOrderService extends BaseManager{
	public List<JsonNode> getOrderList(String dateandtime);//dateandtime下单日期
	
	public String getOrderInfo(int orderid);//orderid订单号
	/*
	 * 参数  params
	 * hid 酒店ID rid 房间ID pid 计划ID agentid 分销ID tm1 到店日期2010-11-25 tm2
	 * 离店日期2010-11-26 latetime 最晚到店时间18:00(小于8:00为次日) rm 房间数 默认为1 guest
	 * 住店客人姓名：入住客人1,入住客人2 mobile 联系人手机号 18601234567
	 * unionid 下线ID confirmtype
	 * 确认方式(noneed|phone|sms) guid
	 * (为了避免重复提交订单，需由合作方自行生成，对于不同的订单，需要设置不同的guid值，如果两次提交的订单，guid值相同，我们会认为它是同一订单，
	 * 不会覆盖原有的订单数据，直接返回原有的订单号。guid格式：778406c2-efff-4262-ab03-70a77d09c2b5)
	 * pucardno 信用卡号(如需担保时信用卡信息不能为空，各类文件必须真实有效，否则提交失败) puyear 有效期年（格式：2013）
	 * pucode CVV2码（信用卡背面紧跟在卡号末四位号码的后面印刷的3位数字） pumonth 有效期月（格式：01、02.....12）
	 * puname 持卡人姓名 puidtype 0或1或2(分别对应：身份证,护照,其他) puidno 证件号码
	 */
	public List<JsonNode> postBook(String userId,String captcha,HotelOrderConditions hotelOrderConditions);
	
	public String cancelOrder(int orderid);
}
