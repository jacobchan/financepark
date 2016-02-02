/**
 * 代码声明
 */
package com.manage.EnterpriseManager.service.impl;

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

import com.manage.EnterpriseManager.entity.InformationProduct;
import com.manage.EnterpriseManager.dao.InformationProductDao;
import com.manage.EnterpriseManager.service.InformationProductManager;

@Service("informationProductManager")
@Transactional
public class InformationProductManagerImpl extends BaseManagerImpl implements InformationProductManager{
	@Autowired
	private InformationProductDao informationProductDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<InformationProduct> getInformationProducts() throws BusException{
    	return informationProductDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<InformationProduct> getInformationProducts(
    	@ConditionCollection(domainClazz=InformationProduct.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return informationProductDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public InformationProduct getInformationProduct(@ServiceParam(name="productId") String id)  throws BusException{
    	return informationProductDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerInformationProducts(Pager pager,//分页条件
			@ConditionCollection(domainClazz=InformationProduct.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = informationProductDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public InformationProduct saveInformationProduct(InformationProduct o) throws BusException{
//    	String informationProductId = o.getInformationProductId();
//    	boolean isUpdate = StringUtils.isNotEmpty(informationProductId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return informationProductDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeInformationProduct(@ServiceParam(name="productId") String id) throws BusException{
    	informationProductDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeInformationProducts(@ServiceParam(name="productId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeInformationProduct(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitInformationProduct(@ServiceParam(name="productId") String id)  throws BusException{
		return informationProductDao.exists(id);
	}
    
    public boolean exsitInformationProduct(String propertyName,Object value) throws BusException{
		return informationProductDao.exists(propertyName,value);
	}

}
