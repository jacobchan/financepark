/**
 * 代码声明
 */
package com.common.MessageCenter.dao;

import java.util.List;

import com.common.MessageCenter.entity.McMsgdatas;
import com.gsoft.framework.core.dao.Dao;
import com.gsoft.framework.security.agt.entity.User;

public interface McMsgdatasDao extends Dao<McMsgdatas, String>  {
	
	public List<User> getUsersByRoles(String[] roles);
	
}