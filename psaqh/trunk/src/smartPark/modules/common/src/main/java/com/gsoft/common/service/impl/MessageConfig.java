package com.gsoft.common.service.impl;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.gsoft.common.util.SMSUtil;
import com.gsoft.framework.util.DateUtils;

/**
 * 消息配资信息初始化容器读取
 * @author ASUS
 *
 */
@Component
public class MessageConfig implements InitializingBean{
	public static Logger log = Logger.getLogger(MessageConfig.class);
	
	private static Map<String,String> configs = new HashMap<String,String>();
	
	private static void analysis() throws Exception{
		
		String fileName = "config-message.properties";
		 // 生成输入流  
        InputStream ins=MessageConfig.class.getResourceAsStream("/"+fileName);
        if(ins==null){
        	throw new FileNotFoundException(fileName+"is not found in classpath...");
        }
        // 生成properties对象  
        Properties p = new Properties();  
        try {  
            p.load(ins); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        
        boolean wanr = false;
        String info = "";
        if(p.getProperty(SMSUtil.URL)==null){
        	info = SMSUtil.URL;
        	wanr = true;
        }else if(p.getProperty(SMSUtil.ACCOUNT)==null){
        	info += " "+SMSUtil.URL;
        	wanr = true;
        }else if(p.getProperty(SMSUtil.PASSWORD)==null){
        	info += " "+SMSUtil.URL;
        	wanr = true;
        }
        if(wanr)
        	log.warn("[WARN ] "+DateUtils.getToday("yyyy-MM-dd HH:mm:ss")+":the key of '"+info+"'is not exist");
        
        configs.put(SMSUtil.URL, p.getProperty(SMSUtil.URL));
        configs.put(SMSUtil.ACCOUNT, p.getProperty(SMSUtil.ACCOUNT));
        configs.put(SMSUtil.PASSWORD, p.getProperty(SMSUtil.PASSWORD));
        
 //       log.info("-----------"+configs+"------------");
	}
	
	public static String getValue(String key){
		return configs.get(key);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		analysis();
	}
}
