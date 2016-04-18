package com.manage.PublicUtilitiesManager.service;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class PublicutilitiesmanagerResoManagerImplTests extends AbstractJUnit4SpringContextTests {
private PublicutilitiesmanagerResoManager publicutilitiesmanagerResoManager;
	
	@Autowired
	public void setPurchasingmanagerMerchantManager(PublicutilitiesmanagerResoManager publicutilitiesmanagerResoManager){
		this.publicutilitiesmanagerResoManager = publicutilitiesmanagerResoManager;
	}
	
	@Test
    public void testSavePurchasingmanagerMerchant(){
		
//		Collection<Condition> conditions = new ArrayList<Condition>();
//		Pager page = new Pager(10, 0, 0);
//		PagerRecords records = this.publicutilitiesmanagerResoManager.getPagerPublicCommoditys(page, conditions, null, "0301");
//		System.out.println(records.getTotalCount());
		
	}

}
