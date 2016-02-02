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

import com.common.NewsManager.entity.NmIssuetempalate;
import com.common.NewsManager.dao.NmIssuetempalateDao;
import com.common.NewsManager.service.NmIssuetempalateManager;

@Service("nmIssuetempalateManager")
@Transactional
public class NmIssuetempalateManagerImpl extends BaseManagerImpl implements NmIssuetempalateManager{
	@Autowired
	private NmIssuetempalateDao nmIssuetempalateDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<NmIssuetempalate> getNmIssuetempalates() throws BusException{
    	return nmIssuetempalateDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<NmIssuetempalate> getNmIssuetempalates(
    	@ConditionCollection(domainClazz=NmIssuetempalate.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return nmIssuetempalateDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public NmIssuetempalate getNmIssuetempalate(@ServiceParam(name="issueTempalateId") String id)  throws BusException{
    	return nmIssuetempalateDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerNmIssuetempalates(Pager pager,//分页条件
			@ConditionCollection(domainClazz=NmIssuetempalate.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		PagerRecords pagerRecords = nmIssuetempalateDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}
    /**
     * 保存对象
     */
    @EsbServiceMapping
    public NmIssuetempalate saveNmIssuetempalate(NmIssuetempalate o) throws BusException{
//    	String nmIssuetempalateId = o.getNmIssuetempalateId();
//    	boolean isUpdate = StringUtils.isNotEmpty(nmIssuetempalateId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
    	return nmIssuetempalateDao.save(o);
    }

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeNmIssuetempalate(@ServiceParam(name="issueTempalateId") String id) throws BusException{
    	nmIssuetempalateDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeNmIssuetempalates(@ServiceParam(name="issueTempalateId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeNmIssuetempalate(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitNmIssuetempalate(@ServiceParam(name="issueTempalateId") String id)  throws BusException{
		return nmIssuetempalateDao.exists(id);
	}
    
    public boolean exsitNmIssuetempalate(String propertyName,Object value) throws BusException{
		return nmIssuetempalateDao.exists(propertyName,value);
	}

}
