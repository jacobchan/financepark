package com.gsoft.common.service;

import java.util.List;

import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.security.agt.entity.User;

public interface BaseUserManager extends BaseManager{

	/**根据角色获取用户
	 * @param roles
	 * @return
	 */
	public List<User> getUsersByRoles(String[] roles);
	
	/**通过用户ID获取用户手机号码
	 * @param userId
	 * @return
	 */
	public List<String> getPhones(String[] userId);
	
	/**通过用户ID获取用户名
	 * @param userId
	 * @return
	 */
	public List<String> getUserCaption(String[] userId);
}
