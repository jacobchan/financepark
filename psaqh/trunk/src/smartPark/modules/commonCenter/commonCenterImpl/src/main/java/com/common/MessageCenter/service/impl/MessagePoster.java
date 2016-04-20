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
public class MessagePoster implements MessagePostProcessor {
	@Autowired
	McMsgdatasManager msgdatasManager;

	@Override
	public void send(IMessage message, String[] phones) throws BusException {
		// 00 - 待发送 ，01 - 成功,02 -- 失败

		sendAndSave(message, phones);

	}

	/**
	 * 单个发送单个保存
	 * 
	 * @param message
	 * @param phones
	 */
	@SuppressWarnings("unchecked")
	public void sendAndSave(final IMessage message, String[] phones) {
		if (phones != null && phones.length > 0) {
			if (phones.length <= 100) {
				for (String phone : phones) {
					sendSingel(message, phone);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				ExecutorService threadPool = Executors.newFixedThreadPool(10);
				Collection tasks = new ArrayList();
				for (final String phone : phones) {
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
				} finally {
					threadPool.shutdown();
				}
			}
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
			messageDate
					.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			msgdatasManager.saveMcMsgdatas(messageDate);
		}
	}

}
