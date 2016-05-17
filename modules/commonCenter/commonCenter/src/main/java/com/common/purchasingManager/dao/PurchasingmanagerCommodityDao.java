/**
 * 代码声明
 */
package com.common.purchasingManager.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.common.purchasingManager.entity.PurchasingmanagerCommodity;

public interface PurchasingmanagerCommodityDao extends Dao<PurchasingmanagerCommodity, String>  {

	List<User> getUserRoleListByRoleId(String roleId);

	List<String> getUserRoleListByMenuId(String id);
	
}