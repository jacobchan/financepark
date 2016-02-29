package com.gsoft.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.common.dao.BaseUserDao;
import com.gsoft.common.service.BaseUserManager;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.security.agt.entity.User;

@Service("baseUserManager")
@Transactional
public class BaseUserManagerImpl extends BaseManagerImpl implements BaseUserManager{
	
	@Autowired
	private BaseUserDao userDao;

	@Override
	public List<User> getUsersByRoles(String[] roles) {
		return userDao.getUsersByRoles(roles);
	}

	@Override
	public List<String> getPhones(String[] userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUserCaption(String[] userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
