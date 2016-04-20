package com.gsoft.common.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;

/**
 * 消息配资信息初始化容器读取
 * @author ASUS
 *
 */
public class MessageConfig implements InitializingBean{
	
	public static Map<String,String> configs = new HashMap<String,String>();
	
	public static void analysis(){
		 // 生成输入流  
        InputStream ins=MessageConfig.class.getResourceAsStream("/message.properties");  
        // 生成properties对象  
        Properties p = new Properties();  
        try {  
            p.load(ins); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        configs.put("url", p.getProperty("url"));
        configs.put("account", p.getProperty("account"));
        configs.put("password", p.getProperty("password"));
	}
	
	public static String getValue(String key){
		return configs.get(key);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		analysis();
	}
}
