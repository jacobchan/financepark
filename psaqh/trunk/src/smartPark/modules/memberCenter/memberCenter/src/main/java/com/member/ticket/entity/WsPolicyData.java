package com.member.ticket.entity;

import org.hibernate.annotations.Entity;

@Entity
public class WsPolicyData {
	private Integer policyId;//	政策ID	Integer	是	
	private String commisionPoint;//	政策返点	String	是	
	private Double commisionMoney;//	返现	Double		可以是正负值，正值表示给客人返现，负值表示留钱。把一代加上金额，买家支付手续费，买家服务费，都合起来算在这个字段里
	private Integer needSwitchPNR;//	是否更换PNR	Integer	是	1 更换
	private String policyType;//	政策类型	String	是	B2B 航空公司网站政策;	BSP 中性票政策	不限;
	private Integer seatType;//	舱位类型	Integer	是	普通舱位政策还是特价舱位政策	1普通舱位	3特殊折扣舱位
	private String workTime;//	供应商工作时间	String	是	出票工作时间
	private String vtWorkTime;//	废票时间	String	是	
	private Integer policyBelongTo;//	政策归属	Integer	是	1 上级代理政策 2 异地政策 3 自己政策
	private Integer commisionType;//	是否特殊政策	Integer	是	0 普通政策	1 特殊政策
	private String comment;//	政策备注	String	否
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public String getCommisionPoint() {
		return commisionPoint;
	}
	public void setCommisionPoint(String commisionPoint) {
		this.commisionPoint = commisionPoint;
	}
	public Double getCommisionMoney() {
		return commisionMoney;
	}
	public void setCommisionMoney(Double commisionMoney) {
		this.commisionMoney = commisionMoney;
	}
	public Integer getNeedSwitchPNR() {
		return needSwitchPNR;
	}
	public void setNeedSwitchPNR(Integer needSwitchPNR) {
		this.needSwitchPNR = needSwitchPNR;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public Integer getSeatType() {
		return seatType;
	}
	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getVtWorkTime() {
		return vtWorkTime;
	}
	public void setVtWorkTime(String vtWorkTime) {
		this.vtWorkTime = vtWorkTime;
	}
	public Integer getPolicyBelongTo() {
		return policyBelongTo;
	}
	public void setPolicyBelongTo(Integer policyBelongTo) {
		this.policyBelongTo = policyBelongTo;
	}
	public Integer getCommisionType() {
		return commisionType;
	}
	public void setCommisionType(Integer commisionType) {
		this.commisionType = commisionType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
