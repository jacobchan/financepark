/**
 * 代码声明
 */
package com.common.purchasingManager.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;

public interface PurchasingmanagerGenreDao extends Dao<PurchasingmanagerGenre, String>  {
	/**
	 * 获取所有的采购餐饮类别列表
	 * @return
	 */
	public List<PurchasingmanagerGenre> getPurFoodGenresList();
	/**
	 * 获取所有的订单类型列表
	 * @return
	 */
	public List<PurchasingmanagerGenre> getOrderTypesList();
	
}