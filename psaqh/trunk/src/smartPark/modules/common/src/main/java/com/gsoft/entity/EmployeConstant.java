package com.gsoft.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeConstant {

	public static Map<String,String> properties = new HashMap<String,String>();//key为entity属性，value为xls文件头行
	public static Map<String,String> employMap = new HashMap<String, String>();
	
	static{
		employMap.put("employeesDepartment","所属部门");
		employMap.put("createTime","加入时间");
	}
	static{
		properties.put("memberName", "姓名");
		properties.put("memberPhoneNumber", "电话");
		properties.put("memberBirthdate", "出生年月");
		properties.put("memberNickname","昵称");
		properties.put("memberDescribe2","简介");
		properties.put("companyId","所在企业");
		//会员属性
		properties.putAll(employMap);
	}
	
	public static List<String> header = new ArrayList<String>();//和excel模板头相同顺序
	static{
		header.add("memberName");
		header.add("memberPhoneNumber");
		header.add("memberBirthdate");
		header.add("employeesDepartment");
		header.add("createTime");
		header.add("memberNickname"); 
		header.add("memberDescribe2");
		header.add("companyId");
	}
	
	public static boolean isEmploye(String key){
		return employMap.containsKey(key);
	}
}
