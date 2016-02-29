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
	@Test
	public void getMsgTempalateByUniqueCode(){
		//#user发起了#OrderType的订单，订单编号#OrderNo，请处理
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_TEMPT_1);
		System.out.println("tempalate:"+tempalate.getMsgTempalateCaption());
	}
	@Test
	public void genContent(){
		McMsgtempalate tempalate = mcMsgtempalateManager.getMsgTempalate(MessageTempCode.MSG_TEMPT_1);;
		Map<String, String> replaceMap = new ReferenceMap();
		replaceMap.put("#user", "张三");
		replaceMap.put("#OrderType", "午餐");
		replaceMap.put("#OrderNo", "NO1111");
		String content = mcMsgdatasManager.buildMsgContent(tempalate, replaceMap );
		System.out.println("content:"+content);
	}
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
}
