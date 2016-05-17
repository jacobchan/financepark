/**
 * 代码声明
 */
package com.common.roleMenuManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.purchasingManager.dao.PurchasingmanagerCommodityDao;
import com.common.roleMenuManager.service.RoleMenuManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.agt.dao.UserDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.security.fuc.dao.MenuDao;
import com.gsoft.framework.security.fuc.dao.RoleDao;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.security.fuc.service.MenuManager;
import com.gsoft.framework.security.fuc.service.RoleManager;

@Service("roleMenuManager")
@Transactional
public class RoleMenuManagerImpl extends BaseManagerImpl implements RoleMenuManager{
	@Autowired
	private PurchasingmanagerCommodityDao purchasingmanagerCommodityDao;
	@Autowired
	private RoleManager roleManager;

	@Autowired
	private MenuManager menuManager;
	
	@Autowired
	private UserManager userManager;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
   
	@EsbServiceMapping
	public void removeRole(@ServiceParam(name="roleId") String id) throws BusException{
		Role dbRole=roleManager.getRole(id);
		List<User> userRoleList = purchasingmanagerCommodityDao.getUserRoleListByRoleId(dbRole.getRoleId());
		for(User u:userRoleList){
			User user = (User) this.userDao.get(u.getUserId());
			user.setRoles(null);
			user=userDao.save(user);
		}
		dbRole.setMenus(null);
		dbRole=roleDao.save(dbRole);
		roleDao.remove(id);
	}
	
	@EsbServiceMapping
	public void removeMenu(@ServiceParam(name="menuId") String id) throws BusException{
		//通过菜单编号menuId查询所有关联的角色
		List<String> userRoleList = purchasingmanagerCommodityDao.getUserRoleListByMenuId(id);
		for(String roleId:userRoleList){
			Role dbRole=roleManager.getRole(roleId);
			dbRole.setMenus(null);
			dbRole=roleDao.save(dbRole);
		}
		 this.menuDao.remove(id);
	}
}
