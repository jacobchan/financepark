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
	 * #user发起了#OrderType的订单，订单编号#OrderNo，请处理。
	 */
	public static final String MSG_TEMPT_1 = "010000";
	/**
	 * #user申请了#Commdity的预约，预约编号#RecNo，请处理。
	 */
	public static final String MSG_TEMPT_2 = "020000";
	/**
	 * #user申请#NewType的政策申请，申请编号#RecNo,请处理。
	 */
	public static final String MSG_TEMPT_3 = "030000";
	/**
	 * #user，您的#Type#RecNo，已处理，当前状态#RecState，请知悉。
	 */
	public static final String MSG_TEMPT_4 = "040000";
	/**
	 * #user，您好，你的预约（预约编号#RecNo）已受理。您的接待员是#waiter，联系电话#Phone
	 */
	public static final String MSG_TEMPT_5 = "050000";
	/**
	 * #user，您好，贵司的企业码是#EnNo，请填写企业邀请码，加入企业。
	 */
	public static final String MSG_TEMPT_6 = "060000";
	/**
	 * #user，您好，你的入驻申请已审核通过，请与#time到服务窗口，凭申请编号#RecNo办理入驻。
	 */
	public static final String MSG_TEMPT_7 = "070000";
	/**
	 * #qyadmin，您好!贵公司的员工#user已申请加入企业
	 */
	public static final String MSG_TEMPT_8 = "080000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_9 = "090000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_10 = "100000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_11 = "110000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_12 = "120000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_13 = "130000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_14 = "140000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_15 = "150000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_16 = "160000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_17 = "170000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_18 = "180000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_19 = "190000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_20 = "200000";
	/**
	 * 获取属性值构成集合
	 * @return
	 */
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
	/**
	 * 
	 * @param codeName
	 * @return
	 */
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
	/**
	 * 属性值是否存在
	 * @param codeValue
	 * @return
	 */
	public static boolean contant(String codeValue){
		return getProperties().contains(codeValue);
	}
	
}
