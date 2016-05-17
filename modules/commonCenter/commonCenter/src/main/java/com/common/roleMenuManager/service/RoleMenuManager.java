/**
 * 代码声明
 */
package com.common.roleMenuManager.service;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;

public interface RoleMenuManager extends BaseManager{

	/**
	 * 删除用户角色
	 * @param id
	 * @throws BusException
	 */
	public void removeRole( String id) throws BusException;
	/**
	 * 删除系统菜单
	 * @param id
	 * @throws BusException
	 */
	public void removeMenu(String id) throws BusException;
}
