package com.gsoft.common.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.gsoft.framework.security.agt.entity.User;

public interface UserDao extends Dao<User, String> {

	public List<User> getUsersByRoles(String[] roles);

}
