package com.common.MessageCenter.service.impl;

import org.springframework.stereotype.Service;

import com.gsoft.framework.core.exception.BusException;

@Service
public class MessagePoster extends MessageAbstractPoster{

	@Override
	public void onSend() throws BusException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSend() throws BusException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSend() throws BusException {
		System.out.println("-----------afterSend");
		
	}

}
