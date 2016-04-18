package com.manage.task.entity;

import com.gsoft.framework.security.fuc.entity.Menu;

public class Task {
	private String taskName;
	private String RoleId;
	private String tagTable;
	public String getTagTable() {
		return tagTable;
	}
	public void setTagTable(String tabgable) {
		this.tagTable = tagTable;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	private int taskCount;
	private String menuId;
//	private String path;
	private Menu menu;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
//	public String getPath() {
//		return path;
//	}
//	public void setPath(String path) {
//		this.path = path;
//	}
}
