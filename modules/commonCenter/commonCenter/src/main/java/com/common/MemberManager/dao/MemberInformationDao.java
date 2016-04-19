/**
 * 代码声明
 */
package com.common.MemberManager.dao;

import java.util.List;

import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.framework.core.dao.Dao;

public interface MemberInformationDao extends Dao<MemberInformation, String>  {
	
	public List<MemberInformation> getMembersByRole(String role);
	
}