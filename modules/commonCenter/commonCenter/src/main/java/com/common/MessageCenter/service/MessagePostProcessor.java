package com.common.MessageCenter.service;

import com.gsoft.framework.core.exception.BusException;

public interface MessagePostProcessor {

	public void send(IMessage message,String[] phones) throws BusException;
	
	/**发送消息前的处理
	 * 注入外部接口
	 * @throws BusException
	 */
	public void beforeSend() throws BusException;
	
	/**发送消息时的处理
	 * 
	 * @throws BusException
	 */
	public void onSend() throws BusException;
	
	/**发送消息后的处理
	 * 1、通过返回码获取发送状态
	 * 2、接收人
	 * 3、保存发送内容实体
	 * @throws BusException
	 */
	public void afterSend(IMessage message) throws BusException;
	
}
