/**
 * 代码声明
 */
package com.common.OrderManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;

import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class OrdermanagerUserorderManagerTests extends AbstractJUnit4SpringContextTests{
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	
	@Autowired
	public void setOrdermanagerUserorderManager(OrdermanagerUserorderManager ordermanagerUserorderManager){
		this.ordermanagerUserorderManager = ordermanagerUserorderManager;
	}
    
    /**
     * 查询列表
     */
    @Test
    public void testGetAllOrdermanagerUserorders(){
    	Pager pager = new Pager(20,1,Pager.QUERY_TYPE_ALL);
		PagerRecords pagerRecords = ordermanagerUserorderManager.getPagerOrdermanagerUserorders(pager , null,null);
		System.out.println(pagerRecords.getRecords());
    }
//     /**
//     * 条件查询列表
//     */
//    @Test
//    public void testGetOrdermanagerUserorders(){
//    	
//    }
//    /**
//     * 根据主键查询
//     */
//    @Test
//    public void testGetOrdermanagerUserorder(){
//    	
//    }
//	@Test
//	public void testGetPagerOrdermanagerUserorders(){
//		
//	}
//    /**
//     * 保存对象
//     */
    @Test
    public void testSaveOrdermanagerUserorder(){
    	
    }
//
//    /**
//     * 删除对象
//     */
//    @Test
//    public void testRemoveOrdermanagerUserorder(){
//    	
//    }
//    /**
//     * 根据主键集合删除对象
//     */
//    @Test
//    public void testRemoveOrdermanagerUserorders(){
//   	
//    }
//    @Test
//    public void testExsitOrdermanagerUserorder(){
//	
//	}
}
