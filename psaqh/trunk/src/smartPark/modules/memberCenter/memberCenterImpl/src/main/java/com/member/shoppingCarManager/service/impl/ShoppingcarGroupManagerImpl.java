/**
 * 代码声明
 */
package com.member.shoppingCarManager.service.impl;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;

import com.gsoft.framework.esb.annotation.*;

import com.gsoft.framework.core.service.impl.BaseManagerImpl;

import com.member.shoppingCarManager.entity.ShoppingcarGroup;
import com.member.shoppingCarManager.dao.ShoppingcarGroupDao;
import com.member.shoppingCarManager.service.ShoppingcarGroupManager;

@Service("shoppingcarGroupManager")
@Transactional
public class ShoppingcarGroupManagerImpl extends BaseManagerImpl implements ShoppingcarGroupManager{
	@Autowired
	private ShoppingcarGroupDao shoppingcarGroupDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ShoppingcarGroup> getShoppingcarGroups() throws BusException{
    	return shoppingcarGroupDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ShoppingcarGroup> getShoppingcarGroups(
    	@ConditionCollection(domainClazz=ShoppingcarGroup.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return shoppingcarGroupDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ShoppingcarGroup getShoppingcarGroup(@ServiceParam(name="companyGroupId") String id)  throws BusException{
    	return shoppingcarGroupDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerShoppingcarGroups(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ShoppingcarGroup.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = shoppingcarGroupDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ShoppingcarGroup saveShoppingcarGroup(ShoppingcarGroup o) throws BusException{
//    	String shoppingcarGroupId = o.getShoppingcarGroupId();
//    	boolean isUpdate = StringUtils.isNotEmpty(shoppingcarGroupId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return shoppingcarGroupDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeShoppingcarGroup(@ServiceParam(name="companyGroupId") String id) throws BusException{
    	shoppingcarGroupDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarGroups(@ServiceParam(name="companyGroupId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeShoppingcarGroup(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitShoppingcarGroup(@ServiceParam(name="companyGroupId") String id)  throws BusException{
		return shoppingcarGroupDao.exists(id);
	}
    
    public boolean exsitShoppingcarGroup(String propertyName,Object value) throws BusException{
		return shoppingcarGroupDao.exists(propertyName,value);
	}

}
