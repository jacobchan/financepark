/**
 * 代码声明
 */
package com.common.OrderManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

import com.common.OrderManager.service.OrdermanagerOrderprojecttypeManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class OrdermanagerOrderprojecttypeManagerTests extends AbstractJUnit4SpringContextTests{
	private OrdermanagerOrderprojecttypeManager ordermanagerOrderprojecttypeManager;
	
	@Autowired
	public void setOrdermanagerOrderprojecttypeManager(OrdermanagerOrderprojecttypeManager ordermanagerOrderprojecttypeManager){
		this.ordermanagerOrderprojecttypeManager = ordermanagerOrderprojecttypeManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllOrdermanagerOrderprojecttypes(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetOrdermanagerOrderprojecttypes(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetOrdermanagerOrderprojecttype(){
    	
    }
	@Test
	public void testGetPagerOrdermanagerOrderprojecttypes(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveOrdermanagerOrderprojecttype(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveOrdermanagerOrderprojecttype(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveOrdermanagerOrderprojecttypes(){
   	
    }
    @Test
    public void testExsitOrdermanagerOrderprojecttype(){
	
	}
}
