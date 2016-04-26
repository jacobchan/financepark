/**
 * 代码声明
 */
package com.common.MessageCenter.dao;

import com.common.MessageCenter.entity.Code;
import com.common.MessageCenter.entity.McMsgdatas;
import com.gsoft.framework.core.dao.Dao;

public interface McMsgdatasDao extends Dao<McMsgdatas, String>  {
	
	public Code getNewCode(String phone);
	
}