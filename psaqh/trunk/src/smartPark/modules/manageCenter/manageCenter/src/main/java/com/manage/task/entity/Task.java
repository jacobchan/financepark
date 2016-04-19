package com.manage.task.entity;

import com.gsoft.framework.security.fuc.entity.Menu;

public class Task {
	private String taskName;//任务名
	private String RoleId;//角色ID
	private String tagTable;//表名
	private int taskCount;//任务数
	private String menuId;//菜单ID
	private Menu menu;//菜单
	private String menuSrc;//菜单地址
	
	public String getMenuSrc() {
		return menuSrc;
	}
	public void setMenuSrc(String menuSrc) {
		this.menuSrc = menuSrc;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getTagTable() {
		return tagTable;
	}
	public void setTagTable(String tagTable) {
		this.tagTable = tagTable;
	}
	public int getTaskCount() {
		return taskCount;
	}
	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	
}
