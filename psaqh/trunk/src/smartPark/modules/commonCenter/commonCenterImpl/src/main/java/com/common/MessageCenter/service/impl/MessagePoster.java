package com.common.MessageCenter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.service.IMessage;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.MessagePostProcessor;
import com.gsoft.entity.MsgParam;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.utils.HttpSenderMsg;

@Service
public class MessagePoster implements MessagePostProcessor {
	@Autowired
	McMsgdatasManager msgdatasManager;

	@Override
	public void send(IMessage message, List<MsgParam> msgParams) throws BusException {
		// 00 - 待发送 ，01 - 成功,02 -- 失败

		sendAndSave(message, msgParams);

	}

	/**
	 * 单个发送单个保存
	 * 
	 * @param message
	 * @param phones
	 */
	@SuppressWarnings("unchecked")
	public void sendAndSave(final IMessage message, List<MsgParam> msgParams) {
		if (msgParams != null && msgParams.size() > 0) {
			if (msgParams.size() <= 1000) {
				for (MsgParam msgParam : msgParams) {
					if(StringUtils.isEmpty(msgParam.getPhone()))
						continue;
					replaceUser(message,msgParam);
					
					sendSingel(message, msgParam.getPhone());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				ExecutorService threadPool = Executors.newFixedThreadPool(10);
				Collection tasks = new ArrayList();
				for (final MsgParam msgParam : msgParams) {
					tasks.add(Executors.callable(new Runnable() {
						@Override
						public void run() {
							if(!StringUtils.isEmpty(msgParam.getPhone())){
								replaceUser(message,msgParam);
								sendSingel(message, msgParam.getPhone());
							}	
						}
					}));
				}
				try {
					threadPool.invokeAll(tasks);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					threadPool.shutdown();
				}
			}
		}
	}

	private void replaceUser(IMessage message, MsgParam msgParam) {
		if(message instanceof McMsgdatas){
			McMsgdatas msgdatas = (McMsgdatas) message;
			msgdatas.setMsgContent(msgdatas.getMsgContent().replaceAll("#admin|#user", msgParam.getUsername()));
		}
	}

	/**
	 * 群发遍历保存
	 * 
	 * @param message
	 * @param phones
	 */
	@SuppressWarnings("unchecked")
	public void sendThenSave(final IMessage message, String[] phones) {
		String code = HttpSenderMsg.sendwithCode(message.getMsgContent(),
				phones);
		final String status;
		if (StringUtils.isEmpty(code) || !"0".equals(code)) {
			status = "01";// 发送失败
		} else {
			status = "02";// 发送成功
		}
		if (phones != null && phones.length > 0) {
			if (phones.length <= 100) {
				for (String phone : phones) {
					afterSend(message, status, phone);
				}
			} else {
				ExecutorService threadPool = Executors.newFixedThreadPool(10);
				Collection tasks = new ArrayList();
				for (final String phone : phones) {
					tasks.add(Executors.callable(new Runnable() {
						@Override
						public void run() {
							afterSend(message, status, phone);
						}
					}));
				}
				try {
					threadPool.invokeAll(tasks);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					threadPool.shutdown();
				}
			}
		}
	}

	/**
	 * 一条一条发送短信并且保存
	 * 
	 * @param message
	 * @param phone
	 */
	public void sendSingel(IMessage message, String phone) {
		String code = HttpSenderMsg.sendwithCode(message.getMsgContent(),
				new String[] { phone });
		String status = "";
		if (StringUtils.isEmpty(code) || !"0".equals(code)) {
			status = "01";// 发送失败
		} else {
			status = "02";// 发送成功
		}
		afterSend(message, status, phone);
	}

	public void afterSend(IMessage message, String status, String phone)
			throws BusException {
		if (message instanceof McMsgdatas) {
			McMsgdatas messageDate = (McMsgdatas) message;
			messageDate.setSendStatus(status);
			messageDate.setReceive(phone);
			messageDate.setSendDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			msgdatasManager.saveMcMsgdatas(messageDate);
		}
	}

}
