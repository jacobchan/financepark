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
	 * 你有一个新的订单需要处理，订单编号为【 #orderNo】，关联项目为【#relateProject】,请及时处理。
	 */
	public static final String MSG_BACKGROUND_1 = "0101";
	/**
	 * 你有一个新的申请需要审批，流程编号为【#flowNo】，关联项目为【#relateProject】，请及时处理！
	 */
	public static final String MSG_BACKGROUND_2 = "0102";
	/**
	 * 你有一个新的物业服务申请需要处理，服务编号为【#serviceNo】，关联项目为【#relateProject】，请及时处理！
	 */
	public static final String MSG_BACKGROUND_3 = "0103";
	/**
	 * 你有一个新的预约需要处理，预约编号为【#appointmentNo】，关联项目为【#relateProject】，请及时处理！
	 */
	public static final String MSG_BACKGROUND_4 = "0104";
	
	
	/**
	 * 尊敬的企业管理员【#admin】，你有一个支付申请需要处理，订单编号为【 #orderNo】，支付项目为【#payProject】，申请的员工为【#user】，请登录企业管理中心进行处理，感谢你对富春硅谷的支持!
	 */
	public static final String MSG_ENT_1 = "0201";
	/**
	 * 尊敬的企业管理员【#admin】，你的订单【#orderNo】已经成功支付，支付总金额为：1999元。感谢你对富春硅谷的支持！
	 */
	public static final String MSG_ENT_2 = "0202";
	
	
	/**
	 * 尊敬的用户#user你好，你的预约已经成功提交，预约单号为【#appointmentNo】，预约结果请留意短信通知，或进入个人中心查看处理结果，感谢你对富春硅谷的支持！
	 */
	public static final String MSG_USER_1 = "0301";
	/**
	 * 尊敬的用户#user你好，你的物业报修【订单号：#orderNo】已受理，我们的工作人员将前往维修，为你服务的专业工程师联系方式：#engineer【手机:#phone】，感谢你对富春硅谷的支持！
	 */
	public static final String MSG_USER_2 = "0302";
	/**
	 * 尊敬的用户#user你好，你的物业报修已经完工，请及时前往个人中心付款，如有疑问欢迎致电客服中心：83438999，感谢你对富春硅谷的支持！
	 */
	public static final String MSG_USER_3 = "0303";
	/**
	 * 尊敬的用户#user你好，你的投诉建议我们已经收到，为此给你带来的不便我们深表歉意，我们会尽快安排专业的人员受理，并将受理结果及时反馈给您，感谢你对富春硅谷的支持！【服务编号：#serviceNo】
	 */
	public static final String MSG_USER_4 = "0304";
	
	/**
	 * 尊敬的用户#user你好，你的预约已经成功受理，受理编号为【#appointmentNo】，感谢你对富春硅谷的支持！
	 */
	public static final String MSG_USER_5 = "0305";
	/**
	 * 尊敬的用户#user你好,感谢您到访【#relateProject】，如果有更好的建议，欢迎到我们的官网www.qypark.com或者致电：0755-82379999反馈，期待您的下次光临！
	 */
	public static final String MSG_USER_6 = "0306";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_11 = "1100";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_12 = "1200";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_13 = "1300";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_14 = "14000";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_15 = "1500";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_16 = "1600";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_17 = "1700";
	/**
	 * 
	 */
	public static final String MSG_TEMPT_18 = "1800";
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
