package com.gsoft.entity;

import java.util.HashMap;

public class ReferenceMap extends HashMap<String, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122406424890438625L;

	public ReferenceMap(){
	//	super();
		this.put("#admin","");//管理员
		this.put("#user","");//用户
		this.put("#phone","");//电话
		this.put("#orderNo","");//订单编号
		this.put("#flowNo","");//流程编号
		this.put("#serviceNo","");//服务编号
		this.put("#appointmentNo","");//预约编号
		this.put("#relateProject","");//关联项目
		this.put("#payProject","");//支付项目
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
