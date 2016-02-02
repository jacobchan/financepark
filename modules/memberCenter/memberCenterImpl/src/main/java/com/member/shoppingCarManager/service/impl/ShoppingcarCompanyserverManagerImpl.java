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

import com.member.shoppingCarManager.entity.ShoppingcarCompanyserver;
import com.member.shoppingCarManager.dao.ShoppingcarCompanyserverDao;
import com.member.shoppingCarManager.service.ShoppingcarCompanyserverManager;

@Service("shoppingcarCompanyserverManager")
@Transactional
public class ShoppingcarCompanyserverManagerImpl extends BaseManagerImpl implements ShoppingcarCompanyserverManager{
	@Autowired
	private ShoppingcarCompanyserverDao shoppingcarCompanyserverDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShoppingcarCompanyservers() throws BusException{
    	return shoppingcarCompanyserverDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ShoppingcarCompanyserver> getShoppingcarCompanyservers(
    	@ConditionCollection(domainClazz=ShoppingcarCompanyserver.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return shoppingcarCompanyserverDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ShoppingcarCompanyserver getShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id)  throws BusException{
    	return shoppingcarCompanyserverDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerShoppingcarCompanyservers(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ShoppingcarCompanyserver.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = shoppingcarCompanyserverDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ShoppingcarCompanyserver saveShoppingcarCompanyserver(ShoppingcarCompanyserver o) throws BusException{
//    	String shoppingcarCompanyserverId = o.getShoppingcarCompanyserverId();
//    	boolean isUpdate = StringUtils.isNotEmpty(shoppingcarCompanyserverId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return shoppingcarCompanyserverDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id) throws BusException{
    	shoppingcarCompanyserverDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarCompanyservers(@ServiceParam(name="companyServerId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeShoppingcarCompanyserver(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitShoppingcarCompanyserver(@ServiceParam(name="companyServerId") String id)  throws BusException{
		return shoppingcarCompanyserverDao.exists(id);
	}
    
    public boolean exsitShoppingcarCompanyserver(String propertyName,Object value) throws BusException{
		return shoppingcarCompanyserverDao.exists(propertyName,value);
	}

}
