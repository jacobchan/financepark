package com.gsoft.common.service;

import java.util.List;

import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.entity.UserConfigItem;

public interface BaseUserManager extends BaseManager{

	/**根据角色获取用户
	 * @param roles
	 * @return
	 */
	public List<User> getUsersByRoles(String[] roles);
	/**
	 * 通过角色获取对应的电话号码
	 * @param roleId
	 * @return
	 */
	public String[] getPhonesByRole(String roleId);
	
	
	/**用户配置信息
	 * @param id
	 * @return
	 */
	public List<UserConfigItem> getUserConfigItems(String id);
	
	/**保存用户配置信息
	 * @param userConfigItem
	 * @param userId
	 */
	public void saveUserConfigItems(String userId, List<UserConfigItem> userConfigItems);
}
