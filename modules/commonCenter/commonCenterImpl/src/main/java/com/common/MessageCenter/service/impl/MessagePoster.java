package com.common.MessageCenter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.IMessage;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.MessagePostProcessor;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.utils.HttpSenderMsg;

@Service
public class MessagePoster implements MessagePostProcessor{
	@Autowired
	McMsgdatasManager msgdatasManager;
	
	private ExecutorService threadPool = Executors.newFixedThreadPool(10);

	@SuppressWarnings("unchecked")
	@Override
	public void send(final IMessage message, String[] phones) throws BusException {
		//01 - 成功,02 -- 失败
		if(phones!=null&&phones.length>0){
			if(phones.length<=100){
				for(String phone : phones){
					sendSingel(message, phone);
				}
			}else{
				Collection tasks = new ArrayList();
				for(final String phone : phones){
					tasks.add(Executors.callable(new Runnable() {
						@Override
						public void run() {
							sendSingel(message, phone);
						}
					}));
				}
				try {
					threadPool.invokeAll(tasks);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
	
	public void sendSingel(IMessage message,String phone){
		String code = HttpSenderMsg.sendwithCode(message.getMsgContent(), new String[]{phone});
		String status = "";
		if(StringUtils.isEmpty(code)||!"0".equals(code)){
			status = "01";//发送失败
		}else{
			status = "02";//发送成功
		}
		afterSend(message,status,phone);
	}

	public void afterSend(IMessage message,String status,String phone) throws BusException {
		if(message instanceof McMsgdatas){
			McMsgdatas messageDate = (McMsgdatas) message;
			messageDate.setSendStatus(status);
			messageDate.setReceive(phone);
			messageDate.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
//			messageDate.setCreateUser(UserUtils.getLoginUserId());
			msgdatasManager.saveMcMsgdatas(messageDate);
		}
	}

}
