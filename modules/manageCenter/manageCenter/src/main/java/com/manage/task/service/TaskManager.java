package com.manage.task.service;

import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;
import com.manage.task.entity.Task;

public interface TaskManager extends BaseManager {
	
	/**
	 * 根据登录用户权限获取任务数据
	 * @param roleId
	 * @return
	 * @throws BusException
	 */
	public List<Task> getAllTasks(String userId) throws BusException;
}
