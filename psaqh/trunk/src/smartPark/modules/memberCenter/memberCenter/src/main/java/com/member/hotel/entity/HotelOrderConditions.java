package com.member.hotel.entity;

import org.hibernate.annotations.Entity;

import com.gsoft.framework.core.dataobj.Domain;

@Entity
public class HotelOrderConditions implements Domain{
	private static final long serialVersionUID = 1473224553868973360L;
    private String hid; //酒店ID
    private String rid;
    private String pid;
    private String agentid;
    private String tm1;
    private String tm2;
    private String latetime;
    private String rm ;//房间数 默认为1
    private String guest;//住店人姓名：入住客人1,入住客人2
    private String mobile;//联系人电话
    
    private String unionid;//下线ID
    private String confirmtype;// 确认方式(noneed|phone|sms)
    private String guid;// (为了避免重复提交订单，需由合作方自行生成，对于不同的订单，需要设置不同的guid值，如果两次提交的订单，guid值相同，我们会认为它是同一订单，不会覆盖原有的订单数据，直接返回原有的订单号。guid格式：778406c2-efff-4262-ab03-70a77d09c2b5)
    private String pucardno;// 信用卡号(如需担保时信用卡信息不能为空，各类文件必须真实有效，否则提交失败)
    private String puyear;// 有效期年（格式：2013）
    private String pucode;//CVV2码（信用卡背面紧跟在卡号末四位号码的后面印刷的3位数字）
    private String pumonth;// 有效期月（格式：01、02.....12）
    private String puname ;//持卡人姓名
    private String puidtype; //0或1或2(分别对应：身份证,护照,其他)
    private String puidno; //证件号码 
    
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAgentid() {
		return agentid;
	}
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	public String getTm1() {
		return tm1;
	}
	public void setTm1(String tm1) {
		this.tm1 = tm1;
	}
	public String getTm2() {
		return tm2;
	}
	public void setTm2(String tm2) {
		this.tm2 = tm2;
	}
	public String getLatetime() {
		return latetime;
	}
	public void setLatetime(String latetime) {
		this.latetime = latetime;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getConfirmtype() {
		return confirmtype;
	}
	public void setConfirmtype(String confirmtype) {
		this.confirmtype = confirmtype;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPucardno() {
		return pucardno;
	}
	public void setPucardno(String pucardno) {
		this.pucardno = pucardno;
	}
	public String getPuyear() {
		return puyear;
	}
	public void setPuyear(String puyear) {
		this.puyear = puyear;
	}
	public String getPucode() {
		return pucode;
	}
	public void setPucode(String pucode) {
		this.pucode = pucode;
	}
	public String getPumonth() {
		return pumonth;
	}
	public void setPumonth(String pumonth) {
		this.pumonth = pumonth;
	}
	public String getPuname() {
		return puname;
	}
	public void setPuname(String puname) {
		this.puname = puname;
	}
	public String getPuidtype() {
		return puidtype;
	}
	public void setPuidtype(String puidtype) {
		this.puidtype = puidtype;
	}
	public String getPuidno() {
		return puidno;
	}
	public void setPuidno(String puidno) {
		this.puidno = puidno;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
