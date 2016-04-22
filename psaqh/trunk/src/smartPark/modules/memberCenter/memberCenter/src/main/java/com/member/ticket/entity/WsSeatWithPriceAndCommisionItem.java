package com.member.ticket.entity;

import org.hibernate.annotations.Entity;

@Entity
public class WsSeatWithPriceAndCommisionItem {
	private String flightNo;//	航班号	String	是	
	private String seatCode;//	舱位码	String	是	
	private String seatStatus;/*舱位状态	String	是	A可以提供9个以上座位;
								1-9 可以提供1-9个座位,系统显示具体的可利用座位数;
								L 没有可利用座位,但旅客可以候补;
								Q 永久申请状态,没有可利用座位,但可以申请(HN);
								S 因达到限制销售数而没有可利用座位,但可以候补;
								C 该等级彻底关闭,不允许候补或申请;
								X 该等级取消, 不允许候补或申请;
								Z 可利用情况不明,这种情况有可能在外航航班上出现*/
	private Double discount;//	折扣	Double	是	
	private String seatMsg;//	舱位说明	String	是	经济舱; 超级经济舱;头等舱;特价舱;
	private Integer parPrice;//	票面价	Integer	是	
	private String seatType;//	是否特价舱位	String	是	1 普通舱位	3 特价舱位

	private WsPolicyData policyData;//	政策信息	WsPolicyData	是	见 WSPolicyData对象

	private Double settlePrice;//	成人的结算价	Double	是	根据 commisionPoint 和commisionMoney算出来的净价

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getSeatMsg() {
		return seatMsg;
	}

	public void setSeatMsg(String seatMsg) {
		this.seatMsg = seatMsg;
	}

	public Integer getParPrice() {
		return parPrice;
	}

	public void setParPrice(Integer parPrice) {
		this.parPrice = parPrice;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public WsPolicyData getPolicyData() {
		return policyData;
	}

	public void setPolicyData(WsPolicyData policyData) {
		this.policyData = policyData;
	}

	public Double getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(Double settlePrice) {
		this.settlePrice = settlePrice;
	}
	
}
