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

import com.common.NewsManager.entity.NmIssueflow;
import com.common.NewsManager.dao.NmIssueflowDao;
import com.common.NewsManager.service.NmIssueflowManager;

@Service("nmIssueflowManager")
@Transactional
public class NmIssueflowManagerImpl extends BaseManagerImpl implements NmIssueflowManager{
	@Autowired
	private NmIssueflowDao nmIssueflowDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssueflow> getNmIssueflows() throws BusException{
    	return nmIssueflowDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssueflow> getNmIssueflows(
    	@ConditionCollection(domainClazz=NmIssueflow.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssueflowDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssueflow getNmIssueflow(@ServiceParam(name="issueFlowId") String id)  throws BusException{
    	return nmIssueflowDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssueflows(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssueflow.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssueflowDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssueflow saveNmIssueflow(NmIssueflow o) throws BusException{
//    	String nmIssueflowId = o.getNmIssueflowId();
//    	boolean isUpdate = StringUtils.isNotEmpty(nmIssueflowId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return nmIssueflowDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssueflow(@ServiceParam(name="issueFlowId") String id) throws BusException{
    	nmIssueflowDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssueflows(@ServiceParam(name="issueFlowId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssueflow(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssueflow(@ServiceParam(name="issueFlowId") String id)  throws BusException{
		return nmIssueflowDao.exists(id);
	}
    
    public boolean exsitNmIssueflow(String propertyName,Object value) throws BusException{
		return nmIssueflowDao.exists(propertyName,value);
	}

}
