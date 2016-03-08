package com.common.MemberManager.entity;

import com.gsoft.framework.security.AbstractFormUserInfo;


public class MemberUserInfo extends AbstractFormUserInfo {
	private static final long serialVersionUID = -7041130519708356120L;

	  public MemberUserInfo(MemberInformation member)
	  {
	    super(member, member.getPassword());
	  }
}
