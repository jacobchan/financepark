/**
 * 代码声明
 */
package com.manage.task.dao;

import com.gsoft.framework.core.dao.Dao;
import com.manage.task.entity.Task;

public interface TaskDao extends Dao<Task, String>  {
	/**
	 * 查询任务总数
	 * @param tableName
	 * @param filter
	 * @return
	 */
	public String getTaskCount(String tableName, String filter);
	
}