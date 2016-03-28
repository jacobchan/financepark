package com.common.ExtentionAtrManager.entity;

/**
 * 车辆商品扩展属性
 * @author jack
 *
 */
public class AgencyBookEntity {
	
	private String serviceTerm;//服务期限
	
	public String getServiceTermfieldName() {
		return "serviceTerm";
	}

	public String getServiceTerm() {
		return serviceTerm;
	}

	public void setServiceTerm(String serviceTerm) {
		this.serviceTerm = serviceTerm;
	}
	
}
