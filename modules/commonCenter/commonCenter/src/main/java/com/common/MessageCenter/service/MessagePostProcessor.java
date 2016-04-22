package com.common.MessageCenter.service;

import java.util.List;

import com.gsoft.entity.MsgParam;
import com.gsoft.framework.core.exception.BusException;

public interface MessagePostProcessor {

	/**发送消息
	 * @param message
	 * @param phones
	 * @throws BusException
	 */
	public void send(IMessage message,List<MsgParam> msgParams) throws BusException;
	
}
