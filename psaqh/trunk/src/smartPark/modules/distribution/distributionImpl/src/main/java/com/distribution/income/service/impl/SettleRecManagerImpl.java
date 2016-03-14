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

import com.distribution.income.entity.SettleRec;
import com.distribution.income.dao.SettleRecDao;
import com.distribution.income.service.SettleRecManager;

@Service("settleRecManager")
@Transactional
public class SettleRecManagerImpl extends BaseManagerImpl implements SettleRecManager{
	@Autowired
	private SettleRecDao settleRecDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<SettleRec> getSettleRecs() throws BusException{
    	return settleRecDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<SettleRec> getSettleRecs(
    	@ConditionCollection(domainClazz=SettleRec.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return settleRecDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public SettleRec getSettleRec(@ServiceParam(name="pocRecId") String id)  throws BusException{
    	return settleRecDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerSettleRecs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=SettleRec.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = settleRecDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public SettleRec saveSettleRec(SettleRec o) throws BusException{
//    	String settleRecId = o.getSettleRecId();
//    	boolean isUpdate = StringUtils.isNotEmpty(settleRecId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return settleRecDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeSettleRec(@ServiceParam(name="pocRecId") String id) throws BusException{
    	settleRecDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeSettleRecs(@ServiceParam(name="pocRecId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeSettleRec(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitSettleRec(@ServiceParam(name="pocRecId") String id)  throws BusException{
		return settleRecDao.exists(id);
	}
    
    public boolean exsitSettleRec(String propertyName,Object value) throws BusException{
		return settleRecDao.exists(propertyName,value);
	}

}
