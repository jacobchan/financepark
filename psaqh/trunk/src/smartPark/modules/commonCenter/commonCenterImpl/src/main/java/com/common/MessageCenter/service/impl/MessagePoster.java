package com.common.MessageCenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.IMessage;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.gsoft.framework.core.exception.BusException;

@Service
public class MessagePoster extends MessageAbstractPoster{
	
	@Autowired
	private McMsgdatasManager msgdatasManager;

	@Override
	public void onSend() throws BusException {
		System.out.println("-----------onSend");
		
	}

	@Override
	public void beforeSend() throws BusException {
		System.out.println("-----------beforeSend");
		
	}

	@Override
	public void afterSend(IMessage message) throws BusException {
		System.out.println("-----------afterSend");
		if(message instanceof McMsgdatas){
			msgdatasManager.saveMcMsgdatas(new McMsgdatas());
		}
	}

}
