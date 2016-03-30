package com.common.ExtentionAtrManager.entity;

/**
 * 工位商品扩展属性
 * @author jack
 *
 */
public class GwEntity {
	
	private String commodityId;//创立方Id
	
	public String getCommodityIdfieldName() {
		return "commodityId";
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	
}
