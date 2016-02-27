/**
 * 代码声明
 */
package com.common.OrderManager.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerUserorderManager;

@ContextConfiguration(locations={"classpath:applicationContext-test-mgf.xml"})
public class OrdermanagerUserorderManagerTests extends AbstractJUnit4SpringContextTests{
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	
	@Autowired
	public void setOrdermanagerUserorderManager(OrdermanagerUserorderManager ordermanagerUserorderManager){
		this.ordermanagerUserorderManager = ordermanagerUserorderManager;
	}
    
    /**
     * 新增采购订单
     */
    @Test
    public void testSaveOrdermanagerUserorder(){
    	OrdermanagerUserorder purOrder = new OrdermanagerUserorder();
    	purOrder.setUserorderAmount(BigDecimal.valueOf(10000));
    	ordermanagerUserorderManager.savePurOrdermanager(purOrder);
    }
}
