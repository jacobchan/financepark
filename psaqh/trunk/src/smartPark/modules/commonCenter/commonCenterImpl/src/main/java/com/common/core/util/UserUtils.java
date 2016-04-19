package com.common.core.util;

import java.util.List;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.util.SecurityUtils;

public class UserUtils {

	/**
	 * 获取登录信息中的人员
	 * @return
	 */
	public static String getLoginUserId(){
		Object principal = SecurityUtils.getPrincipal();
		//
		if(principal == null)return null;
		//后台用户登录
		if(principal instanceof User){
			return ((User) principal).getUserId();
		}
		//会员用户登录
		if(principal instanceof MemberInformation){
			return ((MemberInformation) principal).getMemberId();
		}
		return null;
	}
	
	public static List<String> getLoginRoleIds(){
		AccountPrincipal account = SecurityUtils.getAccount();
		if(account == null)
			return null;
		else 
			return account.roleIds();
	}
}
