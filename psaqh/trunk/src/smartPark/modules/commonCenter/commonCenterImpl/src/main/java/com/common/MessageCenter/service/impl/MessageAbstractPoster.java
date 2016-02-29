package com.common.MessageCenter.service.impl;

import com.common.MessageCenter.service.MessagePostProcessor;
import com.gsoft.framework.core.exception.BusException;

public abstract class MessageAbstractPoster implements MessagePostProcessor{

	@Override
	public void send(String content, String[] phones) throws BusException {
		beforeSend();
		onSend();
		afterSend();
	}

	@Override
	public abstract void onSend() throws BusException ;

	@Override
	public abstract void beforeSend() throws BusException ;

	@Override
	public abstract void afterSend() throws BusException ;

}
