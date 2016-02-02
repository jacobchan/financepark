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

import com.common.NewsManager.entity.NmIssuetype;
import com.common.NewsManager.dao.NmIssuetypeDao;
import com.common.NewsManager.service.NmIssuetypeManager;

@Service("nmIssuetypeManager")
@Transactional
public class NmIssuetypeManagerImpl extends BaseManagerImpl implements NmIssuetypeManager{
	@Autowired
	private NmIssuetypeDao nmIssuetypeDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssuetype> getNmIssuetypes() throws BusException{
    	return nmIssuetypeDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssuetype> getNmIssuetypes(
    	@ConditionCollection(domainClazz=NmIssuetype.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssuetypeDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssuetype getNmIssuetype(@ServiceParam(name="issueTypeId") String id)  throws BusException{
    	return nmIssuetypeDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssuetypes(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuetype.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssuetypeDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssuetype saveNmIssuetype(NmIssuetype o) throws BusException{
//    	String nmIssuetypeId = o.getNmIssuetypeId();
//    	boolean isUpdate = StringUtils.isNotEmpty(nmIssuetypeId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return nmIssuetypeDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssuetype(@ServiceParam(name="issueTypeId") String id) throws BusException{
    	nmIssuetypeDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuetypes(@ServiceParam(name="issueTypeId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssuetype(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssuetype(@ServiceParam(name="issueTypeId") String id)  throws BusException{
		return nmIssuetypeDao.exists(id);
	}
    
    public boolean exsitNmIssuetype(String propertyName,Object value) throws BusException{
		return nmIssuetypeDao.exists(propertyName,value);
	}

}
