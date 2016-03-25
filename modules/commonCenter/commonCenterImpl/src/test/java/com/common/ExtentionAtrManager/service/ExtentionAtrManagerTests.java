package com.common.ExtentionAtrManager.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;



@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class ExtentionAtrManagerTests extends AbstractJUnit4SpringContextTests {
private ExtentionAtrManager extentionAtrManager;
	
	@Autowired
	public void setPurchasingmanagerMerchantAddressManager(ExtentionAtrManager extentionAtrManager){
		this.extentionAtrManager = extentionAtrManager;
	}
	
	@Test
	public void test(){
		this.extentionAtrManager.testMethod();
	} 
}
