package com.common.MessageCenter.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.entity.McMsgtempalate;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.McMsgtempalateManager;
import com.gsoft.entity.MessageTempCode;
import com.gsoft.entity.ReferenceMap;
import com.gsoft.framework.util.DateUtils;

@ContextConfiguration(locations={"classpath:applicationContext-test-scl.xml"})
public class MessageSender extends AbstractJUnit4SpringContextTests{
	@Autowired
	private McMsgtempalateManager mcMsgtempalateManager;
	
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	
//	@Test
	public void sendMessageToBackadmin(){
		//获取消息模板
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_BACKGROUND_1);
		//你有一个新的订单需要处理，订单编号为【 #orderNo】，关联项目为【#relateProject】,请及时处理。
		//构建替换模板参数对应的map
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#orderNo", "121212");
		replaceMap.put("#relateProject", "测试工程");
		//构建消息内容数据
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_BACKGROUND_1, replaceMap);
		//发送消息,发送给个人
		mcMsgdatasManager.sendToBackadmin(msgData, "1");
	}

	@Test
	public void sendMessageToEntadmin(){
		//获取消息模板
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_ENT_1);
		//构建替换模板参数对应的map
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#admin", "xxx");
		replaceMap.put("#orderNo", "99999");
		replaceMap.put("#payProject", "支付poj");
		replaceMap.put("#user", "rose");
		//构建消息内容数据
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_ENT_1, replaceMap);
		//发送消息,发送给个人
		mcMsgdatasManager.sendToEntadmin(msgData);
	}
	
//	@Test
	public void sendMessageToUser(){
		//获取消息模板
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_USER_1);
		//构建替换模板参数对应的map
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#user", "xxxx");
		replaceMap.put("#appointmentNo", DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		//构建消息内容数据
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_USER_1, replaceMap);
		//发送消息,发送给个人
		mcMsgdatasManager.sendToUser(msgData, "123");
	}
	
}
