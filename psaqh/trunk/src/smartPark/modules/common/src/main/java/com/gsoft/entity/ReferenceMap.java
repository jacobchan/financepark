package com.gsoft.entity;

import java.util.HashMap;

public class ReferenceMap extends HashMap<String, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122406424890438625L;

	public ReferenceMap(){
		super();
		this.put("@user","");
		this.put("@NO","");
		this.put("@status","");
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
	
}
