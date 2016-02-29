package com.gsoft.common.util;

import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.SecurityUtils;

public class UserUtils {

	/**
	 * 获取登录信息中的人员
	 * @return
	 */
	public static Object getLoginUser(){
		Object principal = SecurityUtils.getPrincipal();
		//
		if(principal == null)return null;
		//
		if(principal instanceof User){
			return (User) principal;
		}
		return null;
	}
}
