/**
 * 
 */
package com.member.ticket.entity;

import org.hibernate.annotations.Entity;

import com.gsoft.framework.core.dataobj.Domain;

/**
 * @author TF
 *	退废票申请种类的对象。
 *	获取到的申请种类在<订单申请退废票>接口的actionType使用。
 */
@Entity
public class WSRefundActionType implements Domain{

	private static final long serialVersionUID = 1L;
	private String actionTypeCode;//申请种类代码
	private String description;//申请种类描述
	private String effectiveDate;//生效日期
	private String expirationDate;//失效日期
	private String state; //当前状态
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	public String getActionTypeCode() {
		return actionTypeCode;
	}
	public void setActionTypeCode(String actionTypeCode) {
		this.actionTypeCode = actionTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getParam4() {
		return param4;
	}
	public void setParam4(String param4) {
		this.param4 = param4;
	}

}
