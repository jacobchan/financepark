package com.common.MemberManager.entity;

import com.gsoft.framework.security.AccountPrincipal;

public abstract interface IMemberInfomation extends AccountPrincipal{
	public abstract String getLoginType();
}
