package com.gsoft.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gsoft.common.dao.BaseUserDao;
import com.gsoft.common.service.BaseUserManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.DomainCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.PrincipalConfig;
import com.gsoft.framework.security.agt.dao.UserConfigItemDao;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.entity.UserConfigItem;

@Service("baseUserManager")
@Transactional
public class BaseUserManagerImpl extends BaseManagerImpl implements BaseUserManager{
	
	@Autowired
	private BaseUserDao userDao;
	@Autowired
	private UserConfigItemDao userConfigItemDao;

	@Override
	public List<User> getUsersByRoles(String[] roles) {
		return userDao.getUsersByRoles(roles);
	}

	@Override
	public String[] getPhonesByRole(String roleId) {
		List<User> users = getUsersByRoles(new String[]{roleId});
		List<String> phones = null;
		if(users!=null&&users.size()>0){
			phones = new ArrayList<String>();
			for(User user:users){
				PrincipalConfig principalConfig = user.getPrincipalConfig();
				if(principalConfig!=null){
					phones.add(principalConfig.get("phone"));
				}
			}
		}
		return phones==null?null:phones.toArray(new String[phones.size()]);
	}

	@EsbServiceMapping
	public List<UserConfigItem> getUserConfigItems(@ServiceParam(name="userId") String userId) {
		return  this.userConfigItemDao.getList("userId", userId);
	}

	@EsbServiceMapping
	public void saveUserConfigItems(@ServiceParam(name="userId") String userId
			,@DomainCollection(domainClazz=UserConfigItem.class) List<UserConfigItem> userConfigItems) {
		if(userConfigItems!=null&&userConfigItems.size()>0){
			List<UserConfigItem> configs = userConfigItemDao.getList(new String[]{"userId"}, new String[]{userId});
			if(configs!=null){
				for(UserConfigItem config:configs){
					if(!contant(userConfigItems, config.getId())){
						userConfigItemDao.remove(config.getId());
					}
				}
			}
			
			String propertyName = "";
			for(UserConfigItem userConfigItem:userConfigItems){
				if(propertyName.contains(userConfigItem.getName())){
					throw new BusException("存在相同属性名:"+userConfigItem.getName()+"！");
				}
				propertyName += userConfigItem.getName();
				String id = userConfigItem.getId();
				if(StringUtils.isEmpty(userConfigItem.getUserId())){
					userConfigItem.setUserId(userId);
				}
				userConfigItemDao.save(userConfigItem);
			}
		}

	}
	
	private boolean contant(List<UserConfigItem> userConfigItems,String configId){
		if(userConfigItems!=null){
			for(UserConfigItem userConfigItem:userConfigItems){
				if(configId.equals(userConfigItem.getId())){
					return true;
				}
			}
		}
		return false;
		
	}
	
}
