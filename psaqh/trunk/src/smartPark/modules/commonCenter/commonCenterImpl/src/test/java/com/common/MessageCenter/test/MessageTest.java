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

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MessageTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private McMsgtempalateManager mcMsgtempalateManager;
	
	@Autowired
	private McMsgdatasManager mcMsgdatasManager;
	
	/**
	 * 通过唯一码获取消息模板对象
	 */
//	@Test
	public void getMsgTempalateByUniqueCode(){
		//#user发起了#OrderType的订单，订单编号#OrderNo，请处理
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_TEMPT_1);
		System.out.println("tempalate:"+tempalate.getMsgTempalateCaption());
	}
	/**
	 * 通过消息模板和参数map获取内容
	 */
//	@Test
	public void genContent(){
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_TEMPT_1);;
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#user", "张三");
		replaceMap.put("#OrderType", "午餐");
		replaceMap.put("#OrderNo", "NO1111");
		String content = mcMsgdatasManager.buildMsgContent(tempalate, replaceMap );
		System.out.println("content:"+content);
	}
	
	/**
	 * 通过消息模板和参数map获取消息内容实体
	 */
	@Test
	public void genMsgData(){
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#user", "张三");
		replaceMap.put("#OrderType", "午餐");
		replaceMap.put("#OrderNo", "NO1111");
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_TEMPT_1, replaceMap);
		System.out.println("msgData:"+msgData.getMsgCaption()+"\n"+msgData.getMsgContent()+"\n"+msgData.getMcMsgtempalate().getMsgReceiver()+
				"\n"+msgData.getSendDate()+"\n"+msgData.getSendStatus());
	}
	
	@Test
	public void sendMessage(){
		//获取消息模板
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_TEMPT_1);
		//构建替换模板参数对应的map
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#user", "@user");
		replaceMap.put("#OrderType", "午餐");
		replaceMap.put("#OrderNo", "NO1111");
		//构建消息内容数据
		McMsgdatas msgData = mcMsgdatasManager.buildMsgData(MessageTempCode.MSG_TEMPT_1, replaceMap);
		//发送消息,发送给个人
		mcMsgdatasManager.sendMessageSingle(msgData, "123");
	}
	
}
