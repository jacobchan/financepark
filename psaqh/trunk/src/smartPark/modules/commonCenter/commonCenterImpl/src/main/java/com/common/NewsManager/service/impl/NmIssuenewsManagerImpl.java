/**
 * 代码声明
 */
package com.common.NewsManager.service.impl;

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

import com.common.NewsManager.entity.NmIssuenews;
import com.common.NewsManager.dao.NmIssuenewsDao;
import com.common.NewsManager.service.NmIssuenewsManager;

@Service("nmIssuenewsManager")
@Transactional
public class NmIssuenewsManagerImpl extends BaseManagerImpl implements NmIssuenewsManager{
	@Autowired
	private NmIssuenewsDao nmIssuenewsDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssuenews> getNmIssuenewss() throws BusException{
    	return nmIssuenewsDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssuenews> getNmIssuenewss(
    	@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssuenewsDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssuenews getNmIssuenews(@ServiceParam(name="policyId") String id)  throws BusException{
    	return nmIssuenewsDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssuenewss(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuenews.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssuenewsDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssuenews saveNmIssuenews(NmIssuenews o) throws BusException{
//    	String nmIssuenewsId = o.getNmIssuenewsId();
//    	boolean isUpdate = StringUtils.isNotEmpty(nmIssuenewsId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return nmIssuenewsDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssuenews(@ServiceParam(name="policyId") String id) throws BusException{
    	nmIssuenewsDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuenewss(@ServiceParam(name="policyId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssuenews(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssuenews(@ServiceParam(name="policyId") String id)  throws BusException{
		return nmIssuenewsDao.exists(id);
	}
    
    public boolean exsitNmIssuenews(String propertyName,Object value) throws BusException{
		return nmIssuenewsDao.exists(propertyName,value);
	}

}
