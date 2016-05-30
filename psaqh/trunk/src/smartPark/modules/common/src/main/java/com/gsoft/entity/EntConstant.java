package com.gsoft.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntConstant {

	public static Map<String,String> properties = new HashMap<String,String>();//key为entity属性，value为xls文件头行
	public static Map<String,String> legalMap = new HashMap<String, String>();
	
	static{
		legalMap.put("legalName","创世人姓名");
		legalMap.put("legalBirthday","出生日期");
		legalMap.put("legalTelephone","联系电话");
		legalMap.put("legalBusiness","职位");
		legalMap.put("legalRemark","创始人描述");
	}
	static{
		properties.put("rzName", "企业名称");
		properties.put("rzBuss", "企业管理员电话");
		properties.put("enTypeId", "所在行业");
		properties.put("rzProperty", "企业性质"); 
		properties.put("rzType", "上市类型");
		properties.put("rzUrl", "公司网址");
		properties.put("rzRemark", "公司介绍");
		properties.put("productDiscriptio", "产品描述");
		//法人信息
		properties.putAll(legalMap);
	}
	
	public static List<String> header = new ArrayList<String>();//有序，与实体属性对应，同时与excel头行顺序一致
	static{
		header.add("rzName");
		header.add("rzBuss");
		header.add("enTypeId");
		header.add("rzProperty");
		header.add("rzType");
		header.add("rzUrl"); 
		header.add("rzRemark");
		header.add("productDiscriptio");
		                      
		header.add("legalName");
		header.add("legalBirthday");
		header.add("legalTelephone");
		header.add("legalBusiness");
		header.add("legalRemark");
	}
	
	public static boolean isLegal(String key){
		return legalMap.containsKey(key);
	}
}
