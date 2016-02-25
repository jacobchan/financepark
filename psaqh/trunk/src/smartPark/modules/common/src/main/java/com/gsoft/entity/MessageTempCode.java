package com.gsoft.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 *
 */
public class MessageTempCode {
	/**
	 * 
	 */
	public static final String MessageTtpe1="010000";
	
	public static final String MessageTtpe2="020000";
	
	public static final String MessageTtpe3="030000";
	
	public static final String MessageTtpe4="040000";
	
	public static final String MessageTtpe5="050000";
	
	public static final String MessageTtpe6="060000";
	
	public static final String MessageTtpe7="070000";
	
	public static final String MessageTtpe8="080000";
	
	public static final String MessageTtpe9="090000";
	
	public static final String MessageTtpe10="100000";
	
	public static final String MessageTtpe11="110000";
	
	public static final String MessageTtpe12="120000";
	
	public static final String MessageTtpe13="130000";
	
	public static final String MessageTtpe14="140000";
	
	public static final String MessageTtpe15="150000";
	
	public static final String MessageTtpe16="160000";
	
	public static final String MessageTtpe17="170000";
	
	public static final String MessageTtpe18="180000";
	
	public static final String MessageTtpe19="190000";
	
	public static final String MessageTtpe20="200000";
	
	public static List<String> getProperties(){
		List<String> filedName = new ArrayList<String>();
		Class<MessageTempCode> clazz = MessageTempCode.class;
		Field[] fields = clazz.getFields();
		if(fields!=null){
			for(Field field:fields){
				try {
					filedName.add((String)field.get(clazz));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return filedName;
	}
	
	public static String getCodeValue(String codeName){
		String codeValue = "";
		Class<MessageTempCode> clazz = MessageTempCode.class;
		Field[] fields = clazz.getFields();
		try {
			Field field = clazz.getField(codeName);
			codeValue = (String) field.get(MessageTempCode.class);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return codeValue;
	}
	
	public static boolean contant(String codeValue){
		return getProperties().contains(codeValue);
	}
	
}
