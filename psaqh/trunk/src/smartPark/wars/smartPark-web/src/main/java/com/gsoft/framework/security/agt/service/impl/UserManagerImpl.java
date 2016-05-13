package com.gsoft.framework.security.agt.service.impl;
import com.gsoft.framework.core.dataobj.tree.TreeNode;
import com.gsoft.framework.core.dataobj.tree.TreeUtils;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.menu.IMenu;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.DefaultLoginFormToken;
import com.gsoft.framework.security.IAgency;
import com.gsoft.framework.security.IRealmUserInfo;
import com.gsoft.framework.security.IRealmUserToken;
import com.gsoft.framework.security.IUser;
import com.gsoft.framework.security.IUserAdapter;
import com.gsoft.framework.security.PasswordService;
import com.gsoft.framework.security.PrincipalConfig;
import com.gsoft.framework.security.agt.dao.UserConfigItemDao;
import com.gsoft.framework.security.agt.dao.UserDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.entity.UserAccount;
import com.gsoft.framework.security.agt.entity.UserConfigItem;
import com.gsoft.framework.security.agt.service.AgencyManager;
import com.gsoft.framework.security.agt.service.UserLoginService;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.security.fuc.dao.RoleDao;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.gsoft.framework.security.fuc.service.MenuManager;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service("userManager")
@Transactional
public class UserManagerImpl extends BaseManagerImpl implements UserManager,
		UserLoginService<User>, IUserAdapter<User, DefaultLoginFormToken>,
		PasswordService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserConfigItemDao userConfigItemDao;

	@Autowired
	private MenuManager menuManager;

	@Autowired
	private AgencyManager agencyManager;

	@Autowired(required = false)
	private UserPasswordService passwordService;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> getUsers() throws BusException {
		return this.userDao.getAll();
	}

	@EsbServiceMapping
	public List<User> getUsers(
			@ConditionCollection(domainClazz = User.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return this.userDao.commonQuery(conditions, orders);
	}

	@EsbServiceMapping(trancode = "91010201")
	public User getUser(@ServiceParam(name = "userId") String id) {
		return (User) this.userDao.getInitializeObject(id,
				new String[] { "roles" });
	}

	@EsbServiceMapping
	public PagerRecords getPagerUsers(
			Pager pager,
			@ConditionCollection(domainClazz = User.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = this.userDao.findByPager(pager, conditions,
				orders);
		return pagerRecords;
	}

	@EsbServiceMapping
	public User saveUser(User o) throws BusException {
		String userId = o.getUserId();
		boolean isUpdate = StringUtils.isNotEmpty(userId);
		if (isUpdate) {
			User user = (User) this.userDao.get(userId);
			if(null!=o.getPassword() && !"".equals(o.getPassword())){
				o.setPassword(this.passwordService.hashPassword(o.getPassword()).toHex());
			}else{
				o.setPassword(user.getPassword());
			}
		} else {
			if(null!=o.getPassword() && !"".equals(o.getPassword())){
				o.setPassword(this.passwordService.hashPassword(o.getPassword()).toHex());
			}else{
				o.setPassword(this.passwordService.hashPassword("123456").toHex());
			}
		}
		return (User) this.userDao.save(o);
	}

	@EsbServiceMapping(trancode = "010101", caption = "")
	public void removeUser(@ServiceParam(name = "userId") String id)
			throws BusException {
		this.userDao.remove(id);
	}

	public void removeUsers(String[] ids) throws BusException {
		for (String id : ids)
			removeUser(id);
	}

	public boolean exsitUser(String id) throws BusException {
		return this.userDao.exists(id);
	}

	public boolean exsitUser(String propertyName, Object value)
			throws BusException {
		return this.userDao.exists(propertyName, value);
	}

	public List<IMenu> getProviderMenus() {
		Collection orders = new ArrayList();
        orders.add(ConditionUtils.getOrder("menuNum", true));
        List menus = menuManager.getMenus(null, orders);
        List providerMenus = new ArrayList();
        Menu menu;
        for(Iterator iterator = menus.iterator(); iterator.hasNext(); providerMenus.add(menu))
            menu = (Menu)iterator.next();

        return providerMenus;
	}

	@EsbServiceMapping
	public void modifyPassword(
			@ServiceParam(name = "username") String username,
			@ServiceParam(name = "password") String password,
			@ServiceParam(name = "confirmPassword") String confirmPassword,
			@ServiceParam(name = "oldPassword") String oldPassword)
			throws BusException {
		Assert.notNull(oldPassword, "旧密码不能为空！");
		Assert.notNull(password, "新密码不能为空！");
		Assert.notNull(confirmPassword, "确认密码不能为空！");

		User user = null;
		try {
			user = (User) this.userDao.getObjectByUniqueProperty("loginName",
					username);
		} catch (Exception e) {
			throw new BusException("查找用户[" + username + "]出错！");
		}
		Assert.notNull(user, "未找到用户！");

		if (!this.passwordService.hashPassword(oldPassword).toHex()
				.equals(user.getPassword())) {
			throw new BusException("请输入正确的旧密码！");
		}

		if (!password.equals(confirmPassword)) {
			throw new BusException("两次输入的密码不一致！");
		}

		user.setPassword(this.passwordService.hashPassword(password).toHex());
		saveUser(user);
	}

	@EsbServiceMapping
	public void resetPassword(@ServiceParam(name = "id") String id)
			throws BusException {
		User user = getUser(id);
		Assert.notNull(user, "未找到用户！");
		user.setPassword(PasswordUtils.md5Password("123456"));
		saveUser(user);
	}

	private PrincipalConfig queryPrincipalConfig(String userId) {
		PrincipalConfig principalConfig = new PrincipalConfig();
        List configItems = userConfigItemDao.getList("userId", userId);
        for(Iterator iterator = configItems.iterator(); iterator.hasNext();)
        {
            UserConfigItem configItem = (UserConfigItem)iterator.next();
            if(StringUtils.isNotEmpty(configItem.getName()))
                principalConfig.put(configItem.getName(), configItem.getValue());
        }

        return principalConfig;
	}

	public TreeNode getAgencyTree() {
		TreeNode tree = TreeUtils.listToHtmlTree(
				this.agencyManager.getAgencys(), null, "机构");
		tree.setId("TREE_ROOT_AGENCY");
		return tree;
	}

	public List<IAgency> getAgencyByParent(String parentAgencyId) {
		List agencys = new ArrayList();
		agencys.addAll(this.agencyManager.getAgencyChildren(parentAgencyId));
		return agencys;
	}

	public boolean supports(IRealmUserToken token) {
		return DefaultLoginFormToken.class.isAssignableFrom(token.getClass());
	}

	public boolean supports(IUser user) {
		return User.class.isAssignableFrom(user.getClass());
	}

	public IRealmUserInfo getRealmUserInfo(DefaultLoginFormToken token) {
		return getUserInfoByUsername(token.getUsername());
	}

	public IRealmUserInfo getRealmUserInfo(User user) {
		return getUserInfoByUsername(user.getLoginName());
	}

	private IRealmUserInfo getUserInfoByUsername(String username) {
		User user = getLoginUser(username);

		if (user == null)
			return null;

		user.setPrincipalConfig(queryPrincipalConfig(user.getUserId()));

		UserAccount loginUser = new UserAccount(user);

		return loginUser;
	}

	@EsbServiceMapping
	public User getLoginUser(@ServiceParam(name = "username") String username) {
		User user = (User) this.userDao.getObjectByUniqueProperty("loginName",
				username, new String[] { "roles" });
		return user;
	}

	public List<String> getAccountMenus(User user) {
		return this.roleDao.getMenuIdsByRoles(user.roleIds());
	}

	@EsbServiceMapping
	public List<String> getAccountMenus(
			@ServiceParam(name = "username") String username) {
		User user = (User) this.userDao.getObjectByUniqueProperty("loginName",
				username, new String[] { "roles" });
		if (user == null) {
			return null;
		}
		return getAccountMenus(user);
	}
}