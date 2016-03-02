package com.common.MessageCenter.service.impl;

import com.common.MessageCenter.service.IMessage;
import com.common.MessageCenter.service.MessagePostProcessor;
import com.gsoft.framework.core.exception.BusException;

public abstract class MessageAbstractPoster implements MessagePostProcessor{

	@Override
	public void send(IMessage message, String[] phones) throws BusException {
		beforeSend();
		onSend();
		afterSend(message);
	}

	@Override
	public abstract void onSend() throws BusException ;

	@Override
	public abstract void beforeSend() throws BusException ;

	@Override
	public abstract void afterSend(IMessage message) throws BusException ;

}
