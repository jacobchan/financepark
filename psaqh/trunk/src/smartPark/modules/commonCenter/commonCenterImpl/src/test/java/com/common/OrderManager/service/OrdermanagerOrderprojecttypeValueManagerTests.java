/**
 * 代码声明
 */
package com.common.OrderManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

import com.common.OrderManager.service.OrdermanagerOrderprojecttypeValueManager;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class OrdermanagerOrderprojecttypeValueManagerTests extends AbstractJUnit4SpringContextTests{
	private OrdermanagerOrderprojecttypeValueManager ordermanagerOrderprojecttypeValueManager;
	
	@Autowired
	public void setOrdermanagerOrderprojecttypeValueManager(OrdermanagerOrderprojecttypeValueManager ordermanagerOrderprojecttypeValueManager){
		this.ordermanagerOrderprojecttypeValueManager = ordermanagerOrderprojecttypeValueManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllOrdermanagerOrderprojecttypeValues(){
    	
    }
     /**
     * 条件查询列表
     */
    @Test
    public void testGetOrdermanagerOrderprojecttypeValues(){
    	
    }
    /**
     * 根据主键查询
     */
    @Test
    public void testGetOrdermanagerOrderprojecttypeValue(){
    	
    }
	@Test
	public void testGetPagerOrdermanagerOrderprojecttypeValues(){
		
	}
    /**
     * 保存对象
     */
    @Test
    public void testSaveOrdermanagerOrderprojecttypeValue(){
    	
    }

    /**
     * 删除对象
     */
    @Test
    public void testRemoveOrdermanagerOrderprojecttypeValue(){
    	
    }
    /**
     * 根据主键集合删除对象
     */
    @Test
    public void testRemoveOrdermanagerOrderprojecttypeValues(){
   	
    }
    @Test
    public void testExsitOrdermanagerOrderprojecttypeValue(){
	
	}
}
