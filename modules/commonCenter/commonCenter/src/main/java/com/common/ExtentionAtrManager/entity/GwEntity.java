package com.common.ExtentionAtrManager.entity;

/**
 * 工位商品扩展属性
 * @author jack
 *
 */
public class GwEntity {
	
	private String commodityId;//创立方Id
	
	private String commodityName;//创立方名称
	
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

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
