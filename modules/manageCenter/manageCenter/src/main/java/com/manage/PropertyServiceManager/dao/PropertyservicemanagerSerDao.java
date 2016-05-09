/**
 * 代码声明
 */
package com.manage.PropertyServiceManager.dao;

import java.util.List;

import com.gsoft.framework.core.dao.Dao;
import com.gsoft.framework.core.dataobj.Record;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerSer;

public interface PropertyservicemanagerSerDao extends Dao<PropertyservicemanagerSer, String>  {
	
	/**
	 * 根据派工id获取维修材料
	 * @param id
	 * @param distCode
	 * @return
	 */
	public List<Record> querySerList(String id);
	
}