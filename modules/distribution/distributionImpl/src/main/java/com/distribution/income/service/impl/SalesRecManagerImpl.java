/**
 * 代码声明
 */
package com.distribution.income.service.impl;

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

import com.distribution.income.entity.SalesRec;
import com.distribution.income.dao.SalesRecDao;
import com.distribution.income.service.SalesRecManager;

@Service("salesRecManager")
@Transactional
public class SalesRecManagerImpl extends BaseManagerImpl implements SalesRecManager{
	@Autowired
	private SalesRecDao salesRecDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<SalesRec> getSalesRecs() throws BusException{
    	return salesRecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<SalesRec> getSalesRecs(
    	@ConditionCollection(domainClazz=SalesRec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return salesRecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public SalesRec getSalesRec(@ServiceParam(name="saleRecId") String id)  throws BusException{
    	return salesRecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerSalesRecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=SalesRec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = salesRecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public SalesRec saveSalesRec(SalesRec o) throws BusException{
//    	String salesRecId = o.getSalesRecId();
//    	boolean isUpdate = StringUtils.isNotEmpty(salesRecId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return salesRecDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeSalesRec(@ServiceParam(name="saleRecId") String id) throws BusException{
    	salesRecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSalesRecs(@ServiceParam(name="saleRecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeSalesRec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitSalesRec(@ServiceParam(name="saleRecId") String id)  throws BusException{
		return salesRecDao.exists(id);
	}
    
    public boolean exsitSalesRec(String propertyName,Object value) throws BusException{
		return salesRecDao.exists(propertyName,value);
	}

}
