package com.common.MessageCenter.service;

import com.gsoft.framework.core.exception.BusException;

public interface MessagePostProcessor {

	/**发送消息
	 * @param message
	 * @param phones
	 * @throws BusException
	 */
	public void send(IMessage message,String[] phones) throws BusException;
	
}
