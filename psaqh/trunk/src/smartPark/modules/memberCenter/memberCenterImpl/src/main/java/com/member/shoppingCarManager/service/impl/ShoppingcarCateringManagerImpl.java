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

import com.member.shoppingCarManager.entity.ShoppingcarCatering;
import com.member.shoppingCarManager.dao.ShoppingcarCateringDao;
import com.member.shoppingCarManager.service.ShoppingcarCateringManager;

@Service("shoppingcarCateringManager")
@Transactional
public class ShoppingcarCateringManagerImpl extends BaseManagerImpl implements ShoppingcarCateringManager{
	@Autowired
	private ShoppingcarCateringDao shoppingcarCateringDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<ShoppingcarCatering> getShoppingcarCaterings() throws BusException{
    	return shoppingcarCateringDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<ShoppingcarCatering> getShoppingcarCaterings(
    	@ConditionCollection(domainClazz=ShoppingcarCatering.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return shoppingcarCateringDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public ShoppingcarCatering getShoppingcarCatering(@ServiceParam(name="companyCateringId") String id)  throws BusException{
    	return shoppingcarCateringDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerShoppingcarCaterings(Pager pager,//分页条件
			@ConditionCollection(domainClazz=ShoppingcarCatering.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = shoppingcarCateringDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public ShoppingcarCatering saveShoppingcarCatering(ShoppingcarCatering o) throws BusException{
//    	String shoppingcarCateringId = o.getShoppingcarCateringId();
//    	boolean isUpdate = StringUtils.isNotEmpty(shoppingcarCateringId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return shoppingcarCateringDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeShoppingcarCatering(@ServiceParam(name="companyCateringId") String id) throws BusException{
    	shoppingcarCateringDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeShoppingcarCaterings(@ServiceParam(name="companyCateringId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeShoppingcarCatering(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitShoppingcarCatering(@ServiceParam(name="companyCateringId") String id)  throws BusException{
		return shoppingcarCateringDao.exists(id);
	}
    
    public boolean exsitShoppingcarCatering(String propertyName,Object value) throws BusException{
		return shoppingcarCateringDao.exists(propertyName,value);
	}

}
