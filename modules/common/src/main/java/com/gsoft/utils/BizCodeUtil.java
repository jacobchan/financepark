package com.gsoft.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.gsoft.framework.util.DateUtils;

/**
 * 生成唯一编号公共方法
 * @author maogf
 *
 */
public class BizCodeUtil {
	
	private static final BizCodeUtil uniqueInstance = new BizCodeUtil();
	private String initTime = DateUtils.getToday("yyMMddHHmmss");
	private int num =0;
	
	private BizCodeUtil(){
	}
	
	public static BizCodeUtil getInstance(){
		return uniqueInstance;
	}
	
	public synchronized String getBizCodeDate(String bizType){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String nowTime = dateFormat.format(date);
		if(!nowTime.equals(initTime)){
			initTime = nowTime;
			this.num=0;
		}else{
			this.num+=1;
		}
		return bizType+initTime+StringUtils.leftPad(String.valueOf(num), 4, "0");
	}
}
