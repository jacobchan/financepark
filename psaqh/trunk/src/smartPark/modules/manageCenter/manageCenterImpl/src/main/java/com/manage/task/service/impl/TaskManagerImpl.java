package com.manage.task.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.security.fuc.entity.Menu;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.security.fuc.service.MenuManager;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerBxManager;
import com.manage.task.dao.TaskDao;
import com.manage.task.entity.Task;
import com.manage.task.service.TaskManager;;

@Service("taskManager")
@Transactional
public class TaskManagerImpl implements TaskManager {
	
	@Autowired
	private PropertyservicemanagerBxManager bxManager;
	@Autowired
	private MenuManager menuManager;
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserManager userManager;
	
	/**
	 * 初始化所欲任务数据
	 * @return
	 */
	private List<Task> InitAllTaskData(){
		//sp_propertyservicemanager_oc - 一卡通
				//sp_propertyservicemanager_entrec 入驻
				//sp_propertyservicemanager_moverec 搬家
				//sp_propertyservicemanager_cos 投诉
				//sp_propertyservicemanager_bx 报修
				//sp_reservation_record 招商预约
				//sp_policy_apply 政策申请
				//sp_finace 融资申请
				//sp_entrepreneurship 创业加速申请
		String task1 = "sp_propertyservicemanager_oc,一卡通办理,ROLE_OPER_ADMIN,200205,OC_STATUS_ = '01'";
		String task2 = "sp_propertyservicemanager_entrec,入驻预约,ROLE_TEND_ADMIN,100101,ENTERREC_STATUS_ = '01'";
		String task3 = "sp_propertyservicemanager_moverec,搬家,ROLE_TEND_ADMIN,100101,MOVEREC_STATUS_ = '01'";
		String task4 = "sp_propertyservicemanager_cos,投诉处理,ROLE_TEND_ADMIN,100101,COS_STATUS_ = '01'";
		String task5 = "sp_propertyservicemanager_bx,报修处理,ROLE_TEND_ADMIN,100101,BX_STATUS_ = '01'";
		String task6 = "sp_reservation_record,招商预约,ROLE_TEND_ADMIN,100101,RECORD_STATUS = '01'";
		String task7 = "sp_policy_apply,政策申请,ROLE_TEND_ADMIN,100101,POLICY_APPLY_STATUS_ = '01'";
//		String task8 = "sp_finace,融资申请,ROLE_TEND_ADMIN,100101,OC_STATUS_ = '01'";
//		String task9 = "sp_entrepreneurship,创业加速申请,ROLE_TEND_ADMIN,100101,OC_STATUS_ = '01'";
		List<Task> allTask = new ArrayList<Task>();
		allTask.add(getTask(task1));
		allTask.add(getTask(task2));
		allTask.add(getTask(task3));
		allTask.add(getTask(task4));
		allTask.add(getTask(task5));
		allTask.add(getTask(task6));
		allTask.add(getTask(task7));
//		allTask.add(getTask(task8));
//		allTask.add(getTask(task9));
		
		return allTask;
		
	}
	
	private Task getTask(String taskStr){
		Task task = new Task();
		String[] strs = taskStr.split(",");
		task.setTagTable(strs[0]);
		task.setTaskName(strs[1]);
		task.setRoleId(strs[2]);
		task.setMenuId(strs[3]);
		Menu menu = getMenu(strs[3]);
		task.setMenu(menu);
		task.setMenuSrc(menu.getMenuSrc());
		task.setTaskCount(getTaskCount(strs[0], strs[4]));
		return task;
	}
	
	/**
	 * 通过MenuId获取Menu对象
	 * @param menuId
	 * @return
	 */
	private Menu getMenu(String menuId){
		return menuManager.getMenu(menuId);
	}
	
	/**
	 * 获取待处理任务的总条数
	 * @param tableName
	 * @param filter
	 * @return
	 */
	private int getTaskCount(String tableName,String filter){
		int taskCount = 0;
		// TO DO
		// 根据状态条件查询需要处理的任务总条数
//		String querySQL = "select count(ID_) from {0} where {1}";
		String str = taskDao.getTaskCount(tableName, filter);
		taskCount = Integer.parseInt(str);
		return taskCount;
	}
	
	
	@Override
	@EsbServiceMapping
	public List<Task> getAllTasks(@ServiceParam(name="userId",pubProperty="userId") String userId) throws BusException {
		// TODO Auto-generated method stub
		User user = userManager.getUser(userId);
		List<Role> roles = user.getRoles();
		List<Task> allTask = this.InitAllTaskData();
		List<Task> resultTask = new ArrayList<Task>();
		for (Task task : allTask) {
			for(Role role:roles){
				if(task.getRoleId().equals(role.getRoleId())){
					resultTask.add(task);
				}
			}
		}
		return resultTask;
	}

}
