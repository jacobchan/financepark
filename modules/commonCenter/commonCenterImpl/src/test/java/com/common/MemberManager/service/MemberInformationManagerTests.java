/**
 * 代码声明
 */
package com.common.MemberManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;

import com.gsoft.framework.util.Assert;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class MemberInformationManagerTests extends AbstractJUnit4SpringContextTests{
	private MemberInformationManager memberInformationManager;
	
	@Autowired
	public void setMemberInformationManager(MemberInformationManager memberInformationManager){
		this.memberInformationManager = memberInformationManager;
	}
	
	@Test
	public void saveReister(){
		this.memberInformationManager.saveReister("Lisa", "123456", "123456", "18062038510");
		System.out.println("OK");
	}
}
