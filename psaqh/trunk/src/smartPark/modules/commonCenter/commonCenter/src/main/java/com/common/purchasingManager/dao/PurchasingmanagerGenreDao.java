/**
 * 代码声明
 */
package com.common.purchasingManager.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.common.purchasingManager.entity.PurchasingmanagerGenre;

public interface PurchasingmanagerGenreDao extends Dao<PurchasingmanagerGenre, String>  {
	//得到类别根列表
	public List<PurchasingmanagerGenre> getRootList();
	
}