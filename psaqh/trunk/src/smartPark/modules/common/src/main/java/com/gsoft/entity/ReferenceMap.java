package com.gsoft.entity;

import java.util.HashMap;

public class ReferenceMap extends HashMap<String, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122406424890438625L;

	public ReferenceMap(){
	//	super();
		this.put("#user","@user");
		this.put("#OrderType","");
		this.put("#OrderNo","");
		this.put("#Commdity","");
		this.put("#RecNo","");
		this.put("#NewType","");
		this.put("#Type","");
		this.put("#RecState","");
		this.put("#waiter","");
		this.put("#Phone","");
		this.put("#qyadmin","");
	}
	
	public ReferenceMap(String params){
		if(params!=null){
			String[] paramArray = params.split(",|，");
			for(String param:paramArray){
				String[] mapStrs = param.split(":");
				if(mapStrs.length==0){
					
				}else if(mapStrs.length==1){
					this.put(mapStrs[0], "");
				}else if(mapStrs.length>=2){
					this.put(mapStrs[0], mapStrs[1]);
				}
			}
		}
	}
	
//	@Override
//	public String put(String key, String value) {
//		if(this.containsKey(key))
//			return super.put(key, value);
//		else
//			return value;
//	}
	
}
