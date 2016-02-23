/**
 * 代码声明
 */
package com.common.OrderManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

import com.common.OrderManager.entity.OrdermanagerOrdertype;
import com.common.OrderManager.service.OrdermanagerOrdertypeManager;
import com.gsoft.framework.util.Assert;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class OrdermanagerOrdertypeManagerTests extends AbstractJUnit4SpringContextTests{
	private OrdermanagerOrdertypeManager ordermanagerOrdertypeManager;
	
	@Autowired
	public void setOrdermanagerOrdertypeManager(OrdermanagerOrdertypeManager ordermanagerOrdertypeManager){
		this.ordermanagerOrdertypeManager = ordermanagerOrdertypeManager;
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveOrdermanagerOrdertype(){
    	OrdermanagerOrdertype orderType = new OrdermanagerOrdertype();
    	orderType.setOrdertypeName("公共资源订单");
    	orderType.setOrdertypeProjectName("公共资源订单");
    	orderType.setOrdertypeProjectTemplateAddress("/");
    	OrdermanagerOrdertype result = this.ordermanagerOrdertypeManager.saveOrdermanagerOrdertype(orderType);
    	Assert.notNull(result.getOrdertypeId());
    	System.out.println(result.getOrdertypeId());
    }

}
