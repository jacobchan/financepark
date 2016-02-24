package com.gsoft.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gsoft.entity.ReferenceMap;

public class MessageUtils {

	//站位参数
	public static List<String> placeholders = new ArrayList<String>();
	//站位符-值
	public static ReferenceMap referenceMap = new ReferenceMap();
	
	//站位符
	static{
//		placeholders.add("@user");
//		placeholders.add("@NO");
//		placeholders.add("@status");
		placeholders = getKeys(referenceMap);
	}
	
	/**将map的key存入list
	 * @param map
	 * @return
	 */
	public static List<String> getKeys(Map<String,String> map){
		List<String> keys = new ArrayList<String>();
		if(map!=null){
			for(Entry<String, String> entry:map.entrySet()){
				keys.add(entry.getKey());
			}
		}
		return keys;
	}
	
	/**通过约定字符串构建ReferenceMap  ("key:value")
	 * @param params
	 * @return
	 */
	public static ReferenceMap ReferenceMap(String params){
		if(params!=null){
			String[] paramArray = params.split(",|，");
			for(String param:paramArray){
				String[] mapStrs = param.split(":");
				if(mapStrs.length==0){
					
				}else if(mapStrs.length==1){
					if(referenceMap.containsKey(mapStrs[0]))
						referenceMap.put(mapStrs[0], "");
				}else if(mapStrs.length>=2){
					if(referenceMap.containsKey(mapStrs[0]))
						referenceMap.put(mapStrs[0], mapStrs[1]);
				}
			}
		}
		return referenceMap;
	}
}
