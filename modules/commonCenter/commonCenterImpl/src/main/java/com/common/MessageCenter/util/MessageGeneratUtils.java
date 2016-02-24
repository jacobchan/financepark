package com.common.MessageCenter.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MessageGeneratUtils {
	
	public static List<String> placeholders = new ArrayList<String>();
	
	//站位符
	static{
		placeholders.add("@user");
		placeholders.add("@NO");
		placeholders.add("@status");
	}
	
	public static List<String> getKeys(Map<String,String> map){
		List<String> keys = new ArrayList<String>();
		if(map!=null){
			for(Entry<String, String> entry:map.entrySet()){
				keys.add(entry.getKey());
			}
		}
		return keys;
	}
	
}
